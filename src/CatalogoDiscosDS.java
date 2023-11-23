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
            "1",
            "A night at the opera",
            "Queen",
            "1975",
            "11",
            "21",
            "Rock",
            canciones);
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