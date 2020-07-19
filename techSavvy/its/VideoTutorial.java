package techSavvy.its;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class VideoTutorial extends AppCompatActivity {

    TextView t1,t2,t3,t4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_tutorial);

        t1=(TextView) findViewById(R.id.t1);
        t2=(TextView) findViewById(R.id.t2);
        t3=(TextView) findViewById(R.id.t3);
        t4=(TextView) findViewById(R.id.t4);

       t1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent i1=new Intent(Intent.ACTION_VIEW);
               i1.setData(Uri.parse("https://www.youtube.com/watch?v=bZ6NL59FMoc"));
               startActivity(i1);
           }
       });
        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1=new Intent(Intent.ACTION_VIEW);
                i1.setData(Uri.parse("https://www.youtube.com/"));
                startActivity(i1);
            }
        });
        t3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1=new Intent(Intent.ACTION_VIEW);
                i1.setData(Uri.parse("https://www.youtube.com/"));
                startActivity(i1);
            }
        });
        t4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1=new Intent(Intent.ACTION_VIEW);
                i1.setData(Uri.parse("https://www.youtube.com/"));
                startActivity(i1);
            }
        });





    }

}
