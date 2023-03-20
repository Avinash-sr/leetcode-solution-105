class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count =n;
        if(n==0){
            return true;
        }
        if(flowerbed.length==1 && flowerbed[0]==0)
        {
            count--;
            if(count==0){
                return true;
            }
        }
        for(int i=0;i<flowerbed.length; i++){
            if(i==0 && flowerbed[i]==0 ){
                if( flowerbed[i+1]==0){
                    count--;
                    flowerbed[i]=1;
                }
        
            }
            else if(i==flowerbed.length-1 && flowerbed[i]==0){
                if( flowerbed[i-1]==0){
                    count--;
                    flowerbed[i]=1;
                }
            }
            else if(flowerbed[i]==0  ){
               if( flowerbed[i+1]==0 &&  flowerbed[i-1]==0){
                    count--;
                    flowerbed[i]=1;
                }
            }
            

            if(count==0){
                return true;
            }
        }
        return false;
    }
}