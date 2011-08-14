package app.cornhole;

import android.app.Activity;
import android.os.Bundle;

public class GameActivity extends Activity {
	
	public void onCreate(Bundle savedInstanceState) {		
		int sch = getIntent().getIntExtra("layout", 0);
		switch(sch) {
    	case(0x7f070014): setContentView(R.layout.illinois); break;
    	case(0x7f07001a): setContentView(R.layout.indiana); break;
    	case(0x7f070013): setContentView(R.layout.iowa); break;
    	case(0x7f07000f): setContentView(R.layout.michigan); break;
    	case(0x7f070011): setContentView(R.layout.minnesota); break;
    	case(0x7f070019): setContentView(R.layout.msu); break;
    	case(0x7f070012): setContentView(R.layout.nebraska); break;
    	case(0x7f070010): setContentView(R.layout.nu); break;
    	case(0x7f070018): setContentView(R.layout.osu); break;
    	case(0x7f070017): setContentView(R.layout.psu); break;
    	case(0x7f070015): setContentView(R.layout.wisconsin); break;
    	}		
	}
	
	
	//first get resources
	//then allow movement
	//make background scoring class
	
	
}
