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

public class T extends AppCompatActivity {

    private TextToSpeech tts;
    private TextView tv;
    private ListView lw;
    int result;


    private String word[] = {"table","tag","tail","tailor","take","tale","talk","tall","tangle","tank","tap","task","taste","tea","teach","teacher","team","tear",
            "tear","teaspoon","tedious","telephone","tell","ten","tender","tend","tent","terrible","test","than","thank","that","their","then","there",
            "they","thick","thief","thimble","thin","thing","think","this","thorns","those","though","thread","throat","throne","through","throw",
            "thunder","tickle","tidy","tie","tie","tiger","till","time","tin","tiny","tip","tip","tire","tired","title","toad","toast","today",
            "together","tomorrow","tongue","tonight","too","tool","tooth","top","top","toss","touch","tough","toward","towel","toy","track","track","trade",
            "traffic","train","train","tramp","tramp","trap","travel","tray","treat","tree","trial","tricycle","trim","trip","trip","trouble","trousers","truck",
            "true","trunk","trunk","trunk","trust","try","tube","tulip","turkey","turn","turtle","tusk","twin","twinkle","twist"};

    private String desc [] = {"mesa","etiqueta","cola","sastre","llevar","cuento","hablar","alto(a)","enredar","tanque","toque","tarea","gusto","te","enseñar","maestra","equipo","rasgar",
            "lagrima","cucharita","tedioso(a)","teléfono","contar","diez","blando(a)","atender","carpa","terrible","examen","que","gracias","ese(a),(o)","su","entonces","allí",
            "ellos(as)","grueso(a)","ladrón","dedal","delgado(a)","cosa","pensar","este(a),(o)","espina","aquellos(as)","a pesar de","hilo","garganta","trono","a través","lanzar",
            "trueno","cosquillas","aseado(a)","atar","corbata","tigre","hasta","hora","hojalata","pequeñito(a)","volcarse","punta","neumático","cansado(a)","titulo","sapo","tostada","hoy",
    "juntos","mañana","lengua","esta noche","también","herramienta","diente","lo(a) más alto(a)","trompo","lanzar","tocar","duro(a)","hacia","toalla","juguete","riel","huella","comercio",
            "trafico","amaestrar","tren","pisar","vago","trampa","viajar","bandeja","tratar","árbol","prueba","triciclo","recortar","viaje","tropezar","problema","pantalones","camión",
            "verdadero(a)","tronco","baúl","trompa","confiar","tratar","tubo","tulipán","pavo","dar vuelta","tortuga","colmillo","mellizos","centellear","enrollar"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_t);




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
