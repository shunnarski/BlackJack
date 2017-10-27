/*
Stack implementation for a deck of cards in the game of black
*/
package blackjack;
import java.util.*;
public class DeckStack {
    private class Card{
        char value;
        Card next;
        
        public Card(char c){
            this.value = c;
        } 
    }   
    private Card top;
    private int value = 0;

    public void push(char c){
        Card card = new Card(c);
        card.next = top;
        top = card;
    }
    
    public char pop(){
        if(top == null) throw new EmptyStackException();
        char c = top.value;
        top = top.next;
        return c;
    }
    
    public boolean isEmpty(){
        return top == null;
    }
    
    public char peek(){
        if(top == null) throw new EmptyStackException();
        return top.value;
    }
    
    public int getStackVals(){
        return 0;
    }
}
