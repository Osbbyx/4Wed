package app.app.elementary.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import com.example.elementary.myapplication.R;

public class todo extends AppCompatActivity {

    private String[] items;
    private String desc [] ;
   private ArrayList<String> listItems;
    private ArrayAdapter<String> adapter;
    private ListView listView;
    private EditText editText;
    private TextView tv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo);
        listView=(ListView)findViewById(R.id.tw);
        editText=(EditText)findViewById(R.id.txtsearch);
        tv = (TextView)findViewById(R.id.tv);

        initList();

        editText.addTextChangedListener(new TextWatcher() {


            //prueba




            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int
                    after) {
            }



            @Override
            public void onTextChanged(CharSequence s, int start, int before, int
                    count) {
                if(s.toString().equals("")){
                    // reset listview
                    initList();
                }

                else{
                    // perform search
                    searchItem(s.toString());
                }
            }



            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }



    public void searchItem(String textToSearch){
        for(String item:items){
            if(!item.contains(textToSearch)){
                listItems.remove(item);
            }
        }
        adapter.notifyDataSetChanged();
    }

    public void initList(){
        items=new String[]{"a = un(a)","able = capaz","about(1) = acerca de","about(2) = alrededor","above = ancima","absent = ausente","accident = accidente","ache = dolor","acorn = bellota","across = a través de","act = actuar","add = añadir","address = dirección","admire = admirar","admission = entrada","advice = consejo","after(1) = detrás","after(2) = después",
                "again = otra vez","against = en contra","age = edad","agree = de acuerdo","ahead = adelante","aim = apuntar","air = aire","airplane = avión","airport = aeropuerto","alarm = alarma","alive = vivo","allow = permitir","almost = casi","along = a lo largo","already = ya","also = también","always = siempre","among = entre","ancient = antiguo","angry = enojado",
                "animal = animal","annual = anual","another = otro(a)","answer = contestar","ant = hormiga","any = cualquier","apart = aparte","ape = simio","appear = aparecer","apple = manzana","april = abril","apron = delantal","aquarium = acuario","arm = brzo","around = alrededor","arrive = llegar","art = arte","ashamed = avergonzado(a)","ask = pedir(preguntar)",
                "asleep = dormido(a)","aunt = tía","autumn = otoño","awake = despierto(a)","axe = hacha","baby = bebe","bad = malo","bag = bolsa","bake = hornear","ball = pelota","ballerina = bailarina","balloon = globo","band = banda","bank = banco","bar = barra","bare = descalzo","bark = ladrar","barn = establo","barrel = barril","baseball = béisbol","bat = murciélago","bath = baño","bathtub = bañera",
                "beads = cuentas","beans = frijoles","bear = oso","beat = golpear","beautiful = hermoso(a)","bed = cama","bee = abeja","beg = rogar","begin = comenzar","behind = detrás","believe = creer","bell = campana","belong = pertenecer","belt = cinturon","bend = doblar","beneath = debajo","beside = al lado","between = entre","beyond = más allá","big = grande",
                "bill = cuenta","biography = biografía","bird = pájaro","birthday = cumpleaños","bite = morder","bitter = amargo(a)","blackboard = pizarra","blame = culpar","blind = ciego(a)","blister = ampolla","block = cubo","blood = sangre","blow = soplar","blue = azul","board = tabla","boast = jactarse","boat = bote","body = cuerpo","bone = hueso","book = libro",
                "boot = bota","born = nacer","both = ambos(as)","bother = molestar","bottle = botella","bottom = fondo","bounce = rebotar","bow = arco","bowl = vasija","box = caja","boy = niño","brave = valiente","bread = pan","break = romper","breath = aliento","breathe = respirar","breeze = brisa","bridge = puente","bright = inteligente","bring = traer",
                "brook = arroyo","brother = hermano","bucket = cubo","bud = boton","build = construir","bulb = bombilla","brunch = racimo","bunny = conejito","burn = quemar","bury = enterrar","bush = arbusto","busy = ocupado(a)","butter = mantequilla","butterfly = mariposa","button = botón","buy = comprar","buzzard = ratonero","buz = zumbido","cage = jaula","cake = pastel","call = llamar","camp = acampar","capable = capaz","can = poder","candle = vela","cane = bastón","canoe = canoa","cap = gorra","cape = capa","car = coche","card = tarjeta","careful = cuidadoso(a)","carry = cargar","case = maleta","castle = castillo",
                "cat = gato","catch = atrapar","cave = cueva","center = centro","certain = cierto(a)","chain = cadena","chair = silla","chalk = tiza","challenge = desafío","chance = posibilidad","change = cambiar","cheap = barato(a)","check = revisar","cheek = mejilla","cherry = cereza","chest(1) = caja","chest(2) = pecho","chew = masticar","chicken = pollo",
                "chin = barbilla","chip = pedacito","choose = escoger","chop = talar","circle = circulo","circus = circo","citizen = ciudadano","city = ciudad","clap = aplaudir","claw = garra","clean = limpiar","clear = claro(a)","climb = trepar","clip = recortar","clock = reloj","close = cerrar","cloth = tela","cloud = nube","clown = payaso",
                "coal = carbón","coast = costa","coat = abrigo","cobbler = zapatero","cold = frio","colt = potrillo","comb = peine","come = venir","concentrate = concentrar","cone = cono","cook = cocinar","cool = fresco(a)","copy = copiar","corn = maíz","corner = esquina","cost = costar","cottage = cabaña","cough = toser","count = contar","cover = cubrir",
                "cow = vaca","crack = quebradura","cradle = cuna","crawl = gatear","crayon = crayón","cream = crema","creep = arrastrarse","criticize = criticar","cross = cruzar","crown = corona","cruel = cruel","crumbs = migajas","cry = llorar","cup = taza","cure = curar","curl = rizo","curved = curva","cushion = cojin","cut = cortar","cute = gracioso(a","dad = papa","dairy = lechería","dance = bailar","danger = peligro","dare = atreverse","dark = oscuro(a)","dash = apresurarse","date = fecha","day = día","decide = decidir","deep = hondo(a)","deer = venado","definite = definitivo(a)","delight = deleitar","deliver = entregar","demand = exigir",
                "den = madriguera","dentist = dentista","describe = describir","desert = desierto","deserve = merecer","desk = pupitre","destroy = destruir","dew = roció","diamond = diamante","dictionary = diccionario","die = morir","different = diferente","dimension = dimensión","direction = dirección","dirt = suciedad","dirty = sucio(a","disappear = desaparecer",
                "distance = distancia","divide = dividir","doctor = medico","dog = perro","donkey = burro","door = puerta","doorway = entrada","dot = punto","dreadful = terrible","dresser = cómoda","drill = taladro","drink = beber","drive = conducir","drop = dejar caer","drown = ahogarse","drum = tambor","dry = seco","duck = pato","during = durante","dust = polvo",
                "dwarf = enano","dwell = habitar","each = cada","eager = ansioso(a)","eagle = águila","ear = oído","early = temprano","earn = ganar","earth = tierra","east = este","easy = fácil","eat = comer","eclipse = eclipse","edge = orilla","egg = huevo","eight = ocho","either = cualquiera","electric = eléctrico(a)","elephant = elefante",
                "elevator = elevador","empty = vacío","endeavor = esforzarse","enemy = enemigo","engine = motor","enjoy = disfrutar","enough = suficiente","envelope = sobre","escape = escapar","essential = escapar","even = empatar","evening = atardecer","every = cada","everybody = todo el mundo","everything = todo","except = excepto","exchange = cambiar","excite = emocionarse",
                "excuse = excusar","exercise = hacer ejercicio","exhausted = agotado(a)","expect = esperar","eye = ojo","face = cara","fact = hecho","factory = fabrica","fade = decolorar","fail = fallar","fair = honestamente","fairy = hada","fall = caer","false = falso","family = familia","fan = ventilador","far = lejos","farm = finca","farmer = campesino","fat = gordo","father = padre","fatigued = fatigado",
                "fault = culpa","fear = temer","feather = pluma","feed = alimentar","feel = sentir","feet = pies","feign = fingir","fence = cerca","few = pocos(as)","field = llanura","fierce = feroz","fictitious = ficticio(a)","file = fila","fill = llenar","finally = finalmente","find = encontrar","fine = multa","finger = dedo","finish = terminar","fire = fuego",
                "fire alarm = alarma de incendios","fireman = bombero","first = primer(a)","fish = pez","fit = servir","five = cinco","fix = arreglar","flag = bandera","flame = llama","flamingo = flamenco","flash = destello","flat = liso(a)","float = flotar","floor = piso","flour = harina","flow = fluir","flower = flor","fly(1) = volar","fly(2) = mosca",
                "fold = doblar","foliage = follaje","follow = seguir","fond = afectuoso(a)","food = alimento","foot = pie","forehead = frente","forest = bosque","forget = olvidar","forgive = perdonar","fork = tenedor","forward = adelante","four = cuatro","fox = zorro","free(1) = gratis","free(2) = liberar","freeze = congelar","fresh = fresco(a)","Friday = viernes",
                "friend = amigo(a)","frighten = asustar","frog = rana","fruit = fruta","fry = freír","function = funcionar","furnace = estufa","furniture = mueble","gain = ganar","game = juego","garage = garaje","garden = jardín","gasoline = gasolina","gather = recoger","gentle = suave","giant = gigante","gift = regalo","giraffe = jirafa","girl = niña","give = dar","glad = contento(a)","glass(1) = vidrio","glass(2) = vaso","glove = guante","go(1) = ir","go(2) = funcionar",
                "goat = cabra","gold = oro","good = buen(a)","goose = ganso","gorilla = gorila","grade = grado","grain = grano","grandmother = abuela","grape = uva","grass = hierba","great = estupendo","greedy = glotón","ground = suelo","group = grupo","grow = crecer","guarantee = garantizar","guess(1) = adivinar","guess(2) = suponer","guest = huésped",
                "guide = guiar","gum = chicle","hair = cabello","half = mitad","hand = mano","handkerchief = pañuelo","handle = encargarse de","handsome = guapo(a)","hang = colgar","happen = suceder","happy = feliz","hard = duro(a)","harm = dañar","harmony = armonía","hatch = empollar","hate = odiar","have = tener","head = cabeza",
                "hear = oír","heart = corazón","heat = calentar","heavy = pesado(a)","heel(1) = talón","heel(2) = tacón","help = ayudar","hemisphere = hemisferio","hen = gallina","her = su","here = aquí","hide = esconder","high = alto(a)","hill = loma","his = su","hit = golpear","hive = colmena","hold = sostener","hole = agujero","home = casa","honest = honrado(a)",
                "hoop = aro","hop = saltar","horn(1) = corneta,","horn(2) = cuerno","horse = caballo","hose = manguera","hospital = hospital","hot = caliente","hour = hora","how = como","hug = abrazo","huge = gigantesco(a)","hump = joroba","hungry = hambriento","hurry = apresurarse","hurt = lastimar","hush = callar","hydrant = boca de riego","ice = hielo","idea = idea","identical = idéntico(a)","igloo = iglú","ill = enfermo(a)","impolite = descortés","increase = aumentar","indeed = verdaderamente","inflammable = inflamable","ink = tinta","insect = insecto","inside = dentro","instead = en lugar de","into = dentro","invite = invitar",
                "iron(1) = hierro","iron(2) = plancha","island = isla","jacket = chaqueta","jail = cárcel","jam = mermelada","joke = chiste","jolly = alegre","journey = viaje","joy = alegría","judge = juzgar","juice = jugo","jump = saltar","just(1) = justamente","just(2) = justo(a)","kayak = kayac","keep = cuidar","kettle = tetera","key = llave","kick = patear","kill = matar","kind(1) = cariñoso(a)","kind(2) = clase","king = rey","kiss = beso","kitchen = cocina","kite = cometa","kitten = gatito","knee = rodilla","knife = cuchillo","knock = golpear","know(1) = saber","know(2) = conocer","laboratory = laboratorio","lace(1) = atar","lace(2) = lazo","ladder = escalera","lady = dama","lake = lago","lamb = cordero","lamp = lámpara","land(1) = tierra","land(2) = aterrizar","lantern = linterna","large = grande","last = ultimo(a)","late = tarde","laugh = reír","law = ley","lawn = césped","lay = poner",
                "lazy = perezoso(a)","lead(1) = dirigir","lead(2) = plomo","leaf = hoja","lean(1) = apoyarse","lean(2) = magro(a)","leap = saltar","learn = aprender","leave = partir","lecture = conferencia","left = izquierdo(a)","lemon = limón","less = menos","letter(1) = carta","letter(2) = letra","library = biblioteca","lick = lamer","lid = tapa","lie(1) = mentir",
                "lie(2) = echarse","life = vida","lift = levantar","light(1) = luz","light(2) = liviano","light(3) = claro(a),","lightning = relámpago","like = gustar","limb = rama","line = línea","lion = león","lip(1) = labio","lip(2) = borde","list = lista","listen = escuchar","little = pequeño","live = vivir","load(1) = carga","load(2) = cargar","location = sitio",
                "lock = bloquear","log = tronco","look(1) = buscar","look(2) = verse","look(3) = mirar","loose = suelto(a)","lose = perder","loud = alto(a)","low = bajo(a)","lullaby = canción de cuna","lunch = almuerzo","mad = loco(a)","magic = magia","magnify = aumentar","mail = correo","main = principal","make = hacer","man = hombre","manners = modales","many = muchos(as)","map = mapa","March = marzo","march = marchar","mark(1) = nota","mark(2) = desfigurar","market = mercado","marry = casarse","match(1) = igualar",
                "match(2) = fosforo","master = dueño","meal = comida","mean(1) = significar","mean(2) = pretender","mean(3) = malhumorado(a)","measure = medir","meat = carne","meet = encontrarse","melon = melón","melt = derretir","memorize = memorizar","merry = alegre","middle = medio","milk = leche","mind = cuidar","mine(1) = mío(a)",
                "mine(2) = mina","mistake = equivocación","mix = mezclar","money = dinero","monkey = mono","monstrous = monstruoso(a)","moon = luna","more = mas","mother = madre","mountain = montaña","mouth = boca","move = mover(se)","music = música","must = deber","myself = mi mismo","name = nombre","nap = siesta","napkin = servilleta","narrate = narrar","narrow = estrecho(a)","near = cerca","neat = arreglado(a)","neck = cuello","need = necesitar","neighbor = vecino","nest = nido","net = red","never = nunca","new = nuevo","next = próximo","nice = agradable","nine = nueve",
                "nod = cabecear","noise = ruido","none = ninguno(a)","noon = mediodía","North = Norte","note = nota","nothing = nada","notice = notar","nourish = alimentar","now = ahora","number = numero","nurse = enfermera","nut = nuez","oak = roble","oats = avena","obey = obedecer","object(1) = objeto","object(2) = oponerse","oblong = oblongo(a)","ocean = océano","odd(1) = sobrante","odd(2) = raro(a)","off = fuera","office = oficina","often = a menudo","old = viejo(a)","once = una vez","one = uno(a)","only(1) = solamente",
                "only(2) = único(a)","open = abierto(a)","orangutan = orangután","order = orden","organ = órgano","other = otro(a)","our = nuestro(a)","out(1) = fuera","out(2) = apagado(a)","oven = horno","over(1) = terminado(a)","over(2) = encima","over(3) = rehacer","over(4) = mas de","owe = deber","owl = lechuza","own = poseer","pack = empacar","package = paquete","pad = bloc","page = pagina","pail = cubo","pain = dolor","paint = pintar","pair = par","palace = palacio","pale = pálido(a)","palm = palma","pan = sartén","pansy = pensamiento","paper = papel","parachute = paracaídas","parade = desfile","parcel = paquete",
                "parent = padres","park(1) = parque","park(2) = estacionar","part = parte","party = fiesta","pass = pasar","past = pasado","pat = palmada","path = sendero","pattern = modelo","paw = pata","pay = pagar","pelican = pelicano","pen = pluma","pencil = lápiz","people = gente","period(1) = punto final","period(2) = época",
                "persona = persona","piano = piano","pick = escoger","picnic = merienda campestre","picture(1) = retrato","picture(2) = lamina","pie = pastel","piece = pedazo","pile = pila","pilgrim = peregrino","pillow = almohada","pilot = piloto","pine = pino","pipe = pipa","place = sitio","plain = sencillo(a)","plain(2) = llano",
                "plan(1) = planear","plan(2) = plano","plane(1) = cepillo","plane(2) = avión","plant = plantar","plate = plato","play(1) = jugar","play(2) = tocar","please = por favor","plenty = suficiente","plumage = plumaje","plump = grueso(a)","pocket = bolsillo","pod = vaina","poem = poema","point = punta","pole(1) = asta","pole(2 = caña)",
                "policeman = policía","polite = educado(a)","pond = estanque","pony = caballito","possible = posible","postman = cartero","pot = cazuela","poultry = aves","pound = golpear","pour = verter","practice = practicar","praise = alabar","precious = precioso(a)","prepare = preparar","present = presente","pretend = pretender",
                "pretty = bonito(a)","price = precio","prince = príncipe","princess = princesa","principal = director","prize = premio","promise = prometer","promote = promover","prompt = pronto","proper = apropiado(a)","protect = proteger","proud = orgulloso(a)","puddinng = pudin","pull = tirar","pumpkin = calabaza","punctual = puntual","pupil = alumno",
                "puppy = cachorro","pure = puro(a)","purse = bolso","pursue = perseguir","push = empujar","put = poner","quarrel = reñir","quarter = cuarto","queen = reina","quench = apagar","question = pregunta","quick = rápido(a)","quiet = quieto(a)","quit = dejar","quite = muy","quiz = examen","rabbit = conejo","race = carrera","raccoon = mapache","radio = radio","rail = carril","rain = llover","raincoat = impermeable","raise(1) = levantar","raise(2) = criar","rake = rastrillo","rat = rata","raven = cuervo","reach = alcanzar","read = leer","ready = listo(a)","real = real",
                "reason = razón","receive = recibir","recognize = reconocer","red = rojo(a)","remain = quedarse","remember = recordar","remove = quitar","rent = alquilar","repeat = repetir","reply = contestación","report = informe","resident = residente","rest = descansar","return = devolver","rhinoceros = rinoceronte","ribbon = cinta",
                "rich = rico(a)","riddle = adivinanza","ride = montar","right(1) = derecho(a)","right(2) = correcto","ring(1) = circulo","ring(2) = anillo","ripe = maduro(a)","rise = salir","river = rio","road = camino","roast = asar","rock = roca","roll = rodar","roof = techo","room = habitación","rooster = gallo","rope = soga","rose = rosa",
                "rough = bravo(a)","round = redondo(a)","route = ruta","row = remar","rub = frotar","rude = rudo(a)","rug = alfombra","rule = regla","run = correr","rush = apresurarse","sack = saco","sad = triste","safe = seguro(a)","sail = vela","sailor = marinero","salad = ensalada","sale = venta","salt = sal","same(1) = igual","same(2) = mismo(a)","sand = arena","sandwich = emparedado","satisfy = satisfacer","save(1 = ahorrar)","save(2) = salvar","saw = serrucho","say = decir",
                "scale(1) = balanza","scale(2) = escama","scare = asustar","scarf = bufanda","scene(1) = sitio","scene(2) = escena","schedule = itinerario","school = escuela","schoolroom = aula","scissors = tijeras","scold = regañar","scooter = patineta","scrap = recorte","scrape = raspar","scratch = rascar","scream = gritar","screen = pantalla","scrub = fregar",
                "sea = mar","seal = foca","season = estación","seat = asiento","second = segundo","see = ver","seed = semilla","seem = parecer","seize = agarrar","seldom = rara vez","select = seleccionar","sell = vender","semicircle = semicírculo","send = enviar","sense = sentido","sentence = oración","separate = separar","serve = servir",
                "set(1) = colocar","set(2) = juego","seven = siete","sew = coser","shade(1) = cortina","shade(2) = sombra","shadow = sombra","shake(1) = sacudir","shake(2) = estrechar","shape = forma","share = compartir","sharp(1) = afilado(a)","sharp(2) = vivo(a)","shave = afeitar","she = ella","shed(1) = cobertizo","shed(2) = mudar","sheep = oveja",
                "sheet(1) = hoja","sheet(2) = sabana","shelf = estante","shell = cascara","shelter = refugio","shine(1) = brillar","shine(2) = lustrar","ship = buque","shirt = camisa","shiver = temblar","shoe = zapato","shoot = tirar","shore = orilla","short = pequeño","shout = gritar","shovel = pala","show = mostrar","shower = ducha","shut = cerrar",
                "sick = enfermo(a","side = lado","sight = vista","sign(1) = firmar","sign(2) = señal","silent = silencioso(a)","silver = plata","similar = similar","since = desde","sing = cantar","sister = hermana","sit = sentarse","size = numero","skate = patinar","skin = piel","skip = saltar","skirt = falda","sky = cielo","slant = inclinar",
                "slap = abofetear","sled = trineo","sleep = dormir","sleigh = trineo","slice(1) = rebanada","slice(2) = rebanar","slide(1) = tobogán","slide(2) = deslizarse","slip = resbalar","slipper = zapatilla","slow = lento(a)","sly = tramposo(a)","smart = inteligente","smell = oler","smile = sonreír","smoke(1) = fumar","smoke(2) = humo",
                "smooth = liso(a)","snake = serpiente","sneeze = estornudar","snow = nieve","snowflake = copo de nieve","soap = jabón","soft = suave","soil(1) = suelo","soil(2) = mancharse","some = algunos(as)","son = hijo","song = canción","soon = pronto","soprano = soprano","sorry = lamentar","sort = organizar",
                "sound = sonido","soup = sopa","sour = acido(a)","South = Sur","sow = sembrar","space = espacio","speak = hablar","spectacle = espectáculo","speed = velocidad","spell = deletrear","spend = gastar","spider = araña","spin = girar","spinach = espinaca","splash = salpicadura","spoil(1) = consentir","spoil(2) = arruinar","spoil(3) = deteriorarse",
                "spoon = cuchara","sport = deporte","spot(1) = sitio","spot(2) = mancha","spray = salpicar","spread = untar","spring(1) = primavera","spring(2) = fuente","square = cuadrado","squash = calabaza","squeeze = apretar","squid = calamar","stable = establo","stairs = escaleras","stake = estaca","stalk = tallo","stamp = estampilla",
                "star = estrellas","start = comenzar","station = estación","stay = quedarse","steal = robar","steam = vapor","steep = escarpado(a)","stem = tallo","stick(1) = palo","stick(2) = pegar","stiff = entumecido(a)","still(1) = todavía","still(2) = tranquilo(a)","sting = picar","stir = resolver","stocking = media","stomach = estomago",
                "stone = piedra","stool = banqueta","stop = parar","store = tienda","stork = cigüeña","storm = tormenta","story = cuento","stove = estufa","strange = extraño","strap = correa","straw = paja","stream = arroyo","street = calle","stretch = estirar","strike = golpear","string = cuerda","strip = tira","stroll = pasear","strong = fuerte",
                "study = estudiar","succeed = triunfar","such = tal","suddenly = repentinamente","sugar = azúcar","suit = traje","summer = verano","sun = sol","supper = cena","suppose = suponer","sure = seguro(a)","surprise = sorpresa","swallow = tragar","sweater = suéter","sweep = barrer","sweet = dulce","swell = hinchar","swift = veloz","swim = nadar",
                "swing = columpio","sword = espada","table = mesa","tag = etiqueta","tail = cola","tailor = sastre","take = llevar","tale = cuento","talk = hablar","tall = alto(a)","tangle = enredar","tank = tanque","tap = toque","task = tarea","taste = gusto","tea = te","teach = enseñar","teacher = maestra","team = equipo","tear(1) = rasgar",
                "tear(2) = lagrima","teaspoon = cucharita","tedious = tedioso(a)","telephone = teléfono","tell = contar","ten = diez","tender = blando(a)","tend = atender","tent = carpa","terrible = terrible","test = examen","than = que","thank = gracias","that = ese(a),(o)","their = su","then = entonces","there = allí",
                "they = ellos(as)","thick = grueso(a)","thief = ladrón","thimble = dedal","thin = delgado(a)","thing = cosa","think = pensar","this = este(a),(o)","thorns = espina","those = aquellos(as)","though = a pesar de","thread = hilo","throat = garganta","throne = trono","through = a través","throw = lanzar",
                "thunder = trueno","tickle = cosquillas","tidy = aseado(a)","tie(1) = atar","tie(2) = corbata","tiger = tigre","till = hasta","time = hora","tin = hojalata","tiny = pequeñito(a)","tip(1) = volcarse","tip(2) = punta","tire = neumático","tired = cansado(a)","title = titulo","toad = sapo","toast = tostada","today = hoy",
                "together = juntos","tomorrow = mañana","tongue = lengua","tonight = esta noche","too = también","tool = herramienta","tooth = diente","top(1) = lo(a) más alto(a)","top(2) = trompo","toss = lanzar","touch = tocar","tough = duro(a)","toward = hacia","towel = toalla","toy = juguete","track(1) = riel","track(2) = huella","trade = comercio",
                "traffic = trafico","train(1) = amaestrar","train(2) = tren","tramp(1) = pisar","tramp(2) = vago","trap = trampa","travel = viajar","tray = bandeja","treat = tratar","tree = árbol","trial = prueba","tricycle = triciclo","trim = recortar","trip(1) = viaje","trip(2) = tropezar","trouble = problema","trousers = pantalones","truck = camión",
                "true = verdadero(a)","trunk(1) = tronco","trunk(2) = baúl","trunk(3) = trompa","trust = confiar","try = tratar","tube = tubo","tulip = tulipán","turkey = pavo","turn = dar vuelta","turtle = tortuga","tusk = colmillo","twin = mellizos","twinkle = centellear","twist = enrollar","ugly = feo(a)","umbrella = paraguas","uncertain = inseguro(a)","uncle = tío","under = debajo","uneasy = incomodo(a)","unhappy = infeliz","unkind = malo(a)","unless = a no ser que","untie = desatar","upon = sobre","use = usar","useful = útil","vacant = desocupado(a)","vacation = vacaciones","valley = valle","value = valor","vase = jarrón","vegetable = vegetal","verse = verso","very = muy","view = vista","village = aldea","vine = plantas trepadoras","violin = violín","visit = visitar","voice = voz","vote = votar","wag = menear","wagon = vagón","wait = esperar","wake = despertar","walk = caminar","wall = pared","want = querer","warm = tibio(a)","warn = advertir","wash = lavar","waste = malgastar","watch(1) = cuidar","watch(2) = reloj","water(1) = agua","water(2) = regar","wave = ola","way = camino","weak = débil",
                "wear = usar","weary = fatigado(a)","weather = tiempo","weed = mala hierba","week = semana","weep = sollozar","weigh = pesar","wet = mojado(a)","whale = ballena","what = que","wheel = rueda","when = cuando","which = cual","while = mientras","whip = azotar","whistle(1) = silbar","whistle(2) = pito","who = quien",
                "whole = entero(a)","whose = de quien","why = por qué","wide = ancho(a)","wild = salvaje","win = ganar","wind = viento","windmill = molino de viento","window = ventana","wing = ala","winsome = atractivo(a)","winter = invierno","wipe = secar","wire = alambre","wise = sabio","wish = deseo",
                "witch = bruja","with = con","witness = testigo","wolf = lobo","woman = mujer","wood = madera","woods = bosque","wool = lana","word = palabra","work = trabajar","world = mundo","worm = gusano","worry = preocuparse","worse = peor","worth = valer","wrap = envolver","wring = exprimir","write = escribir","wrong = mal","x-ray = rayos X","xylophone = xilofono","yard = patio","yarn = estambre","yawn = bostezar","year = año","yell = gritar","yellow = amarillo","yes = si","yet = todavía","you = tú","young = joven","your = tu","zebra = cebra","zero = cero","zone = zona","zoo = zoológico"};



        listItems=new ArrayList<>(Arrays.asList(items));
        adapter=new ArrayAdapter<String>(this,
                R.layout.item_list_todo, listItems);
        listView.setAdapter(adapter);

        //prueba

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                view.setSelected(true);

            }
    });


}
}

