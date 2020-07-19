 package techSavvy.its;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.google.android.material.navigation.NavigationView;

 public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    GridView g1;
    TextView t1;

     ViewFlipper flipper;

     DrawerLayout drawerLayout;
     NavigationView navigationView;
     ImageView menuIcon;
     FrameLayout frameLayout;
     FragmentManager fragmentManager;
     FragmentTransaction fragmentTransaction;



    String name[] = {"Learn", "code", "Interview", "Books", "Code Compiler","Video Tutorial","Little Fun", "Help"};
    int logo[] = {R.drawable.goal, R.drawable.code11, R.drawable.interview, R.drawable.book, R.drawable.shield, R.drawable.ques,R.drawable.fun,R.drawable.help1};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        menuIcon=findViewById(R.id.image1);


        drawerLayout=findViewById(R.id.drawer_layout);
        navigationView=findViewById(R.id.navigation_view);

        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_home);


        menuIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (drawerLayout.isDrawerVisible(GravityCompat.START))
                    drawerLayout.closeDrawer(GravityCompat.START);
                else drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        drawerLayout.setScrimColor(getResources().getColor(R.color.colorPrimary));


        flipper = findViewById(R.id.flipper);

        int images[] = {R.drawable.code10, R.drawable.code12, R.drawable.code13, R.drawable.code15, R.drawable.code16,R.drawable.code19,R.drawable.company};
        for (int image : images) {
            flipperImages(image);
        }


        t1=findViewById(R.id.text1);
        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(getApplicationContext(),Intro.class);
                startActivity(intent);

            }
        });

        g1 = findViewById(R.id.mygrid);
        MyAdapter adapter = new MyAdapter(getApplicationContext(), logo,name);
        g1.setAdapter(adapter);
        g1.setOnItemClickListener(  new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0)
                {
                    Intent intent=new Intent(getApplicationContext(),Learn.class);
                    startActivity(intent);
                }
                else if(position==1)
                {
                    Intent intent=new Intent(getApplicationContext(),Code.class);
                    startActivity(intent);
                }
                else if(position==2)
                {
                    Intent intent=new Intent(getApplicationContext(),Interview.class);
                    startActivity(intent);
                }
                else if(position==3)
                {
                    Intent intent=new Intent(getApplicationContext(),ProgrammingBook.class);
                    startActivity(intent);
                }
                else if(position==4)
                {
                    Intent intent=new Intent(getApplicationContext(),Compiler.class);
                    startActivity(intent);
                }
                else if(position==5)
                {
                    Intent intent=new Intent(getApplicationContext(),VideoTutorial.class);
                    startActivity(intent);
                }
                else if(position==6)
                {
                    Intent intent=new Intent(getApplicationContext(),Fun.class);
                    startActivity(intent);
                }
                else if(position==7)
                {
                    Intent intent=new Intent(getApplicationContext(),Help.class);
                    startActivity(intent);
                }

            }
        });

    }

    public void callLoginScreen(View view){

        startActivity(new Intent(getApplicationContext(),LoginStartUpScreen.class));

    }

     private void flipperImages(int image) {

         ImageView imageView = new ImageView(this);
         imageView.setBackgroundResource(image);

         flipper.addView(imageView);
         flipper.setFlipInterval(2000);
         flipper.setAutoStart(true);

         flipper.setInAnimation(this, android.R.anim.slide_in_left);
         flipper.setOutAnimation(this, android.R.anim.slide_out_right);

     }

     @Override
     public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.nav_home:
            Intent in = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(in);
            break;

            case R.id.nav_login:
                Intent intent = new Intent(getApplicationContext(),Login.class);
                startActivity(intent);
                break;

            case R.id.nav_profile:
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction= fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container,new ProfileFragment());
                fragmentTransaction.commit();
                break;

            case R.id.nav_share:
                Toast.makeText(this, "Share", Toast.LENGTH_SHORT).show();
                break;

            case R.id.nav_rate_us:
                Toast.makeText(this, "Rate Us On PlayStore", Toast.LENGTH_SHORT).show();
                break;

        }


        return true;
     }
 }
