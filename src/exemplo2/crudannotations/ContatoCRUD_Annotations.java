/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exemplo2.crudannotations;

import exemplo2.conexao.HibernateUtil;
import java.sql.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.MappingException;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author saimor
 */
public class ContatoCRUD_Annotations {
    public void salvar(ContatoAnnotations contato){
        Session sessao = null;
        Transaction transacao = null;
        
        try{
            sessao = HibernateUtil.getSessionFactory().openSession();
            transacao = sessao.beginTransaction();
            sessao.save(contato);
            transacao.commit();
        } catch (HibernateException e){
            System.out.print("Não foi possivel inserir o contato. Erro: " + e.getMessage());
        } finally {
            try{
                sessao.close();
            } catch(Throwable e){
                System.out.println("Erro ao fechar operação de inserir. Erro: " + e.getMessage());
            }
        }
    }
    
    public void atualizar(ContatoAnnotations contato){
        Session sessao = null;
        Transaction transacao = null;
        
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            transacao = sessao.beginTransaction();
            sessao.update(contato);
            transacao.commit();
        } catch (HibernateException e) {
            System.out.println("Não foi possivel alterar o contato. Erro: " + e.getMessage());            
        } finally{
            try{
                sessao.close();
            } catch(Throwable e){
                System.out.println("Erro ao fechar operação de atualização. Mensagem: " + e.getMessage());
            }
        }
    }
    
    public void excluir(ContatoAnnotations contato){
        Session sessao = null;
        Transaction transacao = null;
        
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            transacao = sessao.beginTransaction();
            sessao.delete(contato);
            transacao.commit();
        } catch (HibernateException e) {
            System.out.println("Não foi possivel excluir o contato. Erro: " + e.getMessage());            
        } finally{
            try{
                sessao.close();
            } catch(Throwable e){
                System.out.println("Erro ao fechar operação de exclusão. Mensagem: " + e.getMessage());
            }
        }
    }
    
    public List<ContatoAnnotations> listar(){
        Session sessao = null;
        Transaction transacao = null;
        Criteria consulta = null;
        List<ContatoAnnotations> resultado = null;
        
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            transacao = sessao.beginTransaction();
            consulta = sessao.createCriteria(ContatoAnnotations.class);
            resultado = consulta.list();
            transacao.commit();
            return resultado;            
        } catch (HibernateException e){
            System.out.println("Não foi possivel selecionar contatos. Erro:" + e.getMessage());
        throw new HibernateException(e);
        } finally {
            try{
                sessao.close();
            } catch (Throwable e){
                System.err.println("Erro ao fechar operação de consulta. Erro:" + e.getMessage());
            }
        }
    }
    
    public ContatoAnnotations buscaContato(int valor){
        ContatoAnnotations contato = null;
        Session sessao = null;
        Transaction transacao = null;
        Criteria consulta = null;
        
        try{
            sessao = HibernateUtil.getSessionFactory().openSession();
            transacao = sessao.beginTransaction();
            consulta = sessao.createCriteria(ContatoAnnotations.class);
            consulta.add(Restrictions.eq("codigo", valor));
            contato = (ContatoAnnotations) consulta.uniqueResult();
            transacao.commit();
            return contato;
        } catch (HibernateException e){
            System.err.println("Não foi possivel buscar contato. Erro: " + e.getMessage());
        } finally {
            try{
                sessao.close();
            } catch (Throwable e){
                System.out.println("Erro ao fechar operação de buscar. Mensagem:" +e.getMessage());
            }
        }
        return contato;
    }
    
    public static void main(String[] args){
        ContatoCRUD_Annotations contatoCrudXML = new ContatoCRUD_Annotations();
        
        //ADICIOANR
        /*
        String[] nomes = {"Fulano", "Beltrano", "Ciclano"};
        String[] fones = {"(47) 2222-1111", "(47) 7777-5555", "(47) 9090-2525"};
        String[] emails = {"fulano@teste.com.br", "beltrano@teste.com.br", "ciclano@teste.com.br"};
        String[] observacoes = {"Novo cliente", "Cliente em dia", "Ligar na quinta"};
        ContatoAnnotations contato = null;
        
        for(int i = 0; i < nomes.length; i++){
            contato = new ContatoAnnotations();
            contato.setNome(nomes[i]);
            contato.setTelefone(fones[i]);
            contato.setEmail(emails[i]);
            contato.setDataCadastro(new Date(System.currentTimeMillis()));
            contato.setObservacao(observacoes[i]);
            contatoCrudXML.salvar(contato);
        }
        */
        
        //ATUALIZAR
        /*
        ContatoAnnotations contato = null;
         
        contato = new ContatoAnnotations();
            contato.setNome("Saimor");
            contato.setTelefone("5555-5555");
            contato.setEmail("saimor@gmail.com");
            contato.setDataCadastro(new Date(System.currentTimeMillis()));
            contato.setObservacao("teste");
            contato.setCodigo(22);
            contatoCrudXML.atualizar(contato);
        */    
        
        //APAGAR
        /*
        ContatoAnnotations contato = null;
         contato = new ContatoAnnotations();
        contato.setCodigo(23);
        contatoCrudXML.excluir(contato);
        */
        
        //LISTA TUDOS NA BD
        /*
        System.out.println("Registros: " + contatoCrudXML.listar());
        */
        
        //BUSCA
        ContatoAnnotations contato = contatoCrudXML.buscaContato(13);
        System.out.println("Contato " + contato.getNome());    
        System.out.println("Total de registros cadastrados: " + contatoCrudXML.listar().size());
    }
    
}
