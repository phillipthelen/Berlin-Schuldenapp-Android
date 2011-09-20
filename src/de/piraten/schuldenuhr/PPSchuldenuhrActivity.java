package de.piraten.schuldenuhr;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;

public class PPSchuldenuhrActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
    
    public void bgclick(View view) {
    	Intent intent = new Intent().setClass(this, Schuldenuhr.class);
        startActivity(intent);
    }
}