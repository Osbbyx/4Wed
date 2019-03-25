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

public class D extends AppCompatActivity {

    private TextToSpeech tts;
    private TextView tv;
    private ListView lw;
    int result;


    private String word[] = {"dad","dairy","dance","danger","dare","dark","dash","date","day","decide","deep","deer","definite","delight","deliver","demand",
    "den","dentist","describe","desert","deserve","desk","destroy","dew","diamond","dictionary","die","different","dimension","direction","dirt","dirty","disappear",
    "distance","divide","doctor","dog","donkey","door","doorway","dot","dreadful","dresser","drill","drink","drive","drop","drown","drum","dry","duck","during","dust",
    "dwarf","dwell"};

    private String desc [] = {"papa","lechería","bailar","peligro","atreverse","oscuro(a)","apresurarse","fecha","día","decidir","hondo(a)","venado","definitivo(a)","deleitar","entregar","exigir",
    "madriguera","dentista","describir","desierto","merecer","pupitre","destruir","roció","diamante","diccionario","morir","diferente","dimensión","dirección","suciedad","sucio(a)","desaparecer",
    "distancia","dividir","medico","perro","burro","puerta","entrada","punto","terrible","cómoda","taladro","beber","conducir","dejar caer","ahogarse","tambor","seco","pato","durante","polvo",
    "enano","habitar"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_d);



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
