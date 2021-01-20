package modelo.banco;

import banco_superior_persistencia.PersistenciaEmArquivoCliente;

public class ProgramaBanco {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        PersistenciaEmArquivoCliente pac = new PersistenciaEmArquivoCliente();
   
        ICliente cliente4 = new ClientePessoaJuridica("800","EMPRESA A","12-04-2014");
        IConta conta4 = new ContaCorrente("AA","0101","12-09-2013");
        
        cliente4.adicionarContaCliente(conta4);
       
        pac.cadastrarCliente(cliente4);
        
        ICliente obj = pac.localizarClientePorCPF("123");
        ICliente obj2 = pac.localizarClientePorCNPJ("800");
        
        
		System.out.println(obj);
		System.out.println(obj2);
		
		

		

	}		
		 
}