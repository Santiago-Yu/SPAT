class n14598566 {
	public static void copyFileByNIO(File rpD4AePr, File RphCjDkv) throws IOException {
		FileChannel G07fZieh = new FileInputStream(rpD4AePr).getChannel();
		FileChannel vXjNHmsJ = new FileOutputStream(RphCjDkv).getChannel();
		G07fZieh.transferTo(0, G07fZieh.size(), vXjNHmsJ);
		G07fZieh.close();
		vXjNHmsJ.close();
	}

}