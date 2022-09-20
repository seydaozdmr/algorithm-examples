package algorithms.datastructures;
import java.io.File;

import algorithms.Queue;
import algorithms.StdOut;
public class ListingFiles {
	
	private Queue<String> fileQueue;
	
	public ListingFiles() {
		fileQueue=new Queue<>();
	}
	
	public void listFiles(File file,int depth) {
		if(!file.exists()) {
			return;
		}
		
		//Add directory
		
		addFileToQueue(file,depth);
		
		File[]fileList=file.listFiles();
		
		if(fileList!=null) {
			for(File fileItem:fileList) {
				if(fileItem.isFile()) {
					addFileToQueue(fileItem,depth);
				}else if(fileItem.isDirectory()) {
					listFiles(fileItem,depth+1);
				}
			}
		}
	}
	

	private void addFileToQueue(File file, int depth) {
		StringBuilder stringBuilder=new StringBuilder();
		
		for(int i=0;i<depth;i++) { //Derinlik kadar boşluk bırakıp dosya isimlerini kuyruğa ekleriz.
			stringBuilder.append("  ");
		}
		stringBuilder.append(file.getName());
		fileQueue.enqueue(stringBuilder.toString());
		
	}

	public static void main(String[] args) {
		String folderPath="D:\\Film";
		File folder=new File(folderPath);
		
		ListingFiles listFiles=new ListingFiles();
		listFiles.listFiles(folder, 0);
		
		for(String fileName:listFiles.fileQueue) {
			StdOut.println(fileName);
		}

	}

}
