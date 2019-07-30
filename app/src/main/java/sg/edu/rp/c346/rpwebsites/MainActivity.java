package sg.edu.rp.c346.rpwebsites;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
Spinner spn1;
Spinner spn2;
Button btnGo;
    ArrayList<String> alNumbers;
    ArrayAdapter<String> aaNumbers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spn1=findViewById(R.id.spinner);
        spn2=findViewById(R.id.spinner2);
        btnGo=findViewById(R.id.button);
        alNumbers=new ArrayList<String>();
        //arrayadapter
        aaNumbers=new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,alNumbers);
        spn2.setAdapter(aaNumbers);

        spn1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                int pos=spn1.getSelectedItemPosition();
                alNumbers.clear();
                if(pos==0){
                    //Get the string-array and store as an Array
                    String[] strNumbers = getResources().getStringArray(R.array.subcataRP);

//Convert Array to List and add to the ArrayList
                    alNumbers.addAll(Arrays.asList(strNumbers));
                }else{
                    //Get the string-array and store as an Array
                    String[] strNumbers = getResources().getStringArray(R.array.subcataSOI);

//Convert Array to List and add to the ArrayList
                    alNumbers.addAll(Arrays.asList(strNumbers));
                }
                aaNumbers.notifyDataSetChanged();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Code for the action
                String pos2=spn2.getSelectedItem().toString();
                Intent intent2 = new Intent(getBaseContext(), SecondActivity.class);




                startActivity(intent2);

                String [][] sites={
                        {

                            "https://www.rp.edu.sg",
                                "https://www.rp.edu.sg/student-life"
                        },
                        {
                                "https://www.rp.edu.sg/soi/full-time-diplomas/details/r47",
                                "https://www.rp.edu.sg/soi/full-time-diplomas/details/r12",
                        }


                };

/*
                if(pos2.equals("Homepage")){
                    intent2.putExtra("url", "https://www.rp.edu.sg/");
                }else if(pos2.equals("Student Life")){
                    intent2.putExtra("url", "https://www.rp.edu.sg/student-life");
                }else if(pos2.equals("DMSD")){
                    intent2.putExtra("url", "https://www.rp.edu.sg/soi/full-time-diplomas/details/r47");
                }else if(pos2.equals("DIT")){
                    intent2.putExtra("url", "https://www.rp.edu.sg/soi/full-time-diplomas/details/r12");
                }*/
                String urlz=sites[spn1.getSelectedItemPosition()][spn2.getSelectedItemPosition()];
                intent2.putExtra("url",urlz);
                startActivity(intent2);
            }
        });


    }
}
