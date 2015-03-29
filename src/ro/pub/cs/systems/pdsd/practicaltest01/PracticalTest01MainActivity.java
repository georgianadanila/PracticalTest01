package ro.pub.cs.systems.pdsd.practicaltest01;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PracticalTest01MainActivity extends Activity {
	protected ButtonClickListener buttonClickListener = new ButtonClickListener();
	protected EditText leftEditText;
	protected EditText rightEditText;
	
	
	private class ButtonClickListener implements Button.OnClickListener {

		@Override
		public void onClick(View view) {
			EditText leftEditText = (EditText)findViewById(R.id.left_edit_text);
			EditText rightEditText = (EditText)findViewById(R.id.right_edit_text);
			
			int numberOnLeftEditText = Integer.valueOf(leftEditText.getText().toString());
			int numberOnRightEditText = Integer.valueOf(rightEditText.getText().toString());
			
			switch(view.getId()){
				case (R.id.left_button):
					numberOnLeftEditText++;
					leftEditText.setText(String.valueOf(numberOnLeftEditText));
					break;
				case (R.id.right_button):
					numberOnRightEditText++;
					rightEditText.setText(String.valueOf(numberOnRightEditText));
					break;
				case (R.id.navigate_to_secondary_activity_button):
					Intent intent = new Intent("ro.pub.cs.systems.pdsd.intent.action.PracticalTest01SecondaryActivity");
					int totalPressed = Integer.valueOf(leftEditText.getText().toString()) +
										Integer.valueOf(rightEditText.getText().toString());
					intent.putExtra("totalClicks", String.valueOf(totalPressed));
					startActivityForResult(intent, 1);
					break;
			}
		}
		
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_practical_test01_main);
		
		leftEditText = (EditText)findViewById(R.id.left_edit_text);
		rightEditText = (EditText)findViewById(R.id.right_edit_text);
		
		Button leftButton = (Button)findViewById(R.id.left_button);
		leftButton.setOnClickListener(buttonClickListener);
		Button rightButton = (Button)findViewById(R.id.right_button);
		rightButton.setOnClickListener(buttonClickListener);
		Button navigateToSecondActivity = (Button)findViewById(R.id.navigate_to_secondary_activity_button);
		navigateToSecondActivity.setOnClickListener(buttonClickListener);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.practical_test01_main, menu);
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
	
	@Override
	protected void onSaveInstanceState(Bundle savedInstanceState) {
		
		leftEditText = (EditText)findViewById(R.id.left_edit_text);
		rightEditText = (EditText)findViewById(R.id.right_edit_text);
		
		savedInstanceState.putString("leftText",leftEditText.getText().toString());
		savedInstanceState.putString("rightText",rightEditText.getText().toString());	
	}
	
	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
				
		leftEditText.setText(savedInstanceState.getString("leftText"));
		rightEditText.setText(savedInstanceState.getString("rightText"));
		
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		Toast.makeText(this, "The activity returned with result: " + resultCode, Toast.LENGTH_LONG).show();
	}
}
