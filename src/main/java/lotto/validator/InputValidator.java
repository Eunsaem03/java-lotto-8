package lotto.validator;

import java.util.List;

public class InputValidator {

    private static final int MIN = 1;
    private static final int MAX = 45;
    private static final int MONEY = 1000;
    private static final int MAX_LOTTO_COUNT = 6;

    private InputValidator() {}

    private static void validateNotBlank(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 유효한 숫자를 입력해야 합니다.");
        }
    }

    private static void validateWinningNumberFormat(String input) {
        String[] numbers = input.split(",");
        for (String number : numbers) {
            String trimmed = number.trim();
            if (!trimmed.matches("\\d+")) {
                throw new IllegalArgumentException("[ERROR] 숫자를 입력해야 합니다.");
            }
        }
    }

    private static void validateIsNumber(String input) {
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해야 합니다.");
        }
    }

    private static void validatePurchaseAmountUnit(String input) {
        int value = Integer.parseInt(input);

        if (value % MONEY != 0) {
            throw new IllegalArgumentException("[ERROR] " + MONEY + "원 단위로 입력해야 합니다.");
        }
    }

    private static void validateMaxCount(List<Integer> numbers) {
        if (numbers.size() != MAX_LOTTO_COUNT) {
            throw new IllegalArgumentException("[ERROR] " + MAX_LOTTO_COUNT + "개의 숫자를 입력해야 합니다.");
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

    private static void validate(String input) {
        InputValidator.validateNotBlank(input);
        InputValidator.validateIsNumber(input);
    }

    public static void validatePurchaseAmount(String input) {
        InputValidator.validate(input);
        InputValidator.validatePurchaseAmountUnit(input);
    }

    public static void validateWinningNumberString(String input) {
        InputValidator.validateNotBlank(input);
        InputValidator.validateWinningNumberFormat(input);
    }

    public static void validateWinningNumber(List<Integer> numbers) {
        InputValidator.validateMaxCount(numbers);
        InputValidator.validateRange(numbers);
        InputValidator.validateDuplicateNumber(numbers);
    }

    public static void validateBonusNumber(String input, List<Integer> numbers, int bonusNumber) {
        InputValidator.validate(input);
        InputValidator.validateRangeBonus(bonusNumber);
        InputValidator.validateDuplicateBonus(numbers, bonusNumber);
    }
}
