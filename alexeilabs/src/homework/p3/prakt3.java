package homework.p3;

import java.io.IOException;

import javax.servlet.http.*;

@SuppressWarnings("serial")
public class prakt3 extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/plain; charset=utf-8");
		
			
		if(req.getParameter("n_txt")!= null && req.getParameter("m_txt")!= null){
			
		float n = Float.parseFloat(req.getParameter("n_txt")),
				m = Float.parseFloat(req.getParameter("m_txt")), r1, r2;
		
		r1 = 10.0f - n;
		r2 = 10.0f - m;
		if(r1<0)
			r1*=(-1);
		if(r2<0)
			r2*=(-1);
		if(r1<r2)
			resp.getWriter().println("<div class='alert alert-success' role='alert'>Число "+n+" ближе к 10</div>");
		else if(r1>r2)
			resp.getWriter().println("<div class='alert alert-success' role='alert'>Число "+m+" ближе к 10</div>");
		else
			resp.getWriter().println("<div class='alert alert-success' role='alert'>Числа "+n+" и "+m+" одинаково к 10</div>");
		}
//----------------------------------------------------------------		
		else if(req.getParameter("a_txt")!=null && req.getParameter("b_txt")!=null && req.getParameter("c_txt")!=null){
			
		int a1=Integer.parseInt(req.getParameter("a_txt")),
				b1=Integer.parseInt(req.getParameter("b_txt")), 
				c1=Integer.parseInt(req.getParameter("c_txt"));
		float diskr;
		diskr = (b1*b1) - (4*a1*c1);
		//resp.getWriter().println(diskr);
		double sqdis = Math.sqrt(diskr), x1, x2;
		if(diskr < 0)
			resp.getWriter().println("<div class='alert alert-danger' role='alert'>Корней нет</div>");
		else if (diskr == 0){
			x1 = ((-b1)+sqdis)/(2*a1);
			resp.getWriter().println("<div class='alert alert-success' role='alert'>Корнь: "+x1+"</div>");
		}
		else {
			x1 = ((-b1)+sqdis)/(2*a1);
			x2 = ((-b1)-sqdis)/(2*a1);
			resp.getWriter().println("<div class='alert alert-success' role='alert'>Корни: "+x1+"; "+x2+"</div>");
		}
		}
//--------------------------------------------------------------------
		else if(req.getParameter("mass_hid")!=null){
			
		int[][] mass;
		mass = new int[8][5];
//		(int)Math.random()*90+10;
		for(int r=0; r < 8;r++){
			for(int zj=0;zj<5;zj++){
				mass[r][zj]=(int)(10 + Math.random()*90);
			}
		}
		resp.getWriter().println("<div class='alert alert-success' role='alert'>");
		for(int r=0; r < 8;r++){
			for(int zj=0;zj<5;zj++){
				resp.getWriter().println(mass[r][zj]+"; ");
			}
			resp.getWriter().println("<br>");
		}
		resp.getWriter().println("</div>");
		}
//--------------------------------------------------------------------
		else if(req.getParameter("mass1_hid")!=null){
			
		int[][] mass1;
		mass1 = new int[5][8];
		int max;
//		(int)Math.random()*90+10;
		
		for(int r=0; r < 5;r++){
			for(int zj=0;zj<8;zj++){
				mass1[r][zj]=(int)((-99)+Math.random()*199);
			}
		}
		resp.getWriter().println("<div class='alert alert-success' role='alert'>");
		for(int r=0; r < 5;r++){
			max = mass1[r][0];
			for(int zj=0;zj<8;zj++){
				if(mass1[r][zj] > max)
						max = mass1[r][zj];
				resp.getWriter().println(mass1[r][zj]+"; ");
			}
			resp.getWriter().println("Max in str "+(r+1)+" = "+max+"<br>");
		}
		resp.getWriter().println("</div>");
		}
	
	
	}
}

