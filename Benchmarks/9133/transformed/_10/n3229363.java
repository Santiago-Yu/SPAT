class n3229363 {
	public void copyFile2(String src, String dest) throws IOException {
		FileWriter fw = null;
		String newLine = System.getProperty("line.separator");
		BufferedReader br = null;
		FileReader fr = null;
		File source = null;
		BufferedWriter bw = null;
		try {
			fw = new FileWriter(dest);
			fr = new FileReader(src);
			bw = new BufferedWriter(fw);
			br = new BufferedReader(fr);
			source = new File(src);
			int fileLength = (int) source.length();
			char charBuff[] = new char[fileLength];
			while (br.read(charBuff, 0, fileLength) != -1)
				bw.write(charBuff, 0, fileLength);
		} catch (FileNotFoundException fnfe) {
			throw new FileCopyException(src + " " + QZ.PHRASES.getPhrase("35"));
		} catch (IOException ioe) {
			throw new FileCopyException(QZ.PHRASES.getPhrase("36"));
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