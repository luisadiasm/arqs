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
		Produto p1 = new Produto(1L, "Liquidificador Phillips", "Liquidificador Phillips 3v", cat, new BigDecimal(130.00),"Phillips");
		assertEquals(p1.getId(), new Long(1));
		assertEquals(p1.getNome(), "Liquidificador Phillips");
		assertEquals(p1.getDescricao(), "Liquidificador Phillips 3v");
		assertEquals(p1.getCategoria(), cat);
		assertEquals(p1.getPreco(), new BigDecimal(130.00));
		assertEquals(p1.getFabricante(), "Phillips");
	}

	@Test
	public void testCompareObjects() {
		Categoria cat = new Categoria(1L, "Cozinha");
		Produto p1 = new Produto(1L, "Liquidificador Phillips", "Liquidificador Phillips 3v", cat, new BigDecimal(130.00),"Phillips");
		Produto p2 = new Produto(1L, "Palha de Aço Bombril", "Bombril", cat, new BigDecimal(1.30), "Bombril");
		assertNotEquals(p1, p2);
	}

	@Test
	public void testGenerateHash() {
		Categoria cat = new Categoria(1L, "Cozinha");
		Produto p1 = new Produto(1L, "Liquidificador Phillips", "Liquidificador Phillips 3v", cat, new BigDecimal(130.00),"Phillips");
		Produto p2 = new Produto(1L, "Palha de Aço Bombril", "Bombril", cat, new BigDecimal(1.30), "Bombril");
		assertEquals(p1.hashCode(), p2.hashCode());
		Produto p3 = new Produto(1L, "Faca Tramontina", "Faca Tramontina 30cm", cat, new BigDecimal(80.00), "Tramontina");
		assertNotEquals(p1.hashCode(), p3.hashCode());
	}

	public void testPrintObject() {
		Categoria cat = new Categoria(1L, "Cozinha");
		Produto p1 = new Produto(1L, "Liquidificador Phillips", "Liquidificador Phillips 3v", cat, new BigDecimal(130.00),"Phillips");
		assertEquals(p1.toString(), "Produto [id= 1L, nome=Liquidificador Phillips Tramontina, descricao=Liquidificador Phillips 3v, categoria=Cozinha, preco=new BigDecimal(130.00), fabricante=Phillips");
	}

}