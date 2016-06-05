package homework.p6csv;



import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.*;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

@SuppressWarnings("serial")
public class prakt6csv extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/plain; charset=utf-8");
		
		if(req.getParameter("sel_vivodAll") != null){
			if(req.getParameter("sel_vivodAll").equals("allMar")){
				File file = new File("marGorTr.csv");
				CSVParser pars = CSVParser.parse(file, Charset.forName("utf-8"), CSVFormat.EXCEL);
				resp.getWriter().println("<div class='table-responsive'><table class='table table-striped'>");
				for (CSVRecord record:pars){
		    		resp.getWriter().println("<tr>");
		    		for(int i=0; i<record.size();i++){
		    			resp.getWriter().println("<td>"+record.get(i)+"</td>");
		    		}
		    		resp.getWriter().println("</tr>");
		    	}
		    	resp.getWriter().println("</table></div>");
		    	pars.close();
			}
			else if(req.getParameter("sel_vivodAll").equals("allAutoGrz")){
				File file = new File("GrzMTS.csv");
				CSVParser pars = CSVParser.parse(file, Charset.forName("utf-8"), CSVFormat.EXCEL);
				resp.getWriter().println("<div class='table-responsive'><table class='table table-striped'>");
				for (CSVRecord record:pars){
		    		resp.getWriter().println("<tr>");
		    		for(int i=0; i<record.size();i++){
		    			resp.getWriter().println("<td>"+record.get(i)+"</td>");
		    		}
		    		resp.getWriter().println("</tr>");
		    	}
		    	resp.getWriter().println("</table></div>");
		    	pars.close();
			}
			else if (req.getParameter("sel_vivodAll").equals("allPerevoz")){
				File file = new File("GrzMTS.csv");
				CSVParser pars = CSVParser.parse(file, Charset.forName("utf-8"), CSVFormat.EXCEL);
				List<CSVRecord> list = pars.getRecords();
				ArrayList<String> str = new ArrayList<String>();
				boolean k=false;
				str.add("Список перевозчиков:");
				for(int i=1; i<list.size(); i++){
					k=false;
					for(int j=0; j<str.size(); j++){
						if(list.get(i).get(1).toString().equals(str.get(j))){
							k=true;
						}
					}
					if(!k){
						str.add(list.get(i).get(1).toString());
					}
				}
				pars.close();
		    	resp.getWriter().println("<div class='table-responsive'><table class='table table-striped'>");
		    	for(int i=0; i<str.size();i++){
		    		resp.getWriter().println("<tr><td>"+str.get(i)+"</td></tr>");
		    	}
		    	resp.getWriter().println("</table></div>");
			}
		}
		else if(req.getParameter("sel_vivodFind") != null){
			
			if(!req.getParameter("option_txt").isEmpty()){
				
				File file = new File("marGorTr.csv");
				File file1 = new File("GrzMTS.csv");
				CSVParser pars = CSVParser.parse(file, Charset.forName("utf-8"), CSVFormat.EXCEL);
				List<CSVRecord> list = pars.getRecords();
				pars = CSVParser.parse(file1, Charset.forName("utf-8"), CSVFormat.EXCEL);
				List<CSVRecord> list1 = pars.getRecords();
				pars.close();
				
				if(req.getParameter("sel_vivodFind").equals("findPoGRZ")){
					String opt = req.getParameter("option_txt").toUpperCase(),
							nom = null;
					for (int i=0; i<list1.size(); i++){
						if(list1.get(i).get(7).replaceAll(" ", "").equals(opt)){
							nom = list1.get(i).get(2);
						}
					}
					if(nom != null){
						resp.getWriter().println("<div class='table-responsive'><table class='table table-striped'>");
						for (int i=0; i<list.size(); i++){
							if(list.get(i).get(1).equals(nom) && list.get(i).get(4).equals("Автобус")){
								resp.getWriter().println("<thead><tr>");
								for(int j=0; j<list.get(i).size();j++){
									resp.getWriter().println("<th>"+list.get(0).get(j)+"</th>");
					    		}
								resp.getWriter().println("</tr></thead><tbody>");
								resp.getWriter().println("<tr>");
					    		for(int j=0; j<list.get(i).size();j++){
					    			resp.getWriter().println("<td>"+list.get(i).get(j)+"</td>");
					    		}
					    		resp.getWriter().println("</tr>");
							}
						}
						resp.getWriter().println("</tbody></table></div>");
					}
					else{
						resp.getWriter().println("<div class='alert alert-danger' role='alert'><strong>Ошибка!</strong>К сожалению такой номер не найден</div>");
					}
				}
				else if(req.getParameter("sel_vivodFind").equals("findPoNoBus")){
					String opt = req.getParameter("option_txt").toUpperCase();
					int n = 0, n1=0;
					for (int i=0; i<list.size(); i++){
						if(list.get(i).get(1).replaceAll(" ", "").toUpperCase().equals(opt)){
							n++;
						}
					}
					if(n != 0){
						resp.getWriter().println("<div class='table-responsive'><table class='table table-striped'>");
						resp.getWriter().println("<thead><tr>");
						for(int j=0; j<list.get(0).size();j++){
							resp.getWriter().println("<th>"+list.get(0).get(j)+"</th>");
			    		}
						resp.getWriter().println("</tr></thead><tboby>");
						for (int j=0; j<list.size(); j++){
							if(list.get(j).get(1).replaceAll(" ", "").toUpperCase().equals(opt)){
								resp.getWriter().println("<tr>");
								for (int i = 0; i < list.get(j).size(); i++){
									resp.getWriter().println("<td>"+list.get(j).get(i)+"</td>");
								}
								resp.getWriter().println("</tr>");
							}	
						}
						resp.getWriter().println("</tbody></table></div>");
						for(int i=0; i<list1.size();i++){
							if(list1.get(i).get(2).replaceAll(" ", "").toUpperCase().equals(opt)){
								n1++;
							}
						}
						if(n1!=0){
							resp.getWriter().println("<div class='table-responsive'><table class='table table-striped'>");
							resp.getWriter().println("<thead><tr>");
							for(int j=0; j<list1.get(0).size();j++){
								resp.getWriter().println("<th>"+list1.get(0).get(j)+"</th>");
				    		}
							resp.getWriter().println("</tr></thead><tbody>");
								for (int j=0; j<list1.size(); j++){
									if(list1.get(j).get(2).replaceAll(" ", "").toUpperCase().equals(opt)){
										resp.getWriter().println("<tr>");
										for (int i = 0; i < list1.get(j).size(); i++){
											resp.getWriter().println("<td>"+list1.get(j).get(i)+"</td>");
										}
										resp.getWriter().println("</tr>");
									}	
								}
								resp.getWriter().println("</tbody></table></div>");
							
						}
						else{
							resp.getWriter().println("<div class='alert alert-danger' role='alert'><strong>Ошибка!</strong>К сожалению в базе нет списка автомобилей данного маршщрута</div>");
						}
					}	
					else{
						resp.getWriter().println("<div class='alert alert-danger' role='alert'><strong>Ошибка!</strong>К сожалению такой номер маршрута не найден</div>");
					}
				}
				else if(req.getParameter("sel_vivodFind").equals("findPoTrComp")){
					String opt = req.getParameter("option_txt").toUpperCase();
					int n=0,n1=0;					
					ArrayList<String> str = new ArrayList<String>();
					boolean k=false;
					for (int i=0; i<list1.size(); i++){
						if(list1.get(i).get(1).replaceAll(" ", "").toUpperCase().equals(opt)){
							n1++;
							k=false;
							for(int j=0; j<str.size(); j++){
								if(list1.get(i).get(2).replaceAll(" ", "").toString().equals(str.get(j))){
									k=true;
								}
							}
							if(!k){
								str.add(list1.get(i).get(2).replaceAll(" ", "").toString());
							}
						}
					}
					
					
					if(n1!=0){
						
						resp.getWriter().println("<div class='table-responsive'><table class='table table-striped'>");
						resp.getWriter().println("<thead><tr>");
						for(int j=0; j<list1.get(0).size();j++){
							resp.getWriter().println("<th>"+list1.get(0).get(j)+"</th>");
			    		}
						resp.getWriter().println("</tr></thead><tbody>");
							for (int j=0; j<list1.size(); j++){
								if(list1.get(j).get(1).replaceAll(" ", "").toUpperCase().equals(opt)){
									resp.getWriter().println("<tr>");
									for (int i = 0; i < list1.get(j).size(); i++){
										resp.getWriter().println("<td>"+list1.get(j).get(i)+"</td>");
									}
									resp.getWriter().println("</tr>");
								}	
							}
							resp.getWriter().println("</tbody></table></div>");
						
						for (int i=0; i<list.size(); i++){
							for(int j=0; j<str.size();j++){
								if(list.get(i).get(1).replaceAll(" ", "").equals(str.get(j))){
									n++;
								}
							}
						}
						if(n!=0){
							resp.getWriter().println("<div class='table-responsive'><table class='table table-striped'>");
							resp.getWriter().println("<thead><tr>");
							for(int j=0; j<list.get(0).size();j++){
								resp.getWriter().println("<th>"+list.get(0).get(j)+"</th>");
				    		}
							resp.getWriter().println("</tr></thead><tbody>");
							for (int i=0; i<list.size(); i++){
								for(int j=0; j<str.size();j++){
									if(list.get(i).get(1).replaceAll(" ", "").equals(str.get(j)) && list.get(i).get(4).equals("Автобус")){
										resp.getWriter().println("<tr>");
										for(int h=0; h<list.get(i).size(); h++){
											resp.getWriter().println("<td>"+list.get(i).get(h)+"</td>");
										}
										resp.getWriter().println("</tr>");
									}
								}
							}
							resp.getWriter().println("</tbody></table></div>");
						}
						else{
							resp.getWriter().println("<div class='alert alert-danger' role='alert'><strong>Ошибка!</strong>К сожалению описания маршрутов не найдено</div>");
						}
					}
					else{
						resp.getWriter().println("<div class='alert alert-danger' role='alert'><strong>Ошибка!</strong>К сожалению такой перевозчик не найден</div>");
					}
					
					
				}
			}
			else{
				resp.getWriter().println("<div class='alert alert-danger' role='alert'><strong>Пустое поле!</strong>Введите опцию</div>");
			}
		}
    }
	
}

