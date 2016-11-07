/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoInterface;

import Model.TiposPagamento;
import java.util.List;

/**
 *
 * @author Denilson
 */
public interface TiposPagamentoDAO {
    public void save(TiposPagamento tiposPagamento);
    public void update(TiposPagamento tiposPagamento);
    public void delete(TiposPagamento tiposPagamento);
    public TiposPagamento getTiposPagamento (Long idTiposPagamento);
    public TiposPagamento getTiposPagamentoByDescricao (String descricao);
    public List<TiposPagamento> lista();
}