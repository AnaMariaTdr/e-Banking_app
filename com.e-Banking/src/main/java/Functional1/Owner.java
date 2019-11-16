
package Functional1;

public class Owner {
	private String firstName;
	private String lastName;
	private String accNo;
	private int soldAmount;

	public String getAccNo() {
		return accNo;
	}

	public String setAccNo(String accNo) {
		return this.accNo = accNo;
	}

	public int getSoldAmount() {
		return soldAmount;
	}

	public void setSoldAmount(int soldAmount) {
		this.soldAmount = soldAmount;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Owner(String firstName, String lastName, String accNo, int soldAmount) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.accNo = accNo;
		this.soldAmount = soldAmount;
	}

	@Override
	public String toString() {
		return "FirstName=" + " " + firstName + " LastName= " + lastName + " AccountNumber= " + accNo + " soldAmount= "
				+ soldAmount;
	}

}
