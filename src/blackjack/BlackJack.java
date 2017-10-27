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

        deal(players);
        printCards(players);
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

    private static void printDeal(ArrayList<Player> players) {

        for (int i = 0; i < players.size(); i++) {

            ArrayList<Character> cards = players.get(i).getCards();
            String cardStr = "";
            for (int j = 0; j < cards.size(); j++) {
                // if its the dealer we want to hide the second card for now
                if (i == 0) {
                    
                }
                else{
                    cardStr += cards.get(j) + " ";
                }
                
            }
            System.out.println(players.get(i).getName() + ": " + cardStr);
        }
    }

}
