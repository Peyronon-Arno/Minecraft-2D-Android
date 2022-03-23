package fr.iut.minecraft2d.activity_class;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import java.io.FileNotFoundException;
import java.util.HashMap;

import fr.iut.minecraft2d.DrawableManager;
import fr.iut.minecraft2d.GameView;
import fr.iut.minecraft2d.R;
import fr.iut.minecraft2d.data.FileLoader;
import fr.iut.minecraft2d.data.FileSaver;
import fr.iut.minecraft2d.data.Loader;
import fr.iut.minecraft2d.data.Sauveur;
import fr.iut.minecraft2d.model.GameManager;
import fr.iut.minecraft2d.model.player.Moves;

/**
 * This activity class is used to manage the game
 */
public class PlayingActivity extends Activity {

    /**
     * Gamemanager which manage the player and his moves
     */
    GameManager gameManager;

    /**
     * Drawable manager which manage the map / drawing the player ...
     */
    DrawableManager drawableManager;


    LinearLayout linearLayout;

    /**
     * Display the canvas implemented with draws and moves for playing
     */
    GameView canvas;

    /**
     * Number of cell for the map
     */
    final int cellsize = 90;

    /**
     * TextView on where we print the counter
     */
    TextView textView1;

    /**
     * Value of the counter
     */
    public int counter;

    /**
     * File name in which we will save the data
     */
    public static final String FILE_NAME = "data.txt";

    /**
     * Instance of data saver
     */
    private Sauveur sauveur = new FileSaver();

    /**
     * Instance of data loader
     */
    private Loader loader;


    /**
     * This method will draw the map, the player
     * It will create the instance of the move system
     * It will load data used in thread
     * It will manage the thread
     * @param savedInstanceState instance
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();

        int worldWidth = intent.getExtras().getInt("worldWidth");
        int worldHeight = intent.getExtras().getInt("worldHeight");

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        //loading assets, map and player
        drawableManager = DrawableManager.getInstance();
        drawableManager.loadBitmaps(this, cellsize);
        setContentView(R.layout.playing_layout);
        linearLayout = findViewById(R.id.linearLayout);
        canvas = new GameView(this);
        gameManager = new GameManager(canvas, worldWidth,  worldHeight, loadBitmaps(), cellsize);
        gameManager.setGameView();

        linearLayout.addView(canvas);
        ImageView.generateViewId();


        //Preparing the data to load
        loader = new FileLoader();
        try {
            counter = (int) loader.load(openFileInput(FILE_NAME));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //Making the new thread
        textView1 = findViewById(R.id.timer_textView);
        new Thread(new Runnable() {
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        System.out.println("Erreor in PlayingActivity.java with thread");
                        e.printStackTrace();
                    }
                    textView1.post(new Runnable() {
                        @SuppressLint("SetTextI18n")
                        public void run() {
                            textView1.setText("Time : " + counter);
                        }
                    });
                    counter += 1;
                }
            }
        }).start();
    }


    /**
     * This method will go to the left when up button is clicked
     * @param view used
     */
    @SuppressLint("ClickableViewAccessibility")
    public void go_left(View view) {
        final Button button = (Button) findViewById(R.id.buttonMoveLeft);
        button.setOnTouchListener(new View.OnTouchListener() {
            private Handler handler;

            @Override public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        if(handler != null) return true;
                        handler = new Handler();
                        handler.postDelayed(myAction,50);
                        break;
                    case MotionEvent.ACTION_UP:
                        if(handler == null) return true;
                        handler.removeCallbacks(myAction);
                        handler = null;
                        break;
                }
                return false;
            }

            /**
             * Case if user click on left button
             */
            Runnable myAction = new Runnable() {
                @Override public void run() {
                    System.out.println("move à gauche");
                    gameManager.updateCoordoninates(Moves.LEFT, canvas);
                    handler.postDelayed(this,50);
                }
            };
        });
    }

    /**
     * This method will go to the right when up button is clicked
     * @param view used
     */
    @SuppressLint("ClickableViewAccessibility")
    public void go_right(View view) {
        final Button button = (Button) findViewById(R.id.buttonMoveRight);
        button.setOnTouchListener(new View.OnTouchListener() {
            private Handler handler;

            @Override public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        if(handler != null) return true;
                        handler = new Handler();
                        handler.postDelayed(myAction,50);
                        break;
                    case MotionEvent.ACTION_UP:
                        if(handler == null) return true;
                        handler.removeCallbacks(myAction);
                        handler = null;
                        break;
                }
                return false;
            }

            /**
             * Case if player click on right button
             */
            Runnable myAction = new Runnable() {
                @Override public void run() {
                    //System.out.println("move à droite");
                    gameManager.updateCoordoninates(Moves.RIGHT, canvas);
                    handler.postDelayed(this,50);
                }
            };
        });
    }


    /**
     * This method will do a jump when up button is clicked
     * @param view used
     */
    @SuppressLint("ClickableViewAccessibility")
    public void go_up(View view) {

        final Button button = (Button) findViewById(R.id.buttonMoveUp);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("JUMP");
                gameManager.updateCoordoninates(Moves.UP, canvas);
            }
        });
    }

    /**
     * This method will create the map
     * @return assets
     */
    public HashMap<String,Bitmap> loadBitmaps(){

        HashMap<String, Bitmap> assets = new HashMap<>();
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inMutable = true;

        assets.put("bedrock",BitmapFactory.decodeResource(getResources(), R.drawable.bedrock, options));
        assets.put("dirt",BitmapFactory.decodeResource(getResources(), R.drawable.dirt,options));
        assets.put("grass",BitmapFactory.decodeResource(getResources(), R.drawable.grass, options));
        assets.put("leaves",BitmapFactory.decodeResource(getResources(), R.drawable.leaves,options));
        assets.put("stone",BitmapFactory.decodeResource(getResources(), R.drawable.stone,options));
        assets.put("wood",BitmapFactory.decodeResource(getResources(), R.drawable.wood,options));

        //Rescale of all blocks to the actuel cellsize
        for(String key : assets.keySet()){
            Bitmap b = assets.get(key);
            b = Bitmap.createScaledBitmap(assets.get(key), cellsize,cellsize, true);
            assets.put(key, b);
        }

        //addind the player's texture
        Bitmap steve = BitmapFactory.decodeResource(getResources(), R.drawable.steve);
        assets.put("player", Bitmap.createScaledBitmap(steve, cellsize/2,cellsize + cellsize/2, true));
        Bitmap steveHead = BitmapFactory.decodeResource(getResources(),R.drawable.steve_head);
        assets.put("head", Bitmap.createScaledBitmap(steveHead, cellsize/2,cellsize/2,true));

        return assets;
    }

    /**
     * Method which return on the home when button close is clicked
     * @param view quit the current view
     */
    public void return_home(View view) {
        finish();
    }


    /**
     * Live cycle of the activity
     */
    @Override
    protected void onStart() {
        Log.d("PlayingActivity.java","onStart");
        super.onStart();
    }

    @Override
    protected void onStop() {
        //Save the data
        try {
            sauveur.save(openFileOutput(FILE_NAME,MODE_PRIVATE),counter);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Log.d("PlayingActivity.java","onStop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {

       // fileSaver.save(String.valueOf(counter),this);
        Log.d("PlayingActivity.java","onDestroy");
        super.onDestroy();

    }

    @Override
    protected void onPause() {

        //fileSaver.save(String.valueOf(counter),this);
        Log.d("PlayingActivity.java","OnPause");
        super.onPause();
    }

    @Override
    protected void onResume() {
        Log.d("PlayingActivity.java","OnResume");
        super.onResume();
    }
}
