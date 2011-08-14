package app.cornhole;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;

public class SelectScreenActivity extends Activity implements OnClickListener {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.selectscreen);
		//
		Button michButton = (Button)findViewById(R.id.michButton);
		michButton.setBackgroundColor(Color.TRANSPARENT);
		michButton.setTextColor(Color.TRANSPARENT);
		michButton.setOnClickListener(this);
		//
		Button osuButton = (Button)findViewById(R.id.osuButton);
		osuButton.setBackgroundColor(Color.TRANSPARENT);
		osuButton.setTextColor(Color.TRANSPARENT);
		osuButton.setOnClickListener(this);
		//
		Button indButton = (Button)findViewById(R.id.indButton);
		indButton.setBackgroundColor(Color.TRANSPARENT);
		indButton.setTextColor(Color.TRANSPARENT);
		indButton.setOnClickListener(this);
		//
		Button illButton = (Button)findViewById(R.id.illButton);
		illButton.setBackgroundColor(Color.TRANSPARENT);
		illButton.setTextColor(Color.TRANSPARENT);
		illButton.setOnClickListener(this);
		//
		Button iowaButton = (Button)findViewById(R.id.iowaButton);
		iowaButton.setBackgroundColor(Color.TRANSPARENT);
		iowaButton.setTextColor(Color.TRANSPARENT);
		iowaButton.setOnClickListener(this);
		//
		Button minnButton = (Button)findViewById(R.id.minnButton);
		minnButton.setBackgroundColor(Color.TRANSPARENT);
		minnButton.setTextColor(Color.TRANSPARENT);
		minnButton.setOnClickListener(this);
		//
		Button msuButton = (Button)findViewById(R.id.msuButton);
		msuButton.setBackgroundColor(Color.TRANSPARENT);
		msuButton.setTextColor(Color.TRANSPARENT);
		msuButton.setOnClickListener(this);
		//
		Button nebButton = (Button)findViewById(R.id.nebButton);
		nebButton.setBackgroundColor(Color.TRANSPARENT);
		nebButton.setTextColor(Color.TRANSPARENT);
		nebButton.setOnClickListener(this);
		//
		Button nuButton = (Button)findViewById(R.id.nuButton);
		nuButton.setBackgroundColor(Color.TRANSPARENT);
		nuButton.setTextColor(Color.TRANSPARENT);
		nuButton.setOnClickListener(this);
		//
		Button psuButton = (Button)findViewById(R.id.pennButton);
		psuButton.setBackgroundColor(Color.TRANSPARENT);
		psuButton.setTextColor(Color.TRANSPARENT);
		psuButton.setOnClickListener(this);
		//
		Button wiscButton = (Button)findViewById(R.id.wiscButton);
		wiscButton.setBackgroundColor(Color.TRANSPARENT);
		wiscButton.setTextColor(Color.TRANSPARENT);
		wiscButton.setOnClickListener(this);
		//
		Button purdueButton = (Button)findViewById(R.id.purdueButton);
		purdueButton.setBackgroundColor(Color.TRANSPARENT);
		purdueButton.setTextColor(Color.TRANSPARENT);
		purdueButton.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		int school = v.getId();		
		Intent startGame = new Intent(this,GameActivity.class);
		startGame.putExtra("layout", school);
		startActivity(startGame);		
	}
	
}
