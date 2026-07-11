//codebix  kiya khud se ,code codebix ka hai bass formula use ho raha tha to vatiable formule ke according change kar diya to (y)
class Solution {
    public double myPow(double x, int n) {
        if(n>=0){
            return positive(x,n);
        }
        else{
            return negative(x,n);
        }
    }

    public double negative(double x,int n){
        if(n==-1){
            return 1/x;
        }
        double y=myPow(x,n/2);
        
        if(n%2==0){
            return y*y;
        }
        else{
            return (1/x)*(y*y);
        }
    }

    public double positive(double x,int n){
        if(n==0){
            return 1;
        }

        double y=myPow(x,n/2);
        
        if(n%2==0){
            return (y*y);
        }
        else{
            return (x)*(y*y);
        }

    }

}