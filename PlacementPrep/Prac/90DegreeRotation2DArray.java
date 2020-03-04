int[][] rotateImage(int[][] a) {
    int [][] b = a;
    int n = a.length;
    swapColWithRow(b, n);
    reverseRows(b, n);
    System.out.println("end");
    printMatrix(b, n);
    System.out.println();
    return b;
}

static void reverseRows(int[][] a, int n) {
    for(int i=0; i<n; i++) {
        for(int j=0; j<n/2; j++) {
            int temp = a[i][j];
            a[i][j] = a[i][n-j-1];
            a[i][n-j-1] = temp;
        }
    }
    System.out.println("after reverse rows");
    printMatrix(a, n);
    System.out.println();
}

static void swapColWithRow(int[][] a, int n) {
    for(int c=0; c<n; c++) {
        for(int j=c; j<n ; j++) {
            int temp = a[c][j];
            a[c][j] = a[j][c];
            a[j][c] = temp;
        }
    }
    System.out.println("after swap");
    printMatrix(a, n);
    System.out.println();
}

static void printMatrix(int[][] a, int n) {
    for(int i=0; i<n; i++) {
    for(int j=0; j<n; j++)
        System.out.print(a[i][j] + " ");
    System.out.println();
    }
}
