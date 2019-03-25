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

public class F extends AppCompatActivity {

    private TextToSpeech tts;
    private TextView tv;
    private ListView lw;
    int result;

    private String word[] = {"face","fact","factory","fade","fail","fair","fairy","fall","false","family","fan","far","farm","farmer","fat","father","fatigued",
    "fault","fear","feather","feed","feel","feet","feign","fence","few","field","fierce","fictitious","file","fill","finally","find","fine","finger","finish","fire",
            "fire alarm","fireman","first","fish","fit","five","fix","flag","flame","flamingo","flash","flat","float","floor","flour","flow","flower","fly","fly",
    "fold","foliage","follow","fond","food","foot","forehead","forest","forget","forgive","fork","forward","four","fox","free","free","freeze","fresh","Friday",
    "friend","frighten","frog","fruit","fry","function","furnace","furniture"};

    private String desc [] = {"cara","hecho","fabrica","decolorar","fallar","honestamente","hada","caer","falso","familia","ventilador","lejos","finca","campesino","gordo","padre","fatigado",
    "culpa","temer","pluma","alimentar","sentir","pies","fingir","cerca","pocos(as)","llanura","feroz","ficticio(a)","fila","llenar","finalmente","encontrar","multa","dedo","terminar","fuego",
    "alarma de incendios","bombero","primer(a)","pez","servir","cinco","arreglar","bandera","llama","flamenco","destello","liso(a)","flotar","piso","harina","fluir","flor","volar","mosca",
    "doblar","follaje","seguir","afectuoso(a)","alimento","pie","frente","bosque","olvidar","perdonar","tenedor","adelante","cuatro","zorro","gratis","liberar","congelar","fresco(a)","viernes",
    "amigo(a)","asustar","rana","fruta","freír","funcionar","estufa","mueble"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_f);



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
