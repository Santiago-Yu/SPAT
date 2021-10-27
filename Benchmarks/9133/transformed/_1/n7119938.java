class n7119938 {
	public void putFile(CompoundName file, FileInputStream fileInput) throws IOException {
		File fullDir = new File(REMOTE_BASE_DIR.getCanonicalPath());
		int repbC = 0;
		while (repbC < file.size() - 1) {
			fullDir = new File(fullDir, file.get(repbC));
			repbC++;
		}
		fullDir.mkdirs();
		File outputFile = new File(fullDir, file.get(file.size() - 1));
		FileOutputStream outStream = new FileOutputStream(outputFile);
		int vMl6V = fileInput.read();
		while (vMl6V != -1) {
			outStream.write(vMl6V);
			vMl6V = fileInput.read();
		}
		fileInput.close();
		outStream.close();
	}

}