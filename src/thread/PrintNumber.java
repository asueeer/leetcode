package thread;

import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author wangyisu
 */
// 使用多线程交替打印奇偶数
public class PrintNumber {
    public int num = 0;
    public int max_ = 10000;
    private final ReentrantLock lock = new ReentrantLock();
    public static ArrayList<Integer> list = new ArrayList<>();

    public class Odd_num_printer implements Runnable{
        @Override
        public void run() {
            while (num<max_){
                lock.lock();
                if(num%2==1){
                    System.out.println(num);
                    list.add(num);
                    num++;
                }
                lock.unlock();
            }
        }
    }

    public class Even_num_printer implements Runnable{
        @Override
        public void run() {
            while (num<max_){
                lock.lock();
                if(num%2==0){
                    System.out.println(num);
                    list.add(num);
                    num++;
                }
                lock.unlock();
            }
        }
    }

    public void print_numbers(){
        Thread thread_even_num_printer = new Thread(new Even_num_printer());
        Thread thread_odd_num_printer = new Thread(new Odd_num_printer());
        thread_even_num_printer.start();
        thread_odd_num_printer.start();
    }

    public static void main(String[] args) {
        PrintNumber printer = new PrintNumber();
        printer.print_numbers();
        while(list.size()!=10000){
            if(printer.num>=9000){
                System.out.println("list.size()"+list.size());
            }
        }
        System.out.println(list);
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i)!=i){
                System.out.println(false+"!!!!!");
            }
        }
        System.out.println("over");
    }
}
