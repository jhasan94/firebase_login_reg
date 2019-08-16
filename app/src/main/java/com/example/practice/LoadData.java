package com.example.practice;

import android.os.Bundle;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class LoadData extends AppCompatActivity {

    private ListView listView;
    DatabaseReference databaseReference;
    private List<Result>resultList;
    private CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_data);

        listView = findViewById(R.id.listViewId);
        resultList = new ArrayList<>();
        customAdapter = new CustomAdapter(LoadData.this,resultList);
        databaseReference = FirebaseDatabase.getInstance().getReference("Result");

    }

    @Override
    protected void onStart() {

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                resultList.clear();
                for(DataSnapshot dataSnapshot1 :dataSnapshot.getChildren())
                {
                    Result result = dataSnapshot1.getValue(Result.class);
                    resultList.add(result);
                }
                listView.setAdapter(customAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        super.onStart();
    }
}
