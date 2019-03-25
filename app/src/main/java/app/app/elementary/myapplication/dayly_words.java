package app.app.elementary.myapplication;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import com.example.elementary.myapplication.R;

import java.util.Locale;
import java.util.Random;

public class dayly_words extends AppCompatActivity {

    private TextToSpeech tts;
    private TextView tv;
    private ListView lw;
    int result;
    private AdView mAdView;
    private String wordneutro[];
    private String descneutro[];
    private String wordneutrob[];
    private String descneutrob[];
    private String wordneutroc[];
    private String descneutroc[];
    private String wordneutrod[];
    private String descneutrod[];

    private String worda[] = {"a","able","about","about","above","absent","accident","ache","acorn","across","act","add","address","admire","admission","advice","after","after",
            "again","against","age","agree","ahead","aim","air","airplane","airport","alarm","alive","allow","almost","along","already","also","always","among","ancient","angry",
            "animal","annual","another","answer","ant","any","apart","ape","appear","apple","april","apron","aquarium","arm","around","arrive","art","ashamed","ask",
            "asleep","aunt","autumn","awake","axe"};

    private String wordb[] = {"baby","bad","bag","bake","ball","ballerina","balloon","band","bank","bar","bare","bark","barn","barrel","baseball","bat","bath","bathtub",
            "beads","beans","bear","beat","beautiful","bed","bee","beg","begin","behind","believe","bell","belong","belt","bend","beneath","beside","between","beyond","big",
            "bill","biography","bird","birthday","bite","bitter","blackboard","blame","blind","blister","block","blood","blow","blue","board","boast","boat","body","bone","book"
            };

    private String wordc[] = {"cage","cake","call","camp","capable","can","candle","cane","canoe","cap","cape","car","card","careful","carry","case","castle",
            "cat","catch","cave","center","certain","chain","chair","chalk","challenge","chance","change","cheap","check","cheek","cherry","chest","chest","chew","chicken",
            "chin","chip","choose","chop","circle","circus","citizen","city","clap","claw","clean","clear","climb","clip","clock","close","cloth","cloud","clown",
            "coal"};

    private String wordd[] = {"dad","dairy","dance","danger","dare","dark","dash","date","day","decide","deep","deer","definite","delight","deliver","demand",
            "den","dentist","describe","desert","deserve","desk","destroy","dew","diamond","dictionary","die","different","dimension","direction","dirt","dirty","disappear",
            "distance","divide","doctor","dog","donkey","door","doorway","dot","dreadful","dresser","drill","drink","drive","drop","drown","drum","dry","duck","during","dust",
            "dwarf","dwell"};

    private String worde[] = {"each","eager","eagle","ear","early","earn","earth","east","easy","eat","eclipse","edge","egg","eight","either","electric","elephant",
            "elevator","empty","endeavor","enemy","engine","enjoy","enough","envelope","escape","essential","even","evening","every","everybody","everything","except","exchange","excite",
            "excuse","exercise","exhausted","expect","eye"};

    private String wordf[] = {"face","fact","factory","fade","fail","fair","fairy","fall","false","family","fan","far","farm","farmer","fat","father","fatigued",
            "fault","fear","feather","feed","feel","feet","feign","fence","few","field","fierce","fictitious","file","fill","finally","find","fine","finger","finish","fire",
            "fire alarm","fireman","first","fish","fit","five","fix","flag","flame","flamingo","flash","flat","float","floor","flour","flow","flower","fly","fly"};

    private String wordg[] = {"gain","game","garage","garden","gasoline","gather","gentle","giant","gift","giraffe","girl","give","glad","glass","glass","glove","go","go",
            "goat","gold","good","goose","gorilla","grade","grain","grandmother","grape","grass","great","greedy","ground","group","grow","guarantee","guess","guess","guest",
            "guide","gum"};

    private String wordh[] = {"hair","half","hand","handkerchief","handle","handsome","hang","happen","happy","hard","harm","harmony","hatch","hate","have","head",
            "hear","heart","heat","heavy","heel","heel","help","hemisphere","hen","her","here","hide","high","hill","his","hit","hive","hold","hole","home","honest",
            "hoop","hop","horn","horn","horse","hose","hospital","hot","hour","how","hug","huge","hump","hungry","hurry","hurt","hush","hydrant"};

    private String wordi[] = {"ice","idea","identical","igloo","ill","impolite","increase","indeed","inflammable","ink","insect","inside","instead","into","invite",
            "iron","iron","island"};

