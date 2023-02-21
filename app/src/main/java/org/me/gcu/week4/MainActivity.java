package org.me.gcu.week4;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {

    Spinner spinnerC;
    CheckBox mushroom, sweetcorn, cheese;
    TextView yesno;
    String pizza = "";

    Button button;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.button);
        Spinner spinner = findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);
        //Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.crust, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        mushroom = (CheckBox) findViewById(R.id.mushroomCheckbox);
        sweetcorn = (CheckBox) findViewById(R.id.sweetcornCheckbox);
        cheese = (CheckBox) findViewById(R.id.cheeseCheckBox);
        yesno = (TextView) findViewById(R.id.yesno);
        //Boolean checkBoxState = mushroom.isChecked();

        mushroom.setOnClickListener(this);
        sweetcorn.setOnClickListener(this);
        cheese.setOnClickListener(this);
        button.setOnClickListener(this);

    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long id) {
        adapterView.getItemAtPosition(pos);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.mushroomCheckbox:
                if(mushroom.isChecked() == true)
                     Toast.makeText(getApplicationContext(), "Mushroom", Toast.LENGTH_LONG).show();
                     pizza += " Mushroom";
                break;
            case R.id.button:
                Toast.makeText(getApplicationContext(), pizza, Toast.LENGTH_LONG).show();
                System.out.println(pizza);
                break;
            case R.id.sweetcornCheckbox:
                if(sweetcorn.isChecked())
                    Toast.makeText(getApplicationContext(), "Sweetcorn", Toast.LENGTH_LONG).show();
                    pizza += " Sweetcorn";
                break;
            case R.id.cheeseCheckBox:
                if(cheese.isChecked() == true)
                    Toast.makeText(getApplicationContext(), "Extra Cheese", Toast.LENGTH_SHORT).show();
                    pizza+= " Extra Cheese";
                    yesno.setText("Yes");
                if(cheese.isChecked() == false)
                    yesno.setText("No");

        }
    }
}