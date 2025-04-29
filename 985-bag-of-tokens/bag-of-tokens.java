import java.util.Arrays;

class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        // Tokens ko sort karo taaki chhote tokens pehle aayein
        Arrays.sort(tokens);
        int score = 0; // Score ko 0 se initialize karo
        int i = 0, j = tokens.length - 1; // i ko 0 se aur j ko last index se initialize karo

        // Jab tak i chhota ya barabar hai j ke
        while (i <= j) {
            // Agar current token i power se chhota ya barabar hai
            if (tokens[i] <= power) {
                score++; // Score ko 1 se badhao
                power -= tokens[i++]; // Power se current token ko minus karo aur i ko 1 se badhao
            } 
            // Agar score 0 se zyada hai aur tokens[i] power se chhota ya barabar hai jab tokens[j] ko add karte hain
            else if (score > 0 && tokens[i] <= (power + tokens[j]) && i != j) {
                power += tokens[j--]; // Power ko last token se badhao aur j ko 1 se kam karo
                score--; // Score ko 1 se kam karo
            } 
            // Agar upar wale dono conditions nahi meet hoti
            else {
                break; // Loop se bahar aa jao
            }
        }
        // Final score ko return karo
        return score;
    }
}
