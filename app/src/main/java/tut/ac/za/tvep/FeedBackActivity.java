package tut.ac.za.tvep;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import butterknife.BindView;
import butterknife.ButterKnife;
import tut.ac.za.tvep.classes.BackgroundTask;

public class FeedBackActivity extends AppCompatActivity {

    @BindView(R.id.etComment)
    EditText etComment;
    @BindView(R.id.etSubject) EditText etSubject;
    BackgroundTask task;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed_back);

        ButterKnife.bind(this);

    }


    public void onSubmit(View view)
    {


        if("".equals(etSubject.getText().toString()))
        {
            Toast.makeText(FeedBackActivity.this,"Subject Field Ia Empty",Toast.LENGTH_LONG).show();
        }
        else if("".equals(etComment.getText()))
        {
            Toast.makeText(FeedBackActivity.this,"Comment Field Is Empty",Toast.LENGTH_LONG).show();
        }else
        {

            etComment.setText("");
            etSubject.setText("");
            task = new BackgroundTask(FeedBackActivity.this);
            task.execute(etSubject.getText().toString(),etComment.getText().toString());



            Toast.makeText(FeedBackActivity.this,"FeedBack Sent",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(FeedBackActivity.this,NavActivity.class);
            startActivity(intent);

        }




    }
}
