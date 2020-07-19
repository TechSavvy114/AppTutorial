package techSavvy.its;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUp extends AppCompatActivity {

    Button next;
    ImageView backarrow;
    TextView title;

    TextInputLayout fullname, username, email, password,phoneNo;


    FirebaseDatabase rootNode;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        next = findViewById(R.id.next_btn);
        backarrow = findViewById(R.id.signup_back_button);
        title = findViewById(R.id.title);

        fullname = findViewById(R.id.fullname);
        username = findViewById(R.id.username);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        phoneNo= findViewById(R.id.phoneNo);


    }

    public void callNextSignupScreen(View view) {

        if(!validateEmail() | !validateFullname() | !validatePassword() | !validateUsername() | !validatePhoneNo() ) {

            return;
        }


        rootNode= FirebaseDatabase.getInstance();
       reference= rootNode.getReference("MyCustomer");


  /*      String _name = fullname.getEditText().getText().toString();
        String _username = username.getEditText().getText().toString();
        String _email = email.getEditText().getText().toString();
        String _password = password.getEditText().getText().toString();
        String _phoneNo = phoneNo.getEditText().getText().toString();
*/
        UserHelperClass helperClass = new UserHelperClass(_name,_username,_email,_password,_phoneNo);
        reference.child(_name).setValue(helperClass);


       Intent intent = new Intent(getApplicationContext(), VerifyOTP.class);
       startActivity(intent);
       finish();


   /*     Pair[] pairs = new Pair[3];
        pairs[0] = new Pair<View, String>(findViewById(R.id.next_btn), "transition_next_btn  ");
        pairs[1] = new Pair<View, String>(findViewById(R.id.signup_back_button), "transition_back_arrow ");
        pairs[2] = new Pair<View, String>(findViewById(R.id.title), "transition_title");

        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(SignUp.this, pairs);
       startActivity(intent, options.toBundle());
*/

    }


    private boolean validateFullname() {

        String val = fullname.getEditText().getText().toString().trim();

        if (val.isEmpty()) {
            fullname.setError("Field can not be empty");
            return false;
        } else {
            fullname.setError(null);
            fullname.setErrorEnabled(false);
            return true;

        }
    }


    private boolean validateUsername() {

        String val = username.getEditText().getText().toString().trim();
        String checkspaces = "\\A\\w{1,20}\\z";

        if (val.isEmpty()) {
            username.setError("Field can not be empty");
            return false;
        } else if (val.length() > 20) {
            username.setError("Username is too large!");
            return false;
        } else if (!val.matches(checkspaces)) {
            username.setError("No white spaces are allowed");
            return false;
        } else {
            username.setError(null);
            username.setErrorEnabled(false);
            return true;

        }
    }


    private boolean validateEmail() {

        String val = email.getEditText().getText().toString().trim();
        String checkEmail = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        if (val.isEmpty()) {
            email.setError("Field can not be empty");
            return false;
        } else if (!val.matches(checkEmail)) {
            email.setError("Invalid Email!");
            return false;
        } else {
            email.setError(null);
            email.setErrorEnabled(false);
            return true;

        }
    }

    private boolean validatePassword() {

        String val = password.getEditText().getText().toString().trim();
        String checkPassword = "(?=.*[a-zA-Z])" + "(?=.*[@#$%^&])" + "(?=\\S+$)" + ".{4,}" + "$";

        if (val.isEmpty()) {
            password.setError("Field can not be empty");
            return false;
        } else if (!val.matches(checkPassword)) {
            password.setError("Password should contain 4 characters!");
            return false;
        } else {
            password.setError(null);
            password.setErrorEnabled(false);
            return true;

        }
    }

    private boolean validatePhoneNo() {
        String val = phoneNo.getEditText().getText().toString().trim();

        if (val.isEmpty()) {
            phoneNo.setError("Field cannot be empty");
            return false;
        } else {
            phoneNo.setError(null);
            phoneNo.setErrorEnabled(false);
            return true;
        }
    }


}
