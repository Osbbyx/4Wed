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

public class RRR extends AppCompatActivity {

    private TextToSpeech tts;
    private TextView tv;
    private ListView lw;
    int result;


    private String word[] = {"rabbit","race","raccoon","radio","rail","rain","raincoat","raise","raise","rake","rat","raven","reach","read","ready","real",
            "reason","receive","recognize","red","remain","remember","remove","rent","repeat","reply","report","resident","rest","return","rhinoceros","ribbon",
            "rich","riddle","ride","right","right","ring","ring","ripe","rise","river","road","roast","rock","roll","roof","room","rooster","rope","rose",
            "rough","round","route","row","rub","rude","rug","rule","run","rush"};

    private String desc [] = {"conejo","carrera","mapache","radio","carril","llover","impermeable","levantar","criar","rastrillo","rata","cuervo","alcanzar","leer","listo(a)","real",
            "razón","recibir","reconocer","rojo(a)","quedarse","recordar","quitar","alquilar","repetir","contestación","informe","residente","descansar","devolver","rinoceronte","cinta",
            "rico(a)","adivinanza","montar","derecho(a)","correcto","circulo","anillo","maduro(a)","salir","rio","camino","asar","roca","rodar","techo","habitación","gallo","soga","rosa",
            "bravo(a)","redondo(a)","ruta","remar","frotar","rudo(a)","alfombra","regla","correr","apresurarse"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rrr);


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

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,R.layout.item_list4,word);
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
