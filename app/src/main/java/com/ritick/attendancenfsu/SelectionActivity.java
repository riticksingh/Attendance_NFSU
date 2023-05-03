package com.ritick.attendancenfsu;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Application;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ArrayAdapter.*;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SelectionActivity extends AppCompatActivity {

    String selectedSchool, selectedCourse, selectedBatch;

    TextView tvSchoolSpinner , tvCourseSpinner, tvBatchSpinner;
    Spinner schoolSpinner , courseSpinner, batchSpinner;

    ArrayAdapter<CharSequence> schoolAdapter, courseAdapter, batchAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);

        schoolSpinner = findViewById(R.id.spinner_school);

        schoolAdapter = ArrayAdapter.createFromResource(this, R.array.array_school,R.layout.spinner_layout);
        schoolAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        schoolSpinner.setAdapter(schoolAdapter);

        schoolSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                courseSpinner = findViewById(R.id.spinner_course);
                selectedSchool = schoolSpinner.getSelectedItem().toString();
                System.out.println("Selected School :"+selectedSchool);

                int parent_id = adapterView.getId();
                System.out.println("Parent Id: " + parent_id);
                System.out.println(R.id.spinner_school);

                if (parent_id==R.id.spinner_school){
                    switch (selectedSchool){
                        case "Select your School" :
                            System.out.println("Selected Course Switch : "+ selectedCourse);
                            courseAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                                R.array.array_default,R.layout.spinner_layout);
                        break;
                        case "SCSDFS" :
                            courseAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                                R.array.array_SCSDFS_course,R.layout.spinner_layout);
                        break;
                        case "SFS" :
                            courseAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                                R.array.array_SFS_course,R.layout.spinner_layout);
                        break;
                        case "SBS" :
                            courseAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                                R.array.array_SBS_course,R.layout.spinner_layout);
                        break;

                        default:
                            break;
                    }
                    courseAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    courseSpinner.setAdapter(courseAdapter);

                }
                
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        batchSpinner = findViewById(R.id.spinner_batch);



    }
}