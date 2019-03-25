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

public class S extends AppCompatActivity {

    private TextToSpeech tts;
    private TextView tv;
    private ListView lw;
    int result;


    private String word[] = {"sack","sad","safe","sail","sailor","salad","sale","salt","same","same","sand","sandwich","satisfy","save","save","saw","say",
            "scale","scale","scare","scarf","scene","scene","schedule","school","schoolroom","scissors","scold","scooter","scrap","scrape","scratch","scream","screen","scrub",
            "sea","seal","season","seat","second","see","seed","seem","seize","seldom","select","sell","semicircle","send","sense","sentence","separate","serve",
            "set","set","seven","sew","shade","shade","shadow","shake","shake","shape","share","sharp","sharp","shave","she","shed","shed","sheep",
            "sheet","sheet","shelf","shell","shelter","shine","shine","ship","shirt","shiver","shoe","shoot","shore","short","shout","shovel","show","shower","shut",
    "sick","side","sight","sign","sign","silent","silver","similar","since","sing","sister","sit","size","skate","skin","skip","skirt","sky","slant",
            "slap","sled","sleep","sleigh","slice","slice","slide","slide","slip","slipper","slow","sly","smart","smell","smile","smoke","smoke",
            "smooth","snake","sneeze","snow","snowflake","soap","soft","soil","soil","some","son","song","soon","soprano","sorry","sort",
            "sound","soup","sour","South","sow","space","speak","spectacle","speed","spell","spend","spider","spin","spinach","splash","spoil","spoil","spoil",
            "spoon","sport","spot","spot","spray","spread","spring","spring","square","squash","squeeze","squid","stable","stairs","stake","stalk","stamp",
            "star","start","station","stay","steal","steam","steep","stem","stick","stick","stiff","still","still","sting","stir","stocking","stomach",
            "stone","stool","stop","store","stork","storm","story","stove","strange","strap","straw","stream","street","stretch","strike","string","strip","stroll","strong",
            "study","succeed","such","suddenly","sugar","suit","summer","sun","supper","suppose","sure","surprise","swallow","sweater","sweep","sweet","swell","swift","swim",
            "swing","sword"};

    private String desc [] = {"saco","triste","seguro(a)","vela","marinero","ensalada","venta","sal","igual","mismo(a)","arena","emparedado","satisfacer","ahorrar","salvar","serrucho","decir",
            "balanza","escama","asustar","bufanda","sitio","escena","itinerario","escuela","aula","tijeras","regañar","patineta","recorte","raspar","rascar","gritar","pantalla","fregar",
            "mar","foca","estación","asiento","segundo","ver","semilla","parecer","agarrar","rara vez","seleccionar","vender","semicírculo","enviar","sentido","oración","separar","servir",
            "colocar","juego","siete","coser","cortina","sombra","sombra","sacudir","estrechar","forma","compartir","afilado(a)","vivo(a)","afeitar","ella","cobertizo","mudar","oveja",
            "hoja","sabana","estante","cascara","refugio","brillar","lustrar","buque","camisa","temblar","zapato","tirar","orilla","pequeño","gritar","pala","mostrar","ducha","cerrar",
            "enfermo(a)","lado","vista","firmar","señal","silencioso(a)","plata","similar","desde","cantar","hermana","sentarse","numero","patinar","piel","saltar","falda","cielo","inclinar",
            "abofetear","trineo","dormir","trineo","rebanada","rebanar","tobogán","deslizarse","resbalar","zapatilla","lento(a)","tramposo(a)","inteligente","oler","sonreír","fumar","humo",
            "liso(a)","serpiente","estornudar","nieve","copo de nieve","jabón","suave","suelo","mancharse","algunos(as)","hijo","canción","pronto","soprano","lamentar","organizar",
            "sonido","sopa","acido(a)","Sur","sembrar","espacio","hablar","espectáculo","velocidad","deletrear","gastar","araña","girar","espinaca","salpicadura","consentir","arruinar","deteriorarse",
            "cuchara","deporte","sitio","mancha","salpicar","untar","primavera","fuente","cuadrado","calabaza","apretar","calamar","establo","escaleras","estaca","tallo","estampilla",
            "estrellas","comenzar","estación","quedarse","robar","vapor","escarpado(a)","tallo","palo","pegar","entumecido(a)","todavía","tranquilo(a)","picar","resolver","media","estomago",
            "piedra","banqueta","parar","tienda","cigüeña","tormenta","cuento","estufa","extraño","correa","paja","arroyo","calle","estirar","golpear","cuerda","tira","pasear","fuerte",
            "estudiar","triunfar","tal","repentinamente","azúcar","traje","verano","sol","cena","suponer","seguro(a)","sorpresa","tragar","suéter","barrer","dulce","hinchar","veloz","nadar",
            "columpio","espada"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s);



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
