package techSavvy.its;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class Book3 extends AppCompatActivity {

    PDFView book3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book3);

        book3 = (PDFView) findViewById(R.id.pdfBook3);
        book3.fromAsset("java-for-dummies.pdf").load();
    }
}
