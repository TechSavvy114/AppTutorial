package techSavvy.its;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

public class SignUp2 extends AppCompatActivity {

    Button next;
    ImageView backarrow;
    TextView title;
    RadioGroup radioGroup;
    RadioButton selectGender;
    DatePicker datePicker;

    FirebaseDatabase rootNode;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up2);

        next = findViewById(R.id.next_btn);
        backarrow = findViewById(R.id.signup_back_button);
        title = findViewById(R.id.title);
        radioGroup = findViewById(R.id.radioGroup);
        datePicker = findViewById(R.id.age_picker);

    }

    public void callNextSignupScreen(View view) {


        if (!validateGender() | !validateAge()) {
            return;
        }


        rootNode= FirebaseDatabase.getInstance();
        reference= rootNode.getReference("users");


     //   String _gender = _gender.getText().toString();
       // String _date =  datePicker.getText().toString();






      //  UserHelperClass helperClass = new UserHelperClass(_gender,_date);

      //  reference.setValue(helperClass);



        selectGender = findViewById(radioGroup.getCheckedRadioButtonId());
        String _gender = selectGender.getText().toString();

        int day = datePicker.getDayOfMonth();
        int month = datePicker.getMonth();
        int year = datePicker.getYear();


        String _date = day + "/" + month + "/" + year;


        Intent intent = new Intent(getApplicationContext(), SignUp3.class);

        Pair[] pairs = new Pair[3];

        pairs[0] = new Pair<View, String>(findViewById(R.id.next_btn), "transition_next_btn  ");
        pairs[1] = new Pair<View, String>(findViewById(R.id.signup_back_button), "transition_back_arrow ");
        pairs[2] = new Pair<View, String>(findViewById(R.id.title), "transition_title");

        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(SignUp2.this, pairs);
        startActivity(intent, options.toBundle());

    }

    private boolean validateGender() {
        if (radioGroup.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "Please Select Gender", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            return true;
        }
    }

    private boolean validateAge() {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        int userAge = datePicker.getYear();
        int isAgeValid = currentYear - userAge;

        if (isAgeValid < 16) {
            Toast.makeText(this, "You are not eligible to apply", Toast.LENGTH_SHORT).show();
            return false;

        } else
            return true;

    }
}