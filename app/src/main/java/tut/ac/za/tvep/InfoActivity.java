package tut.ac.za.tvep;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import tut.ac.za.tvep.classes.Info;

public class InfoActivity extends AppCompatActivity {


    private List<Info> infoList = new ArrayList<>();





    @BindView(R.id.rvInfo)
    RecyclerView rvInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);


        ButterKnife.bind(this);


        infoList.add(new Info("Sexual Abuse","https://en.wikipedia.org/wiki/Sexual_abuse"));
        infoList.add(new Info("Physica Abuse","https://en.wikipedia.org/wiki/Physical_abuse"));
        infoList.add(new Info("Sexual Abuse","https://www.relate.org.uk/relationship-help/help-relationships/arguing-and-conflict/what-emotional-abuse"));
        infoList.add(new Info("HIV/AIDs","https://en.wikipedia.org/wiki/HIV/AIDS"));
        infoList.add(new Info("Rape","https://https://en.wikipedia.org/wiki/Rape"));



    }
}
