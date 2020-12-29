package com.learn.java.lang.wangs.game;

import org.apache.tools.ant.taskdefs.Local;

import javax.crypto.NoSuchPaddingException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.UUID;

/**
 * @author wangsai
 * 扭蛋规则类
 */
public class EggRule {

    /**  奖池 **/
    private Set<String> rewords = new HashSet<>();

    private int prize_pos;

    private int eggs[];

    private boolean isHaveBigReword = true;

    private String soil;

    private int days;


    private String getString(){
        StringBuffer sb = new StringBuffer();
        if(eggs != null && eggs.length > 0){
            for (int i = 0; i < eggs.length; i++) {
                sb.append(eggs[i]);
            }
        }
        return sb.toString();
    }

    private int[] changeToArray(String s){
        if(s == null || s == ""){
            return null;
        }
        byte[] bytes = s.getBytes();
        eggs = new int[bytes.length];
        for (int i = 0; i < bytes.length; i++) {
            eggs[i] = bytes[i] - 48;
        }

        return eggs;
    }

    /**
     * 初始化扭蛋
     */
    public void init(int turns){
        if(turns <= 0){
            return;
        }
        if(!loadDbfile()){
            // 初始化
            eggs = new int[turns];
            for (int i = 0; i < turns; i++) {
                eggs[i] = 1;
            }
            soil = UUID.randomUUID().toString();
            Random r = new Random();
            prize_pos = r.nextInt(eggs.length) - 1;
            writeToDb();
        }
    }

    private void writeToDb() {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(System.getProperty("user.dir") + "db");
            String key  = soil + "_" + LocalDate.now().getDayOfYear() + "_" + AESUtil.AESEncode(soil, getString()) + "_" + prize_pos;
            byte[] bytes = key.getBytes("UTF-8");
            fos.write(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     *  加载db文件
     * @return
     */
    private boolean loadDbfile() {
        String local_url = System.getProperty("user.dir") + "db";
        File file = new File(local_url);
        if(!file.exists()){
            return false;
        }

        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file));
            String key = null;
            while((key = br.readLine())!=null){
                // 不使用json，定义位置把
                String[] keySplit = key.split("_");
                soil = keySplit[0];
                days = Integer.valueOf(keySplit[1]);
                eggs = changeToArray(AESUtil.AESDncode(soil, keySplit[2]));
                prize_pos = Integer.valueOf(keySplit[3]);
                isHaveBigReword = eggs[prize_pos] == 1;
                // System.out.println(key);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return true;
    }

    /**
     * 添加奖品
     */
    public void addRewords(String reword){
        rewords.add(reword);
    }

    public void draw(){
        // 校验时间限制
        // 每天一抽
//        if(LocalDate.now().getDayOfYear() == days){
//            // 事件，还没到时间。
//            return;
//        }

        Random r = new Random();
        int drawed = r.nextInt(eggs.length) - 1;
        int allTimes = eggs.length;
        // TODO 应该是要触发一个什么事件之类的。 中奖 咋样
        if(isHaveBigReword){
            // 奖池空的
            while (eggs[drawed] == 0 && allTimes > 0){
                drawed++;
                if(drawed > eggs.length){
                    drawed = 0;
                }
                allTimes--;
            }
            if(allTimes == 0){
                System.out.println("没有奖品了，下一轮");
                return;
            }
            // 已经抽奖
            eggs[drawed] = 0;
            if(drawed == prize_pos){
                // 中大奖了 事件
                System.out.println("中大奖了");
            }else{
                // 真遗憾事件
                System.out.println("真遗憾");
            }
            writeToDb();
        }else {
            // TODO: 大富翁
        }

    }


    /**
     * 展示奖品
     * @return
     */
    public String showRewordsList(){
        StringBuffer sb = new StringBuffer();
        Iterator<String> it = rewords.iterator();
        while(it.hasNext()){
            sb.append(it.next());
            sb.append("\t");
        }
        return sb.toString();
    }

    public int getPrize_pos() {
        return prize_pos;
    }
    public void setPrize_pos(int prize_pos) {
        this.prize_pos = prize_pos;
    }
}
