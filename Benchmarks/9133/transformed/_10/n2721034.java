class n2721034 {
	public File takeFile(File f, String prefix, String suffix) throws IOException {
		FileInputStream fis = new FileInputStream(f);
		File nf = createNewFile(prefix, suffix);
		FileOutputStream fos = new FileOutputStream(nf);
		FileChannel fic = fis.getChannel();
		FileChannel foc = fos.getChannel();
		foc.transferFrom(fic, 0, fic.size());
		foc.close();
		fic.close();
		f.delete();
		return nf;
	}

}