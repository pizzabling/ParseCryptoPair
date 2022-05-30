package ru.itmatveev.parsecryptopair;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.itmatveev.parsecryptopair.data.BinancePairModel;
import ru.itmatveev.parsecryptopair.data.ExmoPairModel;
import ru.itmatveev.parsecryptopair.privateConnect.Binance;
import ru.itmatveev.parsecryptopair.service.BinanceParseService;
import ru.itmatveev.parsecryptopair.service.ByBitParseService;
import ru.itmatveev.parsecryptopair.service.ExmoParseService;
import ru.itmatveev.parsecryptopair.service.FTXParseService;

import java.util.Scanner;

@SpringBootApplication
public class ParseCryptoPairApplication {

    public static void main(String[] args) {
        SpringApplication.run(ParseCryptoPairApplication.class, args);
        //ExmoParseService service = new ExmoParseService();
        //BinanceParseService service = new BinanceParseService();
        //ByBitParseService service = new ByBitParseService();
        //FTXParseService service = new FTXParseService();
        //service.parsePair();
    }

}
