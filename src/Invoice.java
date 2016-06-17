
public class Invoice {
	
static String[][] invoicearr=new String[100][5];
	
    static BookDatabase database=new BookDatabase();
    
	static int count=0;
	static String sku;
	static int num=0;
	static String untaxable;
	static double price=0;
	static boolean isInstock=true;
	static String title;	
	static double pricetotal=0;
	
	static double taxablesubtotal=0;
	static double untaxablesubtotal=0;

	
	public static void createInvoice(String sku, int num, String untaxable)
	{
		title=database.searchBooks(sku).gettitle();
	    price=database.searchBooks(sku).getprice();		    
		isInstock=database.searchBooks(sku).getisInstock();
	    
		pricetotal=pricingtotal(price,isInstock,num);
		
			invoicearr[count][0]=sku;
			invoicearr[count][1]=Integer.toString(num);
			invoicearr[count][2]=title;
			invoicearr[count][3]=(String.format("%.02f",price));
			invoicearr[count][4]=String.format("%.02f",pricetotal);
	    
		count++;
		if(untaxable.equals("true"))
		{
			untaxablesubtotal+=pricetotal;
		}
		else if (untaxable.equals("false"))
		{
			taxablesubtotal+=pricetotal;
		}  
	}
	
	public static double pricingtotal(double price, boolean isInstock, int num)
	{
		if(isInstock)
		{
			return price*num;
		}
		else
		{
			System.out.println("The book is not instock");
		}
		return 0;
	}
}
