package br.com.carrinhocompras.controller;

import br.com.carrinhocompras.domain.Carrinho;
import br.com.carrinhocompras.domain.Produto;
import br.com.carrinhocompras.service.CarrinhoService;
import br.com.carrinhocompras.service.ProdutoServicos;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.swing.JOptionPane;


@ManagedBean(name="carrinhoMB")
@SessionScoped
public class CarrinhoController {
    private Produto produto = new Produto();
    private List<Produto> produtos;
    private ProdutoServicos produtoService = new ProdutoServicos();
    
    private Carrinho carrinho = new Carrinho();
    private List<Carrinho> carrinhos;
    private CarrinhoService carrinhoService = new CarrinhoService();
    private String pagamento;
    
    public CarrinhoController(){
        listar();
    }

    public void listar(){
        produtos = produtoService.listar();
        carrinhos = carrinhoService.listar();
    }
    
    public String novo(){
        carrinho = new Carrinho();
        return "/index.xhtml?faces-redirect=true";
        
    }
    
    public String salvar(Produto produto){
       carrinho = new Carrinho(); 
       carrinho.setId(produto.getId());
       carrinho.setNome(produto.getNome());
       carrinho.setPreco(produto.getPreco());
       carrinho.setDescricao(produto.getDescricao());
       carrinhoService.inserir(carrinho);
       this.listar();
       return "/index.xhtml?faces-redirect=true";
    }
    
    public String excluir(Carrinho carrinho){
        carrinhoService.excluir(carrinho);
        this.listar();
        return "carrinho.xhtml?faces-redirect=true";
    }
    
    public Double total (){
        Double soma = 0.0;
        for (Carrinho car: carrinhos)
          soma += car.getPreco();
        return soma;
    }
    
    public String formaPagamento(){
        if(pagamento.equals("Boleto"))
            return "Boleto";
        else
            return "Cartão";
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public ProdutoServicos getProdutoService() {
        return produtoService;
    }

    public void setProdutoService(ProdutoServicos produtoService) {
        this.produtoService = produtoService;
    }

    public Carrinho getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(Carrinho carrinho) {
        this.carrinho = carrinho;
    }

    public List<Carrinho> getCarrinhos() {
        return carrinhos;
    }

    public void setCarrinhos(List<Carrinho> carrinhos) {
        this.carrinhos = carrinhos;
    }

    public CarrinhoService getCarrinhoService() {
        return carrinhoService;
    }

    public void setCarrinhoService(CarrinhoService carrinhoService) {
        this.carrinhoService = carrinhoService;
    }

    public String getPagamento() {
        return pagamento;
    }

    public void setPagamento(String pagamento) {
        this.pagamento = pagamento;
    }
 
}