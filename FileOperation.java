package Model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class FileOperation {
	
	private String title;
	private String author;
	private String category;
	private String year;
	private String price;
	private String filePath="C:\\JAVA\\LibrarySystem\\src\\Model\\veritabanı";
	
	public FileOperation(String title, String author, String category, String year, String price) {
		super();
		this.title = title;
		this.author = author;
		this.category = category;
		this.year = year;
		this.price = price;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
	//Dosya olup olmadığı kontrol edilir
	
	public void checkDataBase(File file) throws IOException {
		
		if(!file.exists()) {
			file.createNewFile();
		}
	}
	
	//Dosyaya yazdırma işlemi yapıldı
	public void writerFile() throws IOException {
		File file = new File(filePath);
		checkDataBase(file);
		
		FileWriter fWriter = new FileWriter(filePath,true);
		BufferedWriter bWriter = new BufferedWriter(fWriter);
		
		bWriter.append(title + "\t" + author + "\t" + category + "\t" + year + "\t" + price);
		bWriter.newLine();
		bWriter.close();
	}
	
	// writerFile Metodu Overloading Edildi. Bu metod StringBuilder Icin Yazdirma Islemi Yapacak.
		public void writerFile(Object object) throws IOException {
			FileWriter fWriter = new FileWriter(filePath);
			BufferedWriter bWriter = new BufferedWriter(fWriter);
			
			bWriter.write(object.toString());
			bWriter.close();
		}
	
	//Dosyada arama işlemi yapıldı
	public void searchData() throws IOException {
		File file = new File(filePath);
		checkDataBase(file);
		
		FileReader fReader = new FileReader(filePath);
		BufferedReader bReader = new BufferedReader(fReader);
		
		String line;
		boolean durum = false;
		
		while((line = bReader.readLine()) != null) {
			String[] array = line.split("\t");
			
			if(title.equalsIgnoreCase(array[0])) {
				String stringData = array[0] + " / " + array[1] + " / " + array[2] + " / " + array[3] + " / " + array[4];
				JOptionPane.showMessageDialog(null, stringData);
				durum = true;
			}
		}
		
		if(!durum) {
			JOptionPane.showMessageDialog(null, "Aradığını kitap sistemde yer almamaktadır!");
		}
		
		bReader.close();
	}
	
	//Update işlemi gerçekleştirildi
	public void updateData(String nPrice) throws IOException {
		File file = new File(filePath);
		checkDataBase(file);
		
		FileReader fReader = new FileReader(filePath);
		BufferedReader bReader = new BufferedReader(fReader);
		
		StringBuilder builder = new StringBuilder();
		
		String line;
		String newPrice = nPrice;
		
		boolean durum = false;
		
		while((line = bReader.readLine()) != null) {
			String[] array = line.split("\t");
			
			if(price.equals(array[4])) {
				builder.append(array[0] + "\t" + array[1] + "\t" + array[2] + "\t" + array[3] + "\t" + newPrice + "\n");
				durum = true;
			}
			else {
				builder.append(line + "\n");
			}
			
		}
		
		if(durum) {
			writerFile(builder);
			JOptionPane.showMessageDialog(null, "Sistemdeki Ilgili Ücretler Değiştirilmiştir.");
		}
		else {
			JOptionPane.showMessageDialog(null, "Degiştirmek Istediğiniz Ücret Sistemde Bulunamadı.");
		}
		
		bReader.close();
		
	}
	
	
	//Silme işlemi gerçekleşti
	public void deleteData() throws IOException {
		File file = new File(filePath);
		checkDataBase(file);
		
		FileReader fReader = new FileReader(filePath);
		BufferedReader bReader = new BufferedReader(fReader);
		
		StringBuilder builder = new StringBuilder();
		
		String line;
		boolean durum = false;
		
		while((line = bReader.readLine()) != null) {
			String[] array = line.split("\t");
			
			if(title.equalsIgnoreCase(array[0])) {
				durum = true;
			}
			else {
				builder.append(line + "\n");
			}
			
		}
		
		if(durum) {
			writerFile(builder);
			JOptionPane.showMessageDialog(null, "Ilgili Kitap Sistemden Silinmistir.");
		}
		else {
			JOptionPane.showMessageDialog(null, "Silmek Istediðiniz Kitap, Sistemde Bulunamadý.");
		}
		
		bReader.close();
	}
	
	
	//Veri getirme işlemi gerçekleşti
	public StringBuilder getData() throws IOException {
		
		File file = new File(filePath);
		checkDataBase(file);
		
		FileReader fReader = new FileReader(filePath);
		BufferedReader bReader = new BufferedReader(fReader);
		
		StringBuilder builder = new StringBuilder();
		String line;
		
		boolean durum = false;
		
		while((line = bReader.readLine()) != null) {
			
			builder.append(line + "\n");
			durum = true;
			
		}
		
		bReader.close();
		
		if(durum) {
			return builder;
		}
		else {
			builder.append("");
			return builder;
		}
	}
	
	
	

}
