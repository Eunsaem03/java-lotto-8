package lotto;

import lotto.domain.Lottos;
import lotto.validator.InputValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputValidatorTest {
    @Test
    @DisplayName("공백이 들어오거나 숫자가 아니면 예외가 발생한다.")
    void validateNumber() {
        String input = " a";

        assertThatThrownBy(() -> InputValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("공백이 들어오거나 숫자가 아니면 예외가 발생한다.")
    void validateWinningNumber() {
        String input = ", ,a";

        assertThatThrownBy(() -> InputValidator.validateWinningNumbers(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("금액이 1000원 단위가 아니면 예외가 발생한다.")
    void validatePurchaseAmount() {
        assertThatThrownBy(() -> Lottos.fromAmount(1500))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
