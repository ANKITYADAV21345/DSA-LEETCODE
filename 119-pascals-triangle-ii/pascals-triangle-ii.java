class Solution {

    public static int nCr(int n,int r){
        r=Math.min(r,n-r);
        long res=1;
        for(int i=1;i<=r;i++){
            res=(res*(n-i+1))/i;
        }
        return (int) res;
    }
    public List<Integer> getRow(int rowIndex) {
        List<Integer> arr=new ArrayList<>();
        for(int i=0;i<=rowIndex;i++){
            arr.add(nCr(rowIndex,i));
        }
        return arr;
    }
}