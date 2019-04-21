package fileOperation

import com.kms.katalon.core.testdata.TestData
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import com.kms.katalon.core.annotation.Keyword

public class ReadDataFile {
	Map<String,String> dataMap = new HashMap<String, String>();
	int totalRowCount;
	int tcRow;
	String column;

	@Keyword
	public Map<String, String> returnDataMap(String tcName, String dataFileName){
		TestData alltestData = findTestData(dataFileName);
		totalRowCount = alltestData.getRowNumbers();
		tcRow=0;

		for (int i=1; i<=totalRowCount;i++) {
			if(alltestData.getValue("Testcase_Id", i) == tcName) {
				tcRow = i;
				break;
			}
		}

		String[] columnHeader = alltestData.getColumnNames()
		for(int column=0;column < columnHeader.length;column++) {
			dataMap.put(columnHeader[column], alltestData.getValue(columnHeader[column], tcRow));
		}
		return dataMap
	}

	@Keyword
	public List<Map<String,String>> addMapList(String tcName, String LIFileName){
		TestData alltestData = findTestData(LIFileName);
		totalRowCount = alltestData.getRowNumbers();
		List<Map<String,String>> schedules = []
		for (int i=1; i<=totalRowCount;i++) {
			if(alltestData.getValue("Testcase_Id", i) == tcName) {
				Map<String,String> pd = new HashMap<String,String>()
				String[] columnHeader = alltestData.getColumnNames()
				for(int column=0;column < columnHeader.length;column++) {
					pd.put(columnHeader[column], alltestData.getValue(columnHeader[column], i));
				}
				schedules.add(pd)
				pd=null
			}
		}
		return schedules
	}
}