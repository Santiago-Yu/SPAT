class n14157859 {
	static void copyFile(File file, File file1) throws IOException {
		FileInputStream fileinputstream = new FileInputStream(file);
		byte abyte0[] = new byte[512];
		int i;
		FileOutputStream fileoutputstream = new FileOutputStream(file1);
		while ((i = fileinputstream.read(abyte0)) > 0)
			fileoutputstream.write(abyte0, 0, i);
		fileinputstream.close();
		fileoutputstream.close();
	}

}