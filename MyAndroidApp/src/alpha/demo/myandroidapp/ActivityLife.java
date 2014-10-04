package alpha.demo.myandroidapp;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

/**
 * 
 * @author pete_doherty
 * @since 2014/10/03
 * @see http
 *      ://developer.android.com/training/basics/activity-lifecycle/starting.
 *      html
 * @version 1.0
 * 
 */
public class ActivityLife extends Activity {

	private final static String TAG = "ActvityLifeLog";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_activity_life);

		/*
		 * declaring the user interface (defined in an XML layout file),
		 * defining member variables, and configuring some of the UI.
		 */

		Log.i(TAG, "at onCreate()");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_life, menu);
		return true;
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();

		/*
		 * if your activity includes background threads that you created during
		 * onCreate() or other long-running resources that could potentially
		 * leak memory if not properly closed, you should kill them during
		 * onDestroy().
		 */

		Log.i(TAG, "at onDestroy()");

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

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();

		/*
		 * Stop animations or other ongoing actions that could consume CPU.
		 * Commit unsaved changes, but only if users expect such changes to be
		 * permanently saved when they leave (such as a draft email). Release
		 * system resources, such as broadcast receivers, handles to sensors
		 * (like GPS), or any resources that may affect battery life while your
		 * activity is paused and the user does not need them.
		 */

		// Release the Camera because we don't need it when paused
		// and other activities might need to use it.

		/*
		 * if (mCamera != null) { mCamera.release() mCamera = null; }
		 */

		Log.i(TAG, "at onPause()");
	}

	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		super.onRestart();
		/*
		 * It's uncommon that an app needs to use onRestart() to restore the
		 * activity's state
		 */

		Log.i(TAG, "at onRestart()");
	}

	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		Log.i(TAG, "at onRestoreInstanceState()");
		super.onRestoreInstanceState(savedInstanceState);
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume(); // Always call the superclass method first

		/*
		 * implement onResume() to initialize components that you release during
		 * onPause() and perform any other initializations that must occur each
		 * time the activity enters the Resumed state (such as begin animations
		 * and initialize components only used while the activity has user
		 * focus).
		 */

		// Get the Camera instance as the activity achieves full user focus
		/*
		 * if (mCamera == null) { initializeCamera(); // Local method to handle
		 * camera init }
		 */

		Log.i(TAG, "at onResume()");
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		// TODO Auto-generated method stub
		super.onSaveInstanceState(outState);
		Log.i(TAG, "at onSaveInstanceState()");
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		/*
		 * you should usually use the onStart() callback method as the
		 * counterpart to the onStop() method, because the system calls
		 * onStart() both when it creates your activity and when it restarts the
		 * activity from the stopped state.
		 */

		// The activity is either being restarted or started for the first time
		// so this is where we should make sure that GPS is enabled
		/*
		 * LocationManager locationManager = (LocationManager)
		 * getSystemService(Context.LOCATION_SERVICE); boolean gpsEnabled =
		 * locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
		 * 
		 * if (!gpsEnabled) { // Create a dialog here that requests the user to
		 * enable GPS, and use an intent // with the
		 * android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS action //
		 * to take the user to the Settings screen to enable GPS when they click
		 * "OK" }
		 */
		Log.i(TAG, "at onStart()");
	}

	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		/*
		 * The user opens the Recent Apps window and switches from your app to
		 * another app. The user performs an action in your app that starts a
		 * new activity. The user receives a phone call while using your app on
		 * his or her phone. Although the onPause() method is called before
		 * onStop(), you should use onStop() to perform larger, more CPU
		 * intensive shut-down operations, such as writing information to a
		 * database.
		 */
		// Save the note's current draft, because the activity is stopping
		// and we want to be sure the current note progress isn't lost.
		/*
		 * ContentValues values = new ContentValues();
		 * values.put(NotePad.Notes.COLUMN_NAME_NOTE, getCurrentNoteText());
		 * values.put(NotePad.Notes.COLUMN_NAME_TITLE, getCurrentNoteTitle());
		 * 
		 * getContentResolver().update( mUri, // The URI for the note to update.
		 * values, // The map of column names and new values to apply to them.
		 * null, // No SELECT criteria are used. null // No WHERE columns are
		 * used. );
		 */
		Log.i(TAG, "at onStop()");
	}
}
