package 数据结构.稀疏数组;

public class sparseArr {
    public static void main(String[] args) {
        // 创建一个原始的二维数组 11 * 11
        // 0: 表示没有棋子, 1 表示 黑子 2 表蓝子
        int chessArr1[][] = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        chessArr1[4][5] = 2;

        // 输出原始的二维数组
        System.out.println("原始的二维数组~~");
        for (int[] row : chessArr1) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }   
        int sum = 0;
        // 将二维数组 转 稀疏数组的思路
        // 1. 先遍历二维数组 得到非 0 数据的个数
        for (int i = 0; i < chessArr1.length; i++) {
           for (int j = 0; j < chessArr1.length; j++) {
               if (chessArr1[i][j] != 0) {
                   sum++;
               }
           } 
        }
        // 2. 创建对应的稀疏数组
        int sparseArr[][] = new int[sum + 1][3];
        // 给稀疏数组赋值
        sparseArr[0][0] = 11;   //原矩阵的行数
        sparseArr[0][1] = 11;   //原矩阵的列数
        sparseArr[0][2] = sum;  //原矩阵的数据个数

        // 遍历二维数组,将非 0 的值存放到 sparseArr 中
        int count = 0; //count用于记录是第几个非 0 数据
        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < chessArr1.length; j++) {
               if (chessArr1[i][j] != 0) {
                   count++;
                   sparseArr[count][0] = i;     //值在原矩阵的行
                   sparseArr[count][1] = j;     //值在原矩阵的列
                   sparseArr[count][2] = chessArr1[i][j];   //当前位置的值
               } 
            }
        }

        // 输出稀疏数组的形式
        System.out.println();
        System.out.println("得到稀疏数组为~~~~");
        for (int i = 0; i < sparseArr.length; i++) {
        System.out.printf("%d\t%d\t%d\t\n", sparseArr[i][0], sparseArr[i][1], sparseArr[i][2]);
        }
        System.out.println();
        
    }
}
