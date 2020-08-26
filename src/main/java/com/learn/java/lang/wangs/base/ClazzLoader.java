package com.learn.java.lang.wangs.base;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.InvocationTargetException;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;
import java.util.Properties;

//import com.People;

public class ClazzLoader extends ClassLoader {

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        File file = new File("D:/People.class");
        try {
            byte[] bytes = getClassBytes(file);
            //defineClass方法可以把二进制流字节组成的文件转换为一个java.lang.Class
            Class<?> c = this.defineClass(name, bytes, 0, bytes.length);
            return c;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return super.findClass(name);
    }


    private byte[] getClassBytes(File file) throws Exception {
        // 这里要读入.class的字节，因此要使用字节流
        FileInputStream fis = new FileInputStream(file);
        FileChannel fc = fis.getChannel();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        WritableByteChannel wbc = Channels.newChannel(baos);
        ByteBuffer by = ByteBuffer.allocate(1024);

        while (true) {
            int i = fc.read(by);
            if (i == 0 || i == -1)
                break;
            by.flip();
            wbc.write(by);
            by.clear();
        }
        fis.close();
        return baos.toByteArray();
    }

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
        ClazzLoader myloader = new ClazzLoader();
        Class<?> c = Class.forName("com.People", true, myloader);
        // People oo = new People();
        // sSystem.err.println(oo.toString());
        //Constructor.
        // 工资高于8000,就是8000,基本工资2500,工资一次发,年终奖无,其他部门不知道
        Object o = c.getDeclaredConstructor().newInstance();
        setProp();
        System.out.println(c.getClassLoader());
        System.err.println(o.getClass().getClassLoader());
    }

    static void setProp() {
        String key = "java.class.path";
        Properties props = System.getProperties();
        String value = props.getProperty(key) + ";D:\\";
        props.setProperty(key, value);
        String[] paths = value.split(";");
        //String[] paths = System.getProperty("java.class.path").split(";");
        for (int i = 0; i < paths.length; i++) {
            System.err.println(paths[i]);
        }
    }
}
