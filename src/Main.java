public class Main {
    public static void main(String[] args) {
        int[] Pi = {40,30,50,20,35,45,10,15};
        int[] Di = {3,2,3,1,3,2,4,4};

        int n = Pi.length;
        int temp =0;
        for(int i=0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (Pi[j - 1] < Pi[j]) {

                    temp = Pi[j - 1];
                    Pi[j - 1] = Pi[j];
                    Pi[j] = temp;
                    // for Di
                    temp = Di[j-1];
                    Di[j-1]= Di[j];
                    Di[j] = temp;
                }

            }
        }

        System.out.println("Pi : ");
        for (int i = 0; i < Pi.length; i++) {
            System.out.print(Pi[i] + " ");
        }

        System.out.println();
        System.out.println();
        System.out.println("Di : ");
        for (int i = 0; i < Pi.length; i++) {
            System.out.print(Di[i] + " ");
        }

        System.out.println();
        System.out.println();
        System.out.println("final answer: ");
        System.out.println(FindMaximum(Pi,Di,8));
    }

    private static int FindMaximum(int[] pi, int[] di, int i) {
        int sum=0;
        int k=0;
        while( k < pi.length){
            if(di[k]>= k+1){
                sum = sum+ pi[k];
            }
            for (int j = k+1; j < pi.length; j++) {
                if(di[j]>= k+2){
                    sum = sum + pi[j];
                    k++;
                    break;
                }
            }
            k++;
        }

        return sum;
    }
}
