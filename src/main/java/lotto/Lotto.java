package lotto;

import java.util.List;
import lotto.domain.NumberGenerator;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public static Lotto generate() {
        return new Lotto(NumberGenerator.generate());
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int matchCount(Lotto PurchaseNumber) {
        int count = 0;

        for (Integer number : PurchaseNumber.numbers) {
            if (this.numbers.contains(number)) count++;
        }

        return count;
    }
}
