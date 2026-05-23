class Solution {
    public int[] scoreValidator(String[] events) {
        int ans[]=new int[2];
        ans[0]=0;
        ans[1]=0;
        for(int i=0;i<events.length;i++){
            if(ans[1]==10){
                break;
            }
            
            else if(events[i].equals("0")){
                ans[0]=ans[0]+0;
            }
            else if(events[i].equals("1")){
                ans[0]=ans[0]+1;
            }
            else if(events[i].equals("2")){
                ans[0]=ans[0]+2;
            }
            else if(events[i].equals("3")){
                ans[0]=ans[0]+3;
            }
            else if(events[i].equals("4")){
                ans[0]=ans[0]+4;
            }
            else if(events[i].equals("6")){
                ans[0]=ans[0]+6;
            }
            else if(events[i].equals("W")){
                ans[1]=ans[1]+1;
            }
            else if(events[i].equals("WD")){
                ans[0]=ans[0]+1;
            }
            else if(events[i].equals("NB")){
                ans[0]=ans[0]+1;
            }


        }
        return ans;
    }
}