package loja;

import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import br.unibh.loja.entidades.Categoria;

public class TestValidationCategoria {
	private static Validator validator;

	@BeforeClass
	public static void setUp() {
		System.out.println("Inicializando validador...");
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@Test
	public void testeValidacaoCategoria() {
		Categoria o = new Categoria(1L, "Cozinha", null);
		System.out.println(o);
		Set<ConstraintViolation<Categoria>> constraintViolations = validator.validate(o);
		for (ConstraintViolation<Categoria> c : constraintViolations) {
			System.out.println("Erro de Validação: " + c.getMessage());
		}
		Assert.assertEquals(0, constraintViolations.size());
	}

	@Test
	public void testeValidacaoCategoriaInv() {
		Categoria o = new Categoria(1L, "", null);
		System.out.println(o);
		Set<ConstraintViolation<Categoria>> constraintViolations = validator.validate(o);
		for (ConstraintViolation<Categoria> c : constraintViolations) {
			System.out.println("Erro de Validação: " + c.getMessage());
		}
		Assert.assertEquals(1, constraintViolations.size());
	}
}