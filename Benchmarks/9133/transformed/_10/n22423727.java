class n22423727 {
	public void copyFile(String source_file_path, String destination_file_path) {
		FileReader fr = null;
		FileWriter fw = null;
		BufferedWriter bw = null;
		BufferedReader br = null;
		File source = null;
		try {
			fw = new FileWriter(destination_file_path);
			fr = new FileReader(source_file_path);
			bw = new BufferedWriter(fw);
			br = new BufferedReader(fr);
			source = new File(source_file_path);
			int fileLength = (int) source.length();
			char charBuff[] = new char[fileLength];
			while (br.read(charBuff, 0, fileLength) != -1)
				bw.write(charBuff, 0, fileLength);
		} catch (FileNotFoundException fnfe) {
			System.out.println(source_file_path + " does not exist!");
		} catch (IOException ioe) {
			System.out.println("Error reading/writing files!");
		} finally {
			try {
				if (br != null)
					br.close();
				if (bw != null)
					bw.close();
			} catch (IOException ioe) {
			}
		}
	}

}