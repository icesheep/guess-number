import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class SearchFile {

	void getFile(File aString) {
		File[] aFiles = aString.listFiles();
		for (int i = 0; i < aFiles.length; i++) {
			if(!aFiles[i].isFile()) {
				getFile(aFiles[i]);
			}else {
				this.aFiles.add(aFiles[i]);
			}
		}
	}
	static List<File> aFiles = new ArrayList<File>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SearchFile searchFile = new SearchFile();
		searchFile.getFile(new File("F:\\°²×°°ü"));
		for (int i = 0; i < aFiles.size(); i++) {
			System.out.println(aFiles.get(i).getName());
		}
		System.out.println(aFiles.size());
	}

}
