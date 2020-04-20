package br.com.carrinhocompras.dao;

import br.com.carrinhocompras.domain.Carrinho;
import java.util.ArrayList;
import java.util.List;


public class CarrinhoDao {
    
   private ArrayList<Carrinho> carrinho = new ArrayList<>();

    public List<Carrinho> listar(){
        return carrinho;
    }

    public Carrinho consultar(Integer id){
        for (Carrinho produto: carrinho){
            if(id == produto.getId()){
                return produto;
            }
        }
        return null;
    }


    public boolean inserir(Carrinho produto){
        int tamanho = carrinho.size() + 1;
        produto.setId(tamanho);
        carrinho.add(produto);
        return true;
    }

    public boolean alterar(Carrinho produto){
        for (Carrinho c: carrinho){
            if(c == produto){
                c = produto;
                return true;
            }
        }
        return false;
    }

    public boolean excluir(Carrinho produto){
        for (Carrinho c: carrinho){
            if(c == produto){
                carrinho.remove(c);
                return true;
            }
        }
        return false;
    }
}
