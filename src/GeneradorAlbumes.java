import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
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

    /**
     * Añade un album al documento
     * @param tituloAlbum
     * @param nombreGrupo
     * @param anho
     * @param mes
     * @param dia
     * @param genero
     * @param canciones Una lista con las canciones de este album
     */
    public void añadirAlbum(String tituloAlbum,String nombreGrupo,String anho, String mes, String dia, String genero, ArrayList<String> canciones){
        
        //Album
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
            //año
        Element anhoElement = doc.createElement("anho");
        anhoElement.setTextContent(anho);
        fecha.appendChild(anhoElement);
            //mes
        Element mesElement = doc.createElement("mes");
        mesElement.setTextContent(mes);
        fecha.appendChild(mesElement);
            //dia
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
    
    /**
     * Guarda el documento de ligado a este objeto en disco
     * @param ruta La ruta donde se debe guardar el documento, incluido el nombre del documento.
     */
    public void guardarDocumento(String ruta){
        try {
            //Si el directorio de la ruta no existe, lo crea.
            File archivoAGuardar = new File(ruta);
            File directorioPadre = archivoAGuardar.getParentFile();
            if (directorioPadre!=null &&!directorioPadre.exists()){
                directorioPadre.mkdirs();
            }

            Transformer tf = TransformerFactory.newInstance().newTransformer();
            Result output = new StreamResult(archivoAGuardar);
            Source input = new DOMSource(doc);
            tf.transform(input, output);
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        } catch (TransformerFactoryConfigurationError e) {
            e.printStackTrace();
        }
    }

    public Document getDoc() {
        return doc;
    }


    /**
     * Muestra por la salida estandar el contenido del documento XML de una forma facil de leer
     */
    public void imprimirConPrettyPrint(){
        Transformer transformer = null;
        StreamResult resultadoXML = null;

        try {
            transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

            resultadoXML = new StreamResult(new StringWriter());

            transformer.transform(new DOMSource(doc), resultadoXML);
            System.out.println(resultadoXML.getWriter().toString());
            
        }catch (TransformerFactoryConfigurationError | TransformerException e){
            System.out.println("Error al mostrar el xml");
            e.printStackTrace();
        }
    }

}