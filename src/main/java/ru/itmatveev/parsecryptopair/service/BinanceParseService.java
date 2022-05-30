package ru.itmatveev.parsecryptopair.service;

import org.json.JSONArray;
import org.json.JSONObject;
import ru.itmatveev.parsecryptopair.data.BinancePairModel;
import org.springframework.stereotype.Service;
import ru.itmatveev.parsecryptopair.publicConnect.Request;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class BinanceParseService {
    private List<BinancePairModel> pairList = new ArrayList<>();
    private static final String BINANCE_BASE_URL = "https://api.binance.com/api/v3/";
    private Request request = new Request();
    private long id;


    public List<BinancePairModel> getPairList() {
        return pairList;
    }

    public void addPairInList(BinancePairModel model) {
        id = id + 1;
        pairList.add(model);
    }

    public void clearPairList() {
        pairList.clear();
    }

    public void parsePair() {
        clearPairList();
        String jsonResponse = request.sendRequest(BINANCE_BASE_URL,
                "ticker/24hr",
                "GET",
                ""
        );

        JSONArray jsonArray = new JSONArray(jsonResponse);
        for (int i = 0; i < jsonArray.length(); i++){
            BinancePairModel model = new BinancePairModel();
            JSONObject obj = jsonArray.getJSONObject(i);

            model.setId(i);
            model.setPairName(obj.getString("symbol"));
            model.setSell(BigDecimal.valueOf(obj.getDouble("bidPrice")));
            model.setBuy(BigDecimal.valueOf(obj.getDouble("askPrice")));

            addPairInList(model);
            System.out.println(model);
        }
    }
}
