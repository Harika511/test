package com.example.harikag.spinnerapplication;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    Spinner passSpinner;
    EditText 
            dataSelling, silkingEt, sheddersEt, otPlantsEt;
    Button datesBt1, dovBt1,okBt1;
    ArrayList<GeneralDTO2> dataSellingList;
    private ArrayAdapter<GeneralDTO2> passAdapter;
    String Tag="MainActivity";
  

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setAllViews();
        setSpinnerData();
        setPassFiledsSpinner();
        enableEditText();
    }

    private void setAllViews() {



        passSpinner = (Spinner) findViewById(R.id.pass_spin);

//        datesEt,
//                dtVstEt,silkingEt,sheddersEt,otPlantsEt,dataSelling;

        datesBt1 = (Button) findViewById(R.id.dts_bt1);
        dovBt1 = (Button) findViewById(R.id.date_vst_bt1);
        dataSelling = (EditText) findViewById(R.id.dtslng1);

        silkingEt = (EditText) findViewById(R.id.silking_et1);

        sheddersEt = (EditText) findViewById(R.id.shedder_et1);

        otPlantsEt = (EditText) findViewById(R.id.ot_plants1);

     //   pass1Layout = (LinearLayout) findViewById(R.id.Pass1layout);

    }

        private void setPassFiledsSpinner() {

        //  silkingEt, sheddersEt, otPlantsEt, dataSelling;
        onTextChanged(dataSelling, silkingEt);
        onTextChanged(silkingEt, sheddersEt);
        onTextChanged(sheddersEt, otPlantsEt);
        enableSpinnerItem(otPlantsEt, passSpinner);

    }

    private void enableEditText() {
       // select++;
        dataSelling.setEnabled(true);
        silkingEt.setEnabled(false);
        sheddersEt.setEnabled(false);
        otPlantsEt.setEnabled(false);
      //  clearEditTexts();
    }

//
//    private void clearEditTexts() {
//
//        dataSelling.setText("");
//        silkingEt.setText("");
//        sheddersEt.setText("");
//        otPlantsEt.setText("");
//    }


    private void setSpinnerData() {
        dataSellingList = new ArrayList<GeneralDTO2>();
        GeneralDTO2 g = new GeneralDTO2();
        g.setCode(0);
        g.setName("Select");
        dataSellingList.add(g);


        GeneralDTO2 g1 = new GeneralDTO2();
        g1.setCode(1);
        g1.setName("Pass1");
        dataSellingList.add(g1);

        GeneralDTO2 g2 = new GeneralDTO2();
        g2.setCode(2);
        g2.setName("Pass2");
        dataSellingList.add(g2);

        GeneralDTO2 g3 = new GeneralDTO2();
        g3.setCode(3);
        g3.setName("Pass3");
        dataSellingList.add(g3);

        GeneralDTO2 g4 = new GeneralDTO2();
        g4.setCode(4);
        g4.setName("Data selling close");
        dataSellingList.add(g4);

        enableSpinnerItemWithPos(1);


    }

    private void enableSpinnerItemWithPos(final int pos) {

        passAdapter = new ArrayAdapter<GeneralDTO2>(
                this, R.layout.spinner,
                dataSellingList) {
            @Override
            public boolean isEnabled(int position) {
                if (position == pos) {
                    // Disable the second item from Spinner
                    return true;
                } else {
                    return false;
                }
            }

            @Override
            public View getDropDownView(int position, View convertView,
                                        ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
                TextView tv = (TextView) view;
                if(position==pos) {

                    tv.setTextColor(Color.BLACK);

                }
                else {

                    tv.setTextColor(Color.GRAY);

                }
                return view;
            }

        };


        passAdapter.setDropDownViewResource(R.layout.spinner_dropdown);

        passSpinner.setAdapter(passAdapter);


    }

    private void onTextChanged(final EditText field1, final EditText field2) {
        field1.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable s) {

                if (s.toString().length() != 0)
                    field2.setEnabled(true);

            }


            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {

            }
        });
    }

    private void enableSpinnerItem(final EditText field1, final Spinner sp) {

        field1.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable s) {

                if (s.length() != 0) {
                    int selectPos = sp.getSelectedItemPosition();
                    Log.e(Tag, "selected pos is " + selectPos);
                  //  spinPos.add(selectPos);
                    enableSpinnerItemWithPos(selectPos+1);

                    datesBt1.setText("Date");
                    dovBt1.setText("Date");
                    dataSelling.setText("");
                    silkingEt.setText("");
                    sheddersEt.setText("");
                    otPlantsEt.setText("");
                }
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {

            }
        });

    }

}
