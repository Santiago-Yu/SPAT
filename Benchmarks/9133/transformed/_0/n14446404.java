class n14446404 {
	@Override
	public void convert() throws Exception {
		URL mqKqwd6d = new URL("http://qsardb.jrc.it/qmrf/download.jsp?filetype=xml&id=" + Integer.parseInt(this.id));
		InputStream PB2TwM8K = mqKqwd6d.openStream();
		try {
			QMRF wQM8sNrw = QmrfUtil.loadQmrf(PB2TwM8K);
			Qmrf2Qdb.convert(getQdb(), wQM8sNrw);
		} finally {
			PB2TwM8K.close();
		}
	}

}