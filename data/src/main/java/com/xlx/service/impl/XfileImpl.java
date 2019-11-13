package com.xlx.service.impl;

import com.xlx.service.Callback;
import com.xlx.service.Xfile;
import com.xlx.util.ReMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.*;

/**
 * @author xlx
 * @descritption
 * @data 2019/11/6
 */
@Slf4j
public class XfileImpl implements Xfile {

    @Autowired
    private Executor taskExecutor;


    public ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(8, 16,
            60L, TimeUnit.SECONDS,
            new SynchronousQueue<Runnable>());



    @Override
    public void testAsync(Callback callback) {

        AsyncTask asyncTask = new AsyncTask("Nihao",callback);
        threadPoolExecutor.execute(asyncTask);
    }


    private class AsyncTask implements Runnable{

        private String message;

        private Callback callback;

        public AsyncTask(String message,Callback callback) {
            this.message = message;
            this.callback = callback;
        }

        @Override
        public void run() {
            System.out.println("异步接口----" + this.message);
            try {
                TimeUnit.SECONDS.sleep(4);
                int i = 1/0;
                ReMessage reMessage = new ReMessage();
                reMessage.setSuccess(true);
                reMessage.setMessage("执行成功");
                callback.onEvent(reMessage);
            } catch (Throwable e) {
                log.error("fail to execute task,e{}",e);
                ReMessage reMessage = new ReMessage();
                reMessage.setSuccess(false);
                reMessage.setMessage("执行失败");
                callback.onEvent(reMessage);
            }
        }
    }

}
