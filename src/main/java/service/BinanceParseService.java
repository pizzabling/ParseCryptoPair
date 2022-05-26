package service;

import data.BinancePairModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BinanceParseService {
    private List<BinancePairModel> pairList = new ArrayList<>();
    private long id;

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

    public void parsePair(){

    }
}
