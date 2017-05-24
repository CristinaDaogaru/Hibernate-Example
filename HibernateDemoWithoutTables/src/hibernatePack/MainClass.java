package hibernatePack;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MainClass {

	public static void main(String[] args) {

		new MainClass().updateInfo();

	}

	public void insertInfo() {
		Configuration con = new Configuration();
		con.configure("hibernate.cfg.xml");

		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();

		Transaction tr = session.beginTransaction();

		UserPojo pojo = new UserPojo();
		pojo.setId(140);
		pojo.setName("cotulbea");
		pojo.setEmail("cotulbea@gmail");
		pojo.setAddress("craiova");

		session.save(pojo);
		tr.commit();
		System.out.println("Insertion success...");

	}

	public void updateInfo() {

		Configuration con = new Configuration();
		con.configure("hibernate.cfg.xml");

		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();

		Transaction tr = session.beginTransaction();
		Object ob = session.load(UserPojo.class, new Integer(140));

		UserPojo pojo = (UserPojo) ob;
		pojo.setName("cotulbea cosmin");

		tr.commit();
		System.out.println("object updation is success...");

		session.close();
		sf.close();

	}
}
