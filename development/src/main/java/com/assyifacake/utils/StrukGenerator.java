package com.assyifacake.utils;

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import static java.awt.print.Printable.NO_SUCH_PAGE;
import static java.awt.print.Printable.PAGE_EXISTS;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class StrukGenerator extends javax.swing.JFrame {

    /**
     * Creates new form Home
     */
    
    
    
  //  String billNo="";
    int totalAmount=0;
    int cash=0;
    int balance=0;
    double bHeight=0;
    int idTransaksi = 0;
    String status = "";
    
    ArrayList<String> itemName = new ArrayList<>();
    ArrayList<String> quantity = new ArrayList<>();
    ArrayList<String> itemPrice = new ArrayList<>();
    ArrayList<String> subtotal = new ArrayList<>();
    
    
    public StrukGenerator(ArrayList<String[]> detailProduk, int total, int uangBayar, int kembalian, String status, int idTransaksi) {
        
        for(String[] detail : detailProduk) {
            itemName.add(detail[0]);
            quantity.add(detail[2]);
            itemPrice.add(detail[1]);
            subtotal.add(detail[3]);
            
        }
        this.totalAmount = total;
        this.cash = uangBayar;
        this.balance = kembalian;
        this.status = status;
        this.idTransaksi = idTransaksi;
    }

   

//    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
//       
//        
//        itemName.add(txtitemname.getText());
//        quantity.add(txtquantity.getText());
//        itemPrice.add(txtprice.getText());
//        subtotal.add(txtsubtotal.getText());
//        totalAmount = totalAmount+ Double.valueOf(txtsubtotal.getText());
//        txttotalAmount.setText(totalAmount+"");
//         clear();
//        
//        
//        
//    }//GEN-LAST:event_jButton1ActionPerformed

    public void print() {
       
        
         bHeight = Double.valueOf(itemName.size());
        //JOptionPane.showMessageDialog(rootPane, bHeight);
        
        PrinterJob pj = PrinterJob.getPrinterJob();        
        pj.setPrintable(new BillPrintable(),getPageFormat(pj));
        try {
             pj.print();
          
        }
         catch (PrinterException ex) {
                 ex.printStackTrace();
        }
        
        
    }//GEN-LAST:event_jButton2ActionPerformed
    
    public PageFormat getPageFormat(PrinterJob pj)
{
    
    PageFormat pf = pj.defaultPage();
    Paper paper = pf.getPaper();    

    double bodyHeight = bHeight;  
    double headerHeight = 5.0;                  
    double footerHeight = 5.0;        
    double width = cm_to_pp(8); 
    double height = cm_to_pp(headerHeight+bodyHeight+footerHeight); 
    paper.setSize(width, height);
    paper.setImageableArea(0,10,width,height - cm_to_pp(1));  
            
    pf.setOrientation(PageFormat.PORTRAIT);  
    pf.setPaper(paper);    

    return pf;
}
   
    
    
    protected static double cm_to_pp(double cm)
    {            
	        return toPPI(cm * 0.393600787);            
    }
 
protected static double toPPI(double inch)
    {            
	        return inch * 72d;            
    }
    


public class BillPrintable implements Printable {
    
   
    
    
  public int print(Graphics graphics, PageFormat pageFormat,int pageIndex) 
  throws PrinterException 
  {    
      
      int r= itemName.size();
//      ImageIcon icon=new ImageIcon("C:UsersccsDocumentsNetBeansProjectsvideo TestPOSInvoicesrcposinvoicemylogo.jpg"); 
      int result = NO_SUCH_PAGE;    
        if (pageIndex == 0) {                    
        
            Graphics2D g2d = (Graphics2D) graphics;                    
            double width = pageFormat.getImageableWidth();                               
            g2d.translate((int) pageFormat.getImageableX(),(int) pageFormat.getImageableY()); 



          //  FontMetrics metrics=g2d.getFontMetrics(new Font("Arial",Font.BOLD,7));
        
        try{
            int y=20;
            int yShift = 10;
            int headerRectHeight=15;
           // int headerRectHeighta=40;
            
                
            g2d.setFont(new Font("Monospaced",Font.PLAIN,9));
//            g2d.drawImage(icon.getImage(), 50, 20, 90, 30, rootPane);y+=yShift+30;
            g2d.drawString("-------------------------------------",12,y);y+=yShift;
            g2d.drawString("            Assyifa Cakes        ",12,y);y+=yShift;
            g2d.drawString("     Gg. Mangga Dusun Lumbung ",12,y);y+=yShift;
            g2d.drawString("     No.14 RT.2/RW.5 Mulyasari ",12,y);y+=yShift;
            g2d.drawString("   Pamanukan, Subang, Jawa Barat ",12,y);y+=yShift;
            g2d.drawString("           0823-2108-0240      ",12,y);y+=yShift;
            g2d.drawString("-------------------------------------",10,y);y+=headerRectHeight;
            g2d.drawString(" ID Transaksi    :          "+idTransaksi+"   ",10,y);y+=yShift;
            g2d.drawString(" Status Transaksi:          "+status+"   ",10,y);y+=yShift;
            g2d.drawString("-------------------------------------",10,y);y+=headerRectHeight;
            g2d.drawString(" Produk                  Subtotal   ",10,y);y+=yShift;
            g2d.drawString("-------------------------------------",10,y);y+=headerRectHeight;
     
            for(int s=0; s<r; s++)
            {
            g2d.drawString(" "+itemName.get(s)+"                            ",10,y);y+=yShift;
            g2d.drawString("      "+itemPrice.get(s)+" * "+quantity.get(s),10,y); 
            g2d.drawString(subtotal.get(s),150,y);y+=yShift;

            }
          
            g2d.drawString("-------------------------------------",10,y);y+=yShift;
            g2d.drawString(" Total Belanja :          "+IndonesiaCurrency.format(totalAmount)+"   ",10,y);y+=yShift;
            g2d.drawString("-------------------------------------",10,y);y+=yShift;
            g2d.drawString(" Uang Bayar    :          "+IndonesiaCurrency.format(cash)+"   ",10,y);y+=yShift;
            g2d.drawString("-------------------------------------",10,y);y+=yShift;
            g2d.drawString(" Kembalian     :          "+IndonesiaCurrency.format(balance)+"   ",10,y);y+=yShift;
  
            g2d.drawString("*************************************",10,y);y+=yShift;
            g2d.drawString("    TERIMA KASIH TELAH BERBELANJA            ",10,y);y+=yShift;
            g2d.drawString("*************************************",10,y);y+=yShift;   
           

    }
    catch(Exception e){
    e.printStackTrace();
    }

              result = PAGE_EXISTS;    
          }    
          return result;    
      }
   }
}