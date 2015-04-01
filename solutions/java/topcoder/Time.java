package topcoder;

public class Time {
	public String whatTime(int seconds) {
		int hours = seconds / 60 / 60;
		int fullHoursInSeconds = hours * 60 * 60;
		int minutes = (seconds - fullHoursInSeconds) / 60;
		int fullMinutesInSeconds = minutes * 60;
		int secs = seconds - fullHoursInSeconds - fullMinutesInSeconds;
		
		return "" + hours + ":" + minutes + ":" + secs;
	}
	
	public static void main(String[] args) {
		Time time = new Time();
		
		System.out.println(time.whatTime(3661));
		System.out.println(time.whatTime(86399));
	}
}