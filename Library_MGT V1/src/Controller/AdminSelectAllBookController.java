package Controller;



import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.BookDAO;
import DTO.BookDTO;

/**
 * Servlet implementation class SelectAllBookController
 */
public class AdminSelectAllBookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		PrintWriter pw=response.getWriter();
		BookDAO dao=new BookDAO();
		BookDTO dto= new BookDTO();
		String message="";
		
		response.setContentType("text/html");
		List<BookDTO> books=dao.selectAll();
		request.setAttribute("Books", books);
		
			for(BookDTO book:books)
			{
				/*System.out.println(book.getBookName());
				System.out.println("*********************");*/
				String b1=book.getBookName();
				//System.out.println(b1);
			
		
		request.setAttribute("b1", b1);
			}
		request.getRequestDispatcher("AdminSelectAllBook.jsp").forward(request, response);
		
		
	}

}
