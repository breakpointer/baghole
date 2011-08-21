package com.cornscore.app;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;


public class PlayGameActivity extends Activity {
	 /** Called when the activity is first created. */
	
	public int homeTeamResId;
	public int awayTeamResId;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game);
        
        Bundle extras = getIntent().getExtras();
        homeTeamResId = extras.getInt("HOMETEAM_RESID");
        awayTeamResId = extras.getInt("AWAYTEAM_RESID");
        setSelected(homeTeamResId, R.id.homeTeam);
        setSelected(awayTeamResId, R.id.awayTeam);
    }
    
    // Takes the image resource Id and the select element id to actually set 
    // the image view element for the selected team
    private void setSelected(int imgId, int selectId){
    	ImageView viewSelected = (ImageView) findViewById(selectId);
    	viewSelected.setImageResource(imgId);
    }
}
