package br.edu.infnet.maxwellapi.service;

import java.util.List;

public interface CrudService <T,ID> {
    T salvar(T entity);
    T obter();
    T obterPorId(ID id);
    void excluir(ID id);
    List<T> obterLista();
}
