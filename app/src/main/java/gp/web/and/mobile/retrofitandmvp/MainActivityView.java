package gp.web.and.mobile.retrofitandmvp;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import butterknife.BindDrawable;
import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivityView extends Activity implements Contract.View{

    @BindView(R.id.clkbtn)
    Button clkbtn;
   @BindView(R.id.listView)
    ListView list;
    @BindView(R.id.imageview)
    ImageView view;
    @BindDrawable(R.drawable.minion)
    Drawable d;
    Contract.Presenter pres;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_view);
        pres=new PresenterClass(this);


    }

    @Override
    public void initView() {
        //  list=findViewById(R.id.listView);
        // clkbtn=findViewById(R.id.clkbtn);
        ButterKnife.bind(this);
        view.setImageDrawable(d);
//  clkbtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//          public void onClick(View view) {
//                pres.click(view);
//            }
//        });
        }

        @OnClick(R.id.clkbtn)   //Butter Knife
        public void onButtonClicked(View view){
        pres.click(view);
        }


    @Override
    public void setView(String[] data) {
        if (data!=null){
            list.setAdapter(new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, data));
        }
        else {
            Toast.makeText(getApplicationContext(),"Try next time....",Toast.LENGTH_LONG).show();

        }
    }
}
