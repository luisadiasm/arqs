package br.unibh.loja.controle;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import br.unibh.loja.entidades.Produto;
import br.unibh.loja.entidades.Categoria;
import br.unibh.loja.negocio.ServicoProduto;

@ManagedBean(name = "cidademb")
@ViewScoped
public class ControleProduto extends ControleUtil {
	@Inject
	private ServicoProduto ejb;
	private Produto produto;
	private String nomeArg;
	private List<Produto> lista;

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto cidade) {
		this.produto = produto;
	}

	public String getNomeArg() {
		return nomeArg;
	}

	public void setNomeArg(String nomeArg) {
		this.nomeArg = nomeArg;
	}

	public List<Produto> getLista() {
		return lista;
	}

	@PostConstruct
	public void inicializaLista() {
		try {
			lista = ejb.findAll();
		} catch (Exception e) {
			mostrarErro(e);
		}
	}

	public void gravar() {
		try {
			if (produto.getId() == null) {
				produto = ejb.insert(produto);
				mostrarMensagem("Inclusão realizada com sucesso!", "");
			} else {
				produto = ejb.update(produto);
				mostrarMensagem("Atualização realizada com sucesso!", "");
			}
			lista = ejb.findByName(nomeArg);
		} catch (Exception e) {
			mostrarErro(e);
		}
	}

	public void pesquisar() {
		produto = null;
		try {
			lista = ejb.findByName(nomeArg);
		} catch (Exception e) {
			mostrarErro(e);
		}
	}

	public void novo() {
		produto = new Produto();
	}

	public void editar(Long id) {
		try {
			produto = ejb.find(id);
			return;
		} catch (Exception e) {
			mostrarErro(e);
		}
		produto = null;
	}

	public void excluir(Long id) {
		try {
			ejb.delete(ejb.find(id));
			lista = ejb.findByName(nomeArg);
		} catch (Exception e) {
			mostrarErro(e);
			return;
		}
		produto = null;
		mostrarMensagem("Exclusão realizada com sucesso!", "");
	}

/*	public Categoria[] getCategoria() {
		Categoria[] categorias = Categoria.values();
		Comparator<Categoria> comparator = new Comparator<Categoria>() {
			public int compare(Categoria e1, Categoria e2) {
				return e1.getDescricao().compareTo(e2.getDescricao());
			}
		};
		Arrays.sort(categorias, comparator);
		return categorias;
	}*/
}
