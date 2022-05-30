package ru.itmatveev.parsecryptopair.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.itmatveev.parsecryptopair.service.*;

@Controller
public class MainController {

    private final FindTransactionService transactionService;
    private final BinanceParseService binanceParseService;
    private final ByBitParseService byBitParseService;
    private final ExmoParseService exmoParseService;
    private final FTXParseService ftxParseService;

    public MainController(FindTransactionService transactionService, BinanceParseService binanceParseService, ByBitParseService byBitParseService, ExmoParseService exmoParseService, FTXParseService ftxParseService) {
        this.transactionService = transactionService;
        this.binanceParseService = binanceParseService;
        this.byBitParseService = byBitParseService;
        this.exmoParseService = exmoParseService;
        this.ftxParseService = ftxParseService;
    }


    @GetMapping
    public String mainPage(Model model){
        transactionService.findIdentPairsForAllEx();
        return "mainPage";
    }
}
