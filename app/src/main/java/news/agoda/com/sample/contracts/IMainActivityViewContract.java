package news.agoda.com.sample.contracts;

import java.util.List;

import news.agoda.com.sample.Model.Result;

/**
 * Created by jeffery.emanuel on 2017-02-24.
 */

public interface IMainActivityViewContract {
    void dataSetUpdated(List results);
    void goToDetailsActivity(Result data);

}
