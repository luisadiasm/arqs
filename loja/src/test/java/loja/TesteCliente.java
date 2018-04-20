package loja;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import java.util.Date;
import org.junit.Test;
import br.unibh.loja.entidades.Cliente;

public class TesteCliente {

	@Test
	public void testCreateObject() {
		Cliente c = new Cliente(1L, "Luísa", "luisadiasm", "1234", "Luisadiasm", "12072627656", "(31)992038277", "luisadiasm@gmail.com", new Date(), new Date());
		assertEquals(c.getId(), new Long(1));
		assertEquals(c.getNome(), "Luísa");
		assertEquals(c.getLogin(), "luisadiasm");
		assertEquals(c.getSenha(), "1234");
		assertEquals(c.getPerfil(), "Luisadiasm");
		assertEquals(c.getCpf(), "12072627656");
		assertEquals(c.getTelefone(), "(31)992038277");
		assertEquals(c.getEmail(), "luisadiasm@gmail.com");
		assertEquals(c.getDataNascimento(), new Date());
		assertEquals(c.getDataCadastro(), new Date());
	}

	@Test
	public void testCompareObjects() {
		Date date = new Date();
		Cliente c1 = new Cliente(1L, "Luísa", "luisadiasm", "1234", "Luisadiasm", "12072627656", "(31)992038277", "luisadiasm@gmail.com", date, date);
		Cliente c2 = new Cliente(1L, "Vinicius", "viniciusB", "4321", "ViniciusBrum", "12345678910", "(31)33333333", "vinicim1997@gmail.com", date, date);
		assertNotEquals(c1, c2);
	}

	@Test
	public void testGenerateHash() {
		Date date = new Date();
		Cliente c1 = new Cliente(1L, "Luísa", "luisadiasm", "1234", "Luisadiasm", "12072627656", "(31)992038277", "luisadiasm@gmail.com", date, date);
		Cliente c2 = new Cliente(1L, "Vinicius", "viniciusB", "4321", "ViniciusBrum", "12345678910", "(31)33333333", "vinicim1997@gmail.com", date, date);
		assertEquals(c1.hashCode(), c2.hashCode());
		Cliente c3 = new Cliente(1L, "Guilherme", "GuilhermeB", "2468", "Guilhermisson", "01987654321", "(31)22222222", "gbbastos@gmail.com", date, date);
		assertNotEquals(c1.hashCode(), c3.hashCode());
	}

	public void testPrintObject() {
		Date date = new Date();
		Cliente c1 = new Cliente(1L, "Luísa", "luisadiasm", "1234", "Luisadiasm", "12072627656", "(31)992038277", "luisadiasm@gmail.com", date, date);
		assertEquals(c1.toString(),
				"Cliente [id= 1L, nome=Luísa, login=luisadiasm, senha=1234, perfil=Luisadiasm, cpf=12072627656, telefone=(31)992038277, email=luisadiasm@gmail.com, dataNascimento=new Date(), dataCadastro=new Date()");
	}

}