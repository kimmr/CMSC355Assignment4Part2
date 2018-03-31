package com.example.megry.findsynonym;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper helper = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
/*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
*/

    public void onValueClick(View v) {
        if(v.getId() == R.id.Bvalue) {
            Intent i = new Intent(MainActivity.this, EnterValues.class);
            startActivity(i);
        }

    }

    public void onSynonymClick(View v) {
        if(v.getId() == R.id.Bsynonym) {
            EditText text = (EditText)findViewById(R.id.userInput);
            String word = text.getText().toString();
            String synonym = helper.searchSynonym(word);

            Intent i = new Intent(MainActivity.this, Results.class);
            i.putExtra("word", word);
            i.putExtra("synonym", synonym);
            startActivity(i);
        }
    }
}
