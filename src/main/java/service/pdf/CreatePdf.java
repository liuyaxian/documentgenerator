package service.pdf;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType0Font;

public class CreatePdf {


    public  void create(){
        //首先创建pdf文档类
        PDDocument document = null;
        try
        {
            document = new PDDocument();
            //实例化pdf页对象
            PDPage blankPage = new PDPage();
            //字体大小
            float fontSize = 36.0f;

            PDPageContentStream contentStream = new PDPageContentStream(document, blankPage, true, true,true);
            contentStream.beginText();
            // set text color to red
            contentStream.setNonStrokingColor(255, 0, 0);
            contentStream.drawString( "fsdjfksdjfksdjf低的借款打飞机快递费接口的复健科" );
            contentStream.endText();
            //插入文档类
            document.addPage(blankPage);
            //记得一定要写保存路径,如"H:\\text.pdf"
            document.save( outputFile );
            System.out.println("over");
        }
        finally
        {
            if( document != null )
            {
                document.close();
            }
        }
    }
}
