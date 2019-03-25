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

public class C extends AppCompatActivity {

    private TextToSpeech tts;
    private TextView tv;
    private ListView lw;
    int result;



    private String word[] = {"cage","cake","call","camp","capable","can","candle","cane","canoe","cap","cape","car","card","careful","carry","case","castle",
            "cat","catch","cave","center","certain","chain","chair","chalk","challenge","chance","change","cheap","check","cheek","cherry","chest","chest","chew","chicken",
            "chin","chip","choose","chop","circle","circus","citizen","city","clap","claw","clean","clear","climb","clip","clock","close","cloth","cloud","clown",
            "coal","coast","coat","cobbler","cold","colt","comb","come","concentrate","cone","cook","cool","copy","corn","corner","cost","cottage","cough","count","cover",
            "cow","crack","cradle","crawl","crayon","cream","creep","criticize","cross","crown","cruel","crumbs","cry","cup","cure","curl","curved","cushion","cut","cute"};

    private String desc [] = {"jaula","pastel","llamar","acampar","capaz","poder","vela","bastón","canoa","gorra","capa","coche","tarjeta","cuidadoso(a)","cargar","maleta","castillo",
            "gato","atrapar","cueva","centro","cierto(a)","cadena","silla","tiza","desafío","posibilidad","cambiar","barato(a)","revisar","mejilla","cereza","caja","pecho","masticar","pollo",
            "barbilla","pedacito","escoger","talar","circulo","circo","ciudadano","ciudad","aplaudir","garra","limpiar","claro(a)","trepar","recortar","reloj","cerrar","tela","nube","payaso",
    "carbón","costa","abrigo","zapatero","frio","potrillo","peine","venir","concentrar","cono","cocinar","fresco(a)","copiar","maíz","esquina","costar","cabaña","toser","contar","cubrir",
    "vaca","quebradura","cuna","gatear","crayón","crema","arrastrarse","criticar","cruzar","corona","cruel","migajas","llorar","taza","curar","rizo","curva","cojin","cortar","gracioso(a)"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c);


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
