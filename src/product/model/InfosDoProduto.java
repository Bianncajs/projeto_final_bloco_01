package product.model;

public class InfosDoProduto extends Produto {

	private String categoria; 
	private String marca; 
	private int estoque; 

	public InfosDoProduto(int id, String nome, double preco, String categoria, String marca, int estoque) {
		super(id, nome, preco); 
		this.categoria = categoria;
		this.marca = marca;
		this.estoque = estoque;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public int getEstoque() {
		return estoque;
	}

	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}

	@Override
	public void exibirInfo() {
		super.exibirInfo();
		System.out.println("Categoria: " + categoria);
		System.out.println("Marca: " + marca);
		System.out.println("Estoque disponível: " + estoque + " unidades");
	}

	@Override
	public void exibirInfo(boolean detalhes) {
		if (detalhes) {
			super.exibirInfo(detalhes);
			System.out.println("Categoria: " + categoria);
			System.out.println("Marca: " + marca);
			System.out.println("Estoque disponível: " + estoque + " unidades");
		} else {
			System.out.println("Produto: " + getNome() + " | Preço: R$ " + getPreco() + " | Categoria: " + categoria);
		}
	}
}
