package model;

// SQL Create Table ::
/*	create table customer(
 *  
 *  create table customer(
  	cust_id int primary key auto_increment,
	name varchar(256),
	phone varchar(256),
	rewardPoints int,
	inDate date
	);
 */
/*
 * SQL Insert data int rows and colums
 * insert into customer values(0, 'John', '7118', 'john@example.com');
 */
public class customer {
	
	public int cust_id;
	public String name;
	public String phone;
	public int rewardPoints;
	public String inDate;
	public customer(){
		
	}
	public customer(int cust_id, String name, String phone, int rewardPoints, String inDate) {
		super();
		this.cust_id = cust_id;
		this.name = name;
		this.phone = phone;
		this.rewardPoints = rewardPoints;
		this.inDate = inDate;
	}
	@Override
	public String toString() {
		return "customer [cust_id=" + cust_id + ", name=" + name + ", phone=" + phone + ", rewardPoints=" + rewardPoints
				+ ", inDate=" + inDate + "]";
	}
	
	public String sql() {
		return "insert into Customer values(0, '"+name+"', '"+phone+"', "+rewardPoints+" , '"+inDate+"');";
	}
	
}


	
	