    private String wordj[] = {"jacket","jail","jam","joke","jolly","journey","joy","judge","juice","jump","just","just"};

    private String wordk[] = {"kayak","keep","kettle","key","kick","kill","kind","kind","king","kiss","kitchen","kite","kitten","knee","knife","knock","know","know"};

    private String wordl[] = {"laboratory","lace","lace","ladder","lady","lake","lamb","lamp","land","land","lantern","large","last","late","laugh","law","lawn","lay",
            "lazy","lead","lead","leaf","lean","lean","leap","learn","leave","lecture","left","lemon","less","letter","letter","library","lick","lid","lie",
            "lie","life","lift","light","light","light,","lightning","like","limb","line","lion","lip","lip","list","listen","little","live","load","load","location",};

    private String wordm[] = {"mad","magic","magnify","mail","main","make","man","manners","many","map","March","march","mark","mark","market","marry","match",
            "match","master","meal","mean","mean","mean","measure","meat","meet","melon","melt","memorize","merry","middle","milk","mind","mine",
            "mine","mistake","mix","money","monkey","monstrous","moon","more","mother","mountain","mouth","move","music","must","myself"};

    private String wordn[] = {"name","nap","napkin","narrate","narrow","near","neat","neck","need","neighbor","nest","net","never","new","next","nice","nine",
            "nod","noise","none","noon","North","note","nothing","notice","nourish","now","number","nurse","nut"};

    private String wordo[] = {"oak","oats","obey","object","object","oblong","ocean","odd","odd","off","office","often","old","once","one","only",
            "only","open","orangutan","order","organ","other","our","out","out","oven","over","over","over","over","owe","owl","own"};

    private String wordp[] = {"pack","package","pad","page","pail","pain","paint","pair","palace","pale","palm","pan","pansy","paper","parachute","parade","parcel",
            "parent","park","park","part","party","pass","past","pat","path","pattern","paw","pay","pelican","pen","pencil","people","period","period",
            "persona","piano","pick","picnic","picture","picture","pie","piece","pile","pilgrim","pillow","pilot","pine","pipe","place","plain","plain"};

    private String wordq[] = {"quarrel","quarter","queen","quench","question","quick","quiet","quit","quite","quiz"};

    private String wordr[] = {"rabbit","race","raccoon","radio","rail","rain","raincoat","raise","raise","rake","rat","raven","reach","read","ready","real",
            "reason","receive","recognize","red","remain","remember","remove","rent","repeat","reply","report","resident","rest","return","rhinoceros","ribbon",
            "rich","riddle","ride","right","right","ring","ring","ripe","rise","river","road","roast","rock","roll","roof","room","rooster","rope","rose"};

    private String words[] = {"sack","sad","safe","sail","sailor","salad","sale","salt","same","same","sand","sandwich","satisfy","save","save","saw","say",
            "scale","scale","scare","scarf","scene","scene","schedule","school","schoolroom","scissors","scold","scooter","scrap","scrape","scratch","scream","screen","scrub",
            "sea","seal","season","seat","second","see","seed","seem","seize","seldom","select","sell","semicircle","send","sense","sentence","separate","serve"};

    private String wordt[] = {"table","tag","tail","tailor","take","tale","talk","tall","tangle","tank","tap","task","taste","tea","teach","teacher","team","tear",
            "tear","teaspoon","tedious","telephone","tell","ten","tender","tend","tent","terrible","test","than","thank","that","their","then","there",
            "they","thick","thief","thimble","thin","thing","think","this","thorns","those","though","thread","throat","throne","through","throw"};

    private String wordu[] = {"ugly","umbrella","uncertain","uncle","under","uneasy","unhappy","unkind","unless","untie","upon","use","useful"};

    private String wordv[] = {"vacant","vacation","valley","value","vase","vegetable","verse","very","view","village","vine","violin","visit","voice","vote"};

    private String wordw[] = {"wag","wagon","wait","wake","walk","wall","want","warm","warn","wash","waste","watch","watch","water","water","wave","way","weak",
            "wear","weary","weather","weed","week","weep","weigh","wet","whale","what","wheel","when","which","while","whip","whistle","whistle","who",
            "whole","whose","why","wide","wild","win","wind","windmill","window","wing","winsome","winter","wipe","wire","wise","wish"};

