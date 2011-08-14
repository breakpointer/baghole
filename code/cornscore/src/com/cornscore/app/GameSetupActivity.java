package com.cornscore.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class GameSetupActivity extends Activity {
	

	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_setup);
        
        //wiring up the start game button
        Button start_button = (Button) findViewById(R.id.start_game);
        start_button.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				startGame();
			}
		});
        
        // Getting all the buttons under the layout for the teams
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.homeTeamsLinearLayout);
        int cCount = linearLayout.getChildCount();
        for(int i = 0; i < cCount; i++){
        	View child = linearLayout.getChildAt(i);
        	wireUpHomeTeamButton(child);
        }
        
    }
    
    private void wireUpHomeTeamButton(View child){ 	
//    	Button button = (Button) child;
//    	button.setOnClickListener(new View.OnClickListener() {
//			
//			@Override
//			public void onClick(View v) {			
//			}
//		});
    }
    
    // Sets the selected home team image and data element
    private void setSelectedHomeTeam(int resId){
    	setSelected(resId,R.id.selectedHomeTeam);
    }   
    
    // Sets the selected the away team image and data element
    private void setSelectedAwayTeam(int resId){
    	setSelected(resId,R.id.selectedAwayTeam);
    }
    
    // Takes the image rez Id and the select element id to actually set 
    // the image view element for the selected team
    private void setSelected(int imgId, int selectId){
    	ImageView homeSelected = (ImageView) findViewById(selectId);
    	homeSelected.setImageResource(imgId);
    }
    
    private void startGame(){
    	// call new intent
    	setSelectedHomeTeam(R.drawable.nuteam);
    	setSelectedAwayTeam(R.drawable.i2team);
    }
	
}
