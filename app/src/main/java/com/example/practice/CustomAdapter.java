package com.example.practice;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class CustomAdapter extends ArrayAdapter<Result> {


    private Activity context;
    private List<Result> resultList;

    public CustomAdapter(Activity context,List<Result> resultList) {
        super(context, R.layout.sample_layout, resultList);
        this.context = context;
        this.resultList = resultList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater layoutInflater =context.getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.sample_layout,null,true);

        Result result = resultList.get(position);
        TextView t1 = view.findViewById(R.id.nameTextViewId);
        TextView t2 = view.findViewById(R.id.ageTextViewId);
        TextView t3 = view.findViewById(R.id.subjectTextViewId);
        TextView t4 = view.findViewById(R.id.gradeTextViewId);
        TextView t5 = view.findViewById(R.id.markTextViewId);

        t1.setText("name : "+result.getName());
        t2.setText("age : "+result.getAge());
        t3.setText("subject : "+result.getSubject());
        t4.setText("grade : "+result.getGrade());
        t5.setText("mark : "+result.getMark());


        return view;
    }
}
