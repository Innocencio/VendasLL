/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.DaoVendasCliente;
import java.util.ArrayList;
import model.ModelVendasCliente;

/**
 *
 * @author Jeffrey
 */
public class ControllerVendasCliente {
    private DAO.DaoVendasCliente daoVendasCliente = new DaoVendasCliente();

    public ArrayList<ModelVendasCliente> getListaVendasClienteController() {
        return this.daoVendasCliente.getListaVendasClienteDAO();
    }    
}
