package ru.itmatveev.parsecryptopair.service;

import ru.itmatveev.parsecryptopair.data.BinancePairModel;
import org.springframework.stereotype.Service;
import ru.itmatveev.parsecryptopair.privateConnect.Binance;

import java.util.ArrayList;
import java.util.List;
/*CYlHa2XhZf6Mh9tlgWYAUJk5SWU6wR2i9zRM0ty0GmmROh8TVGy6t5ZtvHb0bqKb*/
@Service
public class BinanceParseService {
    private Binance binanceApi;
    private List<BinancePairModel> pairList = new ArrayList<>();
    private long id;
    private String apiKey;

    public List<BinancePairModel> getPairList(){
        return pairList;
    }

    public void addPairInList(BinancePairModel model){
        id = id + 1;
        pairList.add(model);
    }

    public void clearPairList(){
        pairList.clear();
    }

    public void setBinanceApi(String key){
        apiKey = key;
    }

    public void parsePair(){
        binanceApi = new Binance(apiKey,"");


    }
}
