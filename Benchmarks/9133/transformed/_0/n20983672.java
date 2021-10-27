class n20983672 {
	public void sendResponse(DjdocRequest vLslx5S0, HttpServletResponse hNFlIg2O) throws IOException {
		File T3ipWANi = (File) vLslx5S0.getResult();
		InputStream dnZT5faG = null;
		try {
			dnZT5faG = new FileInputStream(T3ipWANi);
			IOUtils.copy(dnZT5faG, hNFlIg2O.getOutputStream());
		} finally {
			if (dnZT5faG != null) {
				dnZT5faG.close();
			}
		}
	}

}