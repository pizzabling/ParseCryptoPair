package ru.itmatveev.parsecryptopair.service;

import org.json.JSONObject;
import org.springframework.stereotype.Service;
import ru.itmatveev.parsecryptopair.data.ExmoPairModel;
import ru.itmatveev.parsecryptopair.publicConnect.Request;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class ExmoParseService {
    private List<ExmoPairModel> pairList = new ArrayList<>();
    private static final String EXMO_BASE_URL = "https://api.exmo.com/v1.1/";
    private Request request = new Request();
    private long id;


    public List<ExmoPairModel> getPairList() {
        return pairList;
    }

    public void addPairInList(ExmoPairModel model) {
        id = id + 1;
        pairList.add(model);
    }

    public void clearPairList() {
        pairList.clear();
    }

    public void parsePair(){
        clearPairList();
        String jsonString = request.sendRequest(EXMO_BASE_URL, "ticker", "POST", "");
        //System.out.println(jsonString);
        JSONObject obj = new JSONObject(jsonString);
        for (int i = 0; i < obj.names().length(); i++) {
            ExmoPairModel model = new ExmoPairModel();
            model.setId(i);
            model.setPairName((String) obj.names().get(i));
            model.setEditName(((String) obj.names().get(i)).replace("_", ""));
            model.setSell(BigDecimal.valueOf(obj.getJSONObject(model.getPairName()).getDouble("sell_price")));
            model.setBuy(BigDecimal.valueOf(obj.getJSONObject(model.getPairName()).getDouble("buy_price")));
            addPairInList(model);
            System.out.println(model);
        }
    }
}
