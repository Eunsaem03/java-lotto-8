package lotto.domain;

import lotto.Lotto;
import java.util.List;

public class WinningNumbers {

    private static final int MIN = 1;
    private static final int MAX = 45;

    private final Lotto mainNumbers;
    private final int bonusNumber;

    public WinningNumbers(List<Integer> mainNumbers, int bonusNumber) {
        this.mainNumbers = new Lotto(mainNumbers);

        validateBonusNumber(mainNumbers, bonusNumber);
        this.bonusNumber = bonusNumber;
    }


    public int matchCount(Lotto lotto) {
        return lotto.matchCount(mainNumbers);
    }

    public boolean bonusNumberMatched(Lotto lotto) {
        return lotto.contains(bonusNumber);
    }

    private static void validateBonusNumber(List<Integer> numbers, int bonusNumber) {
        validateRangeBonus(bonusNumber);
        validateDuplicateBonus(numbers, bonusNumber);
    }

    private static void validateDuplicateBonus(List<Integer> numbers, int bonusNumber) {
        for (int number : numbers) {
            if (number == bonusNumber) {
                throw new IllegalArgumentException("[ERROR] 중복된 숫자 없이 입력해야 합니다.");
            }
        }
    }

    private static void validateRangeBonus(int bonusNumber) {
        if (bonusNumber < MIN || bonusNumber > MAX) {
            throw new IllegalArgumentException("[ERROR] " + MIN + "~" + MAX + "범위 내의 숫자를 입력해야 합니다.");
        }
    }
}
