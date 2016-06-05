package homework.p2;

import java.io.IOException;

import javax.servlet.http.*;

@SuppressWarnings("serial")
public class prakt2 extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/plain");
		
		String var1 = req.getParameter("var1");
		String var2 = req.getParameter("var2");	
		
		if (var1 == null && var2 == null)
		{
			resp.getWriter().println("<div class='alert alert-success' role='alert'>Hello, world</div>");
		}
		else if (var1 != null && var2 != null) {
		
			int i1 = Integer.parseInt(var1);
			int i2 = Integer.parseInt(var2);
		
			String operation = req.getParameter("operation");
			int result;
			if(operation.equals("0")){
				result = i1 + i2;
			} else if(operation.equals("1")){
				result = i1 - i2;
			} else if (operation.equals("2")){
				result = i1 * i2;
			} else {
				result = i1 / i2;
			}
			resp.getWriter().println("<div class='alert alert-success' role='alert'>"+result+"</div>");
		}
	}
}

