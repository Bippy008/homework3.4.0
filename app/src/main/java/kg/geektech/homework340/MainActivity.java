package kg.geektech.homework340;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().add(R.id.container, new ContinentFragment()).commit();
        }


        //https://i.imgur.com/eYbvaGT.png africa
        //https://imgur.com/a/JHUTBci asia
        //https://imgur.com/a/1kqm2RS europe
        //https://imgur.com/a/iT9ROXN north america
        //https://imgur.com/a/VhtWCaB oceania
        //https://imgur.com/a/UhWgIWj south america
    }
}