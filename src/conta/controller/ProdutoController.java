package conta.controller;

import java.util.ArrayList;
import java.util.List;

import product.model.Produto;
import product.model.InfosDoProduto;
import produto.Repository.ProdutoRepositoy;


		public class ProdutoController implements ProdutoRepository {
	
		private ArrayList<Produto> listaProdutos = new ArrayList<>();
	    int numeroProduto = 0;
	    
	    

	    @Override
	    public void cadastrar(Produto produto) {
	        listaProdutos.add(produto);
	        System.out.println("\nProduto " + produto.getNome() + " cadastrado com sucesso! ");
	    }

	    @Override
	    public void atualizar(Produto produto) {
	        Produto produtoExistente = buscarNaCollection(produto.getId());

	        if (produtoExistente != null) {
	            listaProdutos.set(listaProdutos.indexOf(produtoExistente), produto);
	            System.out.println("\nProduto " + produto.getNome() + " atualizado com sucesso!");
	        } else {
	            System.out.println("\nProduto com ID " + produto.getId() + " não encontrado!");
	        }
	    }

	    @Override
	    public void deletar(int id) {
	        Produto produto = buscarNaCollection(id);

	        if (produto != null) {
	            listaProdutos.remove(produto);
	            System.out.println("\nProduto com ID " + id + " deletado com sucesso!");
	        } else {
	            System.out.println("\nProduto com ID " + id + " não encontrado!");
	        }
	    }

	    @Override
	    public Produto procurarPorId(int id) {
	        Produto produto = buscarNaCollection(id);
	        
	        if (produto != null) {
	            return produto;
	        } else {
	            System.out.println("\nProduto com ID " + id + " não encontrado!");
	            return null;
	        }
	    }

	    @Override
	    public List listarTodas() {
	        if (listaProdutos.isEmpty()) {
	            System.out.println("\nNão há produtos cadastrados!");
	        } else {
	            for (Produto produto : listaProdutos) {
	                produto.exibirInfo(true);
	            }
	        }
			return listaProdutos;
	    }

	    @Override
	    public void realizarVenda(int id, int quantidade) {
	        Produto produto = buscarNaCollection(id);

	        if (produto != null) {
	            if (produto instanceof InfosDoProduto) {
	                InfosDoProduto infoProduto = (InfosDoProduto) produto;

	                if (infoProduto.getEstoque() >= quantidade) {
	                    infoProduto.setEstoque(infoProduto.getEstoque() - quantidade);
	                    System.out.println("\nVenda de " + quantidade + " unidades do produto " + produto.getNome() + " realizada com sucesso!");
	                } else {
	                    System.out.println("\nEstoque insuficiente para realizar a venda!");
	                }
	            }
	        } else {
	            System.out.println("\nProduto com ID " + id + " não encontrado!");
	        }
	    }

	    @Override
	    public void adicionarEstoque(int id, int quantidade) {
	        Produto produto = buscarNaCollection(id);

	        if (produto != null) {
	            if (produto instanceof InfosDoProduto) {
	                InfosDoProduto infoProduto = (InfosDoProduto) produto;
	                infoProduto.setEstoque(infoProduto.getEstoque() + quantidade);
	                System.out.println("\nEstoque de " + produto.getNome() + " atualizado. Novo estoque: " + infoProduto.getEstoque() + " unidades.");
	            }
	        } else {
	            System.out.println("\nProduto com ID " + id + " não encontrado!");
	        }
	    }

	    
	    public int gerarNumero() {
	        return ++numeroProduto;
	    }

	    
	    private Produto buscarNaCollection(int id) {
	        for (Produto produto : listaProdutos) {
	            if (produto.getId() == id) {
	                return produto;
	            }
	        }
	        return null;
	    }
}
	
	
	


