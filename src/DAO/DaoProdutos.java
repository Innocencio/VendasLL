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
public class DaoProdutos extends ConexaoMySql{
    
    public int salvarProdutosSao(ModelProdutos pModelProdutos){
        try{
            this.conectar();
            return this.insertSQL("INSERT INTO t_produto ("
                    + "pro_nome,"
                    + "pro_valor"
                    + "pro_estoque"
                    + ") VALUES ("
                    + "'" + pModelProdutos.getProNome() + "'," 
                    + "'" + pModelProdutos.getProValor() + "'," 
                    + "'" + pModelProdutos.getProEstoque()+ "'," 
            );
        }catch(Exception e){
            e.printStackTrace();
            return 0;
        }finally{
            this.fecharConexao();
        }
    }
    
}

