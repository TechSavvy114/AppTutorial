package techSavvy.its;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class Sqlintro extends AppCompatActivity implements TextToSpeech.OnInitListener {

    TextView t1;
    Button b1;
    TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlintro);

        t1=findViewById(R.id.t1);
        b1=findViewById(R.id.b1);
        tts=new TextToSpeech(this,this);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mySpeech();
            }
        });
    }

    @Override
    public void onDestroy() {

        if (tts != null)
        {
            tts.stop();
            tts.shutdown();
        }
        super.onDestroy();
    }

    @Override
    public void onInit(int status) {
        if (status == TextToSpeech.SUCCESS)
        {
            int result = tts.setLanguage(Locale.US);
        }
        else
        {
            b1.setEnabled(true);
            mySpeech();
        }

    }

    private void mySpeech() {

        String text = t1.getText().toString();
        tts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
    }
}
