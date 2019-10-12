package br.com.codenation.comercio.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.codenation.comercio.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

	public Produto findByNome(String nome);

	// Nesse caso, precisamos usar o sinal de percentual em nossas consultas.
	public List<Produto> findByNomeLike(String nome);

	// Equivalente ao like, mas não precisamos nos preocupar com o sinal de percentual.
	// Podemos usar também EndingWith, Containing.
	public List<Produto> findByNomeStartingWith(String nome);
	
	//Containing
	public List<Produto> findByNomeContaining(String nome);

	// Ordenando pelo nome.
	public List<Produto> findByNomeStartingWithOrderByNome(String nome);

	// Não levar em consideração a caixa.
	public List<Produto> findByNomeStartingWithIgnoreCase(String nome);

	// Pesquisando por duas propriedades: nome e ativo.
	public List<Produto> findByNomeStartingWithIgnoreCaseAndAtivoEquals(String nome, boolean ativo);
	
	 // Podemos usar também IsNotNull ou NotNull.
    public List<Produto> findByDescricaoIsNull(); 
   
    // Quando você quer negar o que passa no parâmetro
    public List<Produto> findByNomeNot(String nome);
   
    // Todos os produtos com os IDs passados no varargs. Poderia usar NotIn para negar os IDs.
    public List<Produto> findByIdIn(Integer... ids);
   
    // Todos onde a propriedade ativo é true. Poderia ser falso, usando False.
    public List<Produto> findByAtivoTrue();
    
    // Buscar onde a data de cadastro é depois do parâmetro passado. 
    // Pode ser usado Before também.
    public List<Produto> findByCadastroAfter(LocalDate data);
   
    // Buscar onde a data cadastro está dentro de um período.
    public List<Produto> findByCadastroBetween(LocalDate inicio, LocalDate fim);
   
    // Todos com quantidade "menor que". Poderia ser usado também LessThanEqual, GreaterThan, GreaterThanEqual.
    public List<Produto> findByQuantidadeLessThan(int quantidade);
    
    @Query("from Produto where nome like concat(?1, '%')")
    public List<Produto> pesquisarProdutos(String nome);

}