    private String wordx[] = {"x-ray","xylophone"};

    private String wordy[] = {"yard","yarn","yawn","year","yell","yellow","yes","yet","you","young","your"};

    private String wordz[] = {"zebra","zero","zone","zoo"};


    //------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------


    private String desca [] = {"un(a)","capaz","acerca de","alrededor","encima","ausente","accidente","dolor","bellota","a través  de","actuar","añadir","dirección","admirar","entrada","consejo","detrás","después",
            "otra vez","en contra","edad","de acuerdo","adelante","apuntar","aire","avión","aeropuerto","alarma","vivo(con vida)","permitir","casi","a lo largo","ya","también","siempre","entre","antiguo","enojado(molesto)",
            "animal","anual","otro (a)","contestar","hormiga","cualquier","aparte","simio","aparecer","manzana","abril","delantal","acuario","brazo","alrededor","llegar","arte","avergonzado(a)","pedir(preguntar)",
            "dormido(a)","tía","otoño","despierto(a)","hacha"};

    private String descb [] = {"bebe","malo","bolsa","hornear","pelota","bailarina","globo","banda","banco","barra","descalzo","ladrar","establo","barril","béisbol","murciélago","baño","bañera",
            "cuentas","frijoles","oso","golpear","hermoso(a)","cama","abeja","rogar","comenzar","detrás","creer","campana","pertenecer","cinturon","doblar","debajo","al lado","entre","más allá","grande",
            "cuenta","biografía","pájaro","cumpleaños","morder","amargo(a)","pizarra","culpar","ciego(a)","ampolla","cubo","sangre","soplar","azul","tabla","jactarse","bote","cuerpo","hueso","libro"
            };

    private String descc [] = {"jaula","pastel","llamar","acampar","capaz","poder","vela","bastón","canoa","gorra","capa","coche","tarjeta","cuidadoso(a)","cargar","maleta","castillo",
            "gato","atrapar","cueva","centro","cierto(a)","cadena","silla","tiza","desafío","posibilidad","cambiar","barato(a)","revisar","mejilla","cereza","caja","pecho","masticar","pollo",
            "barbilla","pedacito","escoger","talar","circulo","circo","ciudadano","ciudad","aplaudir","garra","limpiar","claro(a)","trepar","recortar","reloj","cerrar","tela","nube","payaso",
            "carbón"};

    private String descd [] = {"papa","lechería","bailar","peligro","atreverse","oscuro(a)","apresurarse","fecha","día","decidir","hondo(a)","venado","definitivo(a)","deleitar","entregar","exigir",
            "madriguera","dentista","describir","desierto","merecer","pupitre","destruir","roció","diamante","diccionario","morir","diferente","dimensión","dirección","suciedad","sucio(a)","desaparecer",
            "distancia","dividir","medico","perro","burro","puerta","entrada","punto","terrible","cómoda","taladro","beber","conducir","dejar caer","ahogarse","tambor","seco","pato","durante","polvo",
            "enano","habitar"};

    private String desce [] = {"cada","ansioso(a)","águila","oído","temprano","ganar","tierra","este","fácil","comer","eclipse","orilla","huevo","ocho","cualquiera","eléctrico(a)","elefante",
            "elevador","vacío","esforzarse","enemigo","motor","disfrutar","suficiente","sobre","escapar","esencial","empatar","atardecer","cada","todo el mundo","todo","excepto","cambiar","emocionarse",
            "excusar","hacer ejercicio","agotado(a)","esperar","ojo"};


    private String descf [] = {"cara","hecho","fabrica","decolorar","fallar","honestamente","hada","caer","falso","familia","ventilador","lejos","finca","campesino","gordo","padre","fatigado",
            "culpa","temer","pluma","alimentar","sentir","pies","fingir","cerca","pocos(as)","llanura","feroz","ficticio(a)","fila","llenar","finalmente","encontrar","multa","dedo","terminar","fuego",
            "alarma de incendios","bombero","primer(a)","pez","servir","cinco","arreglar","bandera","llama","flamenco","destello","liso(a)","flotar","piso","harina","fluir","flor","volar","mosca"};

    private String descg [] = {"ganar","juego","garaje","jardín","gasolina","recoger","suave","gigante","regalo","jirafa","niña","dar","contento(a)","vidrio","vaso","guante","ir","funcionar",
            "cabra","oro","buen(a)","ganso","gorila","grado","grano","abuela","uva","hierba","estupendo","glotón","suelo","grupo","crecer","garantizar","adivinar","suponer","huésped",
            "guiar","chicle"};

