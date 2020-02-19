public class Poker {
    public static final int totalCards = 52;
    public static final int CardsPerColor = 13;
    public static final int handCards = 5;
    public static final int[] CardDeck = new int[totalCards];


    public static void initArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }
    }
}