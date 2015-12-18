/**
 * Created by snyder on 2015-05-11.
 */
public class HiddenWord {
    private final String hiddenWord;

    public HiddenWord(String hiddenWord) {
        this.hiddenWord = hiddenWord;
    }

    public String getHint(String guessedWord){
        return getString1(guessedWord);
    }

    /*
        String length:10000  Time:124.934779
        String length:20000  Time:357.004541
        String length:40000  Time:1887.283979
        String length:80000  Time:1923.153691
        String length:160000 Time:4213.633660
     */
    private String getString2(String guessedWord) {
        int length = guessedWord.length();
        String result ="";
        for (int i = 0; i < length; i++) {
            String buffer = guessedWord.substring(i, i + 1);
            if (guessedWord.indexOf(buffer) == i) {
                result = result + buffer;
            } else if ((guessedWord.indexOf(buffer) != -1)) {
                result = result + "+";
            }
            if ((guessedWord.indexOf(buffer) == -1)) {
                result = result + "*";
            }
        }
        return result;
    }


    /*
        String length:10000  Time:2.671263
        String length:20000  Time:3.085478
        String length:40000  Time:8.089733
        String length:80000  Time:9.574179
        String length:160000 Time:7.621328
     */
    private String getString1(String guessedWord) {
        char[] result = guessedWord.toCharArray();
        for (int i=0; i<result.length; i++){
            if(!hiddenWord.contains(String.valueOf(result[i])))
                result[i] = '*';
            else if (result[i] != hiddenWord.charAt(i))
                result[i] = '+';
        }
        return new String(result);
    }
}
