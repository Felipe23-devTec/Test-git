package modelo.banco;

import java.io.Serializable;

public  class ContaSalario implements IConta, Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String numeroConta;
	String agencia;
	private float saldo;
	boolean status;
	String dataAbertura;
	static  final float TAXA_MANUTENCAO =  0.025f;
	
	
	public ContaSalario(String numeroConta, String agencia,
			String dataAbertura) {
	
		// TODO Auto-generated constructor stub
		this.numeroConta = numeroConta;
		this.agencia = agencia;

		this.saldo = 0f;
		this.status = true;
		this.dataAbertura = dataAbertura;
	}

	@Override
	public void transferencia(IConta contaDestino, float valorTransferido){
		// TODO Auto-generated method stub
	
		if(contaDestino == null) {
		  System.err.println("Conta salario nao faz tranferencia");
			
		
		}
	
	}

	@Override
	public void sacar(float valorSacado) {
		// TODO Auto-generated method stub
		if(valorSacado <= this.saldo  && this.status == true) {
			this.saldo -=  valorSacado;
			
		}
		
	}

	@Override
	public void depositar(float valorDepositado) {
		// TODO Auto-generated method stub
		if(valorDepositado > 0 && this.status == true) {
			this.saldo += valorDepositado;
			
		}
		
	}

	@Override
	public void desativarConta() {
		// TODO Auto-generated method stub
		this.status = false;
		
	}

	@Override
	public void ativarConta() {
		// TODO Auto-generated method stub
		this.status = true;
		
	}

	@Override
	public String toString() {
		return "ContaSalario [numeroConta=" + numeroConta + ", agencia=" + agencia + ", saldo=" + saldo + ", status="
				+ status + ", dataAbertura=" + dataAbertura + "]";
	}
	

}