    private String desch [] = {"cabello","mitad","mano","pañuelo","encargarse de","guapo(a)","colgar","suceder","feliz","duro(a)","dañar","armonía","empollar","odiar","tener","cabeza",
            "oír","corazón","calentar","pesado(a)","talón","tacón","ayudar","hemisferio","gallina","su","aquí","esconder","alto(a)","loma","su","golpear","colmena","sostener","agujero","casa","honrado(a)",
            "aro","saltar","corneta","cuerno","caballo","manguera","hospital","caliente","hora","como","abrazo","gigantesco(a)","joroba","hambriento","apresurarse","lastimar","callar","boca de riego"};

    private String desci [] = {"hielo","idea","idéntico(a)","iglú","enfermo(a)","descortés","aumentar","verdaderamente","inflamable","tinta","insecto","dentro","en lugar de","dentro","invitar",
            "hierro","plancha","isla"};

    private String descj [] = {"chaqueta","cárcel","mermelada","chiste","alegre","viaje","alegría","juzgar","jugo","saltar","justamente","justo(a)"};

    private String desck [] = {"kayac","cuidar","tetera","llave","patear","matar","cariñoso(a)","clase","rey","beso","cocina","cometa","gatito","rodilla","cuchillo","golpear","saber","conocer"};

    private String descl [] = {"laboratorio","atar","lazo","escalera","dama","lago","cordero","lámpara","tierra","aterrizar","linterna","grande","ultimo(a)","tarde","reír","ley","césped","poner",
            "perezoso(a)","dirigir","plomo","hoja","apoyarse","magro(a)","saltar","aprender","partir","conferencia","izquierdo(a)","limón","menos","carta","letra","biblioteca","lamer","tapa","mentir",
            "echarse","vida","levantar","luz","liviano","claro(a)","relámpago","gustar","rama","línea","león","labio","borde","lista","escuchar","pequeño","vivir","carga","cargar","sitio",};

    private String descm [] = {"loco(a)","magia","aumentar","correo","principal","hacer","hombre","modales","muchos(as)","mapa","marzo","marchar","nota","desfigurar","mercado","casarse","igualar",
            "fosforo","dueño","comida","significar","pretender","malhumorado(a)","medir","carne","encontrarse","melón","derretir","memorizar","alegre","medio","leche","cuidar","mío(a)",
            "mina","equivocación","mezclar","dinero","mono","monstruoso(a)","luna","mas","madre","montaña","boca","mover(se)","música","deber","mi mismo"};

    private String descn [] = {"nombre","siesta","servilleta","narrar","estrecho(a)","cerca","arreglado(a)","cuello","necesitar","vecino","nido","red","nunca","nuevo","próximo","agradable","nueve",
            "cabecear","ruido","ninguno(a)","mediodía","Norte","nota","nada","notar","alimentar","ahora","numero","enfermera","nuez"};

    private String desco [] = {"roble","avena","obedecer","objeto","oponerse","oblongo(a)","océano","sobrante","raro(a)","fuera","oficina","a menudo","viejo(a)","una vez","uno(a)","solamente",
            "único(a)","abierto(a)","orangután","orden","órgano","otro(a)","nuestro(a)","fuera","apagado(a)","horno","terminado(a)","encima","rehacer","mas de","deber","lechuza","poseer"};

    private String descp [] = {"empacar","paquete","bloc","pagina","cubo","dolor","pintar","par","palacio","pálido(a)","palma","sartén","pensamiento","papel","paracaídas","desfile","paquete",
            "padres","parque","estacionar","parte","fiesta","pasar","pasado","palmada","sendero","modelo","pata","pagar","pelicano","pluma","lápiz","gente","punto final","época",
            "persona","piano","escoger","merienda campestre","retrato","lamina","pastel","pedazo","pila","peregrino","almohada","piloto","pino","pipa","sitio","sencillo(a)","llano"};

    private String descq [] = {"reñir","cuarto","reina","apagar","pregunta","rápido(a)","quieto(a)","dejar","muy","examen"};

