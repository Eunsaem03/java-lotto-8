package lotto.domain;

import lotto.Lotto;
import java.util.List;
import lotto.validator.InputValidator;

public class WinningNumbers {

    private static final int MIN = 1;
    private static final int MAX = 45;
    private static final int MAX_LOTTO_COUNT = 6;

    private final Lotto mainNumbers;
    private final int bonusNumber;

    public WinningNumbers(List<Integer> mainNumbers, int bonusNumber) {
        WinningNumbers.validateWinningNumber(mainNumbers);
        WinningNumbers.validateBonusNumber(mainNumbers, bonusNumber);
        this.mainNumbers = new Lotto(mainNumbers);
        this.bonusNumber = bonusNumber;
    }

    private static void validateWinningNumber(List<Integer> numbers) {
        WinningNumbers.validateMaxCount(numbers);
        WinningNumbers.validateRange(numbers);
        WinningNumbers.validateDuplicateNumber(numbers);
    }

    private static void validateBonusNumber(List<Integer> numbers, int bonusNumber) {
        WinningNumbers.validateRangeBonus(bonusNumber);
        WinningNumbers.validateDuplicateBonus(numbers, bonusNumber);
    }

    private static void validateMaxCount(List<Integer> numbers) {
        if (numbers.size() != MAX_LOTTO_COUNT) {
            throw new IllegalArgumentException("[ERROR] " + MAX_LOTTO_COUNT + "개의 숫자를 입력해야 합니다.");
        }
    }

    private static void validateDuplicateNumber(List<Integer> numbers) {
        long uniqueNumber = numbers.stream()
                .distinct()
                .count();

        if (uniqueNumber != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자 없이 입력해야 합니다.");
        }
    }

    private static void validateDuplicateBonus(List<Integer> numbers, int bonusNumber) {
        for (int number : numbers) {
            if (number == bonusNumber) {
                throw new IllegalArgumentException("[ERROR] 중복된 숫자 없이 입력해야 합니다.");
            }
        }
    }

    private static void validateRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < MIN || number > MAX) {
                throw new IllegalArgumentException("[ERROR] " + MIN + "~" + MAX + "범위 내의 숫자를 입력해야 합니다.");
            }
        }
    }

    private static void validateRangeBonus(int bonusNumber) {
        if (bonusNumber < MIN || bonusNumber > MAX) {
            throw new IllegalArgumentException("[ERROR] " + MIN + "~" + MAX + "범위 내의 숫자를 입력해야 합니다.");
        }
    }
}
