package gp.web.and.mobile.retrofitandmvp;

import android.view.View;

/**
 * Created by Mayada on 4/5/2018.
 */

public interface Contract {

    interface View{
         void initView();
         void setView(String[] data);
    }

    interface Model {
         String[] getData();
    }

    interface Presenter {
         void click(android.view.View v);
    }

}
