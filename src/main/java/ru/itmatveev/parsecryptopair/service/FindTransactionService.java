package ru.itmatveev.parsecryptopair.service;

import org.springframework.stereotype.Service;
import ru.itmatveev.parsecryptopair.data.BinancePairModel;
import ru.itmatveev.parsecryptopair.data.ByBitPairModel;
import ru.itmatveev.parsecryptopair.data.ExmoPairModel;
import ru.itmatveev.parsecryptopair.data.FTXPairModel;

import java.util.ArrayList;
import java.util.List;

@Service
public class FindTransactionService {
    private final BinanceParseService binanceService;
    private final ByBitParseService byBitService;
    private final ExmoParseService exmoService;
    private final FTXParseService ftxService;

    private List<BinancePairModel> binancePairList;
    private List<ByBitPairModel> byBitPairList;
    private List<ExmoPairModel> exmoPairList;
    private List<FTXPairModel> ftxPairList;
    private List<String> identialPairs = new ArrayList<>();

    public FindTransactionService(BinanceParseService binanceService, ByBitParseService byBitService, ExmoParseService exmoService, FTXParseService ftxService, List<BinancePairModel> binancePairList, List<ByBitPairModel> byBitPairList, List<ExmoPairModel> exmoPairList, List<FTXPairModel> ftxPairList) {
        this.binanceService = binanceService;
        this.byBitService = byBitService;
        this.exmoService = exmoService;
        this.ftxService = ftxService;
        this.binancePairList = binancePairList;
        this.byBitPairList = byBitPairList;
        this.exmoPairList = exmoPairList;
        this.ftxPairList = ftxPairList;
    }

    public void getPairs() {
        binancePairList = binanceService.getPairList();
        byBitPairList = byBitService.getPairList();
        exmoPairList = exmoService.getPairList();
        ftxPairList = ftxService.getPairList();
    }

    public void findIdentPairsForAllEx() {
        BinancePairModel binanceModel;
        ByBitPairModel byBitModel;
        ExmoPairModel exmoModel;
        FTXPairModel ftxModel;

        for (BinancePairModel binancePairModel : binancePairList) {
            binanceModel = binancePairModel;
            for (ByBitPairModel byBitPairModel : byBitPairList) {
                byBitModel = byBitPairModel;
                if (binanceModel.getPairName().equals(byBitModel.getPairName())) {
                    for (ExmoPairModel exmoPairModel : exmoPairList) {
                        exmoModel = exmoPairModel;
                        if (byBitModel.getPairName().equals(exmoModel.getEditName())) {
                            for (FTXPairModel ftxPairModel : ftxPairList) {
                                ftxModel = ftxPairModel;
                                if (byBitModel.getPairName().equals(ftxModel.getPairName())) {
                                    identialPairs.add(ftxModel.getPairName());
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println(identialPairs);
    }

    public void findIdentPairForBinance() {

    }
}
