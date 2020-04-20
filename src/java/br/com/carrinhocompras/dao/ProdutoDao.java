package br.com.carrinhocompras.dao;


import br.com.carrinhocompras.domain.Produto;
import java.util.ArrayList;
import java.util.List;


public class ProdutoDao {
    
   private ArrayList<Produto> produtos = new ArrayList<>();
   int codigo;

    public List<Produto> listar(){
        return produtos;
    }

    public Produto consultar(Integer id){
        for (Produto produto: produtos){
            if(id == produto.getId()){
                return produto;
            }
        }
        return null;
    }

    public Integer incremento(int codigo){
        for (Produto produto: produtos){
            codigo = produto.getId();
        }
        codigo = codigo + 1;
        return codigo;
    }
    
    public boolean inserir(Produto produto){
        codigo = incremento(codigo);
        produto.setId(codigo);
        produtos.add(produto);
        return true;
    }

    public boolean alterar(Produto produto){
        for (Produto c: produtos){
            if(c == produto){
                c = produto;
                return true;
            }
        }
        return false;
    }

    public boolean excluir(Produto produto){
        for (Produto c: produtos){
            if(c == produto){
                produtos.remove(c);
                return true;
            }
        }
        return false;
    }
}
