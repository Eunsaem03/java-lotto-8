package lotto.controller;

import java.util.List;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;
import lotto.domain.ResultStatistics;
import lotto.domain.WinningNumbers;
import lotto.parser.LottoParser;
import lotto.validator.InputValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final OutputView outputView = new OutputView();

    public void run() {
        String amountInput = InputView.inputPurchaseAmount();
        InputValidator.validate(amountInput);
        int purchaseAmount = LottoParser.purchaseAmount(amountInput);

        Lottos lottos = Lottos.fromAmount(purchaseAmount);
        outputView.printPurchasedLottos(lottos);

        String winningInput = InputView.inputWinningNumber();
        InputValidator.validateWinningNumbers(winningInput);
        List<Integer> winningNumbers = LottoParser.winningNumbers(winningInput);

        String bonusInput = InputView.inputBonusNumber();
        InputValidator.validate(bonusInput);
        int bonusNumber = LottoParser.bonusNumber(bonusInput);

        WinningNumbers winning =new WinningNumbers(winningNumbers, bonusNumber);

        List<LottoResult> results = lottos.evaluate(winning);
        ResultStatistics stats = new ResultStatistics(results);
        outputView.printStatistics(stats);

        double yield = stats.calculateYield(purchaseAmount) * 100.0;
        outputView.printYield(yield);
    }
}
