package com.example.megry.findsynonym;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;



/**
 * Created by megry on 3/31/2018.
 */

public class Results extends Activity{

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.results);

        String word = getIntent().getStringExtra("word");
        TextView view = (TextView)findViewById(R.id.TVword);
        view.setText(word);

        String synonym = getIntent().getStringExtra("synonym");
        TextView view2 = (TextView)findViewById(R.id.TVsynonym);
        view2.setText(synonym);

    }

}
