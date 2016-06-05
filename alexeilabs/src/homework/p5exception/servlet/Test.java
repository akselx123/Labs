package homework.p5exception.servlet;

import homework.p5exception.exceptions.*;

import java.io.IOException;

import javax.servlet.http.*;

@SuppressWarnings("serial")
public class Test extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/plain; charset=utf-8");
		
		//String var1 = req.getParameter("var1");
		//String var2 = req.getParameter("var2");	
		//resp.getWriter().println(result);
		String f_txt = req.getParameter("f_txt"),
				i_txt = req.getParameter("i_txt"),
				email_txt = req.getParameter("email_txt"),
				login_txt = req.getParameter("login_txt"),
				pass_txt = req.getParameter("pass_txt"),
				num_txt = req.getParameter("num_txt");
		try{
			parse(f_txt, i_txt, email_txt, login_txt, pass_txt, num_txt);
		}
		catch(TextExcep e){
			resp.getWriter().println("<div class='alert alert-danger' role='alert'>"+e.getMessage()+"</div>");
		}
		catch(NumberExcep e){
			resp.getWriter().println("<div class='alert alert-danger' role='alert'>"+e.getMessage()+"</div>");
		}
		catch(PassExcep e){
			resp.getWriter().println("<div class='alert alert-danger' role='alert'>"+e.getMessage()+"</div>");
		}
		catch(EmailExcep e){
			resp.getWriter().println("<div class='alert alert-danger' role='alert'>"+e.getMessage()+"</div>");
		}
		
		
	}
	
	public void parse(String f_txt, String i_txt, String email_txt, String login_txt,
			String pass_txt, String num_txt) throws TextExcep, NumberExcep, PassExcep, EmailExcep{
		
		if(f_txt.contains("'") || f_txt.contains("\"")){
			throw new TextExcep("Ковычки в поле Фамилия <br>");
		}
		if(i_txt.contains("'") || i_txt.contains("\"")){
			throw new TextExcep("Ковычки в поле Имя<br>");
		}
		if(login_txt.contains("'") || login_txt.contains("\"") || login_txt.contains(" ")){
			throw new TextExcep("Ковычки или пробел в поле Логин <br>");
		}
		if(!numInTxt(num_txt)){
			throw new NumberExcep("В строке число введено не число <br>");
		}
		if(email_txt.isEmpty()){
			throw new EmailExcep("Поле email пустое <br>");
		}
		else if(!chekEmail(email_txt)){
			throw new EmailExcep("В поле email ошибка <br>");
		}
		if(pass_txt.isEmpty()){
			throw new EmailExcep("Поле пароль пустое <br>");
		}
		else if(!chekPass(pass_txt)){
			throw new EmailExcep("Пароль не надежен <br>");
		}
		
		
	}
	public boolean numInTxt(String s){
		int k=0;
		for(int i=0; i < s.length();i++){
			if (s.codePointAt(i) > 47 && s.codePointAt(i) < 58){
				k++;
			}
		}
		if(k == s.length()){
			return true;
		}
		else {
		return false;}
	}
	public boolean chekEmail(String s){
		int tmp = 0, tmp1 = 0, b = 0;
		if(s.contains("'") || s.contains("\"") || s.contains(" ")){
			return false;
		}
		for(int i=0; i < s.length();i++){
			if (s.charAt(0) == '@'){
				return false;
			}
			if(s.charAt(i) == '@'){
				if(tmp == 1){
					return false;
				}
				tmp = 1;
			}
			else if(tmp == 1 && tmp1 == 0){
				if (s.charAt(i) == '.' && tmp1 == 0){
					return false;
				}
				else { 
					tmp1 = 1;
				}
			}
			else if(tmp1 == 1){
				if(s.charAt(i) == '.'){
					b = 1;
				}
			}
			
		}
		if(b==0){
			return false;
		}
		else {
			return true;
		}
		
	}
	public boolean chekPass(String s){
		if(s.length() > 7){
			for(int i=0; i < s.length();i++){
				if((s.codePointAt(i) > 64 && s.codePointAt(i) < 91) || (s.codePointAt(i) > 1039 && s.codePointAt(i) < 1072)){
					return true;
				}
			}
		}
		return false;
		
	}
}
