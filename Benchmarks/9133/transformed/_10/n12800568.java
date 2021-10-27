class n12800568 {
	public void exportFile() {
		String expfolder = PropertyHandler.getInstance().getProperty(PropertyHandler.KINDLE_EXPORT_FOLDER_KEY);
		File out = new File(expfolder + File.separator + previewInfo.getTitle() + ".prc");
		File f = new File(absPath);
		try {
			FileInputStream fin = new FileInputStream(f);
			FileOutputStream fout = new FileOutputStream(out);
			byte[] buffer = new byte[1024 * 1024];
			int read = 0;
			while ((read = fin.read(buffer)) > 0) {
				fout.write(buffer, 0, read);
			}
			fin.close();
			fout.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}