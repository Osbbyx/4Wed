package app.app.elementary.myapplication;

import android.media.MediaPlayer;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.elementary.myapplication.R;

import java.util.Locale;

public class E extends AppCompatActivity {

    private TextToSpeech tts;
    private TextView tv;
    private ListView lw;
    int result;


    private String word[] = {"each","eager","eagle","ear","early","earn","earth","east","easy","eat","eclipse","edge","egg","eight","either","electric","elephant",
            "elevator","empty","endeavor","enemy","engine","enjoy","enough","envelope","escape","essential","even","evening","every","everybody","everything","except","exchange","excite",
    "excuse","exercise","exhausted","expect","eye"};

    private String desc [] = {"cada","ansioso(a)","águila","oído","temprano","ganar","tierra","este","fácil","comer","eclipse","orilla","huevo","ocho","cualquiera","eléctrico(a)","elefante",
    "elevador","vacío","esforzarse","enemigo","motor","disfrutar","suficiente","sobre","escapar","esencial","empatar","atardecer","cada","todo el mundo","todo","excepto","cambiar","emocionarse",
    "excusar","hacer ejercicio","agotado(a)","esperar","ojo"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e);

        tts = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status==TextToSpeech.SUCCESS){
                    result= tts.setLanguage(Locale.UK);
                }
                else{

                }
            }
        });

        //poner el icono en el action bar
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);

        tv = (TextView)findViewById(R.id.tv);
        lw = (ListView)findViewById(R.id.tw);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,R.layout.item_list,word);
        lw.setAdapter(adapter);

        lw.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                tv.setText(lw.getItemAtPosition(i)+" = " + desc[i] );
                view.setSelected(true);
                tts.speak(word[i],TextToSpeech.QUEUE_FLUSH,null);
                tts.setSpeechRate(1);
            }
        });
    }
}
