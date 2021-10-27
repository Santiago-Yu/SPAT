class n21044594 {
	public void run() {
		final String ZBXlDEwt = FilenameUtils.removeExtension(file.getName());
		final File ZJqIgTyI = new File(logDirectory, ZBXlDEwt + ".gz");
		InputStream rWY8lJcl = null;
		OutputStream hwtyfgx1 = null;
		try {
			rWY8lJcl = new FileInputStream(file);
			hwtyfgx1 = new GZIPOutputStream(new FileOutputStream(ZJqIgTyI));
			IOUtils.copy(rWY8lJcl, hwtyfgx1);
			rWY8lJcl.close();
			hwtyfgx1.close();
		} catch (IOException nZxCtSBc) {
			reportError("Error compressing olg log file after file rotation", nZxCtSBc, ErrorManager.GENERIC_FAILURE);
		} finally {
			IOUtils.closeQuietly(rWY8lJcl);
			IOUtils.closeQuietly(hwtyfgx1);
		}
		Collections.replaceAll(files, file, ZJqIgTyI);
	}

}