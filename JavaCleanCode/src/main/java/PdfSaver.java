import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class PdfSaver {

    public static void SaveDataToPdf(ArrayList<Person> persons) {
        Document document = new Document();
        document.setPageSize(PageSize.A4.rotate());
        PdfWriter writer = null;
        try {
            writer = PdfWriter.getInstance(document, new FileOutputStream(Constants.FILE_NAME));
        }
        catch (IOException e) {
            System.out.println("Файл не найден.");
        }
        catch (DocumentException e) {
            System.out.println("Document exception.");
        }

        try {
            document.open();
            PdfPTable table = GenerateTable(persons);
            document.add(table);

            document.close();
            writer.close();
        }
        catch (DocumentException e) {
            System.out.println("Document exception.");
        }
    }

    private static PdfPTable GenerateTable(ArrayList<Person> persons) {
        BaseFont bf = null;
        try {
            bf = BaseFont.createFont(Constants.FONT, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
        }
        catch (IOException e){
            System.out.println("Файл со шрифтом не найден!");
        }
        catch (DocumentException e){
            System.out.println("Document exception.");
        }

        Font font = new Font(bf, 6, Font.NORMAL);
        PdfPTable table = new PdfPTable(Constants.ROW_NUMBER);
        table.setWidthPercentage(100);

        for (int i = 0; i < Constants.ROW_NUMBER; i++) {
            table.addCell(new PdfPCell(new Paragraph(Constants.headerTitles[i], font)));
        }
        for (int i = 0; i < persons.size(); i++) {
            String[] tempArray = persons.get(i).GetStringArray();
            for (int j = 0; j < Constants.ROW_NUMBER; j++) {
                table.addCell(new PdfPCell(new Paragraph(tempArray[j], font)));
            }
        }
        return table;
    }
}