    private String descr [] = {"conejo","carrera","mapache","radio","carril","llover","impermeable","levantar","criar","rastrillo","rata","cuervo","alcanzar","leer","listo(a)","real",
            "razón","recibir","reconocer","rojo(a)","quedarse","recordar","quitar","alquilar","repetir","contestación","informe","residente","descansar","devolver","rinoceronte","cinta",
            "rico(a)","adivinanza","montar","derecho(a)","correcto","circulo","anillo","maduro(a)","salir","rio","camino","asar","roca","rodar","techo","habitación","gallo","soga","rosa"};

    private String descs [] = {"saco","triste","seguro(a)","vela","marinero","ensalada","venta","sal","igual","mismo(a)","arena","emparedado","satisfacer","ahorrar","salvar","serrucho","decir",
            "balanza","escama","asustar","bufanda","sitio","escena","itinerario","escuela","aula","tijeras","regañar","patineta","recorte","raspar","rascar","gritar","pantalla","fregar",
            "mar","foca","estación","asiento","segundo","ver","semilla","parecer","agarrar","rara vez","seleccionar","vender","semicírculo","enviar","sentido","oración","separar","servir"};

    private String desct [] = {"mesa","etiqueta","cola","sastre","llevar","cuento","hablar","alto(a)","enredar","tanque","toque","tarea","gusto","te","enseñar","maestra","equipo","rasgar",
            "lagrima","cucharita","tedioso(a)","teléfono","contar","diez","blando(a)","atender","carpa","terrible","examen","que","gracias","ese(a),(o)","su","entonces","allí",
            "ellos(as)","grueso(a)","ladrón","dedal","delgado(a)","cosa","pensar","este(a),(o)","espina","aquellos(as)","a pesar de","hilo","garganta","trono","a través","lanzar"};

    private String descu [] = {"feo(a)","paraguas","inseguro(a)","tío","debajo","incomodo(a)","infeliz","malo(a)","a no ser que","desatar","sobre","usar","útil"};

    private String descv [] = {"desocupado(a)","vacaciones","valle","valor","jarrón","vegetal","verso","muy","vista","aldea","plantas trepadoras","violín","visitar","voz","votar"};

    private String descw [] = {"menear","vagón","esperar","despertar","caminar","pared","querer","tibio(a)","advertir","lavar","malgastar","cuidar","reloj","agua","regar","ola","camino","débil",
            "usar","fatigado(a)","tiempo","mala hierba","semana","sollozar","pesar","mojado(a)","ballena","que","rueda","cuando","cual","mientras","azotar","silbar","pito","quien",
            "entero(a)","de quien","por qué","ancho(a)","salvaje","ganar","viento","molino de viento","ventana","ala","atractivo(a)","invierno","secar","alambre","sabio","deseo"};

    private String descx [] = {"rayos X","xilofono"};

    private String descy [] = {"patio","estambre","bostezar","año","gritar","amarillo","si","todavía","tú","joven","tu"};

    private String descz [] = {"cebra","cero","zona","zoológico"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dayly_words);



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

        //prueba ramdom

        Random numP = new Random();

        byte selea = (byte)numP.nextInt(26);
        byte seleb = (byte)numP.nextInt(26);
        byte selec = (byte)numP.nextInt(26);
        byte seled = (byte)numP.nextInt(26);

        switch (selea){
            case 0:
                wordneutro = worda;
                descneutro = desca;
                break;
            case 1:
                wordneutro = wordb;
                descneutro = descb;
                break;
            case 2:
                wordneutro = wordc;
                descneutro = descc;
                break;
            case 3:
                wordneutro = wordd;
                descneutro = descd;
                break;
            case 4:
                wordneutro = worde;
                descneutro = desce;
                break;
            case 5:
                wordneutro = wordf;
                descneutro = descf;
                break;
            case 6:
                wordneutro = wordg;
                descneutro = descg;
                break;
            case 7:
                wordneutro = wordh;
                descneutro = desch;
                break;
            case 8:
                wordneutro = wordi;
                descneutro = desci;
                break;
            case 9:
                wordneutro = wordj;
                descneutro = descj;
                break;
            case 10:
                wordneutro = wordk;
                descneutro = desck;
                break;
            case 11:
                wordneutro = wordl;
                descneutro = descl;
                break;
            case 12:
                wordneutro = wordm;
                descneutro = descm;
                break;
            case 13:
                wordneutro = wordn;
                descneutro = descn;
                break;
            case 14:
                wordneutro = wordo;
                descneutro = desco;
                break;
            case 15:
                wordneutro = wordp;
                descneutro = descp;
                break;
            case 16:
                wordneutro = wordq;
                descneutro = descq;
                break;
            case 17:
                wordneutro = wordr;
                descneutro = descr;
                break;
            case 18:
                wordneutro = words;
                descneutro = descs;
                break;
            case 19:
                wordneutro = wordt;
                descneutro = desct;
                break;
            case 20:
                wordneutro = wordu;
                descneutro = descu;
                break;
            case 21:
                wordneutro = wordv;
                descneutro = descv;
                break;
            case 22:
                wordneutro = wordw;
                descneutro = descw;
                break;
            case 23:
                wordneutro = wordx;
                descneutro = descx;
                break;
            case 24:
                wordneutro = wordy;
                descneutro = descy;
                break;
            case 25:
                wordneutro = wordz;
                descneutro = descz;
                break;
        }

        switch (seleb){
            case 0:
                wordneutrob = worda;
                descneutrob = desca;
                break;
            case 1:
                wordneutrob = wordb;
                descneutrob = descb;
                break;
            case 2:
                wordneutrob = wordc;
                descneutrob = descc;
                break;
            case 3:
                wordneutrob = wordd;
                descneutrob = descd;
                break;
            case 4:
                wordneutrob = worde;
                descneutrob = desce;
                break;
            case 5:
                wordneutrob = wordf;
                descneutrob = descf;
                break;
            case 6:
                wordneutrob = wordg;
                descneutrob = descg;
                break;
            case 7:
                wordneutrob = wordh;
                descneutrob = desch;
                break;
            case 8:
                wordneutrob = wordi;
                descneutrob = desci;
                break;
            case 9:
                wordneutrob = wordj;
                descneutrob = descj;
                break;
            case 10:
                wordneutrob = wordk;
                descneutrob = desck;
                break;
            case 11:
                wordneutrob = wordl;
                descneutrob = descl;
                break;
            case 12:
                wordneutrob = wordm;
                descneutrob = descm;
                break;
            case 13:
                wordneutrob = wordn;
                descneutrob = descn;
                break;
            case 14:
                wordneutrob = wordo;
                descneutrob = desco;
                break;
            case 15:
                wordneutrob = wordp;
                descneutrob = descp;
                break;
            case 16:
                wordneutrob = wordq;
                descneutrob = descq;
                break;
            case 17:
                wordneutrob = wordr;
                descneutrob = descr;
                break;
            case 18:
                wordneutrob = words;
                descneutrob = descs;
                break;
            case 19:
                wordneutrob = wordt;
                descneutrob = desct;
                break;
            case 20:
                wordneutrob = wordu;
                descneutrob = descu;
                break;
            case 21:
                wordneutrob = wordv;
                descneutrob = descv;
                break;
            case 22:
                wordneutrob = wordw;
                descneutrob = descw;
                break;
            case 23:
                wordneutrob = wordx;
                descneutrob = descx;
                break;
            case 24:
                wordneutrob = wordy;
                descneutrob = descy;
                break;
            case 25:
                wordneutrob = wordz;
                descneutrob = descz;
                break;
        }

        switch (selec){
            case 0:
                wordneutroc = worda;
                descneutroc = desca;
                break;
            case 1:
                wordneutroc = wordb;
                descneutroc = descb;
                break;
            case 2:
                wordneutroc = wordc;
                descneutroc = descc;
                break;
            case 3:
                wordneutroc = wordd;
                descneutroc = descd;
                break;
            case 4:
                wordneutroc = worde;
                descneutroc = desce;
                break;
            case 5:
                wordneutroc = wordf;
                descneutroc = descf;
                break;
            case 6:
                wordneutroc = wordg;
                descneutroc = descg;
                break;
            case 7:
                wordneutroc = wordh;
                descneutroc = desch;
                break;
            case 8:
                wordneutroc = wordi;
                descneutroc = desci;
                break;
            case 9:
                wordneutroc = wordj;
                descneutroc = descj;
                break;
            case 10:
                wordneutroc = wordk;
                descneutroc = desck;
                break;
            case 11:
                wordneutroc = wordl;
                descneutroc = descl;
                break;
            case 12:
                wordneutroc = wordm;
                descneutroc = descm;
                break;
            case 13:
                wordneutroc = wordn;
                descneutroc = descn;
                break;
            case 14:
                wordneutroc = wordo;
                descneutroc = desco;
                break;
            case 15:
                wordneutroc = wordp;
                descneutroc = descp;
                break;
            case 16:
                wordneutroc = wordq;
                descneutroc = descq;
                break;
            case 17:
                wordneutroc = wordr;
                descneutroc = descr;
                break;
            case 18:
                wordneutroc = words;
                descneutroc = descs;
                break;
            case 19:
                wordneutroc = wordt;
                descneutroc = desct;
                break;
            case 20:
                wordneutroc = wordu;
                descneutroc = descu;
                break;
            case 21:
                wordneutroc = wordv;
                descneutroc = descv;
                break;
            case 22:
                wordneutroc = wordw;
                descneutroc = descw;
                break;
            case 23:
                wordneutroc = wordx;
                descneutroc = descx;
                break;
            case 24:
                wordneutroc = wordy;
                descneutroc = descy;
                break;
            case 25:
                wordneutroc = wordz;
                descneutroc = descz;
                break;
        }

