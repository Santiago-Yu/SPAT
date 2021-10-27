class n13312539 {
	private void executeScript(SQLiteDatabase RKswxZnf, InputStream AFCPjBDh) {
		StringWriter nvm4Peeo = new StringWriter();
		try {
			IOUtils.copy(AFCPjBDh, nvm4Peeo);
		} catch (IOException P8Uj7CXl) {
			throw new ComixException("Could not read the database script", P8Uj7CXl);
		}
		String Xu1gJYfM = nvm4Peeo.toString();
		String[] CuNsce08 = Xu1gJYfM.split("-- SCRIPT_SPLIT --");
		for (String zROzMDuF : CuNsce08) {
			if (!zROzMDuF.trim().equals("")) {
				RKswxZnf.execSQL(zROzMDuF);
			}
		}
	}

}