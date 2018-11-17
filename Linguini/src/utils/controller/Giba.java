package utils.controller;

import utils.controller.Sessao;
import controller.TelaController;
import javax.swing.JButton;
import javax.swing.JDialog;
import model.Grupo;
import model.Permissao;
import model.PermissaoBotao;
import model.Telas;

/**
 * @author guilherme-souza
 */
public class Giba {        
    
    private static boolean bloquearTela(Grupo grupo, Telas tela, JDialog dialog){
        boolean bloqueio = false;
        for (Permissao permissao : grupo.getPermissaoList()) {
            if(permissao.getTelasId().getId() == tela.getId()){
                if(!permissao.getVisivel()) {
                    bloqueio = true;
                    break;
                }
            }
        } 
        return bloqueio;
    }
    
    private static void bloquearBotoes(Grupo grupo, Telas tela, JDialog dialog){
        //Para cada botao da Dialog
        for (JButton button : LeitorTela.leitorBotoes(dialog)) {   
            //Procure as permissoes de botao
            for (PermissaoBotao permissaoBotao : grupo.getPermissaoBotaoList()) {
                //Se forem da mesma tela
                if(permissaoBotao.getBotoesId().getTelasId().getId() == tela.getId()){
                    //E do mesmo botao
                    if(permissaoBotao.getBotoesId().getNome().equals(button.getName())){
                        //E estiver bloqueado
                        if(!permissaoBotao.getVisivel()) {
                            System.out.println("blockButton");
                            button.setEnabled(false);
                            break;
                        }
                    }
                }
            } 
            
        }        
    }
    
    public static boolean bloquear(String nomeTela, JDialog dialog){
        Telas tela = (Telas) new TelaController().consultarPorNome(nomeTela).getObjeto();
        Grupo grupo = Sessao.getUsuario().getGrupoId();
        
        System.out.println(tela.getTela());
        System.out.println(grupo.getNome());

        boolean gibaBloqueou = Giba.bloquearTela(grupo, tela, dialog);
        if(!gibaBloqueou) {
            Giba.bloquearBotoes(grupo, tela, dialog);
        }
        return gibaBloqueou;
    }
}
