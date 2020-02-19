public class Poker {
    public static final int totalCards = 52;
    public static final int CardsPerColor = 13;
    public static final int handCards = 5;
    public static final int[] CardDeck = new int[totalCards];


    public static void initArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }
    }

    public static int[] dealhandCards(int[] array) {
        int[] hand = new int[handCards];
        for (int i = 0; i < hand.length; i++) {
            //   hand[i] = array[i];
        }
        return hand;
    }
    public static int CardColor(int card) {
        return (card % CardsPerColor);
    }

    public static int CardValue(int card) {
        return (card / CardsPerColor);
    }

    public static String[] determineCardType(int cards[]) {
        String[] cardT = new String[5];
        for (int i = 0; i < cards.length; i++) {
            int handCardsValue = (cards[i] / CardsPerColor);
            switch(handCardsValue) {
                case 0:
                    cardT[i] = "Herz";
                    break;

                case 1:
                    cardT[i] = "Kreuz";
                    break;

                case 2:
                    cardT[i] = "Pik";
                    break;

                case 3:
                    cardT[i] = "Karo";
                    break;
            }
        }
        return cardT;
    }
}