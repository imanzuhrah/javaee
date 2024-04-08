package controller;

import java.io.IOException;
import java.util.ArrayList;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.DAO;
import model.JavaBeans;

// TODO: Auto-generated Javadoc
/**
 * Servlet implementation class Controller.
 */
//Mapeamento:
@WebServlet(urlPatterns = { "/Controler", "/main", "/lista", "/insert", "/select", "/update", "/delete", "/report"})
public class Controller extends HttpServlet {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The dao. */
	DAO dao = new DAO();
	
	/** The contato. */
	JavaBeans contato = new JavaBeans();

	/**
	 * Instantiates a new controller.
	 */
	public Controller() {
		super();
	}

	/**
	 * Do get.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());

		// Teste de Conexao
		// dao.testeConexao();

		String requisicao = request.getServletPath();
		System.out.println(requisicao);
		if (requisicao.equals("/main")) {
			contatos(request, response);
		}

		else if (requisicao.equals("/insert")) {
			novoContato(request, response);
		}
		// Outra forma de fazer (/lista):

		/*
		 * if(requisicao.equals("/lista")) { lista(request, response);
		 * 
		 * } }
		 */
		else if (requisicao.equals("/lista")) {
			listacontatos(request, response);
		} else if (requisicao.equals("/select")) {
			selecionarContato(request, response);
		} else if (requisicao.equals("/update")) {
			editarContato(request, response);		
		
		} else if (requisicao.equals("/delete")) {
			excluirContato(request, response);	
		}else if (requisicao.equals("/report")) {
			gerarRelatorio(request, response);
		}else {
			response.sendRedirect("index.html");
		}
	}

	/**
	 * Contatos.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void contatos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// response.sendRedirect("agenda.jsp");
		// Criando um objeto que irá receber os dados da Classe JavaBeans
		ArrayList<JavaBeans> lista = dao.listarContatos();
		// Encaminhamento do objetro lista ao documento agenda.jsp

		request.setAttribute("contatos", lista);
		RequestDispatcher rd = request.getRequestDispatcher("agenda.jsp");
		rd.forward(request, response);

		// Teste de recebimento de lista
		/*
		 * for (int i=0; i<lista.size(); i++) {
		 * System.out.println(lista.get(i).getIdcon());
		 * System.out.println(lista.get(i).getNome());
		 * System.out.println(lista.get(i).getFone());
		 * System.out.println(lista.get(i).getFone2());
		 * System.out.println(lista.get(i).getFone3());
		 * System.out.println(lista.get(i).getEmail());
		 * 
		 * }
		 */
		// background: no repeat url(imagem/agendaimg.jpg);
	}

	/**
	 * Listacontatos.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void listacontatos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("ListadeContatos.jsp");

	}

	/**
	 * Selecionar contato.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void selecionarContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Recebimento do id de contato que será editado.
		String idcon = request.getParameter("idcon");

		// System.out.println(idcon);
		contato.setIdcon(Integer.parseInt(idcon));
		// Executar o método selecionarContato pelo DAO.
		dao.selecaoContato(contato);

		// Teste de recebimento
		/*
		 * System.out.println(contato.getIdcon());
		 * System.out.println(contato.getNome()); System.out.println(contato.getFone());
		 * System.out.println(contato.getFone2());
		 * System.out.println(contato.getFone3());
		 * System.out.println(contato.getEmail());
		 */

		// Setar (configurar) os atributos ao formulário com o conteúdo da Classe
		// JavaBeans
		request.setAttribute("idcon", contato.getIdcon());
		request.setAttribute("nome", contato.getNome());
		request.setAttribute("fone", contato.getFone());
		request.setAttribute("fone2", contato.getFone2());
		request.setAttribute("fone3", contato.getFone3());
		request.setAttribute("email", contato.getEmail());

		// Encaminhar ao documento Editar.jsp
		RequestDispatcher rd = request.getRequestDispatcher("editar.jsp");
		rd.forward(request, response);

	}

	/**
	 * Novo contato.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	// Novo Contato
	protected void novoContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Teste de recebimento de dados do formulário teladecadastro.html
		System.out.println(request.getParameter("nome"));
		System.out.println(request.getParameter("fone"));
		System.out.println(request.getParameter("fone2"));
		System.out.println(request.getParameter("fone3"));
		System.out.println(request.getParameter("email"));

		// Setar os atributos da Classe JavaBeans.
		contato.setNome(request.getParameter("nome"));
		contato.setFone(request.getParameter("fone"));
		contato.setFone2(request.getParameter("fone2"));
		contato.setFone3(request.getParameter("fone3"));
		contato.setEmail(request.getParameter("email"));

		// Invocar o método inserirContato passando o objeto contato.
		dao.inserirContato(contato);
		// Redirecionar para a página agenda.jsp
		response.sendRedirect("main");
	}

	/**
	 * Editar contato.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void editarContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Teste de recebimento para edição após precionar o botão salvar.
		/*
		 * System.out.println(request.getParameter("idcon"));
		 * System.out.println(request.getParameter("nome"));
		 * System.out.println(request.getParameter("fone"));
		 * System.out.println(request.getParameter("fone2"));
		 * System.out.println(request.getParameter("fone3"));
		 * System.out.println(request.getParameter("email"));
		 */

		// Settar os atributos do JavaBeans.
		contato.setIdcon(Integer.parseInt(request.getParameter("idcon")));
		contato.setNome(request.getParameter("nome"));
		contato.setFone(request.getParameter("fone"));
		contato.setFone2(request.getParameter("fone2"));
		contato.setFone3(request.getParameter("fone3"));
		contato.setEmail(request.getParameter("email"));

		// executar o método alterarContato da classe DAO.
		dao.alterarContato(contato);
		// redirecionar para o documento agenda.jsp (salvar alterações)
		response.sendRedirect("main");
	}

	/**
	 * Excluir contato.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void excluirContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idcon = request.getParameter("idcon");
		contato.setIdcon(Integer.parseInt(idcon));

		//System.out.println(request.getParameter("idcon"));
		
		dao.excluirContato(contato);
		response.sendRedirect("main");
	}

	/**
	 * Gerar relatorio.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void gerarRelatorio(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//Gerar Relatório em PDF.
		Document documento = new Document();
		
		try {
			//Tipo de Conteúdo.
			response.setContentType("application/pdf");
			//nome do documento.
			response.addHeader("Content-Disposition", "inline; filename="+"contatos.pdf");
			//Criar o documento.
			
			PdfWriter.getInstance(documento, response.getOutputStream());
			//abrir o documento -> conteúdo.
			documento.open();
			documento.add(new Paragraph("Lista de Contatos: "));
			documento.add(new Paragraph(" "));
			//criar a tabela no documento.
			PdfPTable tabela = new PdfPTable(5);
			//cabeçalho.
			PdfPCell col1 = new PdfPCell(new Paragraph("Nome"));
			PdfPCell col2 = new PdfPCell(new Paragraph("DDI"));
			PdfPCell col3 = new PdfPCell(new Paragraph("DDD"));
			PdfPCell col4 = new PdfPCell(new Paragraph("Telefone"));
			PdfPCell col5 = new PdfPCell(new Paragraph("Email"));
			tabela.addCell(col1);
			tabela.addCell(col2);
			tabela.addCell(col3);
			tabela.addCell(col4);
			tabela.addCell(col5);
			//popular tabela com os contatos;
			ArrayList<JavaBeans> lista = dao.listarContatos();
			for(int i= 0; i<lista.size(); i++) {
				tabela.addCell(lista.get(i).getNome());
				tabela.addCell(lista.get(i).getFone());
				tabela.addCell(lista.get(i).getFone2());
				tabela.addCell(lista.get(i).getFone3());
				tabela.addCell(lista.get(i).getEmail());
			}
			
			documento.add(tabela);
			
			documento.close();
			
		} catch (Exception e) {
			documento.close();
		}
		
		//dao.gerarRelatorio(contato);
		//response.sendRedirect("report");
	}
}

