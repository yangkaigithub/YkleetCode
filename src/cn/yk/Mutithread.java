package cn.yk;

import java.util.concurrent.atomic.AtomicInteger;

import static java.lang.Thread.sleep;

/**
 * Created by tpusers on 2017/3/16.
 */
public class Mutithread {
    public static void main(String[] args){
        Thread[] th = new Thread[10];
        for(int i=0;i<10;i++){
            th[i] = new ykthread();
            th[i].setName(Integer.toString(i));
        }
        for(int i=0;i<10;i++){
            th[i].start();
        }
        }
        }
class ykthread extends Thread{
    private static AtomicInteger count = new AtomicInteger(0);
    public  void run(){
        addcount();
    }
    public synchronized void addcount(){
        for (int i = 0; i < 10000; i++)
            count.incrementAndGet();
        System.out.println(Thread.currentThread().getName() + ":" + count);
    }
}

