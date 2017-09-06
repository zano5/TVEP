package tut.ac.za.tvep;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlaceAutocompleteFragment;
import com.google.android.gms.location.places.ui.PlaceSelectionListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import butterknife.BindView;
import butterknife.ButterKnife;
import tut.ac.za.tvep.classes.Area;
import tut.ac.za.tvep.classes.Report;

public class ReportActivity extends AppCompatActivity {


    @BindView(R.id.etDescription)
    EditText etDescription;
    @BindView(R.id.spSubject)
    Spinner spSubject;
    String option;
    String[] optionsArray;

    private DatabaseReference db;
    PlaceAutocompleteFragment autocompleteFragment;
    Area area;
    private FirebaseAuth mAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

        ButterKnife.bind(this);
         optionsArray = getResources().getStringArray(R.array.report_options);


        mAuth = FirebaseAuth.getInstance();
        autocompleteFragment = (PlaceAutocompleteFragment)
                getFragmentManager().findFragmentById(R.id.place_autocomplete_fragment);


        db = FirebaseDatabase.getInstance().getReference();

        ArrayAdapter<String> adapter =new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,optionsArray);

        spSubject.setAdapter(adapter);


        spSubject.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {


                option = optionsArray[i];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        location();

    }


    public void location()
    {


        autocompleteFragment.setOnPlaceSelectedListener(new PlaceSelectionListener() {
            @Override
            public void onPlaceSelected(Place place) {
                // TODO: Get info about the selected place.
                //Log.i(TAG, "Place: " + place.getName());

                 area = new Area();

                area.setAreaAddress(String.valueOf(place.getAddress()));
                area.setAreaName(String.valueOf(place.getName()));


            }

            @Override
            public void onError(Status status) {
                // TODO: Handle the error.
                //Log.i(TAG, "An error occurred: " + status);
            }
        });
    }


    public void onReport(View view)
    {


        if("".equals(etDescription.getText().toString()))
        {

            Toast.makeText(ReportActivity.this,"Enter Description",Toast.LENGTH_SHORT).show();
        }else if("".equals(area.getAreaAddress()))
        {

            Toast.makeText(ReportActivity.this,"Enter location",Toast.LENGTH_SHORT).show();
        }else
        {


            Report report = new Report();

            report.setArea(area);
            report.setDescription(etDescription.getText().toString());
            report.setSubject(option);
            report.setEmail(mAuth.getCurrentUser().getEmail());

            db.child("Report").child("ReportList").push().setValue(report);


            Intent intent = new Intent(ReportActivity.this,NavActivity.class);
            startActivity(intent);

        }




    }


}
