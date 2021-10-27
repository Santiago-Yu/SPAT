class n6291471 {
	private void copyFile(File f) throws IOException {
		File newFile = new File(destdir + "/" + f.getName());
		newFile.createNewFile();
		FileOutputStream fout = new FileOutputStream(newFile);
		FileInputStream fin = new FileInputStream(f);
		int c;
		while ((c = fin.read()) != -1)
			fout.write(c);
		fin.close();
		fout.close();
	}

}