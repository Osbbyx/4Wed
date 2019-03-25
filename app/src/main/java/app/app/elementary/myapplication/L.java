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

public class L extends AppCompatActivity {

    private TextToSpeech tts;
    private TextView tv;
    private ListView lw;
    int result;


    private String word[] = {"laboratory","lace","lace","ladder","lady","lake","lamb","lamp","land","land","lantern","large","last","late","laugh","law","lawn","lay",
    "lazy","lead","lead","leaf","lean","lean","leap","learn","leave","lecture","left","lemon","less","letter","letter","library","lick","lid","lie",
            "lie","life","lift","light","light","light,","lightning","like","limb","line","lion","lip","lip","list","listen","little","live","load","load","location",
            "lock","log","look","look","look","loose","lose","loud","low","lullaby","lunch"};

    private String desc [] = {"laboratorio","atar","lazo","escalera","dama","lago","cordero","lámpara","tierra","aterrizar","linterna","grande","ultimo(a)","tarde","reír","ley","césped","poner",
    "perezoso(a)","dirigir","plomo","hoja","apoyarse","magro(a)","saltar","aprender","partir","conferencia","izquierdo(a)","limón","menos","carta","letra","biblioteca","lamer","tapa","mentir",
            "echarse","vida","levantar","luz","liviano","claro(a)","relámpago","gustar","rama","línea","león","labio","borde","lista","escuchar","pequeño","vivir","carga","cargar","sitio",
            "bloquear","tronco","buscar","verse","mirar","suelto(a)","perder","alto(a)","bajo(a)","canción de cuna","almuerzo"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l);



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

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,R.layout.item_list3,word);
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
