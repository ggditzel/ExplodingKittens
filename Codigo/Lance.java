import br.ufsc.inf.leobr.cliente.Jogada;


// Jogada apenas indica um objeto que pode ser transmitido via rede, nao possui metodos

public class Lance implements Jogada {
	
	// incluir todos os atributos necessarios para definir a jogada
	// serao enviados como um unico objeto via rede
	// quem receber deve dar um cast para (Lance) para recuperar os dados
	
	String msgTeste = "";
	
	public Lance(String msgTeste) {
		super();
		this.msgTeste = msgTeste;
		// todos os dados que precisam ser enviados a cada jogada vao ser setados aqui
	}
	
	public String getMessage() {
		return msgTeste;
	}
	
	public void setMessage(String msg) {
		this.msgTeste = msg;
	}

}
