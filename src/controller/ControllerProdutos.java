/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.DaoProdutos;
import java.util.ArrayList;
import model.ModelProdutos;

/**
 * Salvar produtos Controller
 * @author Jeffrey
 * return int
 */
public class ControllerProdutos {
    
    private DaoProdutos daoProdutos = new DaoProdutos();
    
    public int salvarProdutoController(ModelProdutos pModelProdutos){
        return this.daoProdutos.salvarProdutosDAO(pModelProdutos);     
    }
    
    /**
     * Excluir produto pelo código
     * @param pCodigo
     * @return boolean
     */
    
    public boolean excluirProdutoController(int pCodigo){
        return this.daoProdutos.excluirProdutoDAO(pCodigo);        
    }
    
    /**
     * Alterar produto 
     * @param pModelProdutos
     * @return boolean
     */
    
    public boolean alterarProdutoController(ModelProdutos pModelProdutos){
        return this.daoProdutos.alterarProdutoDAO(pModelProdutos);
    }
    
    /**
     * Retornar produto
     * @param pCodigo
     * @return  Model Produto
     */
    
    public ModelProdutos retornarProdutoController(int pCodigo){
        return this.daoProdutos.retornarProdutoDAO(pCodigo);
    }
    
    /**
     * Retornar produto
     * @param pNomeProduto
     * @return  Model Produto
     */
    
    public ModelProdutos retornarProdutoController(String pNomeProduto){
        return this.daoProdutos.retornarProdutoDAO(pNomeProduto);
    }
    
    /**
     * retornar uma lista de produtos
     * @return Lista Model Produtos
     */
    
    public ArrayList<ModelProdutos> retornarListaProdutoController(){
        return this.daoProdutos.retornarListaProdutosDAO();
    }
    
}

