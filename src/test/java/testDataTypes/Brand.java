package testDataTypes;

public class Brand {
	public String brandName;
	public String displayName;
	public String brandCode;
	public PublishFromDate publishFromDate;
	public PublishToDate publishToDate;
	public String brandImage;
	
	public class PublishFromDate {
		public String fromMonth;
		public String fromDay;
		public String fromYear;
	}
	public class PublishToDate {
		public String toMonth;
		public String toDay;
		public String toYear;
	}
}
