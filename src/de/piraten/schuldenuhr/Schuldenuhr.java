package de.piraten.schuldenuhr;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.content.Intent;
import java.sql.Timestamp;
import java.util.Date;
import java.text.NumberFormat;
import android.os.Handler;
import de.piraten.schuldenuhr.R;
import android.os.Message;  

public class Schuldenuhr extends Activity {
	
	private RefreshHandler mRedrawHandler = new RefreshHandler();
	
	class RefreshHandler extends Handler {  
	    @Override  
	    public void handleMessage(Message msg) {  
	      Schuldenuhr.this.updateSchulden();  
	    }  
	  
	    public void sleep(long delayMillis) {  
	      this.removeMessages(0);  
	      sendMessageDelayed(obtainMessage(0), delayMillis);  
	    }  
	  };  
	  
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.schulden);
        updateSchulden(); 
    }
    
    public void updateSchulden() {
	   	 TextView schuldenview = (TextView) findViewById(R.id.schuldenview);
	     TextView prokopfview = (TextView) findViewById(R.id.prokopfview);
	     TextView zuwachsview = (TextView) findViewById(R.id.zuwachsview);
	     double schulden = 63827241000.7;
	     double schuldenkopf = 0;
	     double zuwachs = 86.8;
	     long startzeit = 1316040960;
	     Date today = new Date();
	     Timestamp now = new Timestamp(today.getTime());
	     double extraSchulden = 0;
    	now.setTime(today.getTime());
        
        extraSchulden = ((now.getTime() / 1000) - startzeit);
        extraSchulden = extraSchulden * zuwachs;
        
        schulden = schulden + extraSchulden;
        schuldenkopf = schulden/3468939;

        schuldenview.setText(strPre(schulden));
        prokopfview.setText(strPre(schuldenkopf));
        zuwachsview.setText(strPre(zuwachs));
        mRedrawHandler.sleep(1000);
    }
    
    public String strPre(double inValue){
    	String shortString = NumberFormat.getIntegerInstance().format(inValue);
    	return shortString;
    }
    
    public void infoclick(View view) {
    	Intent intent = new Intent().setClass(this, InfoActivity.class);
        startActivity(intent);
    }
}
