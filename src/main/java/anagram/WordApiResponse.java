package anagram;

import java.util.List;

public class WordApiResponse {

    String word;
    String phonetic;

    List<Meaning> meanings;

    public static class Meaning{
        String partOfSpeech;
        List<Definition> definitions;

        public Meaning(String partOfSpeech,
                       List<Definition> definitions) {
            this.partOfSpeech = partOfSpeech;
            this.definitions = definitions;
        }

        public String getPartOfSpeech() {
            return partOfSpeech;
        }

        public void setPartOfSpeech(String partOfSpeech) {
            this.partOfSpeech = partOfSpeech;
        }

        public List<Definition> getDefinitions() {
            return definitions;
        }

        public void setDefinitions(List<Definition> definitions) {
            this.definitions = definitions;
        }

        @Override
        public String toString() {
            return "Meaning{" +
                    "partOfSpeech='" + partOfSpeech + '\'' +
                    ", definitions=" + definitions +
                    '}';
        }
    }

    public static class Definition{
        String definition;
        String example;

        public Definition(String definition,
                          String example) {
            this.definition = definition;
            this.example = example;
        }

        public void setDefinition(String definition) {
            this.definition = definition;
        }

        public void setExample(String example) {
            this.example = example;
        }

        public String getDefinition() {
            return definition;
        }

        public String getExample() {
            return example;
        }

        @Override
        public String toString() {
            return "Definition{" +
                    "definition='" + definition + '\'' +
                    ", example='" + example + '\'' +
                    '}';
        }
    }

    public WordApiResponse(String word,
                           String phonetic,
                           List<Meaning> meanings) {
        this.word = word;
        this.phonetic = phonetic;
        this.meanings = meanings;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getPhonetic() {
        return phonetic;
    }

    public void setPhonetic(String phonetic) {
        this.phonetic = phonetic;
    }

    public List<Meaning> getMeanings() {
        return meanings;
    }

    public void setMeanings(List<Meaning> meanings) {
        this.meanings = meanings;
    }

    @Override
    public String toString() {
        return "WordApiResponse{" +
                "word='" + word + '\'' +
                ", phonetic='" + phonetic + '\'' +
                ", meanings=" + meanings +
                '}';
    }
}
