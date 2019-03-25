package app.app.elementary.myapplication;

import android.graphics.drawable.Drawable;
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

public class A extends AppCompatActivity {

    private TextToSpeech tts;
    private TextView tv;
    private ListView lw;
    int result;



    private String word[] = {"a","able","about","about","above","absent","accident","ache","acorn","across","act","add","address","admire","admission","advice","after","after",
            "again","against","age","agree","ahead","aim","air","airplane","airport","alarm","alive","allow","almost","along","already","also","always","among","ancient","angry",
            "animal","annual","another","answer","ant","any","apart","ape","appear","apple","april","apron","aquarium","arm","around","arrive","art","ashamed","ask",
            "asleep","aunt","autumn","awake","axe"};
    private String desc [] = {"un(a)","capaz","acerca de","alrededor","encima","ausente","accidente","dolor","bellota","a través  de","actuar","añadir","dirección","admirar","entrada","consejo","detrás","después",
            "otra vez","en contra","edad","de acuerdo","adelante","apuntar","aire","avión","aeropuerto","alarma","vivo(con vida)","permitir","casi","a lo largo","ya","también","siempre","entre","antiguo","enojado(molesto)",
            "animal","anual","otro (a)","contestar","hormiga","cualquier","aparte","simio","aparecer","manzana","abril","delantal","acuario","brazo","alrededor","llegar","arte","avergonzado(a)","pedir(preguntar)",
            "dormido(a)","tía","otoño","despierto(a)","hacha"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);




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
