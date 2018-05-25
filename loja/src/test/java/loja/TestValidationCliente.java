package loja;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.unibh.loja.entidades.Cliente;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestValidationCliente {
	private static Validator validator;


	@BeforeClass
	public static void setUp() {
		System.out.println("Inicializando validador...");
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@Test
	public void testeValidacaoCliente() {
		Cliente o = new Cliente(1L, "Luísa", "luisadiasm", "1234", "Luisadiasm", "12072627656", "(31)992038277",
				"luisadiasm@gmail.com", null, null, null);
		System.out.println(o);
		Set<ConstraintViolation<Cliente>> constraintViolations = validator.validate(o);
		for (ConstraintViolation<Cliente> c : constraintViolations) {
			System.out.println("Erro de Validação: " + c.getMessage());
		}
		Assert.assertEquals(3, constraintViolations.size());
	}

	@Test
	public void testeValidacaoClienteInv() {
		Cliente o = new Cliente(1L, "Luísa", "luisadiasm", "1234", "Luisadiasm", "12072627656", "(31)992038277",
				"luisadiasm@gmail.com", null, null, null);
		System.out.println(o);
		Set<ConstraintViolation<Cliente>> constraintViolations = validator.validate(o);
		for (ConstraintViolation<Cliente> c : constraintViolations) {
			System.out.println("Erro de Validação: " + c.getMessage());
		}
		Assert.assertEquals(3, constraintViolations.size());
	}
}