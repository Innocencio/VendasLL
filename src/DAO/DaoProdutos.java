/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import conexoes.ConexaoMySql;
import model.ModelProdutos;

/**
 *
 * @author Jeffrey
 */
public class DaoProdutos extends ConexaoMySql {
/**
 * Cadastrar um produto no banco
 * @param pModelProdutos
 * @return 
 */

    public int salvarProdutosDAO(ModelProdutos pModelProdutos) {
        try {
            this.conectar();
            return this.insertSQL("INSERT INTO t_produto ("
                    + "pro_nome,"
                    + "pro_valor"
                    + "pro_estoque"
                    + ") VALUES ("
                    + "'" + pModelProdutos.getProNome() + "',"
                    + "'" + pModelProdutos.getProValor() + "',"
                    + "'" + pModelProdutos.getProEstoque() + "',"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            this.fecharConexao();
        }
    }
    /**
     * Excluir um produto do banco
     * @param pIdProduto
     * @return boolean 
     */

    public boolean excluirProdutoDAO(int pIdProduto) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "DELETE FROM t_produto WHERE pk_id_produto = '" + pIdProduto + "'"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }

    }
    /**
     * Alterar dados do produto
     * @param pModelProdutos
     * @return boolean
     */
    public boolean alterarProdutoDAO (ModelProdutos pModelProdutos){
        try{
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "UPDATE t_produto SET "
                    + "pro_nome = '"+pModelProdutos.getProNome()+"',"
                    + "pro_valor = '"+pModelProdutos.getProValor()+"',"
                    + "pro_estoque = '"+pModelProdutos.getProEstoque()+"',"
                    + " WHERE pk_id_produto= '"+pModelProdutos.getIdProduto()+"'"                  
            );
            
        }catch (Exception e){
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }

}
