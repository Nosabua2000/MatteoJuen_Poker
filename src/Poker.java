public class Poker {
    public static final int totalCards = 52;
    public static final int CardsPerColor = 13;
    public static final int handCards = 5;
    public static final int[] CardDeck = new int[totalCards];
    public static boolean royalflash = false;
    //Ass, 2, 3, 4, 5, 6, 7, 8, 9, 10, Jack, Dame, König -> Ass, 2...
    // 0,  1, 2, 3, 4, 5, 6, 7, 8, 9,  10,   11,   12,      13, 14...
    //0%13 = 0 -> Ass   13%13 = 0 -> Ass

    public static void initArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }
    }

    public static int[] deal(int[] cardarray, int number) {
        int[] random = new int[number];
        for (int i = 0; i < number; i++) {
            int rand = (int) (Math.random() * (cardarray.length - 1 - i));
            random[i] = cardarray[rand];
            int storage = cardarray[rand];
            cardarray[rand] = cardarray[cardarray.length - 1 - i];
            cardarray[cardarray.length - 1 - i] = storage;
        }
        return random;
    }


    public static int cardColor(int card) {
        return (card % CardsPerColor);
    }


    public static int cardValue(int card) {
        return (card / CardsPerColor);
    }


    public static int dupeValues(int[] cardarray) {
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

    public static int dupeTypes(int[] cardarray) {
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

    public static boolean paar(int[] cards) {
        return dupeValues(cards) == 2;
    }

    public static boolean zweipaare(int[] cards) {
        return dupeValues(cards) == 4;
    }

    public static boolean drillinge(int[] cards) {
        return dupeValues(cards) == 6;
    }

    public static boolean straight(int[] cards) {
        if (cards[0] == 0 && cards[1] == 1 && cards[2] == 2 && cards[3] == 3 && cards[4] == 12)
            return true;
        for (int i = 1; i < cards.length; i++) {
            if ((cardValue(cards[i]) - cardValue(cards[i - 1])) != 1) {
                return false;
            }
        }
        return true;
    }

    public static boolean flush(int[] cards) {
        return dupeTypes(cards) == 4;
    }

    public static boolean fullHouse(int[] cards) {
        return dupeValues(cards) == 8;
    }

    public static boolean vierling(int[] cards) {
        return dupeValues(cards) == 12;
    }

    public static boolean straightFlush(int[] cards) {
        return straight(cards) && flush(cards);
    }

    public static boolean royalFlush(int[] cards) {
        int storage = cardValue(cards[cards.length - 1]);
        if (storage == 0) {
            storage = cardValue(cards[0]);
            for (int i = 1; i < cards.length - 1; i++) {
                if (storage + 1 == cardValue(cards[i])) {
                    royalflash = true;
                    storage = cardValue(cards[i]);
                } else {
                    royalflash = false;
                }
            }
        }
        return royalflash;
    }
}
