package com.learn.java.lang.wangs.base.classloader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * 凯撒加密类加载器
 * @author wangsai
 *
 */

public class CaesarLoader extends ClassLoader{

    private int k;
    
    
    public CaesarLoader(int k) {
        super();
        this.k = k;
    }

    /**
     * 类加载器的作用，加载class文件的字节码，将加载后的字节码提供给虚拟机
     */
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        // TODO 1 未本地或者其他来源的类【加载字节码】
        try {
            byte[] loadClassByte = loadClassByte(name);
            // TODO 2 调用CLassLoader超类的defineClass，向虚拟机【提供字节码】
            Class<?> defineClass = super.defineClass(name, loadClassByte, 0, loadClassByte.length);
            if(defineClass == null) {
                throw new ClassNotFoundException();
            }
            return defineClass;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 找到指定文件，加载，返回字节码
     * @param name
     * @return
     * @throws IOException 
     */
    private byte[] loadClassByte(String name) throws IOException {
        String cname = name.replace(".", "/") + ".caeser";
        
        byte[] readAllBytes = Files.readAllBytes(Paths.get(cname));
        
        for (int i = 0; i < readAllBytes.length; i++) {
            readAllBytes[i] = (byte)(readAllBytes[i] - k);
        }
        
        return readAllBytes;
    }
    
}
