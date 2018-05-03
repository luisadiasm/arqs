package loja;

import java.math.BigDecimal;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import br.unibh.loja.entidades.Categoria;
import br.unibh.loja.entidades.Produto;

public class TestValidationProduto {
	private static Validator validator;

	@BeforeClass
	public static void setUp() {
		System.out.println("Inicializando validador...");
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@Test
	public void testeValidacaoProduto() {
		Categoria cat = new Categoria(1L, "Cozinha", null);
		Produto o = new Produto(1L, "Liquidificador Phillips", "Liquidificador Phillips 3v", cat,
				new BigDecimal(130.00), "Phillips", null);
		System.out.println(o);
		Set<ConstraintViolation<Produto>> constraintViolations = validator.validate(o);
		for (ConstraintViolation<Produto> c : constraintViolations) {
			System.out.println(" Erro de Validacao: " + c.getMessage());
		}
		Assert.assertEquals(1, constraintViolations.size());
	}

	@Test
	public void testeValidacaoProduto2Inv() {
		Categoria cat = new Categoria(1L, "Cozinha", null);
		Produto o = new Produto(1L, "Liquidificador Phillips", "Liquidificador Phillips 3v", cat,
				new BigDecimal(130.00), "Phillips", null);
		System.out.println(o);
		Set<ConstraintViolation<Produto>> constraintViolations = validator.validate(o);
		for (ConstraintViolation<Produto> c : constraintViolations) {
			System.out.println(" Erro de Validacao: " + c.getMessage());
		}
		Assert.assertEquals(1, constraintViolations.size());
	}
}