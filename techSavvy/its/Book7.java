package techSavvy.its;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class Book7 extends AppCompatActivity {

    PDFView book7;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book7);

        book7 = (PDFView) findViewById(R.id.pdfBook7);
        book7.fromAsset("ruby_tutorial.pdf").load();

    }
}
