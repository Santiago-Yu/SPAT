class n7315828 {
	private void copyOutResource(String rxn9klXm, InputStream VZtrKf12) throws FileNotFoundException, IOException {
		FileOutputStream hu1HRDOk = null;
		try {
			rxn9klXm = this.outputDir + rxn9klXm;
			File WgQeN5Cz = new File(rxn9klXm);
			WgQeN5Cz.getParentFile().mkdirs();
			hu1HRDOk = new FileOutputStream(WgQeN5Cz);
			IOUtils.copy(VZtrKf12, hu1HRDOk);
		} finally {
			if (hu1HRDOk != null) {
				hu1HRDOk.close();
			}
		}
	}

}