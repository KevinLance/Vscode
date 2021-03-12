package 数据结构.队列;

import java.util.Scanner;

public class loopQueue {
    public static void main(String[] args) {
        //测试一把
        System.out.println("测试数组模拟环形队列的案例~~~");
        // 创建一个环形队列
        loopArray queue = new loopArray(4); //说明设置 4, 其队列的有效数据最大是 3
        char key = ' '; // 接收用户输入
        Scanner scanner = new Scanner(System.in);//
        boolean loop = true;
        // 输出一个菜单
        while (loop) {
            System.out.println("s(show): 显示队列");
            System.out.println("e(exit): 退出程序");
            System.out.println("a(add): 添加数据到队列");
            System.out.println("g(get): 从队列取出数据");
            System.out.println("h(head): 查看队列头的数据");
            key = scanner.next().charAt(0);// 接收一个字符
            switch (key) {
                case 's':
                    queue.showQueue();
                    break;
                case 'a':
                    System.out.println("输入一个数");
                    int value = scanner.nextInt();
                    queue.addQueue(value);
                    break;
                case 'g': // 取出数据
                    try {
                        int res = queue.getQueue();
                        System.out.printf("取出的数据是%d\n", res);
                    } catch (Exception e) {
                        // TODO: handle exception
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h': // 查看队列头的数据
                    try {
                        int res = queue.headQueue();
                        System.out.printf("队列头的数据是%d\n", res);
                    } catch (Exception e) {
                        // TODO: handle exception
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e': // 退出
                    scanner.close();
            }
        }
    }
}
class loopArray{

    //属性
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;

    //构造器,分配内存
    public loopArray(int arrMaxSize){
        maxSize = arrMaxSize;
        arr = new int[maxSize];
    }

    //队空
    public boolean isEmpty(){
        return front == rear;
    }

    //队满
    public boolean isFull(){
        return (rear+1)%maxSize == front;
    }

    public void showQueue() {
        if (isEmpty()){
            System.out.println("队空！！！");
            return;
        }
        for (int i = front; i < front+((rear+maxSize-front)%maxSize); i++) {
            System.out.print(arr[i%maxSize]+" ");
            System.out.println();
        }
    }

    public void addQueue(int value) {
        if (isFull()){
            System.out.println("队满！！");
            return;
        }
        arr[rear] = value;
        rear = (rear+1)%maxSize;
    }

    public int getQueue() {
        if (isEmpty()){
            System.out.println("队空！！");
        }
        int temp = arr[front];
        front = (front+1)%maxSize;
        return temp;
    }

    public int headQueue() {
        if (isEmpty()){
            System.out.println("队空！！！");
        }
        return arr[front];
    }
}