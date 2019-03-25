package app.app.elementary.myapplication;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.elementary.myapplication.R;

public class MainActivity extends AppCompatActivity {

   private MediaPlayer mp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mp = MediaPlayer.create(this,R.raw.puntos);




        //poner el icono en el action bar
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);
    }


    public void Seleccion(View view){
        switch (view.getId()){
            case R.id.a:
                Intent a = new Intent(this,A.class);
                startActivity(a);
                mp.start();
                break;
            case R.id.b:
                Intent b = new Intent(this,B.class);
                startActivity(b);
                mp.start();
                break;
            case R.id.c:
                Intent c = new Intent(this,C.class);
                startActivity(c);
                mp.start();
                break;
            case R.id.d:
                Intent d = new Intent(this,D.class);
                startActivity(d);
                mp.start();
                break;
            case R.id.e:
                Intent e = new Intent(this,E.class);
                startActivity(e);
                mp.start();
                break;
            case R.id.f:
                Intent f = new Intent(this,F.class);
                startActivity(f);
                mp.start();
                break;
            case R.id.g:
                Intent g = new Intent(this,G.class);
                startActivity(g);
                mp.start();
                break;
            case R.id.h:
                Intent h = new Intent(this,H.class);
                startActivity(h);
                mp.start();
                break;
            case R.id.i:
                Intent i = new Intent(this,I.class);
                startActivity(i);
                mp.start();
                break;
            case R.id.j:
                Intent j = new Intent(this,J.class);
                startActivity(j);
                mp.start();
                break;
            case R.id.k:
                Intent k = new Intent(this,K.class);
                startActivity(k);
                mp.start();
                break;
            case R.id.l:
                Intent l = new Intent(this,L.class);
                startActivity(l);
                mp.start();
                break;
            case R.id.m:
                Intent m = new Intent(this,M.class);
                startActivity(m);
                mp.start();
                break;
            case R.id.n:
                Intent n = new Intent(this,N.class);
                startActivity(n);
                mp.start();
                break;
            case R.id.o:
                Intent o = new Intent(this,O.class);
                startActivity(o);
                mp.start();
                break;
            case R.id.p:
                Intent p = new Intent(this,P.class);
                startActivity(p);
                mp.start();
                break;
            case R.id.q:
                Intent q = new Intent(this,Q.class);
                startActivity(q);
                mp.start();
                break;
            case R.id.r:
                Intent r = new Intent(this,RRR.class);
                startActivity(r);
                mp.start();
                break;
            case R.id.s:
                Intent s = new Intent(this,S.class);
                startActivity(s);
                mp.start();
                break;
            case R.id.t:
                Intent t = new Intent(this,T.class);
                startActivity(t);
                mp.start();
                break;
            case R.id.u:
                Intent u = new Intent(this,U.class);
                startActivity(u);
                mp.start();
                break;
            case R.id.v:
                Intent v = new Intent(this,V.class);
                startActivity(v);
                mp.start();
                break;
            case R.id.w:
                Intent w = new Intent(this,W.class);
                startActivity(w);
                mp.start();
                break;
            case R.id.x:
                Intent x = new Intent(this,X.class);
                startActivity(x);
                mp.start();
                break;
            case R.id.y:
                Intent y = new Intent(this,Y.class);
                startActivity(y);
                mp.start();
                break;
            case R.id.z:
                Intent z = new Intent(this,Z.class);
                startActivity(z);
                mp.start();
                break;
            case R.id.opcion:
                Intent opcion = new Intent(this,opcion.class);
                startActivity(opcion);
                mp.start();
                break;
            case R.id.buscar:
                Intent buscar = new Intent(this,todo.class);
                startActivity(buscar);
                mp.start();
                break;
            case R.id.alealtorio:
                Intent aleatorio = new Intent(this,dayly_words.class);
                startActivity(aleatorio);
                mp.start();
                break;
            case R.id.ayuda:
                Intent ayuda = new Intent(this,ayuda.class);
                startActivity(ayuda);
                mp.start();
                break;

        }
    }
}
