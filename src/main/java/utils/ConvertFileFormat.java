package utils;
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
	private static final String rootPath = "E:\\Learnning\\JAVA CODE\\eclipse-workspace\\EclipseLearnning\\InterviewCode\\src";
	
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
				System.out.println("create faile");
				return;
			}
		}
		//中文测试
		FileOutputStream fileOutputStream = new FileOutputStream(newFile);
		
		FileInputStream fileInputStream = new FileInputStream(file);
		byte[] bytes = new byte[1024*1024];
		int hasRead = 0;
		//这个方法有问题， GBK格式下的文件结束符跟UTF8的不一样
		while ((hasRead = fileInputStream.read(bytes)) > 0) {
			String fileString = new String(bytes, "GBK");
			byte[] outPuts = fileString.getBytes("UTF-8");
			fileOutputStream.write(outPuts);
		}
		fileInputStream.close();
		fileOutputStream.close();
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
