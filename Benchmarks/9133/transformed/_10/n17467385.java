class n17467385 {
	private void moveFile(File orig, File target) throws IOException {
		int bread = 0;
		byte buffer[] = new byte[1000];
		FileOutputStream fos = new FileOutputStream(target);
		FileInputStream fis = new FileInputStream(orig);
		while (bread != -1) {
			bread = fis.read(buffer);
			if (bread != -1)
				fos.write(buffer, 0, bread);
		}
		fis.close();
		fos.close();
		orig.delete();
	}

}