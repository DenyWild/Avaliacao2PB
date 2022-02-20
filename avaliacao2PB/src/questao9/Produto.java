package questao9;

import java.sql.Date;
import java.text.DecimalFormat;

public class Produto {

	private Integer id;
	private String nome;
	private String descricao;
	private float desconto;
	@DateTimeFormat
	private Date data_inicio;

	public Produto(Integer id, String nome, String descricao, float desconto, Date data_inicio) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.desconto = desconto;
		this.data_inicio = data_inicio;

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public float getDesconto() {
		return desconto;
	}

	public void setDesconto(float desconto) {
		DecimalFormat df = new DecimalFormat("#,###.00");
		df.format(desconto);
		this.desconto = desconto;
	}

	public Date getData_inicio() {
		return data_inicio;
	}

	public void setData_inicio(Date data_inicio) {
		this.data_inicio = data_inicio;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Produto [id = " + id + ", nome = " + nome + ", descricao = " + descricao + ", desconto = " + desconto
				+ ", data_inicio = " + data_inicio + "]";
	}

}
