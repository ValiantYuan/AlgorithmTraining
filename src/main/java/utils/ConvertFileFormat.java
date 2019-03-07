package utils;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
public class ConvertFileFormat {
	private static final String rootPath = "/Users/chenlianda/code/framework/src";
	
	public static void main(String[] args) throws Exception {
//		new ConvertFileFormat().convertUseFileReader(new File("/Users/chenlianda/code/algorithm/AlgorithmTraining/src/main/java/utils/ConvertFileFormat.java"));
		new ConvertFileFormat().convertCurrentFile(new File(rootPath));
		System.out.println("done");
	
	}
	
	public void convertCurrentFile(File file) throws Exception {
		if (file.isDirectory()) {
			File[] subFiles = file.listFiles();
			for (File subfile : subFiles) {
				convertCurrentFile(subfile);
			}
		} else {
			convertUseFileReader(file);
//			convertUseFileInputStream(file);
		}
	}
	
	public void convertUseFileInputStream(File file) throws Exception {
		String fileNameString = file.getAbsolutePath();
		if (!fileNameString.endsWith(".java")) {
			return;
		}
		String rename = file.getAbsolutePath() + "bak";
		File newFile = new File(rename);
		if (!file.exists()) {
			if (!newFile.createNewFile()) {
				System.out.println("create failed");
				return;
			}
		}
		//中文测试
//		FileOutputStream fileOutputStream = new FileOutputStream(newFile);
//		BufferedReader bufferedReader = new BufferedReader(in);
//		FileInputReader fil = new FileInputStream(file);
//		byte[] bytes = new byte[1024*1024];
		InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file), "GBK");
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		OutputStreamWriter ouptOutputStreamWriter = new OutputStreamWriter(new FileOutputStream(newFile), "UTF-8");
		BufferedWriter bufferedWriter = new BufferedWriter(ouptOutputStreamWriter);
		
		String line = null;
		while ((line = bufferedReader.readLine()) != null) {
			bufferedWriter.write(line + "\n");
		}
		bufferedReader.close();
		bufferedWriter.close();
		file.delete();
		newFile.renameTo(new File(fileNameString));
	}
	
	//iconv -f GBK -t UTF-8 ConsistentHashingWithoutVirtualNode.java
	public void convertUseFileReader(File file) throws Exception {
		String fileNameString = file.getAbsolutePath();
		if (!fileNameString.endsWith(".java")) {
			return;
		}
		String rename = file.getAbsolutePath() + "bak";
		File newFile = new File(rename);
		if (!file.exists()) {
			if (!newFile.createNewFile()) {
				System.out.println("create faile");
				return;
			}
		}
		//中文测试
		InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file), "GBK");
		BufferedReader br = new BufferedReader(inputStreamReader);
		OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(newFile), "UTF-8");
		BufferedWriter bw = new BufferedWriter(outputStreamWriter);
		
		
		String line = null;
		while ((line = br.readLine()) != null) {
			line = line + "\n";
			bw.write(line);
		}
		br.close();
		bw.close();
		file.delete();
		newFile.renameTo(new File(fileNameString));
	}
	
}
