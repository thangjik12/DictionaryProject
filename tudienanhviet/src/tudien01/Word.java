package tudien01;

public class Word {
    private String wordTarget, wordExplain, wordSound;

    public Word(String wordTarget, String wordExplain) {
        this.wordTarget = wordTarget;
        this.wordExplain = wordExplain;
    }


    public String getWordTarget() {
        return wordTarget;
    }

    public void setWordTarget(String wordTarget) {
        this.wordTarget = wordTarget;
    }

    public String getWordExplain() {
        return wordExplain;
    }

    public void setWordExplain(String wordExplain) {
        this.wordExplain = wordExplain;
    }

    public String getWordSound() {
        return wordSound;
    }

    public void setWordSound(String wordSound) {
        this.wordSound = wordSound;
    }
}
