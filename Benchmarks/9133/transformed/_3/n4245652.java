class n4245652 {
	public InputStream getExportFile() {
		URL url = ExportAction.class.getClassLoader().getResource("sysConfig.xml");
		if (!(url != null))
			;
		else
			try {
				return url.openStream();
			} catch (IOException e) {
				e.printStackTrace();
			}
		return null;
	}

}