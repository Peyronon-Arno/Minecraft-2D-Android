package fr.iut.minecraft2d.activity_class;

import android.app.ListActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;

import androidx.annotation.Nullable;

import fr.iut.minecraft2d.AdaptateurDeListe;

public class ListItem extends ListActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        String[] values = new String[] { "Grass", "Dirt", "Stone","Bedrock", "Leaves", "Wood"};
        AdaptateurDeListe adaptateur = new AdaptateurDeListe(this, values);
        setListAdapter(adaptateur);
    }

    /**
     * Go back to the home menu
     * @param view used
     */
    public void return_home(View view) {
        finish();
    }

    /**
     * Life cycle of the activity
     */
    @Override
    protected void onStart() {
        Log.d("ListItem.java","onStart");
        super.onStart();
    }

    @Override
    protected void onStop() {
        Log.d("ListItem.java","onStop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.d("ListItem.java","onDestroy");
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        Log.d("ListItem.java","onPause");
        super.onPause();
    }

    @Override
    protected void onResume() {
        Log.d("MainActivity.java","onResume");
        super.onResume();
    }
}
