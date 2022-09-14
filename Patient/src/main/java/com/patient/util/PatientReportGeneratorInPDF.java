package com.patient.util;

import java.awt.Color;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.patient.dto.PatientVitalDetailsDTO;
import com.patient.entity.AllergicTo;
import com.patient.entity.EmergencyContactInfo;
import com.patient.entity.Patient;
import com.patient.entity.PatientDiagnosticDetails;
import com.patient.entity.PatientMedication;
import com.patient.entity.PatientProcedure;

@Component
public class PatientReportGeneratorInPDF {


	@Value("${spring.mail.username}")
	private String senderMailId;
	
	@Value("${pdfDir}")
	private String pdfDir;
	
	@Value("${reportFileName}")
	private String reportFileName;
	
	@Value("${reportFileNameDateFormat}")
	private String reportFileNameDateFormat;
	
	@Value("${localDateFormat}")
	private String localDateFormat;
	
	@Value("${logoImgPath}")
	private String logoImgPath;
	
	@Value("${logoImgScale}")
	private Float[] logoImgScale;
	
	@Value("${currencySymbol:}")
	private String currencySymbol;
	
	@Value("${table_noOfColumns}")
	private int noOfColumns;
	
	@Value("${table.columnNames}")
	private List<String> columnNames;
	
	
	private static Font COURIER_SMALL_FOOTER = FontFactory.getFont(FontFactory.COURIER_BOLD,12);

	
	private void addLogo(Document document) {
		try {	
			Image img = Image.getInstance(logoImgPath);
			img.scalePercent(logoImgScale[0], logoImgScale[1]);
			img.scaleAbsolute(300.0f, 150.0f);
			img.setAlignment(Element.ALIGN_CENTER);
			document.add(img);
		} catch (DocumentException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private static void leaveEmptyLine(Paragraph paragraph, int number) {
		for (int i = 0; i < number; i++) {
			paragraph.add(new Paragraph(" "));
		}
	}
	private void addFooter(Document document) throws DocumentException {
		Paragraph p2 = new Paragraph();
		leaveEmptyLine(p2, 3);
		p2.setAlignment(Element.ALIGN_MIDDLE);
		p2.add(new Paragraph(
				"------------------------End Of " +reportFileName+"------------------------", 
				COURIER_SMALL_FOOTER));
		
		document.add(p2);
		Paragraph p3 = new Paragraph();
		leaveEmptyLine(p3, 1);
		Font fontForHeading = FontFactory.getFont(FontFactory.TIMES_ROMAN);
        
        fontForHeading.setColor(Color.GREEN);
		p3.setAlignment(Element.ALIGN_CENTER);
		p3.setFont(fontForHeading);
		p3.add(new Paragraph(
				"------- Thank you for using CT Hospital Website -------", 
				COURIER_SMALL_FOOTER));
		
		document.add(p3);
	}

	public void sendPatientReport(Patient patient, HttpServletResponse response, PatientVitalDetailsDTO patientVitalDetailsDTO) throws DocumentException, IOException, IllegalArgumentException, IllegalAccessException {
		
		 Document document = new Document(PageSize.A4);
	        PdfWriter.getInstance(document, response.getOutputStream());
	        

	        document.open();
	        
	      //  addLogo(document);
	        Font fontForHeading = FontFactory.getFont(FontFactory.TIMES_ROMAN);
	        fontForHeading.setSize(30);
	        fontForHeading.setColor(Color.blue);
	        Paragraph paragraph1 = new Paragraph("CT Hospital",fontForHeading);
	        paragraph1.setAlignment(Paragraph.ALIGN_CENTER);
	        paragraph1.setFont(fontForHeading);
	        //document.add(paragraph1);
	        
	        Font fontTitle = FontFactory.getFont(FontFactory.TIMES_ROMAN);
	        fontTitle.setSize(18);
	        fontTitle.setColor(Color.BLUE);
	        
	        //Table font
	        Font tableFont = FontFactory.getFont(FontFactory.defaultEncoding);
	       // tableFont.setSize(14);
	       
	        //tableFont.setColor(Color.BLUE);
	        

	        Paragraph paragraph = new Paragraph(patient.getFirstName() +" " +patient.getLastName(), fontTitle);
	        paragraph.setAlignment(Paragraph.ALIGN_CENTER);
	        paragraph.setSpacingAfter(10.0f);

	        Font fontParagraph = FontFactory.getFont(FontFactory.TIMES_ROMAN);
	        fontParagraph.setSize(14);
	        fontParagraph.setColor(Color.BLACK);
	        
	        
	        
	       

	        Font font1 = FontFactory.getFont(FontFactory.TIMES_ROMAN);
	        font1.setSize(18);
	        font1.setStyle("bold");
	        
	        
	        
	        Paragraph paragraph4 = new Paragraph("_______________ Vital Details _______________", fontParagraph);
	        paragraph4.setAlignment(Paragraph.ALIGN_CENTER);
	        paragraph4.setFont(font1);
	        paragraph4.setSpacingBefore(20.0f);
	        
	        Paragraph paragraph5 = new Paragraph("_______________ Allergy Details _______________", fontParagraph);
	        paragraph5.setAlignment(Paragraph.ALIGN_CENTER);
	        paragraph5.setFont(font1);	      
	        
	        Paragraph paragraph6 = new Paragraph("_______________ Emergency Contact Details _______________", fontParagraph);
	        paragraph6.setAlignment(Paragraph.ALIGN_CENTER);
	        paragraph6.setFont(font1);
	        
	        Paragraph paragraph7 = new Paragraph("_______________ Diagnostic Details _______________", fontParagraph);
	        paragraph7.setAlignment(Paragraph.ALIGN_CENTER);
	        paragraph7.setFont(font1);
	        
	        Paragraph paragraph8 = new Paragraph("_______________ Medication Details _______________", fontParagraph);
	        paragraph8.setAlignment(Paragraph.ALIGN_CENTER);
	        paragraph8.setFont(font1);
	        
	        Paragraph paragraph9 = new Paragraph("_______________ Procedure Details _______________", fontParagraph);
	        paragraph9.setAlignment(Paragraph.ALIGN_CENTER);
	        paragraph9.setFont(font1);
	        
	        //
//	        PdfPTable table = new PdfPTable(2);
//	        PdfPCell cellOne = new PdfPCell(new Phrase("Hello"));
//	        PdfPCell cellTwo = new PdfPCell(new Phrase("World"));
//
//	        cellOne.setBorder(Rectangle.NO_BORDER);
//	        cellOne.setBackgroundColor(new Color(255,255,45));
//
//	        cellTwo.setBorder(Rectangle.BOX);
//
//	        table.addCell(cellOne);
//	        table.addCell(cellTwo);
	        
	        
	        //
	       //Patient Data table
	        PdfPTable patientDataTable = new PdfPTable(2);
	        List<Object> fieldData = getPatientFieldData(patient,patientVitalDetailsDTO);
	        List<String> columnNames = getFieldNames();
	        for(int i=0;i<columnNames.size();i++) 
	        {
	        	
	        	PdfPCell cell1 = new PdfPCell();
	        	PdfPCell cell2 = new PdfPCell();
	        	cell1.setBorder(Rectangle.NO_BORDER);
	        	cell2.setBorder(Rectangle.NO_BORDER);
	        	cell1.addElement(new Phrase(columnNames.get(i),tableFont));
	        	cell2.addElement(new Phrase(fieldData.get(i).toString()));
	        	patientDataTable.addCell(cell1);
	        	patientDataTable.addCell(cell2);
//	        	patientDataTable.addCell(new PdfPCell(new Phrase(columnNames.get(i),tableFont)));
//	        	patientDataTable.addCell(new PdfPCell(new Phrase(fieldData.get(i).toString())));
	        	
	        }
	        patientDataTable.setSpacingBefore(0);
	        patientDataTable.setSpacingAfter(20);
            patientDataTable.completeRow();
            

            
            //Vital Data table
            PdfPTable vitalDetailTable = new PdfPTable(2);
            List<Object> vitalData = getPatientVitalData(patientVitalDetailsDTO);
            List<String> VitalColumnNames = getPatientVitalFieldName();
            for(int i=0;i<VitalColumnNames.size();i++) 
	        {
            	vitalDetailTable.addCell(new PdfPCell(new Phrase(VitalColumnNames.get(i))));
            	vitalDetailTable.addCell(new PdfPCell(new Phrase(vitalData.get(i).toString())));
	        }
            vitalDetailTable.setSpacingBefore(20);
            vitalDetailTable.setSpacingAfter(20);
            vitalDetailTable.completeRow();
            
           
            //Patient Name
	        //document.add(paragraph);
	        document.add(patientDataTable);
	        document.add(paragraph4);
	        document.add(vitalDetailTable);
	      
	        document.add(paragraph5);
	      //Allergy Data table
            int j = patient.getAllergicTo().size();
            for (int ii = 0; ii < j; ii++) {
            	PdfPTable table3 = new PdfPTable(2);
                List<Object> allergyData = getPatientAllergyData( patient,ii);
                List<String> allergyField = getPatientAllergyFieldName();
                for(int i=0;i<allergyField.size();i++) 
    	        {
                	table3.addCell(new PdfPCell(new Phrase(allergyField.get(i))));
                	table3.addCell(new PdfPCell(new Phrase(allergyData.get(i).toString())));
    	        }
                table3.setSpacingBefore(20);
                table3.setSpacingAfter(20);
                table3.completeRow();
                document.add(table3);
			}
	
            document.add(paragraph6);
            //Emergency Contact Table            
            int k = patient.getEmergencyContactInfo().size();
            for (int ii = 0; ii < k; ii++) {
            	PdfPTable table3 = new PdfPTable(2);
                List<Object> allergyData = getPatientEmergencyContactData(patient,ii);
                List<String> allergyField = getPatientEmergencyConatcFieldName();
                for(int i=0;i<allergyField.size();i++) 
    	        {
                	table3.addCell(new PdfPCell(new Phrase(allergyField.get(i))));
                	table3.addCell(new PdfPCell(new Phrase(allergyData.get(i) != null ? allergyData.get(i).toString() : "Home")));
    	        }
                table3.setSpacingBefore(20);
                table3.setSpacingAfter(20);
                table3.completeRow();
                document.add(table3);
			}
            
            document.add(paragraph7);
            //Patient diagnostic details          
            int size = patient.getPatientDiagnosticDetails().size();
            for (int ii = 0; ii < size; ii++) {
            	PdfPTable table3 = new PdfPTable(2);
                List<Object> allergyData = getPatientDiagnosticData(patient,ii);
                List<String> allergyField = getPatientDiagnosticFieldName();
                for(int i=0;i<allergyField.size();i++) 
    	        {
                	table3.addCell(new PdfPCell(new Phrase(allergyField.get(i))));
                	table3.addCell(new PdfPCell(new Phrase(allergyData.get(i).toString())));
    	        }
                table3.setSpacingBefore(20);
                table3.setSpacingAfter(20);
                table3.completeRow();
                document.add(table3);
			}
            
            //Patient Medication details
            document.add(paragraph8);
            int size1 = patient.getPatientMedication().size();
            for (int ii = 0; ii < size1; ii++) {
            	PdfPTable table3 = new PdfPTable(2);
                List<Object> allergyData = getPatientMedicationData(patient,ii);
                List<String> allergyField = getPatientMedicationFieldName();
                for(int i=0;i<allergyField.size();i++) 
    	        {
                	table3.addCell(new PdfPCell(new Phrase(allergyField.get(i))));
                	table3.addCell(new PdfPCell(new Phrase(allergyData.get(i).toString())));
    	        }
                table3.setSpacingBefore(20);
                table3.setSpacingAfter(20);
                table3.completeRow();
                document.add(table3);
			}
            
          //Patient Procedure details
            document.add(paragraph9);
            int size2 = patient.getPatientMedication().size();
            for (int ii = 0; ii < size2; ii++) {
            	PdfPTable table3 = new PdfPTable(2);
                List<Object> allergyData = getPatientProcedureData(patient,ii);
                List<String> allergyField = getPatientProcedureFieldName();
                for(int i=0;i<allergyField.size();i++) 
    	        {
                	
                	table3.addCell(new PdfPCell(new Phrase(allergyField.get(i))));
                	table3.addCell(new PdfPCell(new Phrase(allergyData.get(i).toString())));
    	        }
                table3.setSpacingBefore(20);
                table3.setSpacingAfter(20);
                table3.completeRow();
                document.add(table3);
			}
            addFooter(document);
	        document.close();
	        
	}
	
	private List<String> getPatientProcedureFieldName() {
		List<String> columnNames = new ArrayList<>();
		columnNames.add("Procedure Code");
		columnNames.add("Procedure Description");
		columnNames.add("Procedure Is Descriptive");
		columnNames.add("Date");
		return columnNames;
	}
	
	static List<Object> getPatientProcedureData(Patient patient,int i){
		List<Object> procedureData = new ArrayList<>();
		List<PatientProcedure> listOfProcedure = patient.getPatientProcedure();
		PatientProcedure medication = listOfProcedure.get(i);
		procedureData.add(medication.getProcedureCode());
		procedureData.add(medication.getProcedureDescription());
		procedureData.add(medication.getProcedureIsDescriptive());
		procedureData.add(medication.getCreatedDate());
		return procedureData;
	}
	
	private List<String> getPatientMedicationFieldName() {
		List<String> columnNames = new ArrayList<>();
		columnNames.add("Medication Id");
		columnNames.add("Drug Id");
		columnNames.add("Drug Name");
		columnNames.add("Drug Generic Name");
		columnNames.add("Drug Brand Name");
		columnNames.add("Drug Form");
		columnNames.add("Drug Strength");
		columnNames.add("Date");
		return columnNames;
	}
	
	static List<Object> getPatientMedicationData(Patient patient,int i){
		List<Object> medicationData = new ArrayList<>();
		List<PatientMedication> listOfMedication = patient.getPatientMedication();
		PatientMedication medication = listOfMedication.get(i);
		medicationData.add(medication.getMedicationId());
		medicationData.add(medication.getDrugId());
		medicationData.add(medication.getDrugName());
		medicationData.add(medication.getDrugGenericName());
		medicationData.add(medication.getDrugBrandName());
		medicationData.add(medication.getDrugForm());
		medicationData.add(medication.getDrugStrength());
		medicationData.add(medication.getCreatedDate());
		return medicationData;
	}

	
	private List<String> getPatientVitalFieldName() {
		List<String> columnNames = new ArrayList<>();
		columnNames.add("Height");
		columnNames.add("Weight");
		columnNames.add("Body Temperature");
		columnNames.add("Respiratory Rate");
		return columnNames;
	}

	static <T> List<String> inspect(Class<T> className) {
        Field[] fields = className.getDeclaredFields();
        className.getDeclaredMethods();
        List<String> listOfPatientFields = new ArrayList<>();
        for (Field field : fields) {
        	listOfPatientFields.add(field.getName());
        }
        return listOfPatientFields;
	}
	public static List<String> getFieldNames() {
		List<String> columnNames = new ArrayList<>();
		columnNames.add("Patient ID");
		columnNames.add("Full Name ");
		columnNames.add("Email Address");
		columnNames.add("Date of Birth");
		columnNames.add("Contact Number");
		columnNames.add("Age");
		columnNames.add("Race");
		columnNames.add("Ethnicity");
		columnNames.add("Language Known");
		columnNames.add("Home Address");
		columnNames.add("Is Alergic to something");
		return columnNames;
		
	}
	static List<Object> getPatientFieldData(Patient patient,PatientVitalDetailsDTO patientVitalDetailsDTO) {
		List<Object> fieldData = new ArrayList<>();
		fieldData.add(patient.getPatientId());
		fieldData.add(patient.getTitle() +" "+ patient.getFirstName()+" "+ patient.getLastName());
		fieldData.add(patient.getEmailId());
		fieldData.add(patient.getDateOfBirth());
		fieldData.add(patient.getContactNumber());	
		fieldData.add(patient.getAge());
		fieldData.add(patient.getRace());
		fieldData.add(patient.getEthnicity());
		fieldData.add(patient.getLanguagesKnown());
		fieldData.add(patient.getHomeAddress());
		fieldData.add(patient.getIsAllergic());
		return fieldData;
	}
	static List<Object> getPatientVitalData(PatientVitalDetailsDTO patientVitalDetailsDTO) {
		List<Object> vitalData = new ArrayList<>();
		vitalData.add(patientVitalDetailsDTO.getHeight());
		vitalData.add(patientVitalDetailsDTO.getWeight());
		vitalData.add(patientVitalDetailsDTO.getBodyTemperature());
		vitalData.add(patientVitalDetailsDTO.getRespiratoryRate());
		return vitalData;
	}
	static List<Object> getPatientAllergyData(Patient patient,int i){
		List<Object> allergyData = new ArrayList<>();
		List<AllergicTo> listOfAllergies = patient.getAllergicTo();
		AllergicTo allergy = listOfAllergies.get(i);
		allergyData.add(allergy.getAllergyId());
		allergyData.add(allergy.getAllergyName());
		allergyData.add(allergy.getAllergyType());
		allergyData.add(allergy.getAllergyDescription());
		allergyData.add(allergy.getAllergyClinicalInfo());
		return allergyData;
	}
	
	static List<Object> getPatientEmergencyContactData(Patient patient,int i){
		List<Object> emergencyContactData = new ArrayList<>();
		List<EmergencyContactInfo>  ListemergencyContactInfo= patient.getEmergencyContactInfo();
		EmergencyContactInfo emergencyContactInfo= ListemergencyContactInfo.get(i);
		emergencyContactData.add(emergencyContactInfo.getId());
		emergencyContactData.add(emergencyContactInfo.getFirstName() + " " + emergencyContactInfo.getLastName());
		emergencyContactData.add(emergencyContactInfo.getRelationship());
		emergencyContactData.add(emergencyContactInfo.getEmailAddress());
		emergencyContactData.add(emergencyContactInfo.getContactNumber());
		emergencyContactData.add(emergencyContactInfo.getAddress());
		return emergencyContactData;
	}
	
	static List<Object> getPatientDiagnosticData(Patient patient,int i){
		List<Object> data = new ArrayList<>();
		List<PatientDiagnosticDetails>  listOfDiagnosticData= patient.getPatientDiagnosticDetails();
		PatientDiagnosticDetails DiagnosticData = listOfDiagnosticData.get(i);
		data.add(DiagnosticData.getId());
		data.add(DiagnosticData.getDiagnosisCode());
		data.add(DiagnosticData.getDiagnosisDescription());
		data.add(DiagnosticData.getDiagnosisIsDescriptive());
		data.add(DiagnosticData.getCreatedDate());
		return data;
	}
	private List<String> getPatientDiagnosticFieldName() {
		List<String> columnNames = new ArrayList<>();
		columnNames.add("Diagnostic ID");
		columnNames.add("Diagnosis Code");
		columnNames.add("Diagnosis Description");
		columnNames.add("Diagnosis Is Descriptive");
		columnNames.add("Date");
		return columnNames;
	}
	
	private List<String> getPatientAllergyFieldName() {
		List<String> columnNames = new ArrayList<>();
		columnNames.add("Allergy ID");
		columnNames.add("Allergy Name");
		columnNames.add("Allergy Type");
		columnNames.add("Allergy Description");
		columnNames.add("Allergy Clinical Infornation");
		return columnNames;
	}
	
	private List<String> getPatientEmergencyConatcFieldName() {
		List<String> columnNames = new ArrayList<>();
		columnNames.add("Id");
		columnNames.add("Full Name");
		columnNames.add("Relationship");
		columnNames.add("Email Address");
		columnNames.add("Contact Number");
		columnNames.add("Home Address");
		return columnNames;
	}
}


