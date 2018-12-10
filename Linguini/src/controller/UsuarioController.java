package controller;

import dao.MensagemRetorno;
import dao.UsuarioDAO;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import model.Grupo;
import model.Usuario;
import utils.controller.Criptografia;
import utils.controller.Sessao;

/**
 * @author guilherme-souza
 */
public class UsuarioController implements Controller<Usuario> {

    private UsuarioDAO usuarioDAO;
    private String tabela = "Usuario";

    public UsuarioController() {
        this.usuarioDAO = new UsuarioDAO();
    }

    public MensagemRetorno autenticar(Usuario usuario) {
        MensagemRetorno msg = this.usuarioDAO.consultarPorNome(usuario);

        if (msg.isSucesso() && msg.getObjeto() != null) {
            Usuario u = (Usuario) msg.getObjeto();
            if (Criptografia.equals(usuario.getSenha(), u.getSenha())) {
                msg.setObjeto(u);
                msg.setSucesso(true);
                msg.setMensagem("Sucesso!");
            } else {
                msg.setSucesso(false);
                msg.setMensagem("Usuário ou senha inválidos");
            }
        } else {
            msg.setSucesso(false);
            msg.setMensagem("Usuário ou senha inválidos");
        }
        return msg;
    }

    @Override
    public MensagemRetorno salvar(Usuario usuario) {
        return this.usuarioDAO.salvar(usuario);
    }

    @Override
    public MensagemRetorno excluir(Usuario usuario) {
        return this.usuarioDAO.excluir(usuario);
    }

    @Override
    public MensagemRetorno excluir(int id) {
        return this.usuarioDAO.excluir(id, this.tabela);
    }

    @Override
    public void popularTabela(JTable tabela, String criterio, String ordenacao) {
// dados da tabela
        Object[][] dadosTabela = null;

        // cabecalho da tabela
        String[] cabecalho = this.getCabecalho();

        // cria matriz de acordo com nº de registros da tabela
        try {
            MensagemRetorno ms = this.usuarioDAO.consultarAtivosComCriterio(this.tabela, this.getCamposPesquisaveis(), criterio, ordenacao);
            if (ms.isSucesso()) {
                dadosTabela = new Object[ms.getLista().size()][cabecalho.length];
            }
            dadosTabela = new Object[ms.getLista().size()][4];

        } catch (Exception e) {
            System.out.println("Erro ao consultar Fornecedor: " + e);
        }

        int lin = 0;

        // efetua consulta na tabela
        try {
            MensagemRetorno ms = this.usuarioDAO.consultarAtivosComCriterio(this.tabela, this.getCamposPesquisaveis(), criterio, ordenacao);

            for (Object o : ms.getLista()) {
                Usuario u = (Usuario) o;
                dadosTabela[lin][0] = u.getId();
                dadosTabela[lin][1] = u.getNome();
                lin++;
            }

            // caso a coluna precise exibir uma imagem
//                if (resultadoQ.getBoolean("Situacao")) {
//                    dadosTabela[lin][2] = new ImageIcon(getClass().getClassLoader().getResource("Interface/imagens/status_ativo.png"));
//                } else {
//                    dadosTabela[lin][2] = new ImageIcon(getClass().getClassLoader().getResource("Interface/imagens/status_inativo.png"));
//                }
        } catch (Exception e) {
            System.out.println("problemas para popular tabela Fornecedor...");
            System.out.println(e);
        }

        // configuracoes adicionais no componente tabela
        tabela.setModel(new DefaultTableModel(dadosTabela, cabecalho) {
            @Override
            // quando retorno for FALSE, a tabela nao é editavel
            public boolean isCellEditable(int row, int column) {
                return false;
            }

            // alteracao no metodo que determina a coluna em que o objeto ImageIcon devera aparecer
            @Override
            public Class
                    getColumnClass(int column) {

                if (column == 2) {
                    //return ImageIcon.class;
                }
                return Object.class;
            }
        });

        // permite seleção de apenas uma linha da tabela
        tabela.setSelectionMode(0);

        // redimensiona as colunas de uma tabela
        TableColumn column = null;
        for (int i = 0; i < tabela.getColumnCount(); i++) {
            column = tabela.getColumnModel().getColumn(i);
            switch (i) {
                case 0:
                    column.setPreferredWidth(17);
                    break;
                case 1:
                    column.setPreferredWidth(140);
                    break;
            }
        }
    }

    @Override
    public MensagemRetorno consultarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public MensagemRetorno consultarPorID(int id) {
        return usuarioDAO.consultarPorId(id, this.tabela);
    }

    private String[] getCabecalho() {
        String[] cabecalho = {"Código", "Usuário"};
        return cabecalho;
    }

    private String[] getCamposPesquisaveis() {
        String[] campos = {"CAST(id AS text)", "nome"};
        return campos;
    }

    @Override
    public List<CampoOrdenavel> getOrdenacao() {
        List campos = new ArrayList();
        campos.add(new CampoOrdenavel("ID", "id"));
        campos.add(new CampoOrdenavel("Usuário", "nome"));
        return campos;
    }
    
    public boolean grupoCozinha(){
        MensagemRetorno msg = new GrupoController().consultarPorNome("Cozinha");
        if(msg.isSucesso()){
            Grupo g = (Grupo) msg.getObjeto();
            if(g != null) {
                return Objects.equals(Sessao.getUsuario().getGrupoId().getId(), g.getId());            
            }
        }
        return false;
    } 
}
