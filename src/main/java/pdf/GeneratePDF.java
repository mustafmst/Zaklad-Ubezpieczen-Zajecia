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
import entities.Service;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import model.ServiceModel;

/**
 *
 * @author Piotr Filipowicz
 */
public class GeneratePDF {
    
    public Date dateTo;
    public Date dateFrom;
    public GeneratePDF() {
    
    }
    
    public GeneratePDF(Date dateTo, Date dateFrom) {
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;      
    }
    
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
    
    private final ServiceModel serviceModel = new ServiceModel();
    
 @SuppressWarnings("CallToPrintStackTrace")
    public PdfPTable createTable() {

        PdfPTable table = new PdfPTable(7);

        table.addCell(new Paragraph("Advisor", new Font(FontFamily.HELVETICA, 11)));
        table.addCell(new Paragraph("Customer", new Font(FontFamily.HELVETICA, 11)));
        table.addCell(new Paragraph("Description", new Font(FontFamily.HELVETICA, 11)));
        table.addCell(new Paragraph("Insurance Price", new Font(FontFamily.HELVETICA, 11)));
        table.addCell(new Paragraph("Service Price", new Font(FontFamily.HELVETICA, 11)));
        table.addCell(new Paragraph("Cost", new Font(FontFamily.HELVETICA, 11)));
        table.addCell(new Paragraph("Date", new Font(FontFamily.HELVETICA, 11)));
        
        List<Service> transactions = new ArrayList<>();
        try{
            for (Service c : this.serviceModel.findAll()) {
            if(dateTo != null && dateFrom != null) {
                if(c.getDateOfService().getDate() >= dateFrom.getDate() && c.getDateOfService().getDate() <= dateTo.getDate() ){
                    transactions.add(c);
                }
            }else if(dateTo != null) {
                if(c.getDateOfService().getDate() <= dateTo.getDate()){
                    transactions.add(c);
                }
            } else if(dateFrom != null) {
                if(c.getDateOfService().getDate() >= dateFrom.getDate()){
                    transactions.add(c);
                }
            } else {
                transactions.add(c);
            }
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        for (Service c : transactions)
        {
            table.addCell(new Paragraph( c.getUserFk().getImie() + " " + c.getUserFk().getNazwisko() , new Font(FontFamily.HELVETICA, 10)));
            table.addCell(new Paragraph( c.getPeselFk().getFirstName() + " " + c.getPeselFk().getLastName() , new Font(FontFamily.HELVETICA, 10)));
            table.addCell(new Paragraph( c.getDescription() , new Font(FontFamily.HELVETICA, 10)));
            table.addCell(new Paragraph( String.format("%.2f",c.getInsuranceCost() ) , new Font(FontFamily.HELVETICA, 10)));
            table.addCell(new Paragraph( String.format("%.2f",c.getServiceCost() ) , new Font(FontFamily.HELVETICA, 10)));
            table.addCell(new Paragraph( String.format("%.2f",c.getInsuranceCost()+c.getServiceCost() ) , new Font(FontFamily.HELVETICA, 10)));
            table.addCell(new Paragraph( String.format("%td.%tm.%tY",c.getDateOfService(),c.getDateOfService(),c.getDateOfService() ), new Font(FontFamily.HELVETICA, 10)));
        }
        
        return table;
    }
    
}
