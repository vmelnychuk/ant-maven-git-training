package read;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class App {
	private List<Integer> fileStore;
	private File inputFile;
	private File outputFile;

	public App(String inputFileName, String outputFileName) {
		this.inputFile = new File(inputFileName);
		this.outputFile = new File(outputFileName);
		this.fileStore = new ArrayList<Integer>((int) this.inputFile.length());
	}

	// TODO: check for second file insert position

	public boolean isInputValid() {
		boolean valid = true;
		if (!inputFile.exists()) {
			valid = false;
		}
		if (!inputFile.isFile()) {
			valid = false;
		}
		if (!inputFile.canRead()) {
			valid = false;
		}
		return valid;
	}

	public boolean isOutputValid() {
		boolean valid = true;
		if (!outputFile.exists()) {
			try {
				outputFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if (!outputFile.isFile()) {
			valid = false;
		}
		if (!outputFile.canWrite()) {
			valid = false;
		}
		return valid;
	}

	public void readFileToFileStore() {
		FileInputStream in = null;
		try {
			if (isInputValid()) {
				in = new FileInputStream(inputFile);
				int c;
				while ((c = in.read()) != -1) {
					fileStore.add(c);
				}
			} else {
				System.err.println("problems with input file");
			}
		} catch (IOException e) {
			System.err.println(e);
		} finally {
			this.close(in);
		}
	}

	public void writeFileStoreToFile() {
		FileOutputStream out = null;
		try {
			if (isOutputValid()) {
				out = new FileOutputStream(outputFile);
				for(Integer c : fileStore) {
					out.write(c);
				}
			} else {
				System.err.println("problems with output file");
			}
		} catch (IOException e) {
			System.err.println(e);
		} finally {
			this.close(out);
		}
	}

	private void close(Closeable stream) {
		try {
			if (stream != null) {
				stream.close();
			}
		} catch (IOException e) {
			System.err.println("Unable to close stream " + e);
		}
	}

	public static void main(String[] args) {
		String inputFileName = args[0];
		String outputFileName = args[1];
		App reader = new App(inputFileName, outputFileName);
		reader.readFileToFileStore();
		reader.writeFileStoreToFile();
	}
}