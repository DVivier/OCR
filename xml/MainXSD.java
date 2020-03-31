package OCR.xml;
import java.io.File;
import java.io.IOException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.w3c.dom.*;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class MainXSD {
    public static void main(String[] args) throws IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//        factory.setIgnoringElementContentWhitespace(true);
        try {

            //Ces trois lignes servent à informer que la validation se fait via un fichier XSD
            SchemaFactory sfactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            //On créé notre schéma XSD
            //Ici, c'est un schéma interne, pour un schéma externe il faut mettre l'URI
            Schema schema = sfactory.newSchema(new File("src/OCR/xml/galerieart.xsd"));
            //On l'affecte à notre factory afin que le document prenne en compte le fichier XSD
            factory.setSchema(schema);

            DocumentBuilder builder = factory.newDocumentBuilder();

            //création de notre objet d'erreurs
            ErrorHandler errHandler = new SimpleErrorHandler();
            //Affectation de notre objet au document pour interception des erreurs éventuelles
            builder.setErrorHandler(errHandler);
            File fileXML = new File("src/OCR/xml/galerieart.xml");

            //On rajoute un bloc de capture
            //pour intercepter les erreurs au cas où il y en ait
            try {
                Document xml = builder.parse(fileXML);
                Element root = xml.getDocumentElement();
                System.out.println(root.getNodeName());
                System.out.println(description(root, ""));
            } catch (SAXParseException e) {}

        } catch (ParserConfigurationException | SAXException e) {
            e.printStackTrace();
        }
    }

    /**
     * Méthode qui va parser le contenu d'un nœud
     * @param n
     * @param tab
     * @return
     */
    public static String description(Node n, String tab){
        String str = new String();
        //Nous nous assurons que le nœud passé en paramètre est une instance d'Element
        //juste au cas où il s'agisse d'un texte ou d'un espace, etc.
        if(n instanceof Element){

            //Nous sommes donc bien sur un élément de notre document
            //Nous castons l'objet de type Node en type Element
            Element element = (Element)n;

            //Nous pouvons récupérer le nom du nœud actuellement parcouru
            //grâce à cette méthode, nous ouvrons donc notre balise
            str += "<" + n.getNodeName();

            //nous contrôlons la liste des attributs présents
            if(n.getAttributes() != null && n.getAttributes().getLength() > 0){

                //nous pouvons récupérer la liste des attributs d'un élément
                NamedNodeMap att = n.getAttributes();
                int nbAtt = att.getLength();

                //nous parcourons tous les nœuds pour les afficher
                for(int j = 0; j < nbAtt; j++){
                    Node noeud = att.item(j);
                    //On récupère le nom de l'attribut et sa valeur grâce à ces deux méthodes
                    str += " " + noeud.getNodeName() + "=\"" + noeud.getNodeValue() + "\" ";
                }
            }

            //nous refermons notre balise car nous avons traité les différents attributs
            str += ">";

            //La méthode getChildNodes retournant le contenu du nœud + les nœuds enfants
            //Nous récupérons le contenu texte uniquement lorsqu'il n'y a que du texte, donc un seul enfant
            if(n.getChildNodes().getLength() == 1)
                str += n.getTextContent();
//            System.out.println(n.getNodeName());
//            System.out.println(" " + n.getChildNodes().getLength() + " fils");
//            System.out.println(" first " + n.getFirstChild().getNodeName());
//            System.out.println(" last  " + n.getLastChild().getNodeName());
            //Nous allons maintenant traiter les nœuds enfants du nœud en cours de traitement
            int nbChild = n.getChildNodes().getLength();
            //Nous récupérons la liste des nœuds enfants
            NodeList list = n.getChildNodes();
//            System.out.println("list = " + list);
            System.out.println("list.getLength() = " + list.getLength());
            for (int z = 0; z < nbChild; z++) {
                System.out.println(list.item(z).getNodeName());
            }
            String tab2 = tab + "\t";

            //nous parcourons la liste des nœuds
            for(int i = 0; i < nbChild; i++){
                Node n2 = list.item(i);
//                System.out.println("  " + n2.getNodeName());
                //si le nœud enfant est un Element, nous le traitons
                if (n2 instanceof Element){
                    //appel récursif à la méthode pour le traitement du nœud et de ses enfants
                    str += "\n " + tab2 + description(n2, tab2);
                }
            }

            //Nous fermons maintenant la balise
            if(n.getChildNodes().getLength() < 2)
                str += "</" + n.getNodeName() + ">";
            else
                str += "\n" + tab +"</" + n.getNodeName() + ">";
        }

        return str;
    }
}
