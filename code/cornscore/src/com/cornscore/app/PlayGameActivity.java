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
        setRound();
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
        
        // The reset buttons...
        Button homeReset = (Button) findViewById(R.id.homePointsReset);
        homeReset.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				resetHomeBags();
				enableHomeScoring();
			}
		});        
        Button awayReset = (Button) findViewById(R.id.awayPointsReset);
        awayReset.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				resetAwayBags();
				enableAwayScoring();
			}
		});
        
     // Wiring up the next Round button
        Button nextRound = (Button) findViewById(R.id.nextRoundButton);
        nextRound.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				goToNextRound();
			}
		});
    }
    
    public void goToNextRound(){
    	homeRoundScore = 0;
    	awayRoundScore = 0;
    	currentRound ++;
    	resetHomeBags();
    	resetAwayBags();
    	enableHomeScoring();
    	enableAwayScoring();
    	setRound();
    	disableNextRound();
    }
    
    public void setRound(){
    	setTextViewValue(R.id.currentInningText, currentRound, "Round ");
    }
    
    public void resetHomeBags(){
    	currentHomeBag = 0;
    	homeBags[0] = homeBags[1] = homeBags[2] = homeBags[3] = -1;
    	setHomeBags();
    	updateHomeScore();
    }
    
    public void resetAwayBags(){
    	currentAwayBag = 0;
    	awayBags[0] = awayBags[1] = awayBags[2] = awayBags[3] = -1;
    	setAwayBags();
    	updateAwayScore();
    }
    
    
    // Ads points to the next bag in line
    private void assignHomePoints(int pointVal){
    	if (currentHomeBag < 4){
        	homeBags[currentHomeBag] = pointVal;
        	setHomeBags();
        	updateHomeScore();
    		currentHomeBag++;
    		// If we've thrown all the bags
    		if(currentHomeBag == 4){
    			disableHomeScoring();
    			checkEndRound();
    		}
    	}
    }
    
    private void assignAwayPoints(int pointVal){
    	if (currentAwayBag < 4){
        	awayBags[currentAwayBag] = pointVal;
        	setAwayBags();
        	updateAwayScore();
    		currentAwayBag++;
    		// If we've thrown all the bags
    		if(currentAwayBag == 4){
    			disableAwayScoring();
    			checkEndRound();
    		}
    	}
    } 
    
    // Turns off the buttons to score
    private void disableHomeScoring(){
    	Button homeZero = (Button) findViewById(R.id.homePoints0);
    	Button homeOne = (Button) findViewById(R.id.homePoints1);
    	Button homeThree = (Button) findViewById(R.id.homePoints3);
    	homeZero.setEnabled(false);
    	homeOne.setEnabled(false);
    	homeThree.setEnabled(false);
    }
    
    private void disableAwayScoring(){
    	Button awayZero = (Button) findViewById(R.id.awayPoints0);
    	Button awayOne = (Button) findViewById(R.id.awayPoints1);
    	Button awayThree = (Button) findViewById(R.id.awayPoints3);
    	awayZero.setEnabled(false);
    	awayOne.setEnabled(false);
    	awayThree.setEnabled(false);
    }
    
    // Turns on the buttons to score... like after the reset button has been hit
    private void enableHomeScoring(){
    	Button homeZero = (Button) findViewById(R.id.homePoints0);
    	Button homeOne = (Button) findViewById(R.id.homePoints1);
    	Button homeThree = (Button) findViewById(R.id.homePoints3);
    	homeZero.setEnabled(true);
    	homeOne.setEnabled(true);
    	homeThree.setEnabled(true);
    }
    
    private void enableAwayScoring(){
    	Button awayZero = (Button) findViewById(R.id.awayPoints0);
    	Button awayOne = (Button) findViewById(R.id.awayPoints1);
    	Button awayThree = (Button) findViewById(R.id.awayPoints3);
    	awayZero.setEnabled(true);
    	awayOne.setEnabled(true);
    	awayThree.setEnabled(true);
    }
 
    
    // Determines if all bags have been thrown and i
    private void checkEndRound(){
    	if ((currentHomeBag == 4) && (currentAwayBag == 4)){
    		calculateWinner();
    		enableNextRound();
    	}
    }
    
    private void calculateWinner(){
    	int delta = 0;
    	if (homeRoundScore > awayRoundScore){
    		delta = homeRoundScore - awayRoundScore;
    		homeTotalScore = homeTotalScore + delta;
        	setTextViewValue(R.id.currentInningText, delta, "Home team by ");
    	}else if (awayRoundScore > homeRoundScore){
    		delta = awayRoundScore - homeRoundScore;
    		awayTotalScore = awayTotalScore + delta;
        	setTextViewValue(R.id.currentInningText, delta, "Away team by ");
    	}else{
    		setTextViewValue(R.id.currentInningText, 0, "A Tie! You each get ");
    	}
    	setTextViewValue(R.id.homeTeamScore, homeTotalScore);
    	setTextViewValue(R.id.awayTeamScore, awayTotalScore);
    }
    
    // Calculates the round score based on the int in the bag score array
    private void updateHomeScore(){
    	int sum = 0;
    	for(int x=0; x < 4; x++){
    		if(homeBags[x] > 0){
    			sum = sum + homeBags[x];
    		}
    	}
    	homeRoundScore = sum;
    	setTextViewValue(R.id.homeBagScore, sum);
    }
    
    private void updateAwayScore(){
    	int sum = 0;
    	for(int x=0; x < 4; x++){
    		if(awayBags[x] > 0){
    			sum = sum + awayBags[x];
    		}
    	}
    	awayRoundScore = sum;
    	setTextViewValue(R.id.awayBagScore, sum);
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
