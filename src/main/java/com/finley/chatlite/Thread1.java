package com.finley.chatlite;

import java.io.IOException;

/**
 * @author zyf
 * @date 2017/9/22
 */
public class Thread1 {
    public static void main(String []args){
        try {
            new ClientHandler("127.0.0.1",8080).listen();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
