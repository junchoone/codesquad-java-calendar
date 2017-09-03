package honux.calendar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class PlanItem {

	private HashMap <Date, String> planMap;
	
	public PlanItem() {
		planMap = new HashMap<Date, String>();
	}
	
	public void registerPlan(String strDate, String plan) throws ParseException {
		Date date = new SimpleDateFormat("yyyy-mm-dd").parse(strDate);
		planMap.put(date, plan);
	}
	public String searchPlan(String strDate) throws ParseException {
		Date date = new SimpleDateFormat("yyyy-mm-dd").parse(strDate);
		String plan = planMap.get(date);
		return plan;
	}
}
