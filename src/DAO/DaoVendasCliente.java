/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import conexoes.ConexaoMySql;
import java.util.ArrayList;
import model.ModelCliente;
import model.ModelVendas;
import model.ModelVendasCliente;

/**
 *
 * @author Jeffrey
 */
public class DaoVendasCliente extends ConexaoMySql {
    
    /**
    * recupera uma lista de Vendas
        * @return ArrayList
    */
    public ArrayList<ModelVendasCliente> getListaVendasClienteDAO(){
        ArrayList<ModelVendasCliente> listamodelVendasClientes = new ArrayList();
        ModelVendas modelVendas = new ModelVendas();
        ModelCliente modelCliente = new ModelCliente();
        ModelVendasCliente modelVendasCliente = new ModelVendasCliente();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "t_vendas.pk_id_vendas,"
                    + "t_vendas.fk_cliente,"
                    + "t_vendas.ven_data_venda,"
                    + "t_vendas.ven_valor_liquido,"
                    + "t_vendas.ven_valor_bruto,"
                    + "t_vendas.ven_desconto,"
                    + "t_cliente.pk_id_cliente,"
                    + "t_cliente.cli_nome,"
                    + "t_cliente.cli_endereco,"
                    + "t_cliente.cli_bairro,"
                    + "t_cliente.cli_cidade,"
                    + "t_cliente.cli_uf,"
                    + "t_cliente.cli_cep,"
                    + "t_cliente.cli_contato,"
                 + " FROM"
                     + " t_vendas INNER JOIN t_cliente "
                        + "ON t_cliente.pk_id_cliente = t_vendas.fk_cliente; "
                + ";"
            );

            while(this.getResultSet().next()){
                modelVendas = new ModelVendas();
                modelCliente = new ModelCliente();
                modelVendasCliente = new ModelVendasCliente();
                
                modelVendas.setIdVenda(this.getResultSet().getInt(1));
                modelVendas.setCliente(this.getResultSet().getInt(2));
                modelVendas.setVenDataVenda(this.getResultSet().getDate(3));
                modelVendas.setVenValorLiquido(this.getResultSet().getDouble(4));
                modelVendas.setVenValorBruto(this.getResultSet().getDouble(5));
                modelVendas.setVenDesconto(this.getResultSet().getDouble(6));
                //Cliente
                modelCliente.setIdCliente(this.getResultSet().getInt(1));
                modelCliente.setCliNome(this.getResultSet().getString(2));
                modelCliente.setCliEndereco(this.getResultSet().getString(3));
                modelCliente.setCliBairro(this.getResultSet().getString(4));
                modelCliente.setCliCidade(this.getResultSet().getString(5));
                modelCliente.setCliUf(this.getResultSet().getString(6));
                modelCliente.setCliCep(this.getResultSet().getString(7));
                modelCliente.setCliContato(this.getResultSet().getString(8));
                
                modelVendasCliente.setModelVendas(modelVendas);
                modelVendasCliente.setModelCliente(modelCliente);
                
                listamodelVendasClientes.add(modelVendasCliente);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return listamodelVendasClientes;
    }
    
}
