package com.learn.java.lang.wangs.base.collection;

import com.google.common.collect.Lists;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Data
public class ListTest {


    public static void main(String[] args) {
        ListTest t = new ListTest();

        t.mulitiExcecute();
    }

    private void mulitiExcecute(){

        List<String> userNames = Lists.newArrayList("a","b","c","d","e","f","g","h","i","j","k","l","m","n",
                "o","p","q","r","s","t","u","v","w","x","y","z");

        int cpus = Runtime.getRuntime().availableProcessors() / 4;
        if (cpus < 2) {
            cpus = 2;
        }
        ExecutorService executorService = Executors.newFixedThreadPool(cpus);
        int sizeT = userNames.size();
        int parts = 4 * cpus;
        int npart = sizeT / parts + 1;

        for (int i = 0; i < parts; i++) {
            int begin = i * npart;
            int end = Math.min(begin + npart, sizeT);
            if (begin >= sizeT) {
                break;
            }
            System.out.println("start -"+ begin +" --end -"+ end);

            List<String> subList = userNames.subList(begin, end);
            executorService.execute(() -> {
                for (String s : subList) {
                    try {
                        if(s.equalsIgnoreCase("b")){
                            throw new RuntimeException("stop");
                        }
                        System.out.println(s);
                    } catch (RuntimeException e) {
                        System.out.println("抓到了，正常进行");
                    }
                }
            });
        }
        executorService.shutdown();
    }
}
