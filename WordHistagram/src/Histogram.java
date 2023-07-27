import java.util.*;

public class Histogram implements Iterable<String> {
    private Map<String, Integer> histogram;

    public Histogram() {
        histogram = new HashMap<>();
    }

    public void analyseString(String toAnalyse) {
        String[] words = toAnalyse.toLowerCase().split("\\s+");
        Arrays.sort(words,Comparator.comparingInt(String::length));
        for (String word : words) {
            histogram.put(word, histogram.getOrDefault(word, 0) + 1);
        }
    }
    public static void organizeBySize(String[] words) {
        int n = words.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (words[j].length() > words[j + 1].length()) {
                    String temp = words[j];
                    words[j] = words[j + 1];
                    words[j + 1] = temp;
                }
            }
        }
    }


    public int get(String word) {
        return histogram.getOrDefault(word.toLowerCase(), 0);
    }

    @Override
    public Iterator<String> iterator() {
        return histogram.keySet().iterator();
    }


}
