package stepik.unit5;

import java.util.Arrays;
import java.util.List;

public class SpamAnalyzer extends KeyWordAnalyzer{
    private List<String> keyWords;

    public SpamAnalyzer(String... s ) {
        this.keyWords = Arrays.asList(s);
    }

    @Override
    protected List<String> getKeyWords() {
        return keyWords;
    }

    @Override
    protected Label getLabel() {
        return Label.SPAM;
    }
}
