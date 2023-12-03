import java.util.ArrayList;
import javax.xml.parsers.ParserConfigurationException;

/**
 * @author Dante Sarotti
 */
public class CatalogoDiscosDS {
    public static void main(String[] args) throws Exception {
        AlbumesXML albumes;
        try{
            albumes=new AlbumesXML();

            //Llena la lista con 25 discos
            insertarAlbumes(albumes);

            //Listar los nombres de album y sus canciones.
            albumes.listarAlbumes();

            //Guardar documento en disco
            albumes.guardarDocumento(".\\bin\\discos.xml");

            //Imprimir con pretty print
            albumes.imprimirConPrettyPrint();

        }catch (ParserConfigurationException e){
            System.out.println("Hubo un error al inicializar el album");
            e.printStackTrace();
        }
    }

    /**
     * Añade los 25 albumes al obeto GeneradorAlbumes
     * @param albumes El objeto que gestiona el documento xml al que añadir los albumes
     */
    private static void insertarAlbumes(AlbumesXML albumes){
        ArrayList<String>canciones = new ArrayList<>();

        //crear los 25 albumes y añadirlos a la raiz
    
        canciones.add("Death on Two Legs (Dedicated to...)");
        canciones.add("Lazing on a Sunday Afternoon");
        canciones.add("I'm in Love with My Car");
        canciones.add("You're My Best Friend");
        canciones.add("'39");
        canciones.add("Sweet Lady");
        canciones.add("Seaside Rendezvous");
        canciones.add("The Prophet's Song");
        canciones.add("Love of My Life");
        canciones.add("Good Company");
        canciones.add("Bohemian Rhapsody");
        canciones.add("God Save the Queen");
        albumes.añadirAlbum(
            "A night at the opera",
            "Queen",
            "1975",
            "11",
            "21",
            "Rock",
            canciones);
        canciones.clear();

        canciones.add("Speak to Me");
        canciones.add("Breathe");
        canciones.add("On the Run");
        canciones.add("Time");
        canciones.add("The Great Gig in the Sky");
        canciones.add("Money");
        canciones.add("Us and Them");
        canciones.add("Any Colour You Like");
        canciones.add("Brain Damage");
        canciones.add("Eclipse");
        albumes.añadirAlbum(
            "The Dark Side of the Moon",
            "Pink Floyd",
            "1973",
            "03",
            "01",
            "Rock Progresivo",
            canciones
        );
        canciones.clear();

        canciones.add("Second Hand News");
        canciones.add("Dreams");
        canciones.add("Never Going Back Again");
        canciones.add("Don't Stop");
        canciones.add("Go Your Own Way");
        canciones.add("Songbird");
        canciones.add("The Chain");
        canciones.add("You Make Loving Fun");
        canciones.add("I Don't Want to Know");
        canciones.add("Oh Daddy");
        canciones.add("Gold Dust Woman");
        albumes.añadirAlbum(
            "Rumours",
            "Fleetwood Mac",
            "1977",
            "02",
            "04",
            "Rock",
            canciones
        );
        canciones.clear();

        canciones.add("Imagine");
        canciones.add("Crippled Inside");
        canciones.add("Jealous Guy");
        canciones.add("It's So Hard");
        canciones.add("Give Me Some Truth");
        canciones.add("Oh My Love");
        canciones.add("How Do You Sleep?");
        canciones.add("How?");
        canciones.add("Oh Yoko!");
        albumes.añadirAlbum(
            "Imagine",
            "John Lennon",
            "1971",
            "09",
            "09",
            "Rock",
            canciones
        );
        canciones.clear();

        canciones.add("Stairway to Heaven");
        canciones.add("Black Dog");
        canciones.add("Rock and Roll");
        canciones.add("The Battle of Evermore");
        canciones.add("Misty Mountain Hop");
        canciones.add("Four Sticks");
        canciones.add("Going to California");
        canciones.add("When the Levee Breaks");
        albumes.añadirAlbum(
            "Led Zeppelin IV",
            "Led Zeppelin",
            "1971",
            "11",
            "08",
            "Rock",
            canciones
        );
        canciones.clear();

        canciones.add("Bohemian Rhapsody");
        canciones.add("Another One Bites the Dust");
        canciones.add("Somebody to Love");
        canciones.add("Don't Stop Me Now");
        canciones.add("Crazy Little Thing Called Love");
        canciones.add("Under Pressure");
        canciones.add("We Will Rock You");
        canciones.add("Radio Ga Ga");
        canciones.add("I Want to Break Free");
        albumes.añadirAlbum(
            "Greatest Hits",
            "Queen",
            "1981",
            "10",
            "26",
            "Rock",
            canciones
        );
        canciones.clear();

        canciones.add("Hotel California");
        canciones.add("New Kid in Town");
        canciones.add("Life in the Fast Lane");
        canciones.add("Wasted Time");
        canciones.add("Victim of Love");
        canciones.add("Pretty Maids All in a Row");
        canciones.add("Try and Love Again");
        canciones.add("The Last Resort");
        albumes.añadirAlbum(
            "Hotel California",
            "Eagles",
            "1976",
            "12",
            "08",
            "Rock",
            canciones
        );
        canciones.clear();

        canciones.add("Like a Rolling Stone");
        canciones.add("Tombstone Blues");
        canciones.add("It Takes a Lot to Laugh, It Takes a Train to Cry");
        canciones.add("From a Buick 6");
        canciones.add("Ballad of a Thin Man");
        canciones.add("Queen Jane Approximately");
        canciones.add("Highway 61 Revisited");
        canciones.add("Just Like Tom Thumb's Blues");
        canciones.add("Desolation Row");

        albumes.añadirAlbum(
            "Highway 61 Revisited",
            "Bob Dylan",
            "1965",
            "08",
            "30",
            "Folk Rock",
            canciones
        );

        canciones.clear();
        canciones.add("Billie Jean");
        canciones.add("Beat It");
        canciones.add("Wanna Be Startin' Somethin'");
        canciones.add("Human Nature");
        canciones.add("Thriller");
        canciones.add("P.Y.T. (Pretty Young Thing)");
        canciones.add("The Girl Is Mine");
        canciones.add("Billy Jean (Demo Version)");

        albumes.añadirAlbum(
            "Thriller",
            "Michael Jackson",
            "1982",
            "11",
            "30",
            "Pop",
            canciones
        );
        canciones.clear();

        canciones.add("Superstition");
        canciones.add("You Haven't Done Nothin'");
        canciones.add("Living for the City");
        canciones.add("Signed, Sealed, Delivered I'm Yours");
        canciones.add("Higher Ground");
        canciones.add("I Wish");
        canciones.add("Sir Duke");
        canciones.add("I Just Called to Say I Love You");
        
        albumes.añadirAlbum(
            "Songs in the Key of Life",
            "Stevie Wonder",
            "1976",
            "09",
            "28",
            "Soul",
            canciones
        );
        canciones.clear();

        canciones.add("Purple Haze");
        canciones.add("Manic Depression");
        canciones.add("Hey Joe");
        canciones.add("Love or Confusion");
        canciones.add("May This Be Love");
        canciones.add("I Don't Live Today");
        canciones.add("The Wind Cries Mary");
        canciones.add("Fire");
        canciones.add("Third Stone from the Sun");
        
        albumes.añadirAlbum(
            "Are You Experienced",
            "The Jimi Hendrix Experience",
            "1967",
            "05",
            "12",
            "Rock Psicodélico",
            canciones
        );
        canciones.clear();

        canciones.add("Baba O'Riley");
        canciones.add("Bargain");
        canciones.add("Love Ain't for Keeping");
        canciones.add("My Wife");
        canciones.add("The Song Is Over");
        canciones.add("Getting in Tune");
        canciones.add("Going Mobile");
        canciones.add("Behind Blue Eyes");
        
        albumes.añadirAlbum(
            "Who's Next",
            "The Who",
            "1971",
            "08",
            "14",
            "Rock",
            canciones
        );

        canciones.clear();

        canciones.add("Ramble On");
        canciones.add("Thank You");
        canciones.add("Heartbreaker");
        canciones.add("Living Loving Maid (She's Just a Woman)");
        canciones.add("Moby Dick");
        canciones.add("Bring It On Home");
        
        albumes.añadirAlbum(
            "Led Zeppelin II",
            "Led Zeppelin",
            "1969",
            "10",
            "22",
            "Rock",
            canciones
        );
        canciones.clear();

        canciones.add("Sympathy for the Devil");
        canciones.add("No Expectations");
        canciones.add("Dear Doctor");
        canciones.add("Parachute Woman");
        canciones.add("Jig-Saw Puzzle");
        canciones.add("Street Fighting Man");
        canciones.add("Prodigal Son");
        canciones.add("Stray Cat Blues");
        canciones.add("Factory Girl");
        
        albumes.añadirAlbum(
            "Beggars Banquet",
            "The Rolling Stones",
            "1968",
            "12",
            "06",
            "Rock",
            canciones
        );
        canciones.clear();

        canciones.add("Give Life Back to Music");
        canciones.add("The Game of Love");
        canciones.add("Giorgio by Moroder");
        canciones.add("Within");
        canciones.add("Instant Crush");
        canciones.add("Lose Yourself to Dance");
        canciones.add("Touch");
        canciones.add("Get Lucky");
        canciones.add("Beyond");
        canciones.add("Motherboard");
        canciones.add("Fragments of Time");
        canciones.add("Doin' It Right");
        canciones.add("Contact");
        
        albumes.añadirAlbum(
            "Random Access Memories",
            "Daft Punk",
            "2013",
            "05",
            "17",
            "Electrónica",
            canciones
        );
        canciones.clear();

        canciones.add("Wesley's Theory");
        canciones.add("For Free? (Interlude)");
        canciones.add("King Kunta");
        canciones.add("Institutionalized");
        canciones.add("These Walls");
        canciones.add("u");
        canciones.add("Alright");
        canciones.add("For Sale? (Interlude)");
        canciones.add("Momma");
        canciones.add("Hood Politics");
        canciones.add("How Much a Dollar Cost");
        canciones.add("Complexion (A Zulu Love)");
        canciones.add("The Blacker the Berry");
        canciones.add("i");
        canciones.add("Mortal Man");
        
        albumes.añadirAlbum(
            "To Pimp a Butterfly",
            "Kendrick Lamar",
            "2015",
            "03",
            "16",
            "Hip-Hop",
            canciones
        );
        canciones.clear();

        canciones.add("Welcome to New York");
        canciones.add("Blank Space");
        canciones.add("Style");
        canciones.add("Out of the Woods");
        canciones.add("All You Had to Do Was Stay");
        canciones.add("Shake It Off");
        canciones.add("I Wish You Would");
        canciones.add("Bad Blood");
        canciones.add("Wildest Dreams");
        canciones.add("How You Get the Girl");
        canciones.add("This Love");
        canciones.add("I Know Places");
        canciones.add("Clean");
        
        albumes.añadirAlbum(
            "1989",
            "Taylor Swift",
            "2014",
            "10",
            "27",
            "Pop",
            canciones
        );
        canciones.clear();

        canciones.add("Spring: Allegro");
        canciones.add("Spring: Largo e pianissimo sempre");
        canciones.add("Spring: Danza pastorale. Allegro");
        canciones.add("Summer: Allegro non molto");
        canciones.add("Summer: Adagio e piano - Presto e forte");
        canciones.add("Summer: Presto");
        canciones.add("Autumn: Allegro");
        canciones.add("Autumn: Adagio molto");
        canciones.add("Autumn: Allegro");
        canciones.add("Winter: Allegro non molto");
        canciones.add("Winter: Largo");
        canciones.add("Winter: Allegro");
        
        albumes.añadirAlbum(
            "The Four Seasons",
            "Antonio Vivaldi",
            "1725",
            "N/A",
            "N/A",
            "Música Clásica",
            canciones
        );
        canciones.clear();

        canciones.add("Flume");
        canciones.add("Lump Sum");
        canciones.add("Skinny Love");
        canciones.add("The Wolves (Act I and II)");
        canciones.add("Blindsided");
        canciones.add("Creature Fear");
        canciones.add("Team");
        canciones.add("For Emma");
        canciones.add("Re: Stacks");
        
        albumes.añadirAlbum(
            "For Emma, Forever Ago",
            "Bon Iver",
            "2007",
            "07",
            "08",
            "Indie",
            canciones
        );
        canciones.clear();

        canciones.add("Slow Burn");
        canciones.add("Lonely Weekend");
        canciones.add("Butterflies");
        canciones.add("Oh, What a World");
        canciones.add("Mother");
        canciones.add("Love Is a Wild Thing");
        canciones.add("Space Cowboy");
        canciones.add("Happy & Sad");
        canciones.add("Velvet Elvis");
        canciones.add("Wonder Woman");
        canciones.add("High Horse");
        canciones.add("Golden Hour");
        canciones.add("Rainbow");
        
        albumes.añadirAlbum(
            "Golden Hour",
            "Kacey Musgraves",
            "2018",
            "03",
            "30",
            "Country",
            canciones
        );
        canciones.clear();

        canciones.add("So What");
        canciones.add("Freddie Freeloader");
        canciones.add("Blue in Green");
        canciones.add("All Blues");
        canciones.add("Flamenco Sketches");
        
        albumes.añadirAlbum(
            "Kind of Blue",
            "Miles Davis",
            "1959",
            "08",
            "17",
            "Jazz",
            canciones
        );
        canciones.clear();

        canciones.add("Chan Chan");
        canciones.add("De Camino a La Vereda");
        canciones.add("El Cuarto de Tula");
        canciones.add("Pueblo Nuevo");
        canciones.add("Dos Gardenias");
        canciones.add("¿Y Tú Qué Has Hecho?");
        canciones.add("Veinte Años");
        canciones.add("El Carretero");
        canciones.add("Candela");
        canciones.add("Amor de Loca Juventud");
        canciones.add("Orgullecida");
        canciones.add("Murmullo");
        
        albumes.añadirAlbum(
            "Buena Vista Social Club",
            "Buena Vista Social Club",
            "1997",
            "09",
            "16",
            "Música Latina",
            canciones
        );
        canciones.clear();

        canciones.add("Start");
        canciones.add("Thinkin Bout You");
        canciones.add("Fertilizer");
        canciones.add("Sierra Leone");
        canciones.add("Sweet Life");
        canciones.add("Not Just Money");
        canciones.add("Super Rich Kids");
        canciones.add("Pilot Jones");
        canciones.add("Crack Rock");
        canciones.add("Pyramids");
        canciones.add("Lost");
        canciones.add("White");
        canciones.add("Monks");
        canciones.add("Bad Religion");
        canciones.add("Pink Matter");
        canciones.add("Forrest Gump");
        canciones.add("End");
        
        albumes.añadirAlbum(
            "Channel Orange",
            "Frank Ocean",
            "2012",
            "07",
            "10",
            "R&B",
            canciones
        );
        canciones.clear();

        canciones.add("Genesis");
        canciones.add("Let There Be Light");
        canciones.add("D.A.N.C.E.");
        canciones.add("Newjack");
        canciones.add("Phantom");
        canciones.add("Phantom Pt. II");
        canciones.add("Valentine");
        canciones.add("TTHHEE PPAARRTTYY");
        canciones.add("DVNO");
        canciones.add("Stress");
        canciones.add("Waters of Nazareth");
        canciones.add("One Minute to Midnight");
        
        albumes.añadirAlbum(
            "Cross",
            "Justice",
            "2007",
            "06",
            "11",
            "Electrónica",
            canciones
        );
        canciones.clear();

        canciones.add("The Suburbs");
        canciones.add("Ready to Start");
        canciones.add("Modern Man");
        canciones.add("Rococo");
        canciones.add("Empty Room");
        canciones.add("City with No Children");
        canciones.add("Half Light I");
        canciones.add("Half Light II (No Celebration)");
        canciones.add("Suburban War");
        canciones.add("Month of May");
        canciones.add("Wasted Hours");
        canciones.add("Deep Blue");
        canciones.add("We Used to Wait");
        canciones.add("Sprawl I (Flatland)");
        canciones.add("Sprawl II (Mountains Beyond Mountains)");
        canciones.add("The Suburbs (Continued)");
        
        albumes.añadirAlbum(
            "The Suburbs",
            "Arcade Fire",
            "2010",
            "08",
            "02",
            "Alternativa",
            canciones
        );

    }
}