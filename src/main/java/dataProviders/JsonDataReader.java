package dataProviders;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import com.google.gson.Gson;
import managers.FileReaderManager;
import testDataTypes.Brand;

public class JsonDataReader {
	private final String customerFilePath = FileReaderManager.getInstance().getConfigReader().getTestDataResourcePath() + "Brand.json";
	private List<Brand> brandList;
	
	public JsonDataReader(){
		brandList = getBrandData();
	}
	
	private List<Brand> getBrandData() {
		Gson gson = new Gson();
		BufferedReader bufferReader = null;
		try {
			bufferReader = new BufferedReader(new FileReader(customerFilePath));
			Brand[] customers = gson.fromJson(bufferReader, Brand[].class);
			return Arrays.asList(customers);
		}catch(FileNotFoundException e) {
			throw new RuntimeException("Json file not found at path : " + customerFilePath);
		}finally {
			try { if(bufferReader != null) bufferReader.close();}
			catch (IOException ignore) {}
		}
	}
		
	public final Brand getBrandByName(String brandName){
		for(Brand brand : brandList) {
			if(brand.brandName.equalsIgnoreCase(brandName)) return brand;
		}
		return null;
	}
	
}
