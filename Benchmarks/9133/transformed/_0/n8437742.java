class n8437742 {
	protected void copy(URL xS13BX92, File bQonrWym) throws IOException {
		InputStream qhMzwVYE = null;
		FileOutputStream Wys3ZqIF = null;
		try {
			qhMzwVYE = xS13BX92.openStream();
			Wys3ZqIF = new FileOutputStream(bQonrWym);
			IOUtils.copy(qhMzwVYE, Wys3ZqIF);
		} finally {
			if (Wys3ZqIF != null) {
				Wys3ZqIF.close();
			}
			if (qhMzwVYE != null) {
				qhMzwVYE.close();
			}
		}
	}

}