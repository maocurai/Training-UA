public class Model {
    private String phrase = "";

    /**
     * in this method add word with this.phrase
     * @param word
     * @return phrase
     */
    public String addWordToPhrase(String word){
        return phrase += (phrase.length() == 0) ? word : (" " + word);
    }

    public String getPhrase() {
        return phrase;
    }

    public void setPhrase(String phrase) {
        this.phrase = phrase;
    }
}
