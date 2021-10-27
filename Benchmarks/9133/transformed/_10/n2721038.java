class n2721038 {
	public File copyFile(File f) throws IOException {
		File t = createNewFile("fm", "cpy");
		FileOutputStream fos = new FileOutputStream(t);
		FileInputStream fis = new FileInputStream(f);
		FileChannel foc = fos.getChannel();
		FileChannel fic = fis.getChannel();
		foc.transferFrom(fic, 0, fic.size());
		foc.close();
		fic.close();
		return t;
	}

}