class n17996547 {
	public static File copyFile(File fileToCopy, File copiedFile) {
		BufferedOutputStream outWriter = null;
		BufferedInputStream in = null;
		if (!copiedFile.exists()) {
			try {
				copiedFile.createNewFile();
			} catch (IOException e1) {
				e1.printStackTrace();
				return null;
			}
		}
		try {
			outWriter = new BufferedOutputStream(new FileOutputStream(copiedFile), 4096);
			in = new BufferedInputStream(new FileInputStream(fileToCopy), 4096);
			int c;
			while ((c = in.read()) != -1)
				outWriter.write(c);
			in.close();
			outWriter.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		return copiedFile;
	}

}