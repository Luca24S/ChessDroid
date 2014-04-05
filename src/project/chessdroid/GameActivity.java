package project.chessdroid;

import java.util.ArrayList;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;
import android.os.Build;

public class GameActivity extends ActionBarActivity {

	private int click = 0;
	private ArrayList<project.chessmodel.Tuple<Integer, Integer>> clicks;
	
	private ImageView firstSelected;
	int backgroundColor;
	private final int cellFocused = -16776961;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_game);

		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.game, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_game, container,
					false);
			return rootView;
		}
	}

	public void cellClick(View view) {
		String cell = getResources().getResourceEntryName(view.getId());
		int row = Character.getNumericValue(cell.charAt(cell.length() - 2));
		int col = Character.getNumericValue(cell.charAt(cell.length() - 1));
		if (click == 0) {
			click++;
			clicks = new ArrayList<project.chessmodel.Tuple<Integer, Integer>>();
			clicks.add(new project.chessmodel.Tuple<Integer, Integer>(row, col));
			firstSelected = (ImageView)findViewById(view.getId());
			backgroundColor = ((ColorDrawable)firstSelected.getBackground()).getColor();
			firstSelected.setBackgroundColor(cellFocused);;
		} else if (click == 1) {
			click = 0;
			clicks.add(new project.chessmodel.Tuple<Integer, Integer>(row, col));
			firstSelected.setBackgroundColor(backgroundColor);
			firstSelected = null;
			ImageView secondSelected = (ImageView)findViewById(view.getId());
			
		}
		Toast.makeText(this,
				(click+1) + " click: " + "cell " + row + "," + col,
				Toast.LENGTH_SHORT).show();
	}
}
