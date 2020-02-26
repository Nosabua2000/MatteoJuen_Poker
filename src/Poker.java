public class Poker {
    public static final int totalCards = 52;
    public static final int CardsPerColor = 13;
    public static final int handCards = 5;
    public static final int[] CardDeck = new int[totalCards];
    //Ass, 2, 3, 4, 5, 6, 7, 8, 9, 10, Jack, Dame, König -> Ass, 2...
    // 0,  1, 2, 3, 4, 5, 6, 7, 8, 9,  10,   11,   12,      13, 14...
    //0%13 = 0 -> Ass   13%13 = 0 -> Ass

    public static void initArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
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

    public static String[] CardValue(int cards[]) {
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

    public static int DupeValues(int cardarray[]) {
        int duplicateValues = 0;
        for (int i = 0; i < cardarray.length; i++) {
            for (int j = 0; j < cardarray.length; j++) {
                if ((cardarray[i] % CardsPerColor == cardarray[j] % CardsPerColor) && i != j) {
                    duplicateValues++;
                }
            }
        }
        return duplicateValues;
    }

    public static int DupeTypes(int cardarray[]) {
        int duplicateColors = 0;
        for (int i = 0; i < cardarray.length; i++) {
            for (int j = 0; i < cardarray.length; i++) {
                if ((cardarray[i] / CardsPerColor == cardarray[j] / CardsPerColor) && i != j) {
                    duplicateColors++;
                }
            }
        }
        return duplicateColors;
    }

}