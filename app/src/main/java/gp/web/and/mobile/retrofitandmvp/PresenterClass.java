package gp.web.and.mobile.retrofitandmvp;

import android.view.View;

/**
 * Created by Mayada on 4/5/2018.
 */

public class PresenterClass implements Contract.Presenter {

    private Contract.View view;
    private Contract.Model model;

    public PresenterClass (Contract.View v){
        view=v;
        initPresenter();
    }

    private void initPresenter() {
        model=new ModelClass();
        view.initView();
    }


    @Override
    public void click(View v) {
        String[] data= model.getData();
        view.setView(data);
    }


}
