package product.model;

public abstract class Produto {

		private int id;
	    private String nome;
	    private double preco;

	
	
	    public Produto(int id, String nome, double preco) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    
    public void exibirInfo() {
        System.out.println("ID: " + id);
        System.out.println("Nome: " + nome);
        System.out.println("Preço: R$ " + preco);
    }

    
    public void exibirInfo(boolean detalhes) {
        if (detalhes) {
            System.out.println("Detalhes completos do Produto:");
            exibirInfo(); 
        } else {
            System.out.println("Produto: " + nome + " | Preço: R$ " + preco);
        }
    }
}


