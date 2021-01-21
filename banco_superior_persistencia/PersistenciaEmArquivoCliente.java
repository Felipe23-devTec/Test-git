package banco_superior_persistencia;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import modelo.banco.ClientePessoaFisica;
import modelo.banco.ClientePessoaJuridica;
import modelo.banco.ICliente;

public class PersistenciaEmArquivoCliente implements IPersistenciaCliente{
	
	
	private ArrayList<ICliente> clientesCadastrados = new ArrayList<ICliente>();
    
	public PersistenciaEmArquivoCliente() {
		LerConteudoArquivo();
		
		
	}
	@Override
	public void cadastrarCliente(ICliente obj) {
		// TODO Auto-generated method stub
		if(!clientesCadastrados.contains(obj)) {
			clientesCadastrados.add(obj);
			System.out.println("Clientes cadastrados "+clientesCadastrados);
			salvarEmArquivo();
		}
		
	}

	@Override
	public ICliente localizarClientePorCPF(String cpf) {
		// TODO Auto-generated method stub
		ICliente cliente = new ClientePessoaFisica(cpf);
		if(clientesCadastrados.contains(cliente)) {
			int index = clientesCadastrados.indexOf(cliente);
			cliente = clientesCadastrados.get(index);
		}
		return cliente;
	}

	@Override
	public ICliente localizarClientePorCNPJ(String cnpj) {
		// TODO Auto-generated method stub
		ICliente cliente = new ClientePessoaJuridica(cnpj);
		if(clientesCadastrados.contains(cliente)) {
			int index = clientesCadastrados.indexOf(cliente);
			cliente = clientesCadastrados.get(index);
			
		}
		return cliente;
	}

	@Override
	public void removerCliente(ICliente obj) {
		// TODO Auto-generated method stub
		if(clientesCadastrados.contains(obj)) {
			clientesCadastrados.remove(obj);
			salvarEmArquivo();
		}
		
	}
	private void salvarEmArquivo(){
		try {
			FileOutputStream fos = new FileOutputStream("p.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(clientesCadastrados);
			System.out.println("Dados inseridos");
			oos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void LerConteudoArquivo() {
		try {
			FileInputStream fis = new FileInputStream("p.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			Object obj = ois.readObject();
			clientesCadastrados = (ArrayList<ICliente>)obj;
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}
