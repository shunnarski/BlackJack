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

    private static DeckStack deck;
    private static final int BLACKJACK = 21;

    /*
    Driver method 
     */
    public static void main(String[] args) {

        // get the number of decks that we will be playing with and the number of players
        Scanner in = new Scanner(System.in);
        System.out.print("What is your name? ");
        String playerName = in.nextLine();
        System.out.print("How many decks of cards will be used today? ");
        int numOfDecks = in.nextInt();
        System.out.print("How many players will be in this game? ");
        int numOfPlayers = in.nextInt();
        deck = new DeckStack(numOfDecks);
        playBlackJack(numOfPlayers, playerName);

    }

    /*
    This method is responsible for getting the user setup for playing the game
    of BlackJack
     */
    public static void playBlackJack(int numOfPlayers, String playerName) {
        ArrayList<Player> players = new ArrayList();
        Scanner in = new Scanner(System.in);
        // create players for the game
        Dealer dealer = new Dealer();
        dealer.setName("Dealer");
        players.add(dealer);

        for (int i = 0; i < numOfPlayers - 1; i++) {
            CompPlayer ai = new CompPlayer();
            String name = "COMP" + (i + 1);
            ai.setName(name);
            players.add(ai);
        }
        UserPlayer user = new UserPlayer();
        user.setName(playerName);
        players.add(user);
        System.out.println();
        
        while(true){
            usersPlay(players);
            dealerPlays(players, dealer);
            clearTable(players);
            
            System.out.println("\nPlay another game? Yes or no.");
            String answer = in.nextLine().toLowerCase();
            if(answer.equals("no"))
                break;
        }
        

    }

    private static void deal(ArrayList<Player> players) {
        // deal two cards to each player including the dealer
        for (int i = 0; i < players.size(); i++) {
            players.get(i).addCard(deck.pop());
        }
        for (int i = 0; i < players.size(); i++) {
            players.get(i).addCard(deck.pop());
        }
    }

    private static void printNoFlip(ArrayList<Player> players) {
        System.out.println();
        for (Player p : players) {
            if (p instanceof Dealer) {
                ((Dealer) p).printCardNoFlip();
            } else {
                p.printAllCards();
                System.out.println();
            }
        }
    }
    
    private static void printFinal(ArrayList<Player> players, Dealer dealer){
        System.out.println();
        dealer.printAllCards();
        System.out.println();
        for(Player p: players){
            if(!(p instanceof Dealer)){
                p.printAllCards();
                
                if(p.totalCardValue() <= BLACKJACK){
                    if(dealer.totalCardValue() > BLACKJACK || p.totalCardValue() > dealer.totalCardValue()){
                        System.out.println("YOU WIN!");
                    }
                    else if(p.totalCardValue() == dealer.totalCardValue()){
                        System.out.println("PUSH");
                    }
                    else{
                        System.out.println("YOU LOSE!");
                    }
                }
                else{
                    System.out.println();
                }

            }
        }
    }
    
    private static void printAll(ArrayList<Player> players){
        System.out.println();
        for(Player p: players){
            p.printAllCards();
            System.out.println();
        }
    }

    private static char hit() {
        return deck.pop();
    }

    private static void usersPlay(ArrayList<Player> players) {
        Scanner in = new Scanner(System.in);

        deal(players);
        printNoFlip(players);

        for (int i = 0; i < players.size(); i++) {
            Player p = players.get(i);

            if (p instanceof UserPlayer) {
                while (p.totalCardValue() <= BLACKJACK) {
                    System.out.print("Type \"hit\" to hit or \"stay\" to stay. ");
                    System.out.println("Chance of bust on hit: " + deck.chanceOfBust(p.totalCardValue()));
                    String dec = in.nextLine();
                    System.out.println();
                    if (dec.equals("stay")) {
                        break;
                    } else if (dec.equals("hit")) {
                        p.addCard(hit());
                        printNoFlip(players);
                    } else {
                        System.out.println("Invalid input\n");
                    }
                }
            }
            else if(p instanceof CompPlayer){
                while(p.totalCardValue() <= BLACKJACK){
                    if (deck.chanceOfBust(p.totalCardValue()) > 50) {
                        break;
                    } else {
                        p.addCard(hit());
                        printNoFlip(players);
                    }
                }
            }

        }

    }

    private static void dealerPlays(ArrayList<Player> players, Dealer dealer) {
        
        printAll(players);
        
        while(dealer.totalCardValue() <= 16){
            dealer.addCard(hit());
            printAll(players);
        }
         
        printFinal(players, dealer);
    }
    
    private static void clearTable(ArrayList<Player> players){
        for(Player p : players){
            p.getCards().clear();
        }
    }

//    private static void printDeal(ArrayList<Player> players) {
//
//        for (int i = 0; i < players.size(); i++) {
//
//            ArrayList<Character> cards = players.get(i).getCards();
//            String cardStr = "";
//            for (int j = 0; j < cards.size(); j++) {
//                // if its the dealer we want to hide the second card for now
//                if (i == 0) {
//                    
//                }
//                else{
//                    cardStr += cards.get(j) + " ";
//                }
//                
//            }
//            System.out.println(players.get(i).getName() + ": " + cardStr);
//        }
//    }
}
