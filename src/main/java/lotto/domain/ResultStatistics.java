package lotto.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class ResultStatistics {

    private final Map<Rank, Integer> counts = new EnumMap<>(Rank.class);
    private final long totalPrize;

    public ResultStatistics(List<LottoResult> results) {
        for (Rank rank : Rank.values()) counts.put(rank, 0);
        long sum = 0;
        for (LottoResult result : results) {
            Rank rank = result.toRank();
            counts.put(rank, counts.get(rank) + 1);
            sum += rank.prize;
        }
        this.totalPrize = sum;
    }

    public int countOf(Rank rank) {
        return counts.get(rank);
    }

    public double calculateYield(int purchaseAmount) {
        if (purchaseAmount == 0) {
            return 0.0;
        }
        return (double) totalPrize / purchaseAmount;
    }
}
