/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoInterface;

import Model.ContasBancarias;
import java.util.List;

/**
 *
 * @author Denilson
 */
public interface ContasBancariasDAO {
    public void save(ContasBancarias contasBancarias);
    public void update(ContasBancarias contasBancarias);
    public void delete(ContasBancarias contasBancarias);
    public ContasBancarias getContasBancarias (Long idContasBancarias);
    public ContasBancarias getContasBancariasByDescricao (String descricao);
    public List<ContasBancarias> lista();
}