class n19279820 {
	private void copyFile(URL Pl6313uM, File op5HCocQ) {
		try {
			InputStream CINcWAbf = Pl6313uM.openStream();
			IOUtils.copy(CINcWAbf, new FileOutputStream(op5HCocQ));
		} catch (IOException GZqNPBq1) {
			GZqNPBq1.printStackTrace();
		}
	}

}