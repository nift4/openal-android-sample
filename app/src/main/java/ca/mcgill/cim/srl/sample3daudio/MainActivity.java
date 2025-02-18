package ca.mcgill.cim.srl.sample3daudio;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.pielot.openal.SoundEnv;
import org.pielot.openal.Source;

import java.io.IOException;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    SoundEnv soundEnv;
    Source sound;
    private static float VARIATION = 0.5F;
    float xPos = 0.0F;
    float yPos = 0.0F;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.soundEnv = SoundEnv.getInstance(this);
        try {
            this.sound = new Source(soundEnv.addBuffer("beep2"));
            this.soundEnv.setListenerOrientation(0);
            this.soundEnv.setListenerPos(0, 0, 0);
            this.sound.setPosition(xPos, yPos, 0);
            this.sound.play(true);
            this.updateLabel();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Button btnUp = (Button) findViewById(R.id.btn_up);
        btnUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.this.yPos += VARIATION;
                MainActivity.this.sound.setPosition(xPos, yPos, 0);
                updateLabel();
            }
        });
        Button btnDown = (Button) findViewById(R.id.btn_down);
        btnDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.this.yPos -= VARIATION;
                MainActivity.this.sound.setPosition(xPos, yPos, 0);
                updateLabel();
            }
        });
        Button btnLeft = (Button) findViewById(R.id.btn_left);
        btnLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.this.xPos -= VARIATION;
                MainActivity.this.sound.setPosition(xPos, yPos, 0);
                updateLabel();
            }
        });
        Button btnRight = (Button) findViewById(R.id.btn_right);
        btnRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.this.xPos += VARIATION;
                MainActivity.this.sound.setPosition(xPos, yPos, 0);
                updateLabel();
            }
        });
    }

    private void updateLabel() {
        TextView tv = (TextView) findViewById(R.id.sample_text);
        tv.setText(String.format(Locale.US, "(%.1f,%.1f)", xPos, yPos));
    }

}
