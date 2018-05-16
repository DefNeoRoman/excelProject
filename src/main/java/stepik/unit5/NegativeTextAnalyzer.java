package stepik.unit5;

import java.util.Arrays;
import java.util.List;

public class NegativeTextAnalyzer extends KeyWordAnalyzer {
    private List<String> keyWords = Arrays.asList("bad","negative");
    public NegativeTextAnalyzer() {
    }

    @Override
    protected List<String> getKeyWords() {
        return keyWords;
    }

    @Override
    protected Label getLabel() {
        return Label.NEGATIVE_TEXT;
    }
}
