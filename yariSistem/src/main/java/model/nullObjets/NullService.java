package model.nullObjets;

import model.order.Product;
import model.order.Service;

public class NullService extends Service {
	
	public static Service build() {
		return new NullService();
	}
	
	public NullService() {
		super(0, "", 0.0, 0.0, 0.0, false);
	}
	
	public boolean isNull() {
		return true;
	}

}
