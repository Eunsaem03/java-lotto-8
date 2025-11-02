package lotto.domain;

public class LottoResult {

    private final Lotto lotto;
    private final int matchCount;
    private final boolean bonusNumberMatched;

    public LottoResult(Lotto lotto, int matchCount, boolean bonusNumberMatched) {
        this.lotto = lotto;
        this.matchCount = matchCount;
        this.bonusNumberMatched = bonusNumberMatched;
    }

    public Lotto getLotto() {
        return lotto;
    }

    public Rank toRank() {
        return Rank.of(matchCount, bonusNumberMatched);
    }
}
