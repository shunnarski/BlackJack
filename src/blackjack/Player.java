/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;
import java.util.*;
/**
 *
 * @author alecshunnarah
 */
public class Player {
    private String playerName;
    private ArrayList<Character> playerCards = new ArrayList();
    
    public void setName(String name){
        this.playerName = name;
    }
    
    public String getName(){
        return playerName;
    }
    
    public ArrayList<Character> getCards(){
        return playerCards;
    }
    
    public int totalCardValue(HashMap<Character, Integer> map){
        int value = 0;
        for(int i = 0; i < playerCards.size(); i++){
            value += map.get(playerCards.get(i));
        }
        
        return value;
    }
    
    public void addCard(char c){
        playerCards.add(c);
    }
    
    
    
    
}
