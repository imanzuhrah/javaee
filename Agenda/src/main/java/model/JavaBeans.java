package model;

// TODO: Auto-generated Javadoc
/**
 * The Class JavaBeans.
 */
public class JavaBeans {
	
	/** The idcon. */
	//Atributos do Servidor do BD dbagenda
	private int idcon;
	
	/** The nome. */
	private String nome;
	
	/** The fone. */
	private String fone;
	
	/** The fone 2. */
	private String fone2;
	
	/** The fone 3. */
	private String fone3;
	
	/** The email. */
	private String email;
	
	//Source - Generate Constructors from Superclass (Construtor Superclasse).
	
	/**
	 * Instantiates a new java beans.
	 */
	public JavaBeans() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//Source - Generate Constructor using Fields (Construtor com campos).
	
	/**
	 * Instantiates a new java beans.
	 *
	 * @param idcon the idcon
	 * @param nome the nome
	 * @param fone the fone
	 * @param fone2 the fone 2
	 * @param fone3 the fone 3
	 * @param email the email
	 */
	public JavaBeans(int idcon, String nome, String fone, String fone2, String fone3, String email) {
		super();
		this.idcon = idcon;
		this.nome = nome;
		this.fone = fone;
		this.fone2 = fone2;
		this.fone3 = fone3;
		this.email = email;
	}



	/**
	 * Gets the idcon.
	 *
	 * @return the idcon
	 */
	//Métodos Getters and Setters:
	public int getIdcon() {
		return idcon;
	}
	
	/**
	 * Sets the idcon.
	 *
	 * @param idcon the new idcon
	 */
	public void setIdcon(int idcon) {
		this.idcon = idcon;
	}
	
	/**
	 * Gets the nome.
	 *
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}
	
	/**
	 * Sets the nome.
	 *
	 * @param nome the new nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/**
	 * Gets the fone.
	 *
	 * @return the fone
	 */
	public String getFone() {
		return fone;
	}
	
	
	/**
	 * Gets the fone 2.
	 *
	 * @return the fone 2
	 */
	public String getFone2() {
		return fone2;
	}

	/**
	 * Sets the fone 2.
	 *
	 * @param fone2 the new fone 2
	 */
	public void setFone2(String fone2) {
		this.fone2 = fone2;
	}

	/**
	 * Gets the fone 3.
	 *
	 * @return the fone 3
	 */
	public String getFone3() {
		return fone3;
	}

	/**
	 * Sets the fone 3.
	 *
	 * @param fone3 the new fone 3
	 */
	public void setFone3(String fone3) {
		this.fone3 = fone3;
	}

	/**
	 * Sets the fone.
	 *
	 * @param fone the new fone
	 */
	public void setFone(String fone) {
		this.fone = fone;
	}
	
	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * Sets the email.
	 *
	 * @param email the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
		
}

