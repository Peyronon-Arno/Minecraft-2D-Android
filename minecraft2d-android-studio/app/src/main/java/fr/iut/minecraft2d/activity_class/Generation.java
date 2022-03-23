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
 * This activity class is used to select the world size
 */
public class Generation extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        setContentView(R.layout.generation_layout);
        ImageView.generateViewId();
    }


    /**
     * Generate a small world
     * @param view used
     */
    public void genPetit(View view){
        gen(50,30,view);
    }

    /**
     * Generate a medium size world
     * @param view used
     */
    public void genMoyen(View view){
        gen(90,30,view);
    }

    /**
     * Generate a big world
     * @param view used
     */
    public void genGrand(View view){
        gen(150,30,view);
    }


    /**
     * Generate the world
     * @param width of the world
     * @param height of the world
     * @param view used
     */
    private void gen(int width, int height, View view) {
        play(view, width, height);
    }

    /**
     * Go to the playing activity
     * @param view used
     */
    public void play(View view, int width, int height) {
        Intent intent = new Intent(this, PlayingActivity.class);
        intent.putExtra("worldWidth", width);
        intent.putExtra("worldHeight", height);
        startActivity(intent);
    }

    /**
     * Return to the home
     * @param view used
     */
    public void return_home(View view) {finish(); }


    /**
     * Life cycle of the activity
     */
    @Override
    protected void onStart() {
        Log.d("Generation.java","onStart");
        super.onStart();
    }

    @Override
    protected void onStop() {
        Log.d("Generation.java","onStop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.d("Generation.java","onDestroy");
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        Log.d("Generation.java","onPause");
        super.onPause();
    }

    @Override
    protected void onResume() {
        Log.d("Generation.java","onResume");
        super.onResume();
    }


}
