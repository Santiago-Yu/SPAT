class n20761702 {
	private File newFile(File oldFile) throws IOException {
		File nFile = new File(this.stateDirProvider.get() + File.separator + oldFile.getName());
		int counter = 0;
		while (nFile.exists()) {
			nFile = new File(this.stateDirProvider.get() + File.separator + oldFile.getName() + "_" + counter);
		}
		IOUtils.copyFile(oldFile, nFile);
		return nFile;
	}

}