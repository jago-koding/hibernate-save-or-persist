package id.jagokoding;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class DemoSaveOrUpdate {

	public static void main(String[] args) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();

			Customer customer = new Customer();
			customer.setName("MARLINA");
			session.saveOrUpdate(customer);

			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		HibernateUtil.shutdown();
	}
}
