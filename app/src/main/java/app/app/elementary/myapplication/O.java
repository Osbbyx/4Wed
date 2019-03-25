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

public class O extends AppCompatActivity {

    private TextToSpeech tts;
    private TextView tv;
    private ListView lw;
    int result;


    private String word[] = {"oak","oats","obey","object","object","oblong","ocean","odd","odd","off","office","often","old","once","one","only",
            "only","open","orangutan","order","organ","other","our","out","out","oven","over","over","over","over","owe","owl","own"};

    private String desc [] = {"roble","avena","obedecer","objeto","oponerse","oblongo(a)","océano","sobrante","raro(a)","fuera","oficina","a menudo","viejo(a)","una vez","uno(a)","solamente",
            "único(a)","abierto(a)","orangután","orden","órgano","otro(a)","nuestro(a)","fuera","apagado(a)","horno","terminado(a)","encima","rehacer","mas de","deber","lechuza","poseer"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_o);



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
