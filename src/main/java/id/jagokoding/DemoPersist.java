package id.jagokoding;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class DemoPersist {

	public static void main(String[] args) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();

			Customer customer = new Customer();
			customer.setName("PERIPURNAMA");
			session.persist(customer);

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
