import java.util.Arrays;

public class main {
    public static void main(String[] args) {
        //Array initialisieren und Karten ziehen
        Poker.initArray(Poker.deck);
        int[] handCards = Poker.deal(Poker.deck, Poker.handCards);
        System.out.println("Die gezogenen Karten sind");
        System.out.println(Arrays.toString(handCards));


        //Es wird durchgaenge-mal durchlaufen und sammelt die daten wie oft etwas vorhanden ist im Array
        final int durchgaenge = 1000000;
        int[] count = new int[9];
        for (int i = 0; i <= durchgaenge; i++) {
            handCards = Poker.deal(Poker.deck, Poker.handCards);
            Arrays.sort(handCards);
            if (Poker.paar(handCards))
                count[0]++;

            if (Poker.zweipaare(handCards))
                count[1]++;

            if (Poker.drillinge(handCards))
                count[2]++;

            if (Poker.straight(handCards))
                count[3]++;

            if (Poker.flush(handCards))
                count[4]++;

            if (Poker.fullHouse(handCards))
                count[5]++;

            if (Poker.vierling(handCards))
                count[6]++;

            if (Poker.straightFlush(handCards))
                count[7]++;

            if (Poker.royalFlush(handCards))
                count[8]++;
        }
        //alle Wahrscheinlichkeiten werden mit count ausgerechnet
        float[] warsch = new float[9];
        String[] c = {"paar", "zwei paare", "drilling", "straight", "flush", "fullhouse", "vierling", "straight-flush", "royalflush"};
        for (int i = 0; i < count.length; i++) {
            warsch[i] = (float)count[i] / durchgaenge * 100;
            System.out.printf("%2d. %-20s %1.4f%%\n",  i + 1, c[i], warsch[i]);
        }
    }
}