        switch (seled){
            case 0:
                wordneutrod = worda;
                descneutrod = desca;
                break;
            case 1:
                wordneutrod = wordb;
                descneutrod = descb;
                break;
            case 2:
                wordneutrod = wordc;
                descneutrod = descc;
                break;
            case 3:
                wordneutrod = wordd;
                descneutrod = descd;
                break;
            case 4:
                wordneutrod = worde;
                descneutrod = desce;
                break;
            case 5:
                wordneutrod = wordf;
                descneutrod = descf;
                break;
            case 6:
                wordneutrod = wordg;
                descneutrod = descg;
                break;
            case 7:
                wordneutrod = wordh;
                descneutrod = desch;
                break;
            case 8:
                wordneutrod = wordi;
                descneutrod = desci;
                break;
            case 9:
                wordneutrod = wordj;
                descneutrod = descj;
                break;
            case 10:
                wordneutrod = wordk;
                descneutrod = desck;
                break;
            case 11:
                wordneutrod = wordl;
                descneutrod = descl;
                break;
            case 12:
                wordneutrod = wordm;
                descneutrod = descm;
                break;
            case 13:
                wordneutrod = wordn;
                descneutrod = descn;
                break;
            case 14:
                wordneutrod = wordo;
                descneutrod = desco;
                break;
            case 15:
                wordneutrod = wordp;
                descneutrod = descp;
                break;
            case 16:
                wordneutrod = wordq;
                descneutrod = descq;
                break;
            case 17:
                wordneutrod = wordr;
                descneutrod = descr;
                break;
            case 18:
                wordneutrod = words;
                descneutrod = descs;
                break;
            case 19:
                wordneutrod = wordt;
                descneutrod = desct;
                break;
            case 20:
                wordneutrod = wordu;
                descneutrod = descu;
                break;
            case 21:
                wordneutrod = wordv;
                descneutrod = descv;
                break;
            case 22:
                wordneutrod = wordw;
                descneutrod = descw;
                break;
            case 23:
                wordneutrod = wordx;
                descneutrod = descx;
                break;
            case 24:
                wordneutrod = wordy;
                descneutrod = descy;
                break;
            case 25:
                wordneutrod = wordz;
                descneutrod = descz;
                break;
        }

        byte posP = (byte)numP.nextInt(wordneutro.length-1);
        byte posP2 = (byte)numP.nextInt(wordneutrob.length-1);
        byte posP3 = (byte)numP.nextInt(wordneutroc.length-1);
        byte posP4 = (byte)numP.nextInt(wordneutrod.length-1);


        String v1  = wordneutro[posP];
        String v2  = wordneutrob[posP2];
        String v3  = wordneutroc[posP3];
        String v4  = wordneutrod[posP4];


        String d1  = descneutro[posP];
        String d2  = descneutrob[posP2];
        String d3  = descneutroc[posP3];
        String d4  = descneutrod[posP4];

        final String words []=  {v1,v2,v3,v4};

        final String result []= {d1,d2,d3,d4};



        //poner el icono en el action bar
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);

        tv = (TextView)findViewById(R.id.tv);
        lw = (ListView)findViewById(R.id.tw);


        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,R.layout.item_list_alealtorio,words);
        lw.setAdapter(adapter);

        lw.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                tv.setText(lw.getItemAtPosition(i)+" = " + result[i] );
                view.setSelected(true);


                tts.speak(words[i],TextToSpeech.QUEUE_FLUSH,null);
                tts.setSpeechRate(1);


            }
        });
    }
}
