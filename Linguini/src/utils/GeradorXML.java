package utils;

import dao.GeradorLog;
import dao.MensagemRetorno;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.StringWriter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import model.Produto;

/**
 * @author guilherme-souza
 * @param <T>
 */
public class GeradorXML<T> {
    
    public static final String FOLDER = "xml-files";
    
    public static void main(String[] args) throws FileNotFoundException {
        Produto p = new Produto();
        p.setId((long) 1);
        p.setDescricao("Ovo de galinha");
        p.setQuantidade(60);
        p.setSituacao(true);
        GeradorXML geradorXML = new GeradorXML();
        geradorXML.gerar(p, p.getDescricao()+"-"+p.getId());
    }
    
    private MensagemRetorno gerar(T Objeto, String nomeArquivo) throws FileNotFoundException {
        MensagemRetorno msg = new MensagemRetorno();
        
        try {
            JAXBContext context = JAXBContext.newInstance(Objeto.getClass());
            Marshaller m = context.createMarshaller();

            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE); // To format XML

            StringWriter sw = new StringWriter();
            m.marshal(Objeto, new FileOutputStream(GeradorXML.FOLDER+"/"+nomeArquivo));

        } catch (FileNotFoundException | JAXBException e) {
            new GeradorLog(e);
            e.printStackTrace();
        }
        
        return msg;
    }
}
