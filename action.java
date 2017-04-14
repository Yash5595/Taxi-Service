
public class action {
	public static void main(String[] args) throws Exception{
		
	TaxiService t = new TaxiService();
	
	t.performAction("edge indiagate chanakyapuri 30");
	t.performAction("edge indiagate AIIMS 30");
	t.performAction("edge indiagate lajpatnagar 50");
	t.performAction("edge chanakyapuri AIIMS 20");
	t.performAction("edge AIIMS lajpatnagar 15");
	t.performAction("edge chanakyapuri iitmaingate 50");
	t.performAction("edge AIIMS iitmaingate 30");
	t.performAction("edge lajpatnagar iitmaingate 40");
	t.performAction("taxi shaktimaan iitmaingate");
	t.performAction("taxi batman lajpatnagar");
	t.performAction("taxi superman indiagate");
	t.performAction("printTaxiPosition 0");
	t.performAction("customer iitmaingate lajpatnagar 0 chanakyapuri AIIMS 0 1");
	t.performAction("customer chanakyapuri indiagate 0 chanakyapuri AIIMS 19 52");
	t.performAction("customer AIIMS lajpatnagar 0 lajpatnagar AIIMS 0 70");
	t.performAction("printTaxiPosition 149");
	t.performAction("customer indiagate chanakyapuri 0 chanakyapuri indiagate 0 150");
	t.performAction("customer lajpatnagar indiagate 0 indiagate lajpatnagar 1 150");
	t.performAction("customer lajpatnagar iitmaingate 0 iitmaingate lajpatnagar 0 150");
	t.performAction("printTaxiPosition 151");
	t.performAction("indiagate AIIMS 0  AIIMS indiagate 0 170");
	t.performAction("printTaxiPosition 171");
	t.performAction("printTaxiPosition 400");
	
	}
}
