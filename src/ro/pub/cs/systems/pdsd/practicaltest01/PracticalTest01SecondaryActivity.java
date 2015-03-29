package ro.pub.cs.systems.pdsd.practicaltest01;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.view.MenuItem;

public class PracticalTest01SecondaryActivity extends Activity {
	protected ButtonClickListener buttonClickListener = new ButtonClickListener();
	
	private class ButtonClickListener implements Button.OnClickListener {
		
		@Override
		public void onClick(View view) {
			switch(view.getId()) {
				case (R.id.ok_button) :
					setResult(RESULT_OK, new Intent());
					finish();
					break;
				case (R.id.cancel_button):
					setResult(RESULT_CANCELED, new Intent());
					finish();
					break;
			}
		}
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_practical_test01_secondary);
		
		Button ok = (Button)findViewById(R.id.ok_button);
		Button cancel = (Button)findViewById(R.id.cancel_button);
		ok.setOnClickListener(buttonClickListener);
		cancel.setOnClickListener(buttonClickListener);
		
		TextView numberOfClicks = (TextView)findViewById(R.id.total_clicks);
		Intent intent = getIntent();
		if (intent != null) {
			String totalClicks = intent.getStringExtra("totalClicks");
			numberOfClicks.setText(numberOfClicks.getText().toString() + totalClicks);
		}
	
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.practical_test01_secondary, menu);
		return true;
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
