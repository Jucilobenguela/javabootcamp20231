import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.StringJoiner;


public class WordHistogram implements Iterable<String> {
    private Map<String,Integer> histogram;
    public WordHistogram(){
        histogram = new HashMap<>();

    }

    /**
     * acrescenta caractar nas palavras inferiores para que tenham mesmo tamanho das
     * palavras superiores
     * @param toAnalyse
     */
    public void addCharacterToWord(String toAnalyse){
        String[] words = toAnalyse.toLowerCase().split("\\s");
        for (String word : words) {
            int subtract = analyseString(toAnalyse).length()-word.length();
            System.out.println(word+multiplyCharacter(subtract));

        }
    }

    /**
     * faz comparação da palavra armazenando palavra que tiver mais carácteres
     * @param toAnalyse
     * @return longWord
     */
    private String analyseString(String toAnalyse){
        String[] words = toAnalyse.toLowerCase().split("\\s");
        String longWord = "";
        int soma = 0;
        for (String word : words) {
                if( word.length()>longWord.length()){
                    longWord = word;
                }
        }
        return longWord;
    }
    public StringBuilder multiplyCharacter(int number){
       StringBuilder builder = new StringBuilder();
        for (int i = 0; i < number; i++) {
            builder.append('.');
        }
        return builder;
    }
    public int get (String word) {
      return histogram.getOrDefault(word.toLowerCase(),0);
    }

    @Override
    public Iterator<String> iterator() {
        return histogram.keySet().iterator();
    }
}
