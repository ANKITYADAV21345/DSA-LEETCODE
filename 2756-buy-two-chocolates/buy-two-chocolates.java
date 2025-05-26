// class Solution {
//     public int buyChoco(int[] prices, int money) {
//         Arrays.sort(prices);
//         int total_price=prices[0] + prices[1];

//         if(total_price<=money)
//         return money-total_price;
//         else
//         return money;

        
//     }
// }




//aproach 2 (optimised)
class Solution{
    public int  buyChoco(int prices[],int money){
        int first=Integer.MAX_VALUE;
        int second=Integer.MAX_VALUE;

        for(int price:prices){
            if(price<=first){
                second=first;
                first=price;
            }
            else if(price<second)
                second=price;
        }

        int total_price=first+second;

        if(total_price<=money)
            return money-total_price;
        else
            return money;
    }
}