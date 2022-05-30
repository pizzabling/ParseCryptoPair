package ru.itmatveev.parsecryptopair.service;

import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import ru.itmatveev.parsecryptopair.data.ByBitPairModel;
import ru.itmatveev.parsecryptopair.data.ExmoPairModel;
import ru.itmatveev.parsecryptopair.data.FTXPairModel;
import ru.itmatveev.parsecryptopair.publicConnect.Request;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
@Service
public class FTXParseService {
    private List<FTXPairModel> pairList = new ArrayList<>();
    private static final String FTX_BASE_URL = "https://ftx.com/api/";
    private Request request = new Request();
    private long id;


    public java.util.List<FTXPairModel> getPairList() {
        return pairList;
    }

    public void addPairInList(FTXPairModel model) {
        id = id + 1;
        pairList.add(model);
    }

    public void clearPairList() {
        pairList.clear();
    }

    public void parsePair() {
        clearPairList();
        String jsonString = request.sendRequest(FTX_BASE_URL, "markets", "GET", "");
        //System.out.println(jsonString);
        JSONObject obj = new JSONObject(jsonString);
        JSONArray jsonArray = new JSONArray(obj.getJSONArray("result"));
        for (int i = 0; i < jsonArray.length(); i++) {
            FTXPairModel model = new FTXPairModel();
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            if (jsonObject.isNull("bid")) {
            } else {
                model.setId(i);
                model.setPairName(jsonObject.getString("name").replace("-", "").replace("/", ""));
                model.setSell(BigDecimal.valueOf(jsonObject.getDouble("bid")));
                model.setBuy(BigDecimal.valueOf(jsonObject.getDouble("ask")));
                addPairInList(model);
                System.out.println(model);
            }

        }
    }
}