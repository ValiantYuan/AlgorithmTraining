package practice;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author : yuanqi
 * @since : 2021/4/20
 */
public class BlockingQueue <T>{
//
//    int max = 5;
//
//    public BlockingQueue(int max) {
//        this.max = max;
//    }
//
//    ReentrantLock lock = new ReentrantLock();
//    Condition notFull = lock.newCondition();
//    Condition notEmpty = lock.newCondition();
//
//    Deque<T> list = new LinkedList<>();
//
//    public void offer(T obj) {
//        lock.lock();
//        try {
//            while (list.size() >= max) {
//                notFull.await();
//            }
//            list.addFirst(obj);
//            notEmpty.signalAll();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } finally {
//            lock.unlock();
//        }
//    }
//
//
//
//    public T get() {
//        lock.lock();
//        try {
//            while (list.size() == 0) {
//                notEmpty.await();
//            }
//            T t = list.getLast();
//            notFull.signalAll();
//            return t;
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } finally {
//            lock.unlock();
//        }
//    }
}
