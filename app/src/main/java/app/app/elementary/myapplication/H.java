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

public class H extends AppCompatActivity {

    private TextToSpeech tts;
    private TextView tv;
    private ListView lw;
    int result;



    private String word[] = {"hair","half","hand","handkerchief","handle","handsome","hang","happen","happy","hard","harm","harmony","hatch","hate","have","head",
            "hear","heart","heat","heavy","heel","heel","help","hemisphere","hen","her","here","hide","high","hill","his","hit","hive","hold","hole","home","honest",
    "hoop","hop","horn","horn","horse","hose","hospital","hot","hour","how","hug","huge","hump","hungry","hurry","hurt","hush","hydrant"};

    private String desc [] = {"cabello","mitad","mano","pañuelo","encargarse de","guapo(a)","colgar","suceder","feliz","duro(a)","dañar","armonía","empollar","odiar","tener","cabeza",
    "oír","corazón","calentar","pesado(a)","talón","tacón","ayudar","hemisferio","gallina","su","aquí","esconder","alto(a)","loma","su","golpear","colmena","sostener","agujero","casa","honrado(a)",
    "aro","saltar","corneta","cuerno","caballo","manguera","hospital","caliente","hora","como","abrazo","gigantesco(a)","joroba","hambriento","apresurarse","lastimar","callar","boca de riego"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_h);



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

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,R.layout.item_list2,word);
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
