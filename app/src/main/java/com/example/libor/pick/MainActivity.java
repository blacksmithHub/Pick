package com.example.libor.pick;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageView playerA, playerB;
    Button pick;
    TextView scoreA, scoreB;
    int ranA , ranB, scorea, scoreb;
    public int A[] = {R.drawable.paperleft1, R.drawable.scissorleft1, R.drawable.rockleft1};
    public int B[] = {R.drawable.paperright1, R.drawable.scissorright1, R.drawable.rockright1};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playerA = (ImageView)findViewById(R.id.playerA);
        playerB = (ImageView)findViewById(R.id.playerB);

        scoreA = (TextView)findViewById(R.id.scoreA);
        scoreB = (TextView)findViewById(R.id.scoreB);

        pick = (Button)findViewById(R.id.btnPick);

        scorea = 0;
        scoreb = 0;

        scoreA.setText("Player A: " + scorea);
        scoreB.setText("Player B: " + scoreb);

        pick();

    }

    private void generate()
    {
        ranA = (int) (Math.random() * 3);
        ranB = (int) (Math.random() * 3);

    }

    private void pick()
    {
        pick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                generate();

                playerA.setImageResource(A[ranA]);
                playerB.setImageResource(B[ranB]);

                score();

            }
        });
    }

    private void score()
    {

        if (ranA == 0 && ranB == 1)
        {
            scoreb++;
        }
        else if(ranA == 0 && ranB == 2)
        {
            scorea++;
        }
        else if(ranA == 1 && ranB == 0)
        {
            scorea++;
        }
        else if(ranA == 2 && ranB == 0)
        {
            scoreb++;
        }
        else if(ranA == 1 && ranB == 2)
        {
            scoreb++;
        }
        else if(ranA == 2 && ranB == 1)
        {
            scorea++;
        }
        scoreB.setText("Player B: " + scoreb);
        scoreA.setText("Player A: " + scorea);

        gameover();

    }

    private void gameover()
    {
        if(scoreb == 5)
        {
            scoreb = 0;
            scorea = 0;
            scoreA.setText("Player A: " + scorea);
            scoreB.setText("Player B: " + scoreb);
            Toast.makeText(MainActivity.this, "Player B won!" , Toast.LENGTH_SHORT).show();
        }
        else if(scorea == 5)
        {
            scorea = 0;
            scoreb = 0;
            scoreA.setText("Player A: " + scorea);
            scoreB.setText("Player B: " + scoreb);
            Toast.makeText(MainActivity.this, "Player A won!" , Toast.LENGTH_SHORT).show();
        }
        else if(scorea == 5 && scoreb == 5)
        {
            scorea = 0;
            scoreb = 0;
            scoreA.setText("Player A: " + scorea);
            scoreB.setText("Player B: " + scoreb);
            Toast.makeText(MainActivity.this, "Draw!" , Toast.LENGTH_SHORT).show();
        }
    }
}
