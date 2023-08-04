public class flowerBedPlanting {

    public static boolean canPlaceFlower(int[] flowerBed,int n){
        int count=0;
        int i=0;

        while(i<flowerBed.length){

            if (flowerBed[i]==0){

                boolean prevEmpty= (i==0||flowerBed[i-1]==0);
                boolean nextEmpty=(i==flowerBed.length-1||flowerBed[i+1]==0);

                if (prevEmpty && nextEmpty){
                    count++;
                }
            }
            i++;
        }

        return  count>=n;
    }
    public static void main(String[] args) {
        int[] flowerBed={1,0,0,0,1};
        int n=2;
        boolean canplace=canPlaceFlower(flowerBed,n);

        System.out.println(canplace);
    }
}
