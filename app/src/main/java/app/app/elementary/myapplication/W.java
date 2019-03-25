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

public class W extends AppCompatActivity {

    private TextToSpeech tts;
    private TextView tv;
    private ListView lw;
    int result;


    private String word[] = {"wag","wagon","wait","wake","walk","wall","want","warm","warn","wash","waste","watch","watch","water","water","wave","way","weak",
            "wear","weary","weather","weed","week","weep","weigh","wet","whale","what","wheel","when","which","while","whip","whistle","whistle","who",
            "whole","whose","why","wide","wild","win","wind","windmill","window","wing","winsome","winter","wipe","wire","wise","wish",
            "witch","with","witness","wolf","woman","wood","woods","wool","word","work","world","worm","worry","worse","worth","wrap","wring","write","wrong"};

    private String desc [] = {"menear","vagón","esperar","despertar","caminar","pared","querer","tibio(a)","advertir","lavar","malgastar","cuidar","reloj","agua","regar","ola","camino","débil",
            "usar","fatigado(a)","tiempo","mala hierba","semana","sollozar","pesar","mojado(a)","ballena","que","rueda","cuando","cual","mientras","azotar","silbar","pito","quien",
            "entero(a)","de quien","por qué","ancho(a)","salvaje","ganar","viento","molino de viento","ventana","ala","atractivo(a)","invierno","secar","alambre","sabio","deseo",
    "bruja","con","testigo","lobo","mujer","madera","bosque","lana","palabra","trabajar","mundo","gusano","preocuparse","peor","valer","envolver","exprimir","escribir","mal"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_w);


        //prueba de tts
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

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,R.layout.item_list5,word);
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
