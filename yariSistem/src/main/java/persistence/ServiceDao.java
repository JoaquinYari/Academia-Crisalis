package persistence;

import model.order.Service;
import persistence.commons.GenericDao;

public interface ServiceDao extends GenericDao<Service> {
	
	Service findByName(String name);

}
