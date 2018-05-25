package loja;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import java.util.Date;
import org.junit.Test;
import br.unibh.loja.entidades.Cliente;

public class TesteCliente {

	@Test
	public void testCreateObject() {
		Cliente c = new Cliente(1L, "Luísa", "luisadiasm", "1234", "Luisadiasm", "12072627656", "(31)992038277", "luisadiasm@gmail.com", null, null, null);
		assertEquals(c.getId(), new Long(1));
		assertEquals(c.getNome(), "Luísa");
		assertEquals(c.getLogin(), "luisadiasm");
		assertEquals(c.getSenha(), "1234");
		assertEquals(c.getPerfil(), "Luisadiasm");
		assertEquals(c.getCpf(), "12072627656");
		assertEquals(c.getTelefone(), "(31)992038277");
		assertEquals(c.getEmail(), "luisadiasm@gmail.com");
		assertEquals(c.getDataNascimento(), null);
		assertEquals(c.getDataCadastro(), null);
	}

	@Test
	public void testCompareObjects() {
		//Date date = new Date();
		Cliente c1 = new Cliente(1L, "Luísa", "luisadiasm", "1234", "Luisadiasm", "12072627656", "(31)992038277", "luisadiasm@gmail.com", null, null, null);
		Cliente c2 = new Cliente(1L, "Vinicius", "viniciusB", "4321", "ViniciusBrum", "12345678910", "(31)33333333", "vinicim1997@gmail.com", null, null, null);
		assertNotEquals(c1, c2);
	}

	
	@Test
	public void testPrintObject() {
		//Date date = new Date();
		Cliente c1 = new Cliente(1L, "Luísa", "luisadiasm", "1234", "Luisadiasm", "12072627656", "(31)992038277", "luisadiasm@gmail.com", null, null, null);
		assertEquals(c1.toString(),"Cliente [id=1, nome=Luísa, login=luisadiasm, senha=1234, perfil=Luisadiasm, cpf=12072627656, telefone=(31)992038277, email=luisadiasm@gmail.com, dataNascimento=null, dataCadastro=null]");
		System.out.println(c1);
	}

}