public class java_hw4 {
//    public class Test3 {
        /**
         *  创建一个不规则二维数组
         *  第一行 row 列
         *  第二行 row - 1 列
         *  ...
         *  最后一行 1 列
         *	数组元素值都为默认值
         * @param row 行数
         * @return 创建好的不规则数组
         */
        public static int[][] createArray(int row){
            if (row <= 0) {
                return null;
            }

            int[][] arr = new int[row][];
            for (int i = row; i > 0; i--) {
                arr[row - i] = new int[i];
            }

            return arr;
        }

        /**
         * 逐行打印出二维数组，数组元素之间以空格分开
         * @param a
         */
        public static void printArray(int[][] a){
            if (a == null) {
                return;
            }

            for (int i = 0; i < a.length; i++) {
                for (int j = 0; j < a[i].length; j++) {
                    System.out.print(a[i][j] + " ");
                }
                System.out.println();
            }
        }

        public static void main(String[] args) {
            int row = 6;
            int[][] arr = createArray(row);
            printArray(arr);
        }
//    }
}
