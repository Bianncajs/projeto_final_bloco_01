package produto.Repository;

import product.model.Produto;


public interface ProdutoRepositoy {
	
	public void cadastrar(Produto produto);
	public void atualizar(Produto produto);
	public void deletar(int id);
	Produto procurarPorId(int id);
	public void listarTodas();

    
    void realizarVenda(int id, int quantidade);
    void adicionarEstoque(int id, int quantidade);
}


