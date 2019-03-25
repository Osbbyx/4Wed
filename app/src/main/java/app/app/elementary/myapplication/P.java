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

public class P extends AppCompatActivity {

    private TextToSpeech tts;
    private TextView tv;
    private ListView lw;
    int result;


    private String word[] = {"pack","package","pad","page","pail","pain","paint","pair","palace","pale","palm","pan","pansy","paper","parachute","parade","parcel",
            "parent","park","park","part","party","pass","past","pat","path","pattern","paw","pay","pelican","pen","pencil","people","period","period",
            "persona","piano","pick","picnic","picture","picture","pie","piece","pile","pilgrim","pillow","pilot","pine","pipe","place","plain","plain",
            "plan","plan","plane","plane","plant","plate","play","play","please","plenty","plumage","plump","pocket","pod","poem","point","pole","pole",
            "policeman","polite","pond","pony","possible","postman","pot","poultry","pound","pour","practice","praise","precious","prepare","present","pretend",
            "pretty","price","prince","princess","principal","prize","promise","promote","prompt","proper","protect","proud","puddinng","pull","pumpkin","punctual","pupil",
            "puppy","pure","purse","pursue","push","put"};

    private String desc [] = {"empacar","paquete","bloc","pagina","cubo","dolor","pintar","par","palacio","pálido(a)","palma","sartén","pensamiento","papel","paracaídas","desfile","paquete",
            "padres","parque","estacionar","parte","fiesta","pasar","pasado","palmada","sendero","modelo","pata","pagar","pelicano","pluma","lápiz","gente","punto final","época",
            "persona","piano","escoger","merienda campestre","retrato","lamina","pastel","pedazo","pila","peregrino","almohada","piloto","pino","pipa","sitio","sencillo(a)","llano",
            "planear","plano","cepillo","avión","plantar","plato","jugar","tocar","por favor","suficiente","plumaje","grueso(a)","bolsillo","vaina","poema","punta","asta","caña",
            "policía","educado(a)","estanque","caballito","posible","cartero","cazuela","aves","golpear","verter","practicar","alabar","precioso(a)","preparar","presente","pretender",
            "bonito(a)","precio","príncipe","princesa","director","premio","prometer","promover","pronto","apropiado(a)","proteger","orgulloso(a)","pudin","tirar","calabaza","puntual","alumno",
            "cachorro","puro(a)","bolso","perseguir","empujar","poner"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p);



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
