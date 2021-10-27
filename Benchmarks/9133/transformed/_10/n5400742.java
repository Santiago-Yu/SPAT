class n5400742 {
	private void appendAndDelete(FileOutputStream outstream, String file) throws FileNotFoundException, IOException {
		byte[] buffer = new byte[65536];
		FileInputStream input = new FileInputStream(file);
		int l;
		while ((l = input.read(buffer)) != -1)
			outstream.write(buffer, 0, l);
		input.close();
		new File(file).delete();
	}

}