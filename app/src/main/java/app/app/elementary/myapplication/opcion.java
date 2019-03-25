package app.app.elementary.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.elementary.myapplication.R;

public class opcion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opcion);

        //poner el icono en el action bar
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);

    }
}
