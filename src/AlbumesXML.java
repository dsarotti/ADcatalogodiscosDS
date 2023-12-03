import java.io.File;
import java.io.StringWriter;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Clase que guarda un documento html y métodos para añadir albumes musicales con su información y lista de canciones.
 * @author Dante Sarotti
 */
class AlbumesXML {
    //Documento a tratar por esta clase
    private Document doc;

    //última id registrada en la lista de albumes. se incrementa cada vez que se inserta un nuevo album.
    private int id=0;

    /**
     * Constructor para esta clase. Crea el documento asociado y lo inicializa con el nodo padre "discos"
     * @throws ParserConfigurationException Si hay un error al crear el documento.
     */
    public AlbumesXML() throws ParserConfigurationException{
            doc=crearDocumento();
            Element discos = doc.createElement("discos");
            doc.appendChild(discos);
    }

    /**
     * Crea el documento xml de esta clase y lo devuelve.
     * @return El documento creado.
     * @throws ParserConfigurationException si hay un error al crear el DocumentBuilder
     */ 
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
    public void añadirAlbum(String tituloAlbum, String nombreGrupo, String anho, String mes, String dia, String genero, ArrayList<String> canciones){
        
        //Album
        Element album = doc.createElement("album");
        album.setAttribute("ID",String.valueOf(id));

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

        // si nada ha fallado, incrementa el id para el siguiente album que se inserte.
        id++;
    }
    
    /**
     * Guarda el documento de ligado a este objeto en disco
     * @param ruta La ruta donde se debe guardar el documento, incluido el nombre del documento.
     */
    public void guardarDocumento(String ruta){
        File archivoAGuardar = new File(ruta);
        File directorioPadre = archivoAGuardar.getParentFile();

        StreamResult output = new StreamResult(archivoAGuardar);
        Source input = new DOMSource(doc);
        
        try {
            //Si el directorio de la ruta no existe, lo crea.
            if (directorioPadre!=null &&!directorioPadre.exists()){
                directorioPadre.mkdirs();
            }
            Transformer tf = TransformerFactory.newInstance().newTransformer();
            tf.transform(input, output);
        } catch (TransformerException|TransformerFactoryConfigurationError e) {
            System.out.println("Error al guardar el documento en disco");
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

    /**
     * Lista los albumes y sus canciones con el siguiente formato: 
     * ==Álbum (número)==
     * -Canción 1
     * -Canción 2
     * ...
     * 
     */
    public void listarAlbumes(){
        NodeList listaAlbumes = doc.getElementsByTagName("album");

        for(int i = 0;i<listaAlbumes.getLength();i++){
            Node album = listaAlbumes.item(i);
            NodeList canciones = album.getLastChild().getChildNodes();
            System.out.println("=="+ album.getFirstChild().getTextContent() +"("+ (canciones.getLength())  +")==");
            for (int j = 0; j< canciones.getLength();j++){
                System.out.print(("- " + canciones.item(j).getTextContent()).indent(3));
            }
        }
    }

}