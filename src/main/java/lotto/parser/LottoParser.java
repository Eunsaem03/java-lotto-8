package lotto.parser;

import java.util.List;
import java.util.Arrays;
import lotto.Lotto;

public class LottoParser {

    private static final String DELIMITER = ",";

    private LottoParser(){}

    public static int purchaseAmount(String input) {
        return Integer.parseInt(input.trim());
    }

    public static List<Integer> winningNumbers(String input) {
        return Arrays.stream(input.split(DELIMITER))
                .map(String::trim)
                .map(Integer::parseInt)
                .toList();
    }

    public static int bonusNumber(String input) {
        return Integer.parseInt(input.trim());
    }

}
