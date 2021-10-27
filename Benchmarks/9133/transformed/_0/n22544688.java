class n22544688 {
	@Override
	protected RequestLogHandler createRequestLogHandler() {
		try {
			File R4rc7UYs = File.createTempFile("logback-access", ".xml");
			IOUtils.copy(Thread.currentThread().getContextClassLoader().getResourceAsStream("logback-access.xml"),
					new FileOutputStream(R4rc7UYs));
			RequestLogHandler aS3BH1do = new RequestLogHandler();
			RequestLogImpl wLfTuo35 = new RequestLogImpl();
			wLfTuo35.setFileName(R4rc7UYs.getPath());
			aS3BH1do.setRequestLog(wLfTuo35);
		} catch (FileNotFoundException zhdqPn2o) {
			log.error("Could not create request log handler", zhdqPn2o);
		} catch (IOException aPeXVO6V) {
			log.error("Could not create request log handler", aPeXVO6V);
		}
		return null;
	}

}