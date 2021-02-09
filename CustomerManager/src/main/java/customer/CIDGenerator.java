package customer;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.query.Query;

public class CIDGenerator implements IdentifierGenerator {
	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
// TODO Auto-generated method stub
		String cid = "C-001";

		try {
			Session s = (Session) session;
			Transaction tx = s.getTransaction();
			Query q = s.createQuery("from Customer cus");
			int size = q.list().size();

			if (size != 0) {
				Query query = s.createQuery("select max(cust.id) from Customer cust");
				List list = query.list();
				System.out.println(list.size());

				Object o = list.get(0);
				System.out.println(o);

				String id = "";
				id = o.toString();
				String p2 = id.substring(2);
				int x = Integer.parseInt(p2);
				x = x + 1;

				if (x <= 9) {
					cid = "C-00" + x;
				} else if (x <= 99) {
					cid = "C-0" + x;
				} else if (x <= 999) {
					cid = "C-" + x;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cid;
	}
}