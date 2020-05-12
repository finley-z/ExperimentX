package com.finley.database.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ֣Զ�� on 2017/8/1.
 */
@Service
public class DataBaseTestEntrace {
    // ��װBean��ע�����
    @Autowired
    DataBaseTestService service;

    public void execute() {
        new Worker(true).start();
        new Worker(false).start();
    }
    // �߳��ڲ��࣬Thread����Runnable����
    private class Worker extends Thread {
        boolean who;
        public Worker(boolean who){
            this.who=who;
        }
        @Override
        public void run() {
            // do something...
            if(who){
                DataBaseTestEntrace.this.service.testDeadlock();
            }else{
                DataBaseTestEntrace.this.service.testDeadlock1();
            }
            // ��ʱsomeService�ѱ�ע�룬��null.
        }
    }
}