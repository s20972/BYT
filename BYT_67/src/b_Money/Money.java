package b_Money;

public class Money implements Comparable {
	private int amount = 0;
	private Currency currency;


	Money (Integer amount, Currency currency) {
		this.amount = amount;
		this.currency = currency;
	}

	public Integer getAmount() {
		return this.amount;
	}


	public Currency getCurrency() {
		return this.currency;
	}

	public String toString() {
		return String.format("(%s) (%s)",this.amount,this.currency.getName());
	}

	public Integer universalValue() {
		return this.currency.universalValue(this.amount);
	}

	public Boolean equals(Money other) {
		return universalValue().equals(other.universalValue());
	}

	public Money add(Money other) {
		if(this.currency == other.getCurrency()){
			return new Money(this.amount + other.getAmount(),this.currency);
		}
		return new Money(this.amount + other.universalValue(),this.currency);
	}

	public Money sub(Money other) {
		if(this.currency == other.getCurrency()){
			return new Money(this.amount - other.getAmount(),this.currency);
		}
		return new Money(this.amount - other.universalValue(),this.currency);
	}


	public Boolean isZero() {
		return this.amount == 0;
	}

	public Money negate() {
		return new Money(this.amount * (-1),this.currency);
	}


	public int compareTo(Object other) {
		return this.universalValue().compareTo(((Money)other).universalValue());
	}
}