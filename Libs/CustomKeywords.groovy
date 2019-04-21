
/**
 * This class is generated automatically by Katalon Studio and should not be modified or deleted.
 */

import java.lang.String


def static "fileOperation.ReadCSVFile.addMapList"(
    	String csvFile	) {
    (new fileOperation.ReadCSVFile()).addMapList(
        	csvFile)
}

def static "fileOperation.ReadDataFile.returnDataMap"(
    	String tcName	
     , 	String dataFileName	) {
    (new fileOperation.ReadDataFile()).returnDataMap(
        	tcName
         , 	dataFileName)
}

def static "fileOperation.ReadDataFile.addMapList"(
    	String tcName	
     , 	String LIFileName	) {
    (new fileOperation.ReadDataFile()).addMapList(
        	tcName
         , 	LIFileName)
}

def static "fileOperation.WriteExcel.writeAPIData"(
    	String tcName	
     , 	String columnName	
     , 	String value	) {
    (new fileOperation.WriteExcel()).writeAPIData(
        	tcName
         , 	columnName
         , 	value)
}
