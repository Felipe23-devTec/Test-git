package modelo.banco;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;

public class ClientePessoaJuridica implements ICliente, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String cnpj;
	String nome;
	String dataNascimento;
	
	HashSet<String> telefones = new HashSet<String>();
    
	private ArrayList<IConta> contas = new ArrayList<IConta>();
	
	public ClientePessoaJuridica(String cnpj, String nome, String dataNascimento) {
		
		this.cnpj = cnpj;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		
	}
	public ClientePessoaJuridica(String cnpj) {
		this.cnpj = cnpj;
		
	}
	@Override
	public String toString() {
		return "ClientePessoaJuridica [cnpj=" + cnpj + ", nome=" + nome + ", dataNascimento=" + dataNascimento
				+ ", telefones=" + telefones + ", contas=" + contas + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cnpj == null) ? 0 : cnpj.hashCode());
		result = prime * result + ((contas == null) ? 0 : contas.hashCode());
		result = prime * result + ((dataNascimento == null) ? 0 : dataNascimento.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((telefones == null) ? 0 : telefones.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClientePessoaJuridica other = (ClientePessoaJuridica) obj;
		if (cnpj == null) {
			if (other.cnpj != null)
				return false;
		} else if (!cnpj.equals(other.cnpj))
			return false;
		if (contas == null) {
			if (other.contas != null)
				return false;
		} else if (!contas.equals(other.contas))
			return false;
		if (dataNascimento == null) {
			if (other.dataNascimento != null)
				return false;
		} else if (!dataNascimento.equals(other.dataNascimento))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (telefones == null) {
			if (other.telefones != null)
				return false;
		} else if (!telefones.equals(other.telefones))
			return false;
		return true;
	}
	public void adicionarContaCliente(IConta contaCliente) {
	
		this.contas.add(contaCliente);
		System.out.println(contas);
	}
	public boolean contemContaCliente(IConta conta) {
		return this.contas.contains(conta);
		
	}
	public void removerConta(String telefone) {
		if(telefones.contains(telefone)) {
			telefones.remove(telefone);
			System.out.println("Telefone adicionado com sucesso");
			
		}else {
			System.out.println("Telefone nao adicionado");
			
		}
		
	}
	public void cadastrarConta(IConta conta) {
		contas.add(conta);
		
	}
	
}
