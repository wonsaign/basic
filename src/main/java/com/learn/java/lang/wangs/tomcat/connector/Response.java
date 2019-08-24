package com.learn.java.lang.wangs.tomcat.connector;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;

public class Response {

    private OutputStream output;
    private Request request;
    
    static private final int BUFFER_SIZE = 1024;
    
    public Response(OutputStream output) {
        super();
        this.output = output;
    }
    
    public void sendStaticResource() {
        byte[] bytes = new byte[BUFFER_SIZE];
        
        FileInputStream fis = null;
        
        try {
            File file = new File(HttpServer.WEB_ROOT, request.getUri());
            if(file.exists()) {
                fis = new FileInputStream(file);
                int ch = fis.read(bytes, 0, BUFFER_SIZE);
                while(ch != -1) {
                    output.write(bytes, 0 ,ch);
                    System.err.println(new String(bytes));
                    ch = fis.read(bytes, 0, BUFFER_SIZE);
                }
            }
            else {
                String errorMsg = "HTTP/1.1 404 File Not Found\r\n" + 
                    "Content-Type: text/html\r\n" +
                     "Content-Length: 23/r/n" + 
                    "/r/n" + 
                     "<h1>File Not Fount</h1>";
                output.write(errorMsg.getBytes());
            }
            output.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public OutputStream getOutput() {
        return output;
    }

    public void setOutput(OutputStream output) {
        this.output = output;
    }

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    
}
