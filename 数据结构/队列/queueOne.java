package 数据结构.队列;

import java.util.Scanner;

/*

 */
public class queueOne {
    public static void main(String[] args) {
        //测试一把
        //创建一个队列
        ArrayQueue queue = new ArrayQueue(3);
        char key = ' '; //接收用户输入
        Scanner scanner = new Scanner(System.in);//
        boolean loop = true;
        //输出一个菜单
        while(loop) {
            System.out.println("s(show): 显示队列");
            System.out.println("e(exit): 退出程序");
            System.out.println("a(add): 添加数据到队列");
            System.out.println("g(get): 从队列取出数据");
            System.out.println("h(head): 查看队列头的数据");
            key = scanner.next().charAt(0);//接收一个字符
            switch (key) {
                case 's':
                    queue.showQueue();  //查询队列所有数据
                    break;
                case 'a':
                    System.out.println("输出一个数");
                    int value = scanner.nextInt();
                    queue.addQueue(value);  //添加数据
                    break;
                case 'g': //取出数据
                    try {
                        int res = queue.getQueue();
                        System.out.printf("取出的数据是%d\n", res);
                    } catch (Exception e) {
                        // TODO: handle exception
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h': //查看队列头的数据
                    try {
                        int res = queue.headQueue();
                        System.out.printf("队列头的数据是%d\n", res);
                    } catch (Exception e) {
                        // TODO: handle exception
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e': //退出
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出~~");
    }
}
class ArrayQueue{
    private int maxSize; //队列最大容量
    private int rear;   //队尾指针
    private int front; //队头指针
    private int[] arr; //存放数据

    //构造器
    public ArrayQueue(int arrMaxSize){
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        front = -1; // 指向队列头部,分析出 front 是指向队列头的前一个位置.
        rear = -1;  // 指向队列尾,指向队列尾的数据(即就是队列最后一个数据)
    }

    //判断队列满
    public boolean isFull(){
        return rear == maxSize-1;
    }

    //判断队列空
    public boolean isEmpty(){
        return rear == front;
    }

    //查询队列所有数据
    public void showQueue() {
        if (isEmpty()){
//            throw new RuntimeException("队空！！");
            System.out.println("队空！！");
            return;
        }
//        for (int x : arr) {
//            System.out.print(x+"  ");
//        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n", i, arr[i]);
        }
        System.out.println();
    }
    //添加数据
    public void addQueue(int value) {
        if (isFull()){
            System.out.println("移队满，无法添加数据！！！");
        }else {
            rear++; //队尾指针后移
            arr[rear] = value; //添加数据
        }
    }
    //取出数据
    public int getQueue() {
        //判断队列是否为空
        if (isEmpty()){
            System.out.println("队空！！");
//            throw new RuntimeException("队空！！");
        }
        front++; //队头指针后移
        return arr[front];
    }
    //查看队列头的数据
    public int headQueue() {
        if (isEmpty()){
            throw new RuntimeException("队空！！");
        }
        return arr[front+1];
    }

}