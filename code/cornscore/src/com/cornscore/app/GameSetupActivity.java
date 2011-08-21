package com.cornscore.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class GameSetupActivity extends Activity {
	
	public int homeTeamResId;
	public int awayTeamResId;

	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	
    	homeTeamResId = 0;
    	awayTeamResId = 0;
    	
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_setup);
        
        //wiring up the start game button
        Button start_button = (Button) findViewById(R.id.startGame);
        start_button.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				startGame();
			}
		});
        
        // Wiring up the team buttons with a whole lot of copy and paste.
        // Home teams
        wireUpTeamButton(R.id.i2teamHome, R.drawable.i2team, "HOME");
        wireUpTeamButton(R.id.i3teamHome, R.drawable.i3team, "HOME");
        wireUpTeamButton(R.id.iteamHome, R.drawable.iteam, "HOME");
        wireUpTeamButton(R.id.m2teamHome, R.drawable.m2team, "HOME");
        wireUpTeamButton(R.id.mteamHome, R.drawable.mteam, "HOME");
        wireUpTeamButton(R.id.nteamHome, R.drawable.nteam, "HOME");
        wireUpTeamButton(R.id.nuteamHome, R.drawable.nuteam, "HOME");
        wireUpTeamButton(R.id.oteamHome, R.drawable.oteam, "HOME");
        wireUpTeamButton(R.id.p2teamHome, R.drawable.p2team, "HOME");
        wireUpTeamButton(R.id.pteamHome, R.drawable.pteam, "HOME");
        wireUpTeamButton(R.id.steamHome, R.drawable.steam, "HOME");
        wireUpTeamButton(R.id.wteamHome, R.drawable.wteam, "HOME");
        
        // Away teams
        wireUpTeamButton(R.id.i2teamAway, R.drawable.i2team, "AWAY");
        wireUpTeamButton(R.id.i3teamAway, R.drawable.i3team, "AWAY");
        wireUpTeamButton(R.id.iteamAway, R.drawable.iteam, "AWAY");
        wireUpTeamButton(R.id.m2teamAway, R.drawable.m2team, "AWAY");
        wireUpTeamButton(R.id.mteamAway, R.drawable.mteam, "AWAY");
        wireUpTeamButton(R.id.nteamAway, R.drawable.nteam, "AWAY");
        wireUpTeamButton(R.id.nuteamAway, R.drawable.nuteam, "AWAY");
        wireUpTeamButton(R.id.oteamAway, R.drawable.oteam, "AWAY");
        wireUpTeamButton(R.id.p2teamAway, R.drawable.p2team, "AWAY");
        wireUpTeamButton(R.id.pteamAway, R.drawable.pteam, "AWAY");
        wireUpTeamButton(R.id.steamAway, R.drawable.steam, "AWAY");
        wireUpTeamButton(R.id.wteamAway, R.drawable.wteam, "AWAY");
        
        
    }
    
    private void wireUpTeamButton(int buttonId, int graphicId, String teamType){
    	
    	ImageButton teamButton = (ImageButton) findViewById(buttonId);
    	
    	// Adding some of our own context to the button
    	teamButton.setTag(R.id.teamGraphicId, graphicId); 
    	teamButton.setTag(R.id.teamHomeOrAway, teamType);
    	
    	// Setting up or context sensitive onClick listener
        teamButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				ImageButton activeButton = (ImageButton) v;
				
				// getting button context
				String teamType = (String) activeButton.getTag(R.id.teamHomeOrAway);
				Number resId = (Number) activeButton.getTag(R.id.teamGraphicId); //casting our stored object to something numberish
				
				if (teamType.equals("HOME")){
					setSelectedHomeTeam(resId.intValue()); //getting at it's original type
				}
				else{
					setSelectedAwayTeam(resId.intValue()); 
				}
			}
		});
    }
    
  
    // Sets the selected home team image and data element
    private void setSelectedHomeTeam(int resId){
    	setSelected(resId,R.id.selectedHomeTeam);
    	homeTeamResId = resId;
    }   
    
    // Sets the selected the away team image and data element
    private void setSelectedAwayTeam(int resId){
    	setSelected(resId,R.id.selectedAwayTeam);
    	awayTeamResId = resId;
    }
    
    // Takes the image resource Id and the select element id to actually set 
    // the image view element for the selected team
    private void setSelected(int imgId, int selectId){
    	ImageView viewSelected = (ImageView) findViewById(selectId);
    	viewSelected.setImageResource(imgId);
    }
    
    private void startGame(){
    	
    	// Starting new intent
    	Intent playGame = new Intent(GameSetupActivity.this, PlayGameActivity.class);
    	// Passing in the resource ids for the teams so we can display their graphics on the next activity.
    	playGame.putExtra("HOMETEAM_RESID", homeTeamResId); 
    	playGame.putExtra("AWAYTEAM_RESID", awayTeamResId);
    	startActivity(playGame);
    }
	
}
