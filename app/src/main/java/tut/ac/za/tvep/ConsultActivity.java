package tut.ac.za.tvep;

import android.content.pm.PackageManager;

import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;

import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;


import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.io.IOException;
import java.util.Date;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import tut.ac.za.tvep.classes.Message;

import static android.Manifest.permission.RECORD_AUDIO;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

public class ConsultActivity extends AppCompatActivity {

@BindView(R.id.rvConsult)
    RecyclerView rvConsult;
    @BindView(R.id.etMessage)
    EditText etMessage;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;




    private DatabaseReference db;

    private  DatabaseReference dbWrite;
    private FirebaseAuth mAuth;




    private FirebaseRecyclerAdapter<Message,RVConsultView> adapter;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consult);
        ButterKnife.bind(this);





        mAuth = FirebaseAuth.getInstance();
        db = FirebaseDatabase.getInstance().getReference().child("Consult").child("ConsultList");
        Query query = db.orderByChild("email").equalTo(mAuth.getCurrentUser().getEmail());
        dbWrite = FirebaseDatabase.getInstance().getReference();

        adapter = new FirebaseRecyclerAdapter<Message, RVConsultView>(Message.class,R.layout.consult,RVConsultView.class,query) {
            @Override
            protected void populateViewHolder(RVConsultView viewHolder, Message model, int position) {



                    progressBar.setVisibility(View.GONE);
                viewHolder.setMessage(model.getMessage());
                viewHolder.setDate(model.getDate());
                if(!"".equals(model.getUserEmail()))
                {
                    viewHolder.setEmail(model.getUserEmail());
                }else {
                    viewHolder.setEmail(model.getEmail());
                }



                }

        };

        rvConsult.setLayoutManager(new LinearLayoutManager(this));
        rvConsult.setAdapter(adapter);


    }



    public void onSubmit(View view)
    {


        if(!"".equals(etMessage.getText().toString()))
        {


            Message message = new Message();

            message.setEmail(mAuth.getCurrentUser().getEmail());
            message.setMessage(etMessage.getText().toString());
            message.setDate(new Date().toString());
            message.setTvepEmail("tvep12345@gmail.com");
            message.setUserEmail("");




            dbWrite.child("Consult").child("ConsultList").push().setValue(message);

            etMessage.setText("");




        }
    }



    private static class RVConsultView extends  RecyclerView.ViewHolder
    {

        private View mView;

        public RVConsultView(View itemView) {
            super(itemView);


            mView = itemView;
        }

        public void setMessage(String message)
        {


            TextView tvMessage = ButterKnife.findById(mView,R.id.tvMessage);
            tvMessage.setText(message);
            tvMessage.setVisibility(View.VISIBLE);
        }


        public void setEmail(String email){

            TextView tvEmail = ButterKnife.findById(mView,R.id.tvEmail);
            tvEmail.setText(email);
            tvEmail.setVisibility(View.VISIBLE);
        }


        public void setDate(String date)
        {

            TextView tvDate = ButterKnife.findById(mView,R.id.tvDate);

            String dat = (String) android.text.format.DateFormat.format("yyyy-MM-dd kk:mm:ss", Date.parse(date));
            tvDate.setText(dat);


            tvDate.setVisibility(View.VISIBLE);
        }









    }




}
