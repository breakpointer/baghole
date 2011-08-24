package com.cornscore.app;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class PlayGameActivity extends Activity {
	 /** Called when the activity is first created. */
	
	public int homeTeamResId;
	public int awayTeamResId;
	public int homeTotalScore;
	public int awayTotalScore;
	public int homeRoundScore;
	public int awayRoundScore;
	public int currentRound;
	public int currentHomeBag;
	public int currentAwayBag;
	public int[] homeBags = {-1,-1,-1,-1};
	public int[] awayBags = {-1,-1,-1,-1}; 
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game);
        
        Bundle extras = getIntent().getExtras();
        homeTeamResId = extras.getInt("HOMETEAM_RESID");
        awayTeamResId = extras.getInt("AWAYTEAM_RESID");
        setSelected(homeTeamResId, R.id.currentHomeTeam);
        setSelected(awayTeamResId, R.id.currentAwayTeam);
        
        // some data inits
        homeTotalScore = awayTotalScore = homeRoundScore = awayRoundScore = currentHomeBag = currentAwayBag = 0; 
        currentRound = 1;
        
        // setting some values from the init'd data
        setTextViewValue(R.id.currentInningText, currentRound, "Round ");
        setTextViewValue(R.id.awayBagScore,0);
        setTextViewValue(R.id.homeBagScore,0);
        setHomeBags();
        setAwayBags();
        
        // Set Next round button to disable
        disableNextRound();
        
        // Wiring up the score buttons... sweet Jebus there's so much copy and paste!
        Button homeZero = (Button) findViewById(R.id.homePoints0);
        homeZero.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				assignHomePoints(0);
			}
		});
        
        Button homeOne = (Button) findViewById(R.id.homePoints1);
        homeOne.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				assignHomePoints(1);
			}
		});
        
        Button homeThree = (Button) findViewById(R.id.homePoints3);
        homeThree.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				assignHomePoints(3);
			}
		});
        
        // Now the aways...
        Button awayZero = (Button) findViewById(R.id.awayPoints0);
        awayZero.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				assignAwayPoints(0);
			}
		});
        
        Button awayOne = (Button) findViewById(R.id.awayPoints1);
        awayOne.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				assignAwayPoints(1);
			}
		});
        
        Button awayThree = (Button) findViewById(R.id.awayPoints3);
        awayThree.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				assignAwayPoints(3);
			}
		});
    }
    
    // Ads points to the next bag in line
    private void assignHomePoints(int pointVal){
    	homeBags[currentHomeBag] = pointVal;
    	setHomeBags();
    	currentHomeBag++;
    }   
    
    private void assignAwayPoints(int pointVal){
    	awayBags[currentAwayBag] = pointVal;
    	setAwayBags();
    	currentAwayBag++;
    }  
    
    // Takes the image resource Id and the select element id to actually set 
    // the image view element for the selected team
    private void setSelected(int imgId, int selectId){
    	ImageView viewSelected = (ImageView) findViewById(selectId);
    	viewSelected.setImageResource(imgId);
    }
    
    // enable/disable next round button
    private void disableNextRound(){
    	Button nR = (Button) findViewById(R.id.nextRoundButton);
    	nR.setEnabled(false);
    }
    
    private void enableNextRound(){
    	Button nR = (Button) findViewById(R.id.nextRoundButton);
    	nR.setEnabled(true);
    }
    
    // Set the Home bag values
    private void setHomeBags(){
    	setTextViewValue(R.id.homeBag1, homeBags[0]);
    	setTextViewValue(R.id.homeBag2, homeBags[1]);
    	setTextViewValue(R.id.homeBag3, homeBags[2]);
    	setTextViewValue(R.id.homeBag4, homeBags[3]);
    }
    
    // Away set bag values
    private void setAwayBags(){
       setTextViewValue(R.id.awayBag1, awayBags[0]);
       setTextViewValue(R.id.awayBag2, awayBags[1]);
       setTextViewValue(R.id.awayBag3, awayBags[2]);
       setTextViewValue(R.id.awayBag4, awayBags[3]);
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
