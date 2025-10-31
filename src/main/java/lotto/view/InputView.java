package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String inputPurchaseAmount() {
        String purchaseAmount = Console.readLine();
        System.out.println("구입금액을 입력해 주세요.");
        return purchaseAmount;
    }

    public static String inputWinningNumber() {
        String winningNumber = Console.readLine();
        System.out.println("당첨 번호를 입력해 주세요.");
        return winningNumber;
    }

    public static String inputBonusNumber() {
        String bonusNumber = Console.readLine();
        System.out.println("보너스 번호를 입력해 주세요.");
        return bonusNumber;
    }
}
