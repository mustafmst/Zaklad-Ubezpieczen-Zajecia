/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdf;

import java.io.FileOutputStream;
import java.io.IOException;
 
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import java.util.Calendar;

/**
 *
 * @author Piotr Filipowicz
 */
public class GeneratePDF {
    
    /*
    public static final String RESULT = "accountant.pdf";
    
    public static void main(String[] args) throws DocumentException, IOException {
    	new GeneratePDF().createPdf(RESULT);
    }
    */
    
    public void createPdf(String filename)
	throws DocumentException, IOException {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(filename));
            document.open();
      
            document.add(new Paragraph("Insurance System \n", new Font(FontFamily.HELVETICA, 22)) );
            document.add(new Paragraph("List of transactions made by advisors: \n\n",new Font(FontFamily.HELVETICA, 14)));
            document.add(createTable());
            
            Calendar c = Calendar.getInstance();
            String date = String.format("\nGeneration date: \n%tl:%tM:%tS %tp - %td.%tm.%tY \n",c,c,c,c, c,c,c);
            document.add(new Paragraph(date, new Font(FontFamily.HELVETICA, 9)) );
            
            document.close();
    }
    
    public static PdfPTable createTable() {

        PdfPTable table = new PdfPTable(7);

        table.addCell(new Paragraph("Advisor", new Font(FontFamily.HELVETICA, 11)));
        table.addCell(new Paragraph("Customer", new Font(FontFamily.HELVETICA, 11)));
        table.addCell(new Paragraph("Description", new Font(FontFamily.HELVETICA, 11)));
        table.addCell(new Paragraph("Insurance Price", new Font(FontFamily.HELVETICA, 11)));
        table.addCell(new Paragraph("Service Price", new Font(FontFamily.HELVETICA, 11)));
        table.addCell(new Paragraph("Cost", new Font(FontFamily.HELVETICA, 11)));
        table.addCell(new Paragraph("Date", new Font(FontFamily.HELVETICA, 11)));
        
        for (int i=0 ; i<20 ; i++)
        {
            table.addCell(new Paragraph(" ", new Font(FontFamily.HELVETICA, 10)));
            table.addCell(new Paragraph(" ", new Font(FontFamily.HELVETICA, 10)));
            table.addCell(new Paragraph(" ", new Font(FontFamily.HELVETICA, 10)));
            table.addCell(new Paragraph(" ", new Font(FontFamily.HELVETICA, 10)));
            table.addCell(new Paragraph(" ", new Font(FontFamily.HELVETICA, 10)));
            table.addCell(new Paragraph(" ", new Font(FontFamily.HELVETICA, 10)));
            table.addCell(new Paragraph(" ", new Font(FontFamily.HELVETICA, 10)));
        }
        
        return table;
    }
    
}
