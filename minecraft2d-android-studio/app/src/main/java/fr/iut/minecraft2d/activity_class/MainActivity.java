package fr.iut.minecraft2d.activity_class;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import fr.iut.minecraft2d.R;

/**
 * This class activity manage actions on the home screen of the application
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        setContentView(R.layout.home_screen);
        ImageView.generateViewId();
    }

    /**
     * Launch the playing_layout and start the new activity
     * @param view Will go on playing_activity
     */
    public void play(View view) {
        Intent intent = new Intent(this, Generation.class);
        startActivity(intent);
    }

    /**
     * Launch the view which display all objects in the game (blocs)
     * @param view used
     */
    public void viewListObject(View view) {
        Intent intent = new Intent(this, ListItem.class);
        startActivity(intent);
    }

    /**
     * Method which will close the app if button close is clicked
     * @param view quit the current view
     */
    public void quit_app(View view) {
        finish();
    }

    /**
     * Life cycle of the activity
     */
    @Override
    protected void onStart() {
        Log.d("MainActivity.java","onStart");
        super.onStart();
    }

    @Override
    protected void onStop() {
        Log.d("MainActivity.java","onStop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.d("MainActivity.java","onDestroy");
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        Log.d("MainActivity.java","onPause");
        super.onPause();
    }

    @Override
    protected void onResume() {
        Log.d("MainActivity.java","onResume");
        super.onResume();
    }

}
