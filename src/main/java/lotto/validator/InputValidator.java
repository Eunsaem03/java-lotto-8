package lotto.validator;

import java.util.List;

public class InputValidator {
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

    private static void validate(String input) {
        InputValidator.validateNotBlank(input);
        InputValidator.validateIsNumber(input);
    }
}
