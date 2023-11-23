import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;

public class CatalogoDiscosDS {
    private static GeneradorAlbumes generadorAlbumes;
    public static void main(String[] args) throws Exception {
        try{
            generadorAlbumes=new GeneradorAlbumes();
            insertarAlbumes();
            generadorAlbumes.guardarDocumento(".\\bin\\discos.xml");
        }catch(ParserConfigurationException e){
            e.printStackTrace();
        }
    }

    private static void insertarAlbumes(){
        //crear los 25 albumes y añadirlos a la raiz
        ArrayList<String>canciones = new ArrayList<>();
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
        generadorAlbumes.añadirAlbum(
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
        generadorAlbumes.añadirAlbum(
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
        generadorAlbumes.añadirAlbum(
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
        generadorAlbumes.añadirAlbum(
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
        generadorAlbumes.añadirAlbum(
            "Led Zeppelin IV",
            "Led Zeppelin",
            "1971",
            "11",
            "08",
            "Rock",
            canciones
        );
        canciones.clear();

    }

    private static Document crearDocumento () throws ParserConfigurationException{
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db;
        Document doc;
        db = dbf.newDocumentBuilder();
        doc=db.newDocument();
        return doc;
    }
}