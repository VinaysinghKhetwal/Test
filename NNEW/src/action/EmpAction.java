package action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import dao.Emp;
import dao.EmpDao;
import dao.Emph;
import dao.Feedh;

public class EmpAction extends ActionSupport implements ModelDriven<Emp> {

	Emp e;
	EmpDao empD = new EmpDao();
	List<Emp> empList;
	
	
	public List<Emp> getEmpList() {
		return empList;
	}

	public void setEmpList(List<Emp> empList) {
		this.empList = empList;
	}

	@Override
	public Emp getModel() {

		e = new Emp();
		return e;
	}

	public String add() {
		try {
			Emph emph = new Emph();
			emph.setName(e.getName());
			emph.setPassword(e.getPassword());
			System.out.println(emph);
			empD.add(emph);
			getAll();
			return "success";
		} catch (Exception e) {

			e.printStackTrace();
		}
		return "error";
	}

	public String getAll() {
		try {
		 empList =	empD.findAll();
		 
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	
	public String delete() {
		try {
			empD.delete(e.getId());
			getAll();
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	
	public String update() {
		try {
			empD.update(e);
			getAll();
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	
	public  String feed()
	{
		Feedh feedh = new Feedh();
		feedh.setTextArea(e.getTextArea());
		empD.feed(feedh);
		getAllFeed();
		return "success";

	}
	public String getAllFeed()
	{
		empList =empD.getAllFeed();
		System.out.println(empList);
		return "success";

	}
	
	
}
