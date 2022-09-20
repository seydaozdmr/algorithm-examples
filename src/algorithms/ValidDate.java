package algorithms;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ValidDate {
	private final int month;
	private final int day;
	private final int year;
	
	public ValidDate(int month,int day,int year) {
		//Nesneyi yaratırken tarihin geçerli olup olmadığını isDateValid metodu ile kontrol ediyoruz.
		if(!isDateValid(month,day,year)) {
			throw new RuntimeException("Geçersiz tarih");	
		}
		this.month=month;
		this.day=day;
		this.year=year;
	}
	
	public int month() {
		return month;
	}
	public int day() {
		return day;
	}
	public int year() {
		return year;
	}
	
	public String toString() {
		return month()+"/"+day()+"/"+year();
	}
	
	private boolean isDateValid (int month,int day,int year) {
		boolean valid=true;
		int[] aylarinMaksimumGunleri= {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		if(year<1 || month<1 || month>12 || day<1 || day>aylarinMaksimumGunleri[month-1]) {
			valid=false;
		}
		return valid;
	}
	private String dayOfTheWeek() {
		String[] days= {"Sunday","Monday","TuesDay","Wednesday","Thursday","Friday","Saturday"};
		
		Calendar calendar=Calendar.getInstance();
		Date date;
		try {
			//Burada vd nesnemizin toString() metodu ile oluşan tarihi date nesnesine SimpleDateFormat metodu ile atıyoruz.
			date=new SimpleDateFormat("MM/dd/yyyy").parse(this.toString());
			//System.out.println(this.toString());
			//Burada date nesnemizi takvim nesnemize aktarıyoruz.
			calendar.setTime(date);
		}catch(ParseException e) {
			e.printStackTrace();
		}
		int dayOfWeek=calendar.get(Calendar.DAY_OF_WEEK);
		System.out.println("Haftanın günü: "+dayOfWeek);
		return days[dayOfWeek-1];
	}

	public static void main(String[] args) {
		ValidDate vd=new ValidDate(12,18,1989);
		ValidDate invd = new ValidDate(2, 28, 2016);
		System.out.println(vd);
		System.out.println(invd);
		StdOut.println(vd.dayOfTheWeek());

	}

}
