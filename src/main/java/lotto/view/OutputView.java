package lotto.view;

import lotto.Lotto;
import lotto.domain.*;

public class OutputView {

    public void printPurchasedLottos(Lottos lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos.getLottos()) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void printStatistics(ResultStatistics stats) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.printf("3개 일치 (5,000원) - %d개%n", stats.countOf(Rank.FIFTH));
        System.out.printf("4개 일치 (50,000원) - %d개%n", stats.countOf(Rank.FOURTH));
        System.out.printf("5개 일치 (1,500,000원) - %d개%n", stats.countOf(Rank.THIRD));
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개%n", stats.countOf(Rank.SECOND));
        System.out.printf("6개 일치 (2,000,000,000원) - %d개%n", stats.countOf(Rank.FIRST));
    }

    public void printYield(double yield) {
        System.out.printf("총 수익률은 %.2f입니다.%n", yield);
    }
}
