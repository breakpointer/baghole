package com.cornscore.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class GameOverActivity extends Activity {
	
	public int homeTeamResId;
	public int awayTeamResId;
	public int homeTotalScore;
	public int awayTotalScore;
	
	
	   /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_over);
        
        Bundle extras = getIntent().getExtras();
        homeTeamResId = extras.getInt("HOMETEAM_RESID");
        awayTeamResId = extras.getInt("AWAYTEAM_RESID");
        homeTotalScore = extras.getInt("HOMETEAM_SCORE");
        awayTotalScore = extras.getInt("AWAYTEAM_SCORE");
        setSelected(homeTeamResId, R.id.currentHomeTeam);
        setSelected(awayTeamResId, R.id.currentAwayTeam);
        setScoreDisplay(homeTotalScore, awayTotalScore);
        
     // Setting up listener for button
        Button startButton = (Button) findViewById(R.id.launch_button);
        startButton.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				Intent setupScreen = new Intent(GameOverActivity.this,GameSetupActivity.class);
				startActivity(setupScreen);
			}
		});
    }
    // Updates the team scores
    public void setScoreDisplay(int home, int away){
    	setTextViewValue(R.id.homeTeamScore, home);
    	setTextViewValue(R.id.awayTeamScore, away);
    }
    
    // Takes the image resource Id and the select element id to actually set 
    // the image view element for the selected team
    private void setSelected(int imgId, int selectId){
    	ImageView viewSelected = (ImageView) findViewById(selectId);
    	viewSelected.setImageResource(imgId);
    }
    
 // Basic method signature for generic helper method to set textvalues with simple ints
    private void setTextViewValue(int tId, int tVal){
    	setTextViewValue(tId, tVal, "");
    }
    
    // full method signature
    private void setTextViewValue(int tId, int tVal, String pStr){
    	TextView tView = (TextView) findViewById(tId);
    	if (tVal == -1){
    		tView.setText("X"); // Not the best approach but oh well...
    	}
    	else {
    		tView.setText(pStr + ((Number)tVal).toString());
    	}
    
    }
}
