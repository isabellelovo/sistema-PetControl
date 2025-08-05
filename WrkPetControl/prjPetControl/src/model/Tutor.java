package model;

public class Tutor implements Serializable {
	
	final public static int TAM_CPF = 11;
	final public static int TAM_MAX_NOME = 100;
	final public static int VALOR_MIN_DIA = 1;
	final public static int VALOR_MAX_DIA = 31;
	final public static int VALOR_MIN_ANO = 1900;
	final public static int VALOR_ANO_ATUAL = java.time.Year.now().getValue();
	
	private String cpf;
	private String nome;
	private int diaNasc;
	private String mesNasc;
	private int anoNasc;
	
	public Tutor(String cpf, String nome, int diaNasc, String mesNasc, int anoNasc) throws ModelException {
		super();
		this.setCpf(cpf);
		this.setNome(nome);
		this.setDiaNasc(diaNasc);
		this.setMesNasc(mesNasc);
		this.setAnoNasc(anoNasc);
	}
	
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) throws ModelException{
		Tutor.validarCpf(cpf);
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) throws ModelException{
		Tutor.validarNome(nome);
		this.nome = nome;
	}

	public int getDiaNasc() {
		return diaNasc;
	}

	public void setDiaNasc(int diaNasc) throws ModelException{
		Tutor.validarDiaNasc(diaNasc);
		this.diaNasc = diaNasc;
	}

	public String getMesNasc() {
		return mesNasc;
	}

	public void setMesNasc(String mesNasc) throws ModelException{
		Tutor.validarMesNasc(mesNasc);
		this.mesNasc = mesNasc;
	}

	public int getAnoNasc() {
		return anoNasc;
	}

	public void setAnoNasc(int anoNasc) throws ModelException{
		Tutor.validarAnoNasc(anoNasc);
		this.anoNasc = anoNasc;
	}

	
	public static void validarCpf(String cpf) throws ModelException{
		
		int dv1 = 0, result1 = 0;
		int dv2 = 0, result2 = 0;
		int mult1 = 10, mult2 = 11;
		char c;
		
		if (cpf == null || cpf.length() == 0)
			throw new ModelException("O CPF não pode ser nulo.");
		
		if (cpf.length() != TAM_CPF)
			throw new ModelException("O CPF deve ter " + TAM_CPF + " caracteres.");
		
		for (int i = 0; i < cpf.length(); i++) {
			if (!Character.isDigit(c))
				throw new ModelException("O CPF deve ser numérico.");
		}
		
		// Validação do 1º Dígito Verificador
			
		for(int i = 0; i < 9 ; i++) {
			c = cpf.charAt(i);
			dv1 = c - 48;
			
			result1 += dv1 * mult1;
			mult1--;
		}
		
		result1 = (result1 * 10) % 11;
		if(result1 == 10)
			result1 = 0;
		
		// Validação do 2º Dígito Verificador
		
		for(int i = 0; i < 10 ; i++) {
			c = cpf.charAt(i);
			dv2 = c - 48;
			
			result2 += dv2 * mult2;
			mult2--;
		}
		
		result2 = (result2 * 10) % 11;
		if(result2 == 10)
			result2 = 0;
		
		if(result1 != cpf.charAt(9) - 48 && result2 != cpf.charAt(10) - 48)
			throw new ModelException("O CPF informado é inválido.");
	}
	
	public static void validarNome(String nome) throws ModelException{
		
		if (nome == null || nome.length() == 0)
			throw new ModelException("O Nome não pode ser nulo.");
		
		if (nome.length() > TAM_MAX_NOME)
			throw new ModelException("O Nome deve ter até "+ TAM_MAX_NOME +" caracteres.");
		
		for (int i = 0; i < nome.length(); i++) {
			char c = nome.charAt(i);
			
			if (!Character.isAlphabetic(c) && !Character.isSpaceChar(c))
				throw new ModelException("O Nome tem um caractere inválido '" + c + "' na posição " + i + ".");
		}
	}
	
	public static void validarDiaNasc(int diaNasc) throws ModelException{
		
		if (diaNasc < VALOR_MIN_DIA || diaNasc > VALOR_MAX_DIA)
			throw new ModelException("O Dia do Nascimento deve estar entre " + VALOR_MIN_DIA + " e " + VALOR_MAX_DIA + ".");
	}
	
	public static void validarMesNasc(String mesNasc) throws ModelException{
		
		if (mesNasc == null)
			throw new ModelException("O Mês do Nascimento não pode ser nulo.");
		
		//TODO Se as opções não derem certo, fazer verificação
	}
	
	public static void validarAnoNasc(int anoNasc) throws ModelException{

		if (anoNasc < VALOR_MIN_ANO || anoNasc > VALOR_ANO_ATUAL)
			throw new ModelException("O Ano do Nascimento deve ser entre " + VALOR_MIN_ANO + " e " + VALOR_ANO_ATUAL + ".");
	}
}
