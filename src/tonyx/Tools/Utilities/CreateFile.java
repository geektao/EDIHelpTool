package tonyx.Tools.Utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

final public class CreateFile {
	public static void createXMLFile(Element root, String path, String filename) {
		createXMLFile(root, path + filename);
	}

	public static void createXMLFile(Element root, String filename) {
		Document doc = new Document(root);

		Format format = Format.getPrettyFormat();
		format.setEncoding("UTF-8");
		format.setIndent("");
		XMLOutputter XMLOut = new XMLOutputter(format);
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(filename + ".mxl");
			XMLOut.output(doc, fos);
			fos.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			XMLOut = null;
			doc = null;
		}
	}

	public static void createCSVFile(StringBuffer strBuf, String path,
			String fileName) {
		File outfile = new File(path, fileName + ".csv");

		byte[] bt = strBuf.toString().getBytes();
		try {
			outfile.createNewFile();
			FileOutputStream out = new FileOutputStream(outfile);

			out.write(bt);
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void createXLSFile(Workbook wb, String path, String name) {
		FileOutputStream fileOut;
		try {
			fileOut = new FileOutputStream(path + "\\" + name + ".xls");
			wb.write(fileOut);
			fileOut.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
