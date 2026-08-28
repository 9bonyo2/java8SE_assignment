package mylab.book.entity;


public class Magazine extends Publication {
	
	private String publishingPeriod;

	public Magazine() {
	}

	public Magazine(String title, String publishingDate, int page, int price, String publishingPeriod) {
		super(title, publishingDate, page, price);
		this.publishingPeriod = publishingPeriod;
	}

	public String getPublishingPeriod() {
		return publishingPeriod;
	}

	public void setPublishingPeriod(String publishingPeriod) {
		this.publishingPeriod = publishingPeriod;
	}

	@Override
	public String toString() {
		return super.toString()	+ " [잡지] 발행주기:" + publishingPeriod+ ", " + getPage() + "쪽"+ ", " + getPrice() + "원"	+ ", 출판일:" + getPublishingDate();
	}
}