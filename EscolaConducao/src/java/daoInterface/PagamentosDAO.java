/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoInterface;

import Model.Pagamentos;
import java.util.List;

/**
 *
 * @author Denilson
 */
public interface PagamentosDAO {
    public void save(Pagamentos pagamentos);
    public void update(Pagamentos pagamentos);
    public void delete(Pagamentos pagamentos);
    public Pagamentos getPagamentos (Long idPagamentos);
    public Pagamentos getPagamentosByDescricao (String descricao);
    public List<Pagamentos> lista();
}