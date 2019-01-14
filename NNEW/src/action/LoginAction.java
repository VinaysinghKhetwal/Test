package action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import com.opensymphony.xwork2.ModelDriven;

import dao.Emp;
import dao.Emph;

public class LoginAction implements SessionAware,ModelDriven<Emp>{

	Emp emp;
	
	private SessionMap<String, Object> sessionMap;
	@Override
	public Emp getModel() {
		// TODO Auto-generated method stub
		return emp = new Emp(); 
	}

	@Override
	public void setSession(Map<String, Object> map) {
		// TODO Auto-generated method stub
		sessionMap = (SessionMap<String, Object>) map;
	}
	
	public String login()
	{
		Session session = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory().openSession();
		List<Emph> empl = null;
		empl =	session.createQuery("from Emph").list();
		System.out.println(empl);
		
		for(Emph e :empl)
		{
			if(emp.getName().equalsIgnoreCase(e.getName()) && emp.getPassword().equalsIgnoreCase(e.getPassword()))
			{
				return "success";
			}
		}
				return "error";
	}
	
}
