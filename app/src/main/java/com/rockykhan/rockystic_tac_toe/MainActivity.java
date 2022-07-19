package com.rockykhan.rockystic_tac_toe;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.logging.XMLFormatter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.reset_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (gameActive){
                    gameActive = false;
                }
                X = 0;
                String x = "X : " + X;
                TextView Xwins = findViewById(R.id.x_wins);
                Xwins.setText(x);
                O = 0;
                String o = "O : " + O;
                TextView Owins = findViewById(R.id.o_wins);
                Owins.setText(o);
                D = 0;

                ((ImageView) findViewById(R.id.ImageView0)).setImageResource(0);
                ((ImageView) findViewById(R.id.imageView1)).setImageResource(0);
                ((ImageView) findViewById(R.id.imageView2)).setImageResource(0);
                ((ImageView) findViewById(R.id.imageView3)).setImageResource(0);
                ((ImageView) findViewById(R.id.imageView4)).setImageResource(0);
                ((ImageView) findViewById(R.id.imageView5)).setImageResource(0);
                ((ImageView) findViewById(R.id.imageView6)).setImageResource(0);
                ((ImageView) findViewById(R.id.imageView7)).setImageResource(0);
                ((ImageView) findViewById(R.id.imageView8)).setImageResource(0);
                gameActive = true;
                activePlayer = 0;
                for (int i=0; i<gameState.length; i++){
                    gameState[i] = 2;
                }

                TextView status = findViewById(R.id.status);
                status.setText("It's X's turn - Tap to play");

            }
        });
    }

//    Players:
//    0 - X
//    1 - O
    int activePlayer = 0;
    int[] gameState = {2, 2, 2, 2, 2, 2, 2, 2, 2};
    int[][] winPositions = {
            {0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}
    };
    boolean gameActive = true;

    int X = 0;
    int O = 0;
    int D = 0;

//    States:
//    0 - X
//    1 - O
//    2 - Null

    Button button;
    public void playerTap(View view) {
        if (gameActive) {
            ImageView img = (ImageView) view;
            int tappedImage = Integer.parseInt(img.getTag().toString());
            if (gameState[tappedImage] == 2) {
                gameState[tappedImage] = activePlayer;
                img.setTranslationY(-1000f);
                if (activePlayer == 0) {
                    img.setImageResource(R.drawable.x);
                    activePlayer = 1;
                    TextView status = findViewById(R.id.status);
                    status.setText("It's O's turn - Tap to play");
                } else {
                    img.setImageResource(R.drawable.o2);
                    activePlayer = 0;
                    TextView status = findViewById(R.id.status);
                    status.setText("It's X's turn - Tap to play");
                }
                img.animate().translationYBy(1000f).setDuration(150);
            }
            // checking the winner
            for (int[] winPosition : winPositions) {
                String result, x,o,d;
                if (gameState[winPosition[0]] == gameState[winPosition[1]] && gameState[winPosition[1]] == gameState[winPosition[2]] && gameState[winPosition[0]] != 2) {
                    gameActive = false;
                    if (gameState[winPosition[0]] == 0) {
                        result = "'X' has won! - Tap to Play";
                        X++;
                    } else {
                        result = "'O' has won! - Tap to Play";
                        O++;
                    }
                    TextView status = findViewById(R.id.status);
                    status.setText(result);

                } else if (gameState[winPosition[0]] != gameState[winPosition[1]] && gameState[winPosition[1]] != gameState[winPosition[2]] && gameState[0] != 2 && gameState[1] != 2 && gameState[2] != 2 && gameState[3] != 2 && gameState[4] != 2 && gameState[5] != 2 && gameState[6] != 2 && gameState[7] != 2 && gameState[8] != 2) {
                    result = "This match is a draw \n      - Tap to Play -";
                    TextView status = findViewById(R.id.status);
                    status.setText(result);
                    gameActive = false;
                    D += 1;
                }

                x = "X : " + X;
                TextView Xwins = findViewById(R.id.x_wins);
                Xwins.setText(x);
                o = "O : " + O;
                TextView Owins = findViewById(R.id.o_wins);
                Owins.setText(o);
//                d = "Draw : " + D;
//                TextView draws = findViewById(R.id.draws);
//                draws.setText(d);

            }
        }else if (!gameActive){
            gameReset(view);
        }
    }



    public  void gameReset(View view){
        ((ImageView) findViewById(R.id.ImageView0)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView8)).setImageResource(0);
        gameActive = true;
        activePlayer = 0;
        for (int i=0; i<gameState.length; i++){
            gameState[i] = 2;
        }

        TextView status = findViewById(R.id.status);
        status.setText("It's X's turn - Tap to play");
    }




}