import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

class GeneradorAlbumes {
    private Document doc;
    private int id=0;

    public GeneradorAlbumes() throws ParserConfigurationException{
            doc=crearDocumento();
            Element discos = doc.createElement("discos");
            doc.appendChild(discos);
    }

    private static Document crearDocumento () throws ParserConfigurationException{
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db;
        Document doc;
        db = dbf.newDocumentBuilder();
        doc=db.newDocument();
        return doc;
    }

    public void añadirAlbum(String tituloAlbum,String nombreGrupo,String anho, String mes, String dia, String genero, ArrayList<String> canciones){
        Element album = doc.createElement("album");
        album.setAttribute("id",String.valueOf(id++));
        //titulo
        Element titulo = doc.createElement("titulo");
        titulo.setTextContent(tituloAlbum);
        album.appendChild(titulo);
        //grupo
        Element grupoElement = doc.createElement("grupo");
        grupoElement.setTextContent(nombreGrupo);
        album.appendChild(grupoElement);
        //fecha
        Element fecha = doc.createElement("fecha");
        Element anhoElement = doc.createElement("anho");
        anhoElement.setTextContent(anho);
        fecha.appendChild(anhoElement);
        Element mesElement = doc.createElement("mes");
        mesElement.setTextContent(mes);
        fecha.appendChild(mesElement);
        Element diaElement = doc.createElement("dia");
        diaElement.setTextContent(dia);
        fecha.appendChild(diaElement);
        album.appendChild(fecha);
        //genero
        Element generoElement = doc.createElement("genero");
        generoElement.setTextContent(genero);
        album.appendChild(generoElement);
        //canciones
        Element cancionesElement = doc.createElement("canciones");
        for (String cancion : canciones) {
            Element cancionElement = doc.createElement("cancion");
            cancionElement.appendChild(doc.createTextNode(cancion));
            cancionesElement.appendChild(cancionElement);
        }
        album.appendChild(cancionesElement);

        //añadir este album a la lista de discos
        doc.getDocumentElement().appendChild(album);
    }
    
    public void guardarDocumento(String ruta){
        try {
            Transformer tf = TransformerFactory.newInstance().newTransformer();
            Result output = new StreamResult(new File(ruta));
            Source input = new DOMSource(doc);
            tf.transform(input, output);

        } catch (TransformerConfigurationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (TransformerFactoryConfigurationError e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (TransformerException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public Document getDoc() {
        return doc;
    }
}