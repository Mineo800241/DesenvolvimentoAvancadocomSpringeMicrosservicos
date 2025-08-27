package br.edu.infnet.maxwellapi.service;

import java.util.Iterator;
import java.util.List;

public interface CrudService <T,ID> {
    T incluir(T entity);
    T alterar(ID id, T identity);
    T obterPorId(ID id);
    void excluir(ID id);
    List<T> obterLista();

}
