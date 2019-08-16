package com.example.practice;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class News extends AppCompatActivity {

    private EditText nameR,gradeR,markR,subjectR,ageR;
    private Button saveResult;
    private Button next;
    private Button loadData;
    DatabaseReference databaseReference;



    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        nameR = findViewById(R.id.nameResultId);
        subjectR = findViewById(R.id.subjectEditTextId);
        markR = findViewById(R.id.marksEditTextId);
        gradeR = findViewById(R.id.gradeEditTextId);
        saveResult = findViewById(R.id.saveResultId);
        next = findViewById(R.id.nextButtonId);
        ageR = findViewById(R.id.ageId);
        loadData = findViewById(R.id.loadDataId);
        databaseReference = FirebaseDatabase.getInstance().getReference("Result");


        //data save methode ;

        saveResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveResult();
            }
        });

        //load data methode

        loadData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(News.this,LoadData.class);
                startActivity(intent);
            }
        });

        //going to new activity from one activity ;

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(News.this,Data.class);
                startActivity(intent);
            }
        });



        mAuth = FirebaseAuth.getInstance();

        this.setTitle("RESULT");
    }

    public void saveResult() {


        String name = nameR.getText().toString().trim();
        String subject = subjectR.getText().toString().trim();
        String mark = markR.getText().toString().trim();
        String grade = gradeR.getText().toString().trim();
        String age = ageR.getText().toString().trim();


        String key = databaseReference.push().getKey();

        Result result = new Result(name,subject,mark,grade,age);

        databaseReference.child(key).setValue(result);
        Toast.makeText(getApplicationContext(),"successful",Toast.LENGTH_LONG).show();

        nameR.setText("");
        subjectR.setText("");
        markR.setText("");
        gradeR.setText("");
        ageR.setText("");

    }



    //this work for sign out option

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId()==R.id.signOutId)
        {
            FirebaseAuth.getInstance().signOut();
            finish();
            Intent intent = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}
