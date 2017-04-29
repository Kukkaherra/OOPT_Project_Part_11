package learningTool;

public class DataTuple {
	private String codeDescription, fileName;

	public DataTuple(String codeDescription, String fileName){
		this.codeDescription = codeDescription;
		this.fileName = fileName;
	}

	public String getCode() {
		return codeDescription;
	}

	public String getFileName() {
		return fileName;
	}

	public String toString() {
		return fileName + ": " + codeDescription;
	}
}
