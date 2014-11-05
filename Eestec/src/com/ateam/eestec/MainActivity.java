package com.ateam.eestec;
import java.util.concurrent.TimeUnit;

import com.google.android.gms.games.Notifications;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.NotificationCompat;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener; 
import android.content.Intent; 	


@TargetApi(Build.VERSION_CODES.KITKAT)
@SuppressLint("NewApi")
public class MainActivity extends Activity {
	TextView textViewTime;	
	long cur_time= System.currentTimeMillis();
	String breakfast_timestamp="1414779775000";
	String div=":";
	private Button but;
	
	protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_main);
	textViewTime = (TextView)findViewById(R.id.textViewTime);
	textViewTime.setText(Long.toString(Long.parseLong(breakfast_timestamp)-cur_time));
	//textViewTime.setText(Long.toString((cur_time/3600000-hours)+div+(cur_time/60000-minutes)+div+(cur_time/1000-seconds)));
	final CounterClass timer = new CounterClass(Long.parseLong(breakfast_timestamp)-cur_time,1000);
	timer.start();
//	but = (Button)  findViewById(R.id.button3);//!!!!!it doesnt work
//	but.setOnClickListener((OnClickListener) this);
	
	((Button) findViewById(R.id.button1)).setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
	        Intent intent = new Intent(getApplicationContext(),Map.class);
	        startActivity(intent);	        	        		
		}
	});;
	
	
	
	
		
	((Button) findViewById(R.id.button2)).setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
	        Intent intent = new Intent(getApplicationContext(),Description.class);
	        startActivity(intent);
			
		}
	});;
	
	

}
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent intent = new Intent(this,Notifications.class);
		PendingIntent pIntent = PendingIntent.getActivity(this,0, intent ,PendingIntent.FLAG_UPDATE_CURRENT);
		NotificationCompat.Builder noti =
		        new NotificationCompat.Builder(this)
		        .setSmallIcon(R.drawable.ic_launcher)
		        .setContentTitle("Test")
		        .setContentText("Notification Test")
		        .setContentIntent(pIntent);	
	
		// Sets an ID for the notification
		int mNotificationId = 001;
		// Gets an instance of the NotificationManager service
		NotificationManager mNotifyMgr = 
		        (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
		// Builds the notification and issues it.
		mNotifyMgr.notify(mNotificationId, noti.build());
	}
	
@Override
public boolean onCreateOptionsMenu(Menu menu) {
	// Inflate the menu; this adds items to the action bar if it is present.
	getMenuInflater().inflate(R.menu.main, menu);
	return true;
}
public class CounterClass extends CountDownTimer {
	public CounterClass(long millisInFuture, long countDownInterval) {
	super(millisInFuture, countDownInterval);
}
@Override
public void onFinish() {
	textViewTime.setText("Completed.");
}
@TargetApi(Build.VERSION_CODES.KITKAT)
@SuppressLint("NewApi")
@Override
public void onTick(long millisUntilFinished) {
	long millis = millisUntilFinished;
	String hms = String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(millis),
	TimeUnit.MILLISECONDS.toMinutes(millis) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis)),
	TimeUnit.MILLISECONDS.toSeconds(millis) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis)));
	System.out.println(hms);
	textViewTime.setText(hms);
	}
}
@Override
public boolean onOptionsItemSelected(MenuItem item) {
	// Handle action bar item clicks here. The action bar will
	// automatically handle clicks on the Home/Up button, so long
	// as you specify a parent activity in AndroidManifest.xml.
	int id = item.getItemId();
	if (id == R.id.action_settings) {
	return true;
}
return super.onOptionsItemSelected(item);
}
}