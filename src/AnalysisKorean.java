import org.bitbucket.eunjeon.seunjeon.Analyzer;
import org.bitbucket.eunjeon.seunjeon.Term;
import org.bitbucket.eunjeon.seunjeon.TermNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by md on 15. 10. 2..
 */
public class AnalysisKorean {

    public List getNouns(String text) {
        List term_list = new ArrayList();
        List<TermNode> result = Analyzer.parseJava(text);
        for (TermNode termNode: result) {
            Term term = termNode.term();
            if (isNoun(term)) {
                term_list.add(term.surface());
            }
        }
        return term_list;
    }

    /**
     * 명사 여부 확인
     * NNG 일반 명사
     * NNP 고유 명사
     * NNB 의존 명사
     * NP 대명사
     * SL 외국어
     * @param term term
     * @return boolean
     */
    public boolean isNoun(Term term) {
        String tag = term.feature().split(",")[0];
        return tag.equals("NNG") || tag.equals("NNP") || tag.equals("NNB") || tag.equals("NP") || tag.equals("SL");
    }
}
