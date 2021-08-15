package thread.DiningPhilosophers;

/**
 * @author wangyisu
 */
public class DiningPhilosophers implements Runnable{
    private int philosopher;
    private Fork forkLeft;
    private Fork forkRight;
    public DiningPhilosophers(int philosopher, Fork forkLeft, Fork forkRight) {
        this.philosopher = philosopher;
        this.forkLeft = forkLeft;
        this.forkRight = forkRight;
    }

    @Override
    public void run() {
        while(true){
             //低效版本，每次只有一个哲学家可以进餐
//            synchronized (Object.class){
//                synchronized (forkLeft){
//                    System.out.println("哲学家"+philosopher+" 拿起了他左边的筷子，筷子"+forkLeft.fork_num+"被拿走");
//                    synchronized (forkRight){
//                        System.out.println("哲学家"+philosopher+" 拿起了他右边的筷子，筷子"+forkRight.fork_num+"被拿走");
//                        System.out.println("哲学家"+philosopher +" 开始吃饭了");
//                    }
//                    System.out.println("哲学家"+philosopher+"放下手中的筷子，开始去思考了");
//                }
//            }

            // 规定奇数号哲学家先左后右，偶数号哲学家先右后左
//            if(philosopher%2==0){
//                synchronized (forkLeft){
//                    System.out.println("哲学家"+philosopher+" 拿起了他左边的筷子，筷子"+forkLeft.fork_num+"被拿走");
//                    synchronized (forkRight){
//                        System.out.println("哲学家"+philosopher+" 拿起了他右边的筷子，筷子"+forkRight.fork_num+"被拿走");
//                        System.out.println("哲学家"+philosopher +" 开始吃饭了");
//                    }
//                    System.out.println("哲学家"+philosopher+"放下手中的筷子，开始去思考了");
//                }
//            }else{
//                synchronized (forkRight){
//                    System.out.println("哲学家"+philosopher+" 拿起了他左边的筷子，筷子"+forkRight.fork_num+"被拿走");
//                    synchronized (forkLeft){
//                        System.out.println("哲学家"+philosopher+" 拿起了他右边的筷子，筷子"+forkLeft.fork_num+"被拿走");
//                        System.out.println("哲学家"+philosopher +" 开始吃饭了");
//                    }
//                    System.out.println("哲学家"+philosopher+"放下手中的筷子，开始去思考了");
//                }
//            }

            // 当左右两个叉子都拿到的时候，才进餐
            // Todo

            //
        }
    }

    public static void main(String[] args) {
        Fork[] forks = new Fork[5];
        for (int i = 0; i < forks.length; i++) {
            forks[i] = new Fork(i);
        }
        Thread[] diningPhilosophers = new Thread[5];
        for (int i = 0; i < diningPhilosophers.length; i++) {
            if(i==diningPhilosophers.length-1){
                diningPhilosophers[i] = new Thread(new DiningPhilosophers(i,forks[i],forks[0]));
            }else{
                diningPhilosophers[i] = new Thread(new DiningPhilosophers(i,forks[i],forks[i+1]));
            }
        }

        for (int i = 0; i < diningPhilosophers.length; i++) {
            diningPhilosophers[i].start();
        }
    }
}
