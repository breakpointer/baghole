package com.cornscore.app;

import com.cornscore.app.GameSetupActivity;
import com.cornscore.app.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WelcomeActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);
        
     // Setting up listener for button
        Button startButton = (Button) findViewById(R.id.launch_button);
        startButton.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				Intent setupScreen = new Intent(WelcomeActivity.this,GameSetupActivity.class);
				startActivity(setupScreen);
			}
		});
    }
}