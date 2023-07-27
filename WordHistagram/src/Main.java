// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
      WordHistogram wordHistogram = new WordHistogram();
      wordHistogram.addCharacterToWord("jucilo dos santos benguela");

      System.out.println(wordHistogram.get("jucilo"));
      System.out.println("------------------------------");
      System.out.println("------------------------------");
      Histogram histogram = new Histogram();
      histogram.analyseString("jucilo dos santos benguela benguela");
        for (String word:histogram) {
            System.out.println(word + ": " + histogram.get(word));

        }

    }
}