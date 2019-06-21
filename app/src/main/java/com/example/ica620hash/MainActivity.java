package com.example.ica620hash;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Hashtable;
import java.util.Locale;

import static java.lang.String.format;

/**
 * This app is a demonstration of the use of an Array and a HashTable,
 * per the 6/20/2019 IBG Fast-Track Lecture In Class Assignment
 */


public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private TextView indexedView;
    private Hashtable <Integer, String> animals;
    private int index;
    private String animal[];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //The initial 3 animals to be listed
        animal = new String[]{"Cat","Dog","Bird"};
        index = 0;
        indexedView = findViewById(R.id.arrayIndex);
        //Lets us manipulate the EditText element
        editText = findViewById(R.id.editText);
        animals = new Hashtable<Integer,String>();
        //Populates the Hashtable in Key,Value pairs.  Index,Animal
        for(int i = 0; i < 3; i++){
            animals.put(i,animal[i]);
        }
        //Set the initial view
        editText.setText(animals.get(index));
        indexedView.setText(String.format(Locale.US,"%d",index));
    }

    //This method rewinds the list sequentially
    public void Previous(View view) {
        if(index == 0){
            index = 2;
        } else {
            index--;
        }
        editText.setText(animals.get(index));
        indexedView.setText(String.format(Locale.US,"%d",index));
    }

    //This method goes to the next item in the list
    public void Next(View view) {
        if(index == 2){
            index = 0;
        } else {
            index++;
        }
        editText.setText(animals.get(index));
        indexedView.setText(String.format(Locale.US,"%d",index));
    }

    //This method lets the user overwrite an item in the list.
    public void Save(View view) {
        String critter =(editText.getText().toString());
        animals.put(index,critter);
        editText.setText(animals.get(index));
        indexedView.setText(String.format(Locale.US,"%d",index));
    }
}
