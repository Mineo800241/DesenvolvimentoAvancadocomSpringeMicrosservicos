package br.edu.infnet.maxwellapi.service;

import java.util.Iterator;
import java.util.List;

public interface CrudService <T,ID> {
    T incluir(T entity);
    T alterar(ID id, T identity);
    T obter();
    T obterPorId(ID id);
    //T obterPorIdade(IDADE idade);
    void excluir(ID id);
    List<T> obterLista();

}
