/*
Stack implementation for a deck of cards in the game of black
*/
package blackjack;
import java.util.*;


public class DeckStack<T> {
    private class Card{
        char value;
        Card next;
        
        public Card(char c){
            this.value = c;
        } 
    }   
    private Card top;
    public static HashMap<Character, Integer> map;
    private int deckCount = 0;
    private int numOfDecks = 0;
    
    // Constructor for creating the DeckStack used to play the game of blackjack
    public DeckStack(int numOfDecks) {
        map = new HashMap();
        this.numOfDecks = numOfDecks;
        createCardMap();
        createDeck(numOfDecks);    
    }
    
    public DeckStack(){
        map = new HashMap();
        createCardMap();
    }
    
    /*
    Pushes a new value on the top of the stack
    */
    public void push(char c){
        Card card = new Card(c);
        card.next = top;
        top = card;
        deckCount++;
    }
    
    /*
    Pops the value at the top of the stack. After the card is popped from the stack
    it is out of the stack
    */
    public char pop(){
        if(top == null) throw new EmptyStackException();
        char c = top.value;
        top = top.next;
        deckCount--;
        if(isEmpty()){
            createDeck(numOfDecks);
        }
        return c;
    }
    
    /*
    This value returns true if the stack is currently empty
    and false if otherwise
    */
    public boolean isEmpty(){
        return top == null;
    }
    
    /*
    This method returns the value at the top of the stack
    */
    public char peek(){
        if(top == null) throw new EmptyStackException();
        return top.value;
    }
    
    public int size(){
        return deckCount;
    }
    
    /*
    Takes in one parameter: currentVal which is the value of the cards
    a player currently has. This value is used to determine the number of cards
    in the deck to draw from that will cause this number to go over 21.
    
    This methods calculates the chance of a bust if the player decides to hit
    */
    public double chanceOfBust(int currentVal){
        Card t = top;
        double bustCount = 0;
        final int bustVal = 21 - currentVal;
        while(t != null){
            if(map.get(t.value) > bustVal){
                bustCount++;
            }
            t = t.next;
        }
        
        return ((bustCount / this.size()) * 100);
        
    }
    
    /*
    This method maps each character value in the card 
    to an integer value
    */
    public static void createCardMap(){
        map.put('2', 2);
        map.put('3', 3);
        map.put('4', 4);
        map.put('5', 5);
        map.put('6', 6);
        map.put('7', 7);
        map.put('8', 8);
        map.put('9', 9);
        map.put('T', 10);
        map.put('J', 10);
        map.put('Q', 10);
        map.put('K', 10);
        map.put('A', 1);
    }
    
    /*
    This method takes in an integer that represents the number of 
    decks used to play the game of blackjack
    */
    private void createDeck(int numOfDecks){
        //create the deck
        ArrayList<Character> cards = new ArrayList();
        for(int i = 0; i < (4*numOfDecks); i++) {
            cards.add('2');
            cards.add('3');
            cards.add('4');
            cards.add('5');
            cards.add('6');
            cards.add('7');
            cards.add('8');
            cards.add('9');
            cards.add('T');
            cards.add('J');
            cards.add('Q');
            cards.add('K');
            cards.add('A');
        }
        
        // shuffle the cards
        Collections.shuffle(cards);
        
        for(int i = 0; i < cards.size(); i++){
            this.push(cards.get(i));
        }
    }
    
}
