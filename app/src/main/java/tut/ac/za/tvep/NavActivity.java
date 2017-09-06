package tut.ac.za.tvep;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import tut.ac.za.tvep.Adapter.InfoAdapter;
import tut.ac.za.tvep.classes.Info;
import tut.ac.za.tvep.classes.User;

public class NavActivity extends AppCompatActivity {


    private FrameLayout content;
    private Context context = this;
    LayoutInflater inflater;
    View view;
    private FirebaseAuth mAuth;
    User user;
    private List<Info> infoList = new ArrayList<>();






    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:


                    content.removeAllViews();
                    inflater = null;
                    view=null;
                    inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    view = inflater.inflate(R.layout.info_view,null);


                    Button btnReport = ButterKnife.findById(view,R.id.btnReport);
                    btnReport.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            Intent intent = new Intent(NavActivity.this,ReportActivity.class);
                            startActivity(intent);

                        }
                    });


                    Button btnCentres = ButterKnife.findById(view,R.id.btnCentres);

                    btnCentres.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                         Intent intent = new Intent(NavActivity.this,CentreLocationActivity.class);
                            startActivity(intent);
                        }
                    });


                    Button btnConsult = ButterKnife.findById(view,R.id.btnConsult);
                    btnConsult.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {


                            Intent intent = new Intent(NavActivity.this,ConsultActivity.class);
                            startActivity(intent);
                        }
                    });




                    content.addView(view);

                    return true;
                case R.id.navigation_info:

                    content.removeAllViews();
                    inflater = null;
                    view=null;
                   inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                     view = inflater.inflate(R.layout.home_view,null);


                    RecyclerView rvInfo = ButterKnife.findById(view,R.id.rvInfo);
                    rvInfo.removeAllViews();
                    infoList.clear();

                    infoList.add(new Info("Sexual Abuse","https://en.wikipedia.org/wiki/Sexual_abuse"));
                    infoList.add(new Info("Physica Abuse","https://en.wikipedia.org/wiki/Physical_abuse"));
                    infoList.add(new Info("Sexual Abuse","https://www.relate.org.uk/relationship-help/help-relationships/arguing-and-conflict/what-emotional-abuse"));
                    infoList.add(new Info("HIV/AIDs","https://en.wikipedia.org/wiki/HIV/AIDS"));
                    infoList.add(new Info("Rape","https://https://en.wikipedia.org/wiki/Rape"));

                    InfoAdapter adapter = new InfoAdapter(NavActivity.this,infoList);

                    rvInfo.setLayoutManager(new LinearLayoutManager(NavActivity.this));
                    rvInfo.setAdapter(adapter);




                    content.addView(view);


                    return true;
                case R.id.navigation_profile:

                    content.removeAllViews();
                    inflater = null;
                    view=null;
                    inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                     view = inflater.inflate(R.layout.profile_view,null);

                    TextView tvName = ButterKnife.findById(view,R.id.tvName);
                    TextView tvEmail = ButterKnife.findById(view,R.id.tvEmail);
                    ImageView ivProfile = ButterKnife.findById(view,R.id.ivProfile);
                    Picasso.with(NavActivity.this).load(user.getImage()).into(ivProfile);
                    tvName.setText(user.getName());
                    tvEmail.setText(user.getEmail());






                    content.addView(view);

                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);


        mAuth = FirebaseAuth.getInstance();

        mAuth = FirebaseAuth.getInstance();

        if(mAuth.getCurrentUser() == null)
        {

            Intent intent = new Intent(NavActivity.this,LoginActivity.class);
            startActivity(intent);


        }else
        {

            user = new User();

            user.setEmail(mAuth.getCurrentUser().getEmail());
            user.setUserId(mAuth.getCurrentUser().getProviderId());
            user.setName(mAuth.getCurrentUser().getDisplayName());
            user.setImage(mAuth.getCurrentUser().getPhotoUrl().toString());
        }






        content = (FrameLayout) findViewById(R.id.content);


        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        content.removeAllViews();
        inflater = null;
        view=null;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.info_view,null);



        Button btnReport = ButterKnife.findById(view,R.id.btnReport);
        btnReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(NavActivity.this,ReportActivity.class);
                startActivity(intent);

            }
        });


        Button btnCentres = ButterKnife.findById(view,R.id.btnCentres);

        btnCentres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(NavActivity.this,CentreLocationActivity.class);
                startActivity(intent);
            }
        });


        Button btnConsult = ButterKnife.findById(view,R.id.btnConsult);
        btnConsult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(NavActivity.this,ConsultActivity.class);
                startActivity(intent);
            }
        });





        content.addView(view);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_nav, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.menu_signout) {
            mAuth.signOut();

            Intent intent = new Intent(NavActivity.this,LoginActivity.class);
            startActivity(intent);
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
