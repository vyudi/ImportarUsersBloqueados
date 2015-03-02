package be.lifes.controller;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import be.life.model.Profile;

public class LeitorXlsx {

	
	public static ArrayList<Profile> leitor(String filename) 
	{
		ArrayList<Profile> lista = new ArrayList<Profile>();
		try
		{
			FileInputStream file = new FileInputStream(new File(filename));

			XSSFWorkbook workbook = new XSSFWorkbook(file);
			
			XSSFSheet sheet = workbook.getSheetAt(0);
			
			Iterator<Row> rowIterator = sheet.iterator();
			
			
			Profile profile;
			
			while (rowIterator.hasNext()) 
			{
				Row row = rowIterator.next();
				//For each row, iterate through all the columns
				Iterator<Cell> cellIterator = row.cellIterator();
				profile = new Profile();
				int coluna = 0;
				while (cellIterator.hasNext()) 
				{
					Cell cell = cellIterator.next();
					cell.setCellType(Cell.CELL_TYPE_STRING);
					//Check the cell type and format accordingly
					switch (cell.getCellType()) 
					{
						case Cell.CELL_TYPE_NUMERIC:
							int i = (int)cell.getNumericCellValue(); 
							System.out.print(String.valueOf(i) + "\t");
							helper(profile, coluna, String.valueOf(i));
							break;
						case Cell.CELL_TYPE_STRING:
							if(!cell.getStringCellValue().equals("") ){
								System.out.print(cell.getStringCellValue() + "\t");
								helper(profile, coluna, cell.getStringCellValue());
							}
							break;
					}
					coluna ++;
				}
				lista.add(profile);
				
				System.out.println("");
			}
			file.close();
			System.out.println(lista.size() + " total de profiles");
		
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return lista;
	}
	
	public static Profile helper(Profile profile, int coluna, String value){
		//http://graph.facebook.com/458718917505038/picture?width=640&height=640
		//http://graph.facebook.com/"+value+"/picture?type=large"
		if(coluna == 0){
			profile.setUserFace(value);
		}else if(coluna == 1){
			profile.setIdFace(value);
			if(!value.equals("") && value !=null && !value.equals("null")){
				profile.setUrlAvatar("http://graph.facebook.com/"+value+"/picture?width=640&height=640");
			}else{
				profile.setUrlAvatar("avatar_star.jpg");
			}
		}else if(coluna == 2){
			profile.setUserInsta(value);
		}else if(coluna == 3){
			profile.setIdInsta(value);
		}else if(coluna == 4){
			profile.setTmUser(value);
		}else if(coluna == 5){
			profile.setUserEspecial(value);
		}else if(coluna == 6){
			profile.setUserVar1(value);
		}else if(coluna == 7){
			profile.setUserVar2(value);
		}else if(coluna == 8){
			profile.setUserVar3(value);
		}else if(coluna == 9){
			profile.setUserVar4(value);
		}
		
		profile.setPassword("0c6569fb5cf50bf1936dc4dab9546e28");
		if(profile.getUrlAvatar()==null){
			profile.setUrlAvatar("avatar_star.jpg");
		}
		
		profile.setUrlBanner("banner_protected.jpg");
		return profile;
	}
}
