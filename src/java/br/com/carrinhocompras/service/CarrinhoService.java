package br.com.carrinhocompras.service;

import br.com.carrinhocompras.dao.CarrinhoDao;
import br.com.carrinhocompras.domain.Carrinho;
import java.util.List;

public class CarrinhoService {
    
    private CarrinhoDao carrinhoDao = new CarrinhoDao();
    
    public List<Carrinho> listar(){
        return carrinhoDao.listar();
    }

    public Carrinho consultar(Integer id){
        return carrinhoDao.consultar(id);     
    }    
    
    public boolean inserir(Carrinho produto){
        return carrinhoDao.inserir(produto);
    }
    
    public boolean alterar(Carrinho produto){
        return carrinhoDao.alterar(produto);
    }
    
    public boolean excluir(Carrinho produto){
        return carrinhoDao.excluir(produto);
    }
}
