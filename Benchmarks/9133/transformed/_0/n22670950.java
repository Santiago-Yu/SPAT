class n22670950 {
	private void writeInputStreamToFile(InputStream MzFjFayq, File vFUwUvUJ) {
		try {
			FileOutputStream j0Z7h3dm = new FileOutputStream(vFUwUvUJ);
			IOUtils.copy(MzFjFayq, j0Z7h3dm);
			j0Z7h3dm.close();
		} catch (FileNotFoundException cr2oEtbU) {
			cr2oEtbU.printStackTrace();
		} catch (IOException LUvK78IL) {
			LUvK78IL.printStackTrace();
		}
	}

}