package dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import util.HIbernateUtil;

public class EmpDao extends HIbernateUtil {

	/*
	 * public EmpDao getRep() { return new EmpDao(); }
	 */
	public Emph add(Emph emp) {

		// Session session = HIbernateUtil.createSesionFactory().getCurrentSession();
		Session session = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory().openSession();
		session.beginTransaction();
		session.save(emp);
		session.getTransaction().commit();
		session.close();

		return emp;
	}

	public List<Emp> findAll() {
		Session session = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory().openSession();
		session.beginTransaction();

		List<Emp> emp = null;
		try {
			emp = session.createQuery("from Emph").list();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		return emp;
	}

	public void delete(Integer id) {
		Session session = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory().openSession();
		session.beginTransaction();
		Emph emph = session.load(Emph.class, id);
		if (emph != null) {
			session.delete(emph);
		}
		session.getTransaction().commit();

	}

	public void update(Emp emp) {
		Session session = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory().openSession();
		session.beginTransaction();
		System.out.println(emp);
		// Emph emph = session.load(Emph.class, emp.getId());
		Emph emph = new Emph();

		/*
		 * if(emph != null) {
		 * 
		 * emph.setName(emp.getName()); }
		 */

		emph.setName(emp.getName());
		emph.setId(emp.getId());

		session.update(emph);
		session.getTransaction().commit();

	}

	public void feed(Feedh feed) {
		Session session = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory().openSession();
		session.beginTransaction();
		session.save(feed);
		session.getTransaction().commit();
		session.close();
	}

	public List<Emp> getAllFeed() {
		Session session = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory().openSession();
		session.beginTransaction();

		List<Emp> emp = null;
		try {
			emp = session.createQuery("from Feedh f order by f.id desc ").list();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		return emp;
	}
}
