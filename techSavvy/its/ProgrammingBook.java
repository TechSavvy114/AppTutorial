package techSavvy.its;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class ProgrammingBook extends AppCompatActivity {

    ImageView I1,I2,I3,I4,I5,I6,I7,I8;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_programming_book);
        I1=(ImageView) findViewById(R.id.image1);
        I2=(ImageView) findViewById(R.id.image2);
        I3=(ImageView) findViewById(R.id.image3);
        I4=(ImageView) findViewById(R.id.image4);
        I5 =(ImageView) findViewById(R.id.image5);
        I6=(ImageView) findViewById(R.id.image6);
        I7=(ImageView) findViewById(R.id.image7);
        I8=(ImageView) findViewById(R.id.image8);


        I1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent obj= new Intent(ProgrammingBook.this,Book1.class);
                startActivity(obj);

            }
        });

        I2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent obj= new Intent(ProgrammingBook.this,Book2.class);
                startActivity(obj);

            }
        });
        I3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent obj= new Intent(ProgrammingBook.this,Book3.class);
                startActivity(obj);

            }
        });
        I4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent obj= new Intent(ProgrammingBook.this,Book4.class);
                startActivity(obj);

            }
        });
        I5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent obj= new Intent(ProgrammingBook.this,Book5.class);
                startActivity(obj);

            }
        });
        I6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent obj= new Intent(ProgrammingBook.this,Book6.class);
                startActivity(obj);

            }
        });
        I7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent obj= new Intent(ProgrammingBook.this,Book7.class);
                startActivity(obj);

            }
        });
        I8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent obj= new Intent(ProgrammingBook.this,Book8.class);
                startActivity(obj);

            }
        });

    }
}
