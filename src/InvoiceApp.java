import java.util.Scanner;

public class InvoiceApp {

     static Scanner sc=new Scanner(System.in);
	
	static BookDatabase database=new BookDatabase();
	
	static Invoice invoice=new Invoice();
	static String sku;
	static int num;
	static String untaxable;
	
	
	public static void main(String[] args)
	{
		database.createBookDatabase();
		
		while(1>0)
		{
			System.out.println("Enter Invoice or press -1 to quit");
			System.out.println("Please enter the sku of the book you want to buy");
		
		    sku=sc.next();
		    
		    if(sku.equals("-1"))
			{
				break;
			}	
		   if(database.searchBooks(sku)==null)
		   {
			   System.out.println("We cannot find this book. Please reinput the sku");
			   continue;
		   }
             System.out.println("Please enter the num of the book");
		
		     num=sc.nextInt();
		     
		     if(num==-1)
			  {
				break;
			  }
		    System.out.println("Please enter the untaxable of the book you want to buy");
				
			    untaxable=sc.next();
			    
			    if(untaxable.equals("-1"))
				{
					break;
				}
			    if(database.searchBooks(sku)!=null)
			    {
			    	Invoice.createInvoice(sku, num, untaxable);    	
			    }
					    
		     
		}
		 System.out.println("Item      Quantity      Description      Price      Price Total");
		 
		 for(int k=0;k<=Invoice.count-1;k++)
		 {
			 System.out.println(invoice.invoicearr[k][0]+"      "+invoice.invoicearr[k][1]+"      "+Invoice.invoicearr[k][2]+"      "+invoice.invoicearr[k][3]+"      "+invoice.invoicearr[k][4]);
		 }
		 
		 
		System.out.println("Taxable Subtotal: $"+String.format("%.02f",invoice.taxablesubtotal));			
		System.out.println("Untaxable Subtotal: $"+String.format("%.02f",invoice.untaxablesubtotal));	
		System.out.println("Tax: $"+String.format("%.02f",(invoice.taxablesubtotal*0.06)));	
		System.out.println("Tax: $"+String.format("%.02f",((invoice.taxablesubtotal*1.06)+invoice.untaxablesubtotal)));
		      
	      
	       
	}
}
