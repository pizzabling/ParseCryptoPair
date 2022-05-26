package ru.itmatveev.parsecryptopair.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.itmatveev.parsecryptopair.service.BinanceParseService;

import java.util.Scanner;

@Controller
public class MainController {

    private final BinanceParseService binanceService;

    public MainController(BinanceParseService binanceService) {
        this.binanceService = binanceService;
    }

    @GetMapping
    public String mainPage(Model model){
        getApi();
        binanceService.setBinanceApi(getApi());
        return "mainPage";
    }

    public static String getApi(){
        Scanner in = new Scanner(System.in);
        System.out.println("pub API:");
        String apiKey = in.next();
        in.close();
        return apiKey;
    }
}
