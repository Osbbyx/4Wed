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

public class M extends AppCompatActivity {

    private TextToSpeech tts;
    private TextView tv;
    private ListView lw;
    int result;


    private String word[] = {"mad","magic","magnify","mail","main","make","man","manners","many","map","March","march","mark","mark","market","marry","match",
            "match","master","meal","mean","mean","mean","measure","meat","meet","melon","melt","memorize","merry","middle","milk","mind","mine",
            "mine","mistake","mix","money","monkey","monstrous","moon","more","mother","mountain","mouth","move","music","must","myself"};

    private String desc [] = {"loco(a)","magia","aumentar","correo","principal","hacer","hombre","modales","muchos(as)","mapa","marzo","marchar","nota","desfigurar","mercado","casarse","igualar",
            "fosforo","dueño","comida","significar","pretender","malhumorado(a)","medir","carne","encontrarse","melón","derretir","memorizar","alegre","medio","leche","cuidar","mío(a)",
            "mina","equivocación","mezclar","dinero","mono","monstruoso(a)","luna","mas","madre","montaña","boca","mover(se)","música","deber","mi mismo"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m);



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
