/*
This program serves the purpose of helping a user learn to count cards by calculating the probability
of winning a hand based on the cards that have been dealt in a deck. It can account for multiple players
and multiple decks. 
*/

package blackjack;
import java.util.*;
/**
 *
 * @author alecshunnarah
 */
public class BlackJack {
    private HashMap<Character, Integer> cardVals = new HashMap();
    
   
    public static void main(String[] args) {
        
        // get the number of decks that we will be playing with and the number of players
        Scanner in = new Scanner(System.in);
        System.out.print("How many decks of cards will be used today? ");
        int numOfDecks = in.nextInt();
        System.out.print("How many players will be in this game? ");
        int numOfPlayers = in.nextInt();
        playBlackJack(numOfDecks, numOfPlayers);
        
    }
    
    public static void playBlackJack(int numOfDecks, int numOfPlayers){
        
    }
    
}
