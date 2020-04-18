package Beans;

import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@XmlRootElement
public class PaymentBean {

	// create variables
	int pamentID;
	private int cardNo;
	private String nameOnCard;
	private String expDate;
	private int cvc;

	public PaymentBean() {
		// TODO Auto-generated constructor stub
	}

	public PaymentBean(String doc) {

		JsonObject paymentObject = new JsonParser().parse(doc).getAsJsonObject();

		if (paymentObject.get("pamentID") != null) {
			this.pamentID = paymentObject.get("pamentID").getAsInt();
		}

		this.cardNo = paymentObject.get("cardNo").getAsInt();
		this.nameOnCard = paymentObject.get("nameOnCard").getAsString();
		this.expDate = paymentObject.get("expDate").getAsString();
		this.cvc = paymentObject.get("cvc").getAsInt();

	}

	public PaymentBean(int pamentID, int cardNo, String nameOnCard, String expDate, int cvc) {
		super();
		this.pamentID = pamentID;
		this.cardNo = cardNo;
		this.nameOnCard = nameOnCard;
		this.expDate = expDate;
		this.cvc = cvc;
	}

	public PaymentBean(int cardNo, String nameOnCard, String expDate, int cvc) {
		super();
		this.cardNo = cardNo;
		this.nameOnCard = nameOnCard;
		this.expDate = expDate;
		this.cvc = cvc;
	}

	public int getPamentID() {
		return pamentID;
	}

	public void setPamentID(int pamentID) {
		this.pamentID = pamentID;
	}

	public int getCardNo() {
		return cardNo;
	}

	public void setCardNo(int cardNo) {
		this.cardNo = cardNo;
	}

	public String getNameOnCard() {
		return nameOnCard;
	}

	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
	}

	public String getExpDate() {
		return expDate;
	}

	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}

	public int getCvc() {
		return cvc;
	}

	public void setCvc(int cvc) {
		this.cvc = cvc;
	}

}
