public class Main {

    enum Label {
        SPAM, NEGATIVE_TEXT, TOO_LONG, OK
    }

    interface TextAnalyzer {
        Label processText(String text);
    }

    public static void main(String[] args) {
    }

    public Label checkLabels(TextAnalyzer[] analyzers, String text) {
        Label result = Label.OK;
        for (TextAnalyzer analyzer: analyzers) {
            result = analyzer.processText(text);
            if (result != Label.OK){
                break;
            }
        }
        return result;
    }

    public static abstract class KeywordAnalyzer implements TextAnalyzer{
        protected abstract String[] getKeywords();
        protected abstract Label getLabel();

        @Override
        public Label processText(String text) {
            for (String element: getKeywords()) {
                if (text.contains(element)) {
                    return getLabel();
                }
            }
            return Label.OK;
        }
    }

    public static class SpamAnalyzer extends KeywordAnalyzer {
        private final String[] keywords;

        public SpamAnalyzer(String[] keywords) {
            this.keywords = keywords;
        }

        @Override
        protected String[] getKeywords() {
            return keywords;
        }

        @Override
        protected Label getLabel() {
            return Label.SPAM;
        }
    }
    public static class NegativeTextAnalyzer extends KeywordAnalyzer{

        @Override
        protected String[] getKeywords() {
            return new String[]{":(", "=(", ":|"};
        }

        @Override
        protected Label getLabel() {
            return Label.NEGATIVE_TEXT;
        }
    }
    public class TooLongTextAnalyzer implements TextAnalyzer{
        private final int maxLength;

        public TooLongTextAnalyzer(int maxLength) {
            this.maxLength = maxLength;
        }

        @Override
        public Label processText(String text) {
            if (text.length() >= maxLength) {
                return Label.TOO_LONG;
            }
            return Label.OK;
        }
    }


}