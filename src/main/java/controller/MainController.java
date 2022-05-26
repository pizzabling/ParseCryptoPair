package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import service.BinanceParseService;

@Controller
public class MainController {
    private final BinanceParseService binanceService;

    public MainController(BinanceParseService binanceService) {
        this.binanceService = binanceService;
    }

    @GetMapping
    public String mainPage(Model model){
        return "mainPage";
    }
}
