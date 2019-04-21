package fileOperation

import com.kms.katalon.core.annotation.Keyword
import com.opencsv.CSVReader
public class ReadCSVFile {
	Map<String,String> dataMap = new HashMap<String, String>();
	int totalRowCount;
	int tcRow;
	String column;

	@Keyword
	public List<Map<String,String>> addMapList(String csvFile){
		String line = "";
		String cvsSplitBy = ",";
		List<Map<String,String>> schedules = []
		CSVReader reader = new CSVReader(new FileReader(csvFile));
		String [] nextLine;
		List<String []> allLine = reader.readAll()
		for(int i=1;i<allLine.size();i++) {
			Map<String,String> pd = new HashMap<String,String>()
			for(int column=0;column < allLine[0].length;column++) {
				pd.put(allLine[0][column], allLine[i][column]);
			}
			schedules.add(pd)
			pd=null
		}
		return schedules
	}
}

