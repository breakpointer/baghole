package com.baghole.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GameSetupScreenActivity extends Activity {

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setup);
        
        // Setting up listener for button
        Button startButton = (Button) findViewById(R.id.start_game_button);
        startButton.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				Intent gameScreen = new Intent(GameSetupScreenActivity.this,PlayGameScreenActivity.class);
				startActivity(gameScreen);
			}
		});
    }
    
}

	

