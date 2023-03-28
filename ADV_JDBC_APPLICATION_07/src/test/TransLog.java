package test;

import java.io.Serializable;

public final class TransLog implements Serializable
{
	   private final int hAccNo = 123456799;
	   private final int bAccNo = 458745625;
	   private final int amt = 123456799;
	   private final String dateTime = "10-05-2023 12:35";
	   
	   public int gethAccNo() {
			return hAccNo;
		}
		public int getbAccNo() {
			return bAccNo;
		}
		public int getAmt() {
			return amt;
		}
		public String getDateTime() {
			return dateTime;
		}
}
