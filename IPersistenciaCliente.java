package banco_superior_persistencia;

import modelo.banco.ICliente;

public interface IPersistenciaCliente {
	
	public void cadastrarCliente(ICliente obj);
	
    public ICliente localizarClientePorCPF(String cpf);
    
    public ICliente localizarClientePorCNPJ(String cnpj);
    
    public void removerCliente(ICliente obj);
}
