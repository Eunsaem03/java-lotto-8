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
}
