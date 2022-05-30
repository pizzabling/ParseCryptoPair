package ru.itmatveev.parsecryptopair.service;

import kotlin.jvm.internal.SerializedIr;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import ru.itmatveev.parsecryptopair.data.ByBitPairModel;
import ru.itmatveev.parsecryptopair.publicConnect.Request;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
@Service
public class ByBitParseService {
    private List<ByBitPairModel> pairList = new ArrayList<>();
    private static final String BYBIT_BASE_URL = "https://api.bybit.com/v2/public/";
    private Request request = new Request();
    private long id;


    public List<ByBitPairModel> getPairList() {
        return pairList;
    }

    public void addPairInList(ByBitPairModel model) {
        id = id + 1;
        pairList.add(model);
    }

    public void clearPairList() {
        pairList.clear();
    }

    public void parsePair(){
        clearPairList();
        String jsonString = request.sendRequest(BYBIT_BASE_URL, "tickers", "GET", "");
        //System.out.println(jsonString);
        JSONObject obj = new JSONObject(jsonString);
        JSONArray jsonArray = new JSONArray(obj.getJSONArray("result"));
        for (int i = 0; i < jsonArray.length(); i++) {
            ByBitPairModel model = new ByBitPairModel();
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            model.setId(i);
            model.setPairName(jsonObject.getString("symbol"));
            model.setSell(BigDecimal.valueOf(jsonObject.getDouble("bid_price")));
            model.setBuy(BigDecimal.valueOf(jsonObject.getDouble("ask_price")));
            addPairInList(model);
            System.out.println(model);
        }
    }

}
