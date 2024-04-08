package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class DAO.
 */
public class DAO {
	// Módulo de Conexão
	// Parâmetros para Conexão

	/** The driver. */
	private String driver = "com.mysql.cj.jdbc.Driver";
	
	/** The url. */
	private String url = "jdbc:mysql://127.0.0.1:3306/dbagenda?useTimezone=true&serverTimezone" + "=UTC";
	
	/** The user. */
	private String user = "root";
	
	/** The password. */
	private String password = "backend@24";

	/**
	 * Conectar.
	 *
	 * @return the connection
	 */
	// Método de conexão
	private Connection conectar() {
		Connection con = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
		// TODO: handle exception
	}

	/**
	 * Inserir contato.
	 *
	 * @param contato the contato
	 */
	// CRUD CREATE
	public void inserirContato(JavaBeans contato) {
		String create = "insert into contatos(nome, fone, fone2, fone3, email) values (?, ?, ?, ?, ?)";
		try {
			// abrir a conexão
			Connection con = conectar();
			// Preparar a consulta (Query) para a execução no Banco de Dados.
			PreparedStatement pst = con.prepareStatement(create);
			// Substituir os parâmetros (?) pelo conteúdo dos atributos da Classe JavaBeans.
			pst.setString(1, contato.getNome());
			pst.setString(2, contato.getFone());
			pst.setString(3, contato.getFone2());
			pst.setString(4, contato.getFone3());
			pst.setString(5, contato.getEmail());

			// Executar a Query (Ctrl + Enter).
			pst.executeUpdate();
			// Encerrar a conexão com o Banco.
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// CRUD UPDATE
	/**
	 * Selecao contato.
	 *
	 * @param contato the contato
	 */
	// Selecionar contato
	public void selecaoContato(JavaBeans contato) {
		String read2 = "select * from contatos where idcon = ?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read2);
			pst.setInt(1, contato.getIdcon());
			ResultSet rs = pst.executeQuery();

			// Enquanto houver dados, fazer a seleção, laço WHILE p/ receber dados do BD e
			// enviar p/ a classe JavaBeans.
			while (rs.next()) {
				// Setar as variáveis JavaBeans
				contato.setIdcon(rs.getInt(1));
				contato.setNome(rs.getString(2));
				contato.setFone(rs.getString(3));
				contato.setFone2(rs.getString(4));
				contato.setFone3(rs.getString(5));
				contato.setEmail(rs.getString(6));

			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);

		}
	}

	/**
	 * Alterar contato.
	 *
	 * @param contato the contato
	 */
	public void alterarContato(JavaBeans contato) {
		String atualizar = "update contatos set nome=?, fone=?, fone2=?, fone3=?, email=? where idcon=?;";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(atualizar);
			pst.setString(1, contato.getNome());
			pst.setString(2, contato.getFone());
			pst.setString(3, contato.getFone2());
			pst.setString(4, contato.getFone3());
			pst.setString(5, contato.getEmail());
			pst.setInt(6, contato.getIdcon());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);

		}
	}

	// Teste de conexão
	/*
	 * public void testeConexao() { try { Connection con = conectar();
	 * System.out.println(con); con.close(); } catch (Exception e) {
	 * System.out.println(e);
	 * 
	 * } }
	 */

	// CRUD --> READ

	/**
	 * Listar contatos.
	 *
	 * @return the array list
	 */
	public ArrayList<JavaBeans> listarContatos() {

		// Criando um objeto para acessa a Classe JavaBeans
		ArrayList<JavaBeans> contatos = new ArrayList<>();
		// Ordenar as colunas da tabela.
		String read = "select * from contatos order by idcon";

		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();
			// O laço abaixo será executado enquanto houver contatos
			while (rs.next()) {
				// variáveis de apoio que recebem os dados do banco
				int idcon = rs.getInt(1);
				String nome = rs.getString(2);
				String fone = rs.getString(3);
				String fone2 = rs.getString(4);
				String fone3 = rs.getString(5);
				String email = rs.getString(6);

				// Populando o ArrayList
				contatos.add(new JavaBeans(idcon, nome, fone, fone2, fone3, email));
			}
			con.close();
			return contatos;

		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	/**
	 * Excluir contato.
	 *
	 * @param contato the contato
	 */
	public void excluirContato(JavaBeans contato) {
		
		String del = "delete from contatos where idcon=?;";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(del);
			pst.setInt(1, contato.getIdcon());
			pst.executeUpdate();
			con.close();

		} catch (Exception e) {
			System.out.println(e);

		}

	}

	/**
	 * Gerar relatorio.
	 *
	 * @param contato the contato
	 */
	public void gerarRelatorio(JavaBeans contato) {
		String rep = "";

		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(rep);
			ResultSet rs = pst.executeQuery();
			// O laço abaixo será executado enquanto houver contatos
			while (rs.next()) {
				// variáveis de apoio que recebem os dados do banco
				int idcon = rs.getInt(1);
				String nome = rs.getString(2);
				String fone = rs.getString(3);
				String fone2 = rs.getString(4);
				String fone3 = rs.getString(5);
				String email = rs.getString(6);
			}
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
}

