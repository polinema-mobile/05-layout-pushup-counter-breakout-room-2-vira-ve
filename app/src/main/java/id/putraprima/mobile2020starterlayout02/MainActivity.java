package id.putraprima.mobile2020starterlayout02;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void pushup(View view) {
        Intent intent = new Intent(MainActivity.this, PushUpActivity.class);
        startActivity(intent);
    }
}