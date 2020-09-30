package fire.win.com.yvsr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class DataActivity extends AppCompatActivity {

    TextView textViewStatusone,textViewStatustwo,textViewStatusthree,textViewStatusfour,textViewStatusfive;
    DatabaseReference mref;

    private ProgressBar mProgressCircle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);

        mref = FirebaseDatabase.getInstance().getReference("Status");

        mProgressCircle = findViewById(R.id.progress_circle);

        textViewStatusone = findViewById(R.id.textViewStatusone);
        textViewStatustwo = findViewById(R.id.textViewStatustwo);
        textViewStatusthree = findViewById(R.id.textViewStatusthree);
        textViewStatusfour = findViewById(R.id.textViewStatusfour);
        textViewStatusfive = findViewById(R.id.textViewStatusfive);

        try {
        // Read from the database
        mref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                //String value1 = dataSnapshot.getValue(String.class);
                Statusdata sd = dataSnapshot.getValue(Statusdata.class);
                    textViewStatusone.setText(sd.getStatus1());
                    textViewStatustwo.setText(sd.getStatus2());
                    textViewStatusthree.setText(sd.getStatus3());
                    textViewStatusfour.setText(sd.getStatus4());
                    textViewStatusfive.setText(sd.getStatus5());
                mProgressCircle.setVisibility(View.INVISIBLE);
            }
            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Toast.makeText(DataActivity.this,"Error please try later",Toast.LENGTH_LONG).show();
                mProgressCircle.setVisibility(View.INVISIBLE);
            }
        });

        } catch (Exception e) {
            e.printStackTrace();
        }
/*
        mref.child("status2").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value2 = dataSnapshot.getValue(String.class);
                try {
                    textViewStatustwo.setText(value2);
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
            @Override
            public void onCancelled(DatabaseError error) {
                Toast.makeText(DataActivity.this,"Error please try later",Toast.LENGTH_LONG).show();
            }
        });
        mref.child("status3").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value3 = dataSnapshot.getValue(String.class);
                try {
                    textViewStatusthree.setText(value3);
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
            @Override
            public void onCancelled(DatabaseError error) {
                Toast.makeText(DataActivity.this,"Error please try later",Toast.LENGTH_LONG).show();
            }
        });
        mref.child("status4").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value4 = dataSnapshot.getValue(String.class);
                try {
                    textViewStatusfour.setText(value4);
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
            @Override
            public void onCancelled(DatabaseError error) {
                Toast.makeText(DataActivity.this,"Error please try later",Toast.LENGTH_LONG).show();
            }
        });
        mref.child("status5").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value5 = dataSnapshot.getValue(String.class);
                try {
                    textViewStatusfive.setText(value5);
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
            @Override
            public void onCancelled(DatabaseError error) {
                Toast.makeText(DataActivity.this,"Error please try later",Toast.LENGTH_LONG).show();
            }
        });


 */
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent a = new Intent(DataActivity.this,MainActivity.class);
        startActivity(a);
        finish();
    }
}
