package com.example.megry.findsynonym;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by megry on 3/30/2018.
 */

public class EnterValues extends Activity {

    DatabaseHelper helper = new DatabaseHelper(this);

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.enter_values);

    }

    public void onSubmitClick(View v) {
        if(v.getId() == R.id.Bsubmit) {
            EditText Word = (EditText)findViewById(R.id.word);
            EditText synonym = (EditText)findViewById(R.id.synonym);

            String wordstr = Word.getText().toString();
            String synonymstr = synonym.getText().toString();

            if(wordstr.equals(synonymstr)) {
                Toast CantbeSame = Toast.makeText(EnterValues.this, "Words can't be the same!" , Toast.LENGTH_SHORT);
                CantbeSame.show();
            } else {

                Synonym s = new Synonym();
                s.setWord(wordstr);
                s.setSynonym(synonymstr);
                helper.insertSynonym(s);


                Intent i = new Intent(EnterValues.this, MainActivity.class);
                startActivity(i);

            }
        }

    }
}

