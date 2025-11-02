package lotto.domain;

import java.util.List;

public class Lotto {

    private static final int MIN = 1;
    private static final int MAX = 45;
    private static final int MAX_LOTTO_COUNT = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public static Lotto generate() {
        return new Lotto(NumberGenerator.generate());
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != MAX_LOTTO_COUNT) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 " + MAX_LOTTO_COUNT + "개여야 합니다.");
        }
        Lotto.validateDuplicateNumber(numbers);
        Lotto.validateRange(numbers);
    }

    private static void validateRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < MIN || number > MAX) {
                throw new IllegalArgumentException("[ERROR] " + MIN + "~" + MAX + "범위 내의 숫자를 입력해야 합니다.");
            }
        }
    }

    private static void validateDuplicateNumber(List<Integer> numbers) {
        long uniqueNumber = numbers.stream()
                .distinct()
                .count();

        if (uniqueNumber != MAX_LOTTO_COUNT) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자 없이 입력해야 합니다.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int matchCount(Lotto purchaseNumber) {
        int count = 0;

        for (Integer number : purchaseNumber.numbers) {
            if (this.numbers.contains(number)) count++;
        }

        return count;
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }
}
