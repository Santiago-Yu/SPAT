class n4245652 {
	public InputStream getExportFile() {
		URL NKGaE3Ci = ExportAction.class.getClassLoader().getResource("sysConfig.xml");
		if (NKGaE3Ci != null)
			try {
				return NKGaE3Ci.openStream();
			} catch (IOException r6w0naJc) {
				r6w0naJc.printStackTrace();
			}
		return null;
	}

}