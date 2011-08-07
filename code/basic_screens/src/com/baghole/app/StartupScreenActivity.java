package com.baghole.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StartupScreenActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        // Setting up listener for button
        Button startButton = (Button) findViewById(R.id.launch_button);
        startButton.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				Intent setupScreen = new Intent(StartupScreenActivity.this,GameSetupScreenActivity.class);
				startActivity(setupScreen);
			}
		});
    }
}