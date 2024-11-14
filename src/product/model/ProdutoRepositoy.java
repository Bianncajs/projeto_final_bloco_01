package product.model;

import java.util.List;


public interface ProdutoRepositoy {
	
	public void cadastrar(Produto produto);
	public void atualizar(Produto produto);
	public void deletar(int id);
	Produto procurarPorId(int id);
	List<Produto> listarTodas();

    
    void realizarVenda(int id, int quantidade);
    void adicionarEstoque(int id, int quantidade);
}


