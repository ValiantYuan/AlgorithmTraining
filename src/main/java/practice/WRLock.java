package practice;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author : yuanqi
 * @since : 2021/4/21
 */
public class WRLock {

    ReentrantLock lock = new ReentrantLock();
    Condition reading = lock.newCondition();
    Condition writing = lock.newCondition();

    Semaphore readLock = new Semaphore(Integer.MAX_VALUE);

    Semaphore writeLock = new Semaphore(1);
    volatile boolean write = false;
    volatile boolean read = false;

    /**
     * 获取，写锁禁止获取读写锁
     */
    public void lockWrite() {
        lock.lock();
        while (read) {
            try {
                reading.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            writeLock.acquire();
            write = true;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    /**
     * 获取，读锁禁止获取写锁
     */
    public void lockRead() {
        lock.lock();
        // 正在写禁止读
        while (write) {
            try {
                writing.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            readLock.acquire();
            read = true;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        // 禁止写
    }


    /**
     * 释放
     */
    public Object unlockWrite() {
        writeLock.release();
        write = false;
        // 写锁结束，唤醒等待的线程
        writing.signalAll();
    }

    /**
     * 释放
     */
    public Object unlockRead() {
        readLock.release();
        read = false;
        // 读锁结束
        reading.signalAll();

    }
}
