package com.example.demo.helper;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.Patient;
//import com.example.demo.model.PatientExcelDetails;

public class Helper {
	
	
	public static boolean checkExcelFormat(MultipartFile file) {
		
		String contentType = file.getContentType();
		
		if(contentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")) {
			return true;
		}
		else {
			return false;
		}
	}

    //convert excel to list of patients

    public static List<Patient> convertExcelToListOfPatients(InputStream is) {
        List<Patient> list = new ArrayList<>();

        try {


            XSSFWorkbook workbook = new XSSFWorkbook(is);

            XSSFSheet sheet = workbook.getSheet("data");

            int rowNumber = 0;
            Iterator<Row> iterator = sheet.iterator();

            while (iterator.hasNext()) {
                Row row = iterator.next();

                if (rowNumber == 0) {
                    rowNumber++;
                    continue;
                }

                        	
                    }
                    cid++;

                }

                list.add(patient);


            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;

    }


}
