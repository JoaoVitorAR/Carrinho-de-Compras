package br.com.carrinhocompras.controller;
import br.com.carrinhocompras.domain.Produto;
import br.com.carrinhocompras.service.ProdutoServicos;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="produtoMB")
@SessionScoped
public class ProdutoController implements Serializable{
    private Produto produto = new Produto();
    private List<Produto> produtos;
    private ProdutoServicos produtoServicos = new ProdutoServicos();

    public ProdutoController(){
        listar();
    }

    public void listar(){
        produtos = produtoServicos.listar();
    }

    public String novo(){
        produto = new Produto();
        return "new.xhtml?faces-redirect=true";
    }

    public String cancelar(){
        return "list.xhtml?faces-redirect=true";
    }

    public String buscarDados(Produto produto){
        this.produto = produto;
        return "alter.xhtml?faces-redirect=true";
    }

    public String alterar(){
        produtoServicos.alterar(produto);
        this.listar();
        return "list.xhtml?faces-redirect=true";
    }
    public String excluir(Produto produto){
        produtoServicos.excluir(produto);
        this.listar();
        return "list.xhtml?faces-redirect=true";
    }
    public String salvar(){
       produtoServicos.inserir(produto);
       this.listar();
       return "list.xhtml?faces-redirect=true";
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
}