package Offer.ex3;

import java.util.Scanner;

public class duplicate {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //输入几个数
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();  //依次将输入的数填入数组中
        }
        System.out.println("===================");
       
        int x = cul(arr);
        System.out.println(x);
        sc.close();
    }

    static int cul(int[] a){
        int res =0;
        // System.out.println("sssssssss");
        // for (int i : a) {
        //     System.out.print(i+" "); 
        //  }
        for (int i = 0; i < a.length; i++) {
            
            while(i != a[i]){  
                //当当前位置下标 不等于 当前位置的值 就将当前值对应的下标的位置的值和当前位子的值比较
                if (a[i] == a[a[i]]) {
                    //相等，返回当前位子的值
                    return a[i];
                }
                //否则，值交换
                int tep = a[i];
                a[i] = a[tep];
                a[tep] = tep; 
           }
           
           res = a[i];
        }
        return res;
    }
}
