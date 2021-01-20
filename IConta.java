package modelo.banco;

public interface IConta {
	public final float CUSTO_SACAR_CONTA_CORRENTE = 0.01f;
	public final float CUSTO_SACAR_CONTA_SALARIO = 0.01f;
	public final float TAXA_ADMINISTRACAO = 0.25f;
	public final float CUSTO_SACAR_CONTA_INVESTIMENTO = 0.01f;
	public final float CUSTO_SACAR_CONTA_POUPAN�A = 0.01f;
	
	static final float RENDIMENTO_POUPAN�A = 0.05f;
	
	public void sacar(float valorSacado);
	
	public  void depositar(float valorDepositado);
	
	public void desativarConta();
	
	public void transferencia(IConta contaDestino, float valorTransferido);
	
	public void ativarConta();

}
