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

public class B extends AppCompatActivity {

    private TextToSpeech tts;
    private TextView tv;
    private ListView lw;
    int result;



    private String word[] = {"baby","bad","bag","bake","ball","ballerina","balloon","band","bank","bar","bare","bark","barn","barrel","baseball","bat","bath","bathtub",
    "beads","beans","bear","beat","beautiful","bed","bee","beg","begin","behind","believe","bell","belong","belt","bend","beneath","beside","between","beyond","big",
            "bill","biography","bird","birthday","bite","bitter","blackboard","blame","blind","blister","block","blood","blow","blue","board","boast","boat","body","bone","book",
    "boot","born","both","bother","bottle","bottom","bounce","bow","bowl","box","boy","brave","bread","break","breath","breathe","breeze","bridge","bright","bring",
            "brook","brother","bucket","bud","build","bulb","brunch","bunny","burn","bury","bush","busy","butter","butterfly","button","buy","buzzard","buz"};

    private String desc [] = {"bebe","malo","bolsa","hornear","pelota","bailarina","globo","banda","banco","barra","descalzo","ladrar","establo","barril","béisbol","murciélago","baño","bañera",
    "cuentas","frijoles","oso","golpear","hermoso(a)","cama","abeja","rogar","comenzar","detrás","creer","campana","pertenecer","cinturon","doblar","debajo","al lado","entre","más allá","grande",
    "cuenta","biografía","pájaro","cumpleaños","morder","amargo(a)","pizarra","culpar","ciego(a)","ampolla","cubo","sangre","soplar","azul","tabla","jactarse","bote","cuerpo","hueso","libro",
    "bota","nacer","ambos(as)","molestar","botella","fondo","rebotar","arco","vasija","caja","niño","valiente","pan","romper","aliento","respirar","brisa","puente","inteligente","traer",
    "arroyo","hermano","cubo","boton","construir","bombilla","racimo","conejito","quemar","enterrar","arbusto","ocupado(a)","mantequilla","mariposa","botón","comprar","ratonero","zumbido"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);



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
