/*
This program serves the purpose of helping a user learn to count cards by calculating the probability
of winning a hand based on the cards that have been dealt in a deck. It can account for multiple players
and multiple decks. 

To exit the program, type '#' and the program will terminate.
*/

package blackjack;
import java.util.*;
/**
 *
 * @author alecshunnarah
 */
public class BlackJack {
    private static HashMap<Character, Integer> cardVals = new HashMap();
    
   
    public static void main(String[] args) {
        
        // get the number of decks that we will be playing with and the number of players
        Scanner in = new Scanner(System.in);
        System.out.print("What is your name? ");
        String playerName = in.nextLine();
        System.out.print("How many decks of cards will be used today? ");
        int numOfDecks = in.nextInt();
        System.out.print("How many players will be in this game? ");
        int numOfPlayers = in.nextInt();
        playBlackJack(numOfDecks, numOfPlayers, playerName);
        
    }
    
    public static void playBlackJack(int numOfDecks, int numOfPlayers, String playerName){
        cardVals.put('2', 2);
        cardVals.put('3', 3);
        cardVals.put('4', 4);
        cardVals.put('5', 5);
        cardVals.put('6', 6);
        cardVals.put('7', 7);
        cardVals.put('8', 8);
        cardVals.put('9', 9);
        cardVals.put('T', 10);
        cardVals.put('J', 10);
        cardVals.put('Q', 10);
        cardVals.put('K', 10);
        cardVals.put('A', 1);
        
        Player user = new Player();
        user.setName(playerName);
        
        //create the deck
        ArrayList<Character> cards = new ArrayList();
        for(int i = 0; i < (4*numOfDecks); i++)
            cards.add('2');
        for(int i = 0; i < (4*numOfDecks); i++)
            cards.add('3');
        for(int i = 0; i < (4*numOfDecks); i++)
            cards.add('4');
        for(int i = 0; i < (4*numOfDecks); i++)
            cards.add('5');
        for(int i = 0; i < (4*numOfDecks); i++)
            cards.add('6');
        for(int i = 0; i < (4*numOfDecks); i++)
            cards.add('7');
        for(int i = 0; i < (4*numOfDecks); i++)
            cards.add('8');
        for(int i = 0; i < (4*numOfDecks); i++)
            cards.add('9');
        for(int i = 0; i < (4*numOfDecks); i++)
            cards.add('T');
        for(int i = 0; i < (4*numOfDecks); i++)
            cards.add('J');
        for(int i = 0; i < (4*numOfDecks); i++)
            cards.add('Q');
        for(int i = 0; i < (4*numOfDecks); i++)
            cards.add('K');
        for(int i = 0; i < (4*numOfDecks); i++)
            cards.add('A');
        
        // shuffle the cards
        Collections.shuffle(cards);
        
        // place the cards in a stack
        Stack<Character> deck = new Stack();
        for(int i = 0; i < cards.size(); i++){
            deck.push(cards.get(i));
        }
    }
    
    public void shuffleCards(int numOfDecks){
        
    }
    
}
