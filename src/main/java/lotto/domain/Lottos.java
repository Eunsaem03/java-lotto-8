package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;

public class Lottos {

    private static final int MONEY = 1000;

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public List<LottoResult> evaluate(WinningNumbers winningNumbers) {
        List<LottoResult> results = new ArrayList<>();

        for (Lotto lotto : lottos) {
            int matchCount = winningNumbers.matchCount(lotto);
            boolean bonusNumberMatched = winningNumbers.bonusNumberMatched(lotto);
            results.add(new LottoResult(lotto, matchCount, bonusNumberMatched));
        }

        return results;
    }

    public static Lottos fromAmount(int purchaseAmount) {
        validateAmount(purchaseAmount);
        int totalLottoCount = purchaseAmount / MONEY;

        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < totalLottoCount; i++) {
            lottos.add(Lotto.generate());
        }
        return new Lottos(lottos);
    }

    private static void validateAmount(int purchaseAmount) {
        validatePurchaseAmountUnit(purchaseAmount);
        validateMinimumPurchaseAmount(purchaseAmount);
    }

    private static void validatePurchaseAmountUnit(int purchaseAmount) {
        if (purchaseAmount % MONEY != 0) {
            throw new IllegalArgumentException("[ERROR] " + MONEY + "원 단위로 입력해야 합니다.");
        }
    }

    private static void validateMinimumPurchaseAmount(int purchaseAmount) {
        if (purchaseAmount < MONEY) {
            throw new IllegalArgumentException("[ERROR] 한 장 이상 구매해야 합니다.");
        }
    }

}
