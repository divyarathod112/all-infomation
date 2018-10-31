package com.solusoft;

import java.io.File;
import java.io.IOException;

import javax.jws.WebService;

import org.apache.pdfbox.exceptions.COSVisitorException;
import org.apache.pdfbox.util.PDFMergerUtility;

@WebService(targetNamespace = "http://solusoft.com/", portName = "MergePdfPort", serviceName = "MergePdfService")
public class MergePdf {
	
	public String mergeAllPdf(String fileName,String Source,String Destination) {
		
		PDFMergerUtility ut1 = new PDFMergerUtility();

		File inputLocation = new File(Source);

		if (inputLocation.isDirectory()) {

			File[] attachmentFiles = inputLocation.listFiles();

			System.out.println("Total files in the folder:" + attachmentFiles.length);
			
			for (File aFile : attachmentFiles) {
				if (!aFile.isDirectory()) {
					String sourceFileName = aFile.getAbsolutePath();

					String[] array = sourceFileName.split("\\.");

					for (String temp : array) {
						if (temp.equalsIgnoreCase("pdf")) {
							ut1.addSource(sourceFileName);
						}
					}
				}
			}
			ut1.setDestinationFileName(Destination + fileName +".pdf");
			try {
				ut1.mergeDocuments();
			} catch (COSVisitorException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
		
		return "Successfully Merged";
	}
	
}
