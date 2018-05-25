package loja;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import java.math.BigDecimal;
import org.junit.Test;
import br.unibh.loja.entidades.Categoria;
import br.unibh.loja.entidades.Produto;

public class TesteProduto {

	@Test
	public void testCreateObject() {
		Categoria cat = new Categoria(1L, "Cozinha");
		Produto p1 = new Produto(1L, "Liquidificador Phillips", "Liquidificador Phillips V", cat, new BigDecimal(130.00),"Phillips", null);
		assertEquals(p1.getId(), new Long(1));
		assertEquals(p1.getNome(), "Liquidificador Phillips");
		assertEquals(p1.getDescricao(), "Liquidificador Phillips V");
		assertEquals(p1.getCategoria(), cat);
		assertEquals(p1.getPreco(), new BigDecimal(130.00));
		assertEquals(p1.getFabricante(), "Phillips");
	}

	@Test
	public void testCompareObjects() {
		Categoria cat = new Categoria(1L, "Cozinha");
		Produto p1 = new Produto(1L, "Liquidificador Phillips", "Liquidificador Phillips V", cat, new BigDecimal(130.00),"Phillips", null);
		Produto p2 = new Produto(1L, "Palha de Aco Bombril", "Bombril", cat, new BigDecimal(1.30), "Bombril", null);
		assertNotEquals(p1, p2);
	}

	
	@Test
	public void testPrintObject() {
		Categoria cat = new Categoria(1L, "Cozinha");
		Produto p1 = new Produto(1L, "Liquidificador Phillips", "Liquidificador Phillips V", cat, new BigDecimal(130.00),"Phillips", null);
		assertEquals(p1.toString(), "Produto [id=1, nome=Liquidificador Phillips, descricao=Liquidificador Phillips V, categoria=Categoria [id=1, descricao=Cozinha], preco=130, fabricante=Phillips");
		System.out.println(p1);
	}

}