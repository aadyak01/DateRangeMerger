package logic;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DateMerger {
	
	public List<DateRange>mergeDates(List<DateRange>dateRanges){
		
		System.out.println("-----------------------");
		System.out.println("List Elements");
		System.out.println("-----------------------");
		for(DateRange d: dateRanges) {
			DateFormat formatter = new SimpleDateFormat("dd MMM yyyy");
			String sdate   = formatter.format(d.getStartDate());
			String edate = formatter.format(d.getEndDate());
			System.out.println(sdate+"-"+edate);
			
		}
		
		System.out.println("");
		System.out.println("-----------------------");
		System.out.println("OutPut List");
		System.out.println("-----------------------");
		for(int i=0; i<dateRanges.size();i++)
		{
			for(int j=i+1;j<dateRanges.size();j++) {
				if(dateRanges.get(i).getEndDate().after(dateRanges.get(j).getStartDate()) || dateRanges.get(i).getEndDate().equals(dateRanges.get(j).getStartDate())) {
					
					DateFormat formatter = new SimpleDateFormat("dd MMM yyyy");
					String endDate  = formatter.format(dateRanges.get(j).getEndDate());
					String startDate  = formatter.format(dateRanges.get(i).getStartDate());
					System.out.println(startDate+"-"+endDate);  
					    
				}
				
			}
			
		}
		
		return dateRanges;
	}
	
	public static void main(String[] args) throws ParseException {
		
		DateMerger dm= new DateMerger();
		List<DateRange> drList= new ArrayList<>();
	
		DateRange firstdr= new DateRange();
		DateFormat sdatefmtone = new SimpleDateFormat("dd MMM yyyy");
		Date startdateone = (Date)sdatefmtone.parse("01 JAN 2014");
		firstdr.setStartDate(startdateone);
		DateFormat edatefmtone = new SimpleDateFormat("dd MMM yyyy");
		Date enddateone = (Date)edatefmtone.parse("30 JAN 2014");
		firstdr.setEndDate(enddateone);
		
		DateRange seconddr= new DateRange();
		DateFormat sdatefmttwo = new SimpleDateFormat("dd MMM yyyy");
		Date startdatetwo = (Date)sdatefmttwo.parse("15 JAN 2014");
		seconddr.setStartDate(startdatetwo);
		DateFormat edatefmttwo = new SimpleDateFormat("dd MMM yyyy");
		Date enddatetwo = (Date)edatefmttwo.parse("15 FEB 2014");
		seconddr.setEndDate(enddatetwo);
		
		DateRange thirddr= new DateRange();
		DateFormat sdatefmtthree = new SimpleDateFormat("dd MMM yyyy");
		Date startdatethree = (Date)sdatefmtthree.parse("10 MAR 2014");
		thirddr.setStartDate(startdatethree);
		DateFormat edatefmtthree = new SimpleDateFormat("dd MMM yyyy");
		Date enddate3 = (Date)edatefmtthree.parse("15 APR 2014");
		thirddr.setEndDate(enddate3);
		
		DateRange fourthdr= new DateRange();
		DateFormat sdatefmtfour = new SimpleDateFormat("dd MMM yyyy");
		Date startdatefour = (Date)sdatefmtfour.parse("10 APR 2014");
		fourthdr.setStartDate(startdatefour);
		DateFormat edatefmtfour = new SimpleDateFormat("dd MMM yyyy");
		Date enddatefour = (Date)edatefmtfour.parse("15 MAY 2014");
		fourthdr.setEndDate(enddatefour);
		
		drList.add(firstdr);
		drList.add(seconddr);
		drList.add(thirddr);
		drList.add(fourthdr);
		
		//Dummy to add one more object to test
		
		/*DateRange fifthdr= new DateRange();
		DateFormat sdatefmtfifth = new SimpleDateFormat("dd MMM yyyy");
		Date startdatefifth = (Date)sdatefmtfifth.parse("15 MAY 2014");
		fifthdr.setStartDate(startdatefifth);
		DateFormat edatefmtfifth = new SimpleDateFormat("dd MMM yyyy");
		Date enddatefifth = (Date)edatefmtfifth.parse("15 JUN 2014");
		fifthdr.setEndDate(enddatefifth);
		
		drList.add(fifthdr);*/
		
		dm.mergeDates(drList);

}
}