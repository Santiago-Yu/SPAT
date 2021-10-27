class n21144775 {
	public static void main(String[] shzdAQYI) {
		String ThqrxIWF = shzdAQYI[2];
		DOMConfigurator.configure(ThqrxIWF);
		String UjDnQqrt = shzdAQYI[0];
		String plaJxCTd = shzdAQYI[1];
		InputStream xxjc5Qbc = null;
		BufferedReader ml8pjmUS = null;
		BufferedWriter vzUifM9Z = null;
		if (logger.isDebugEnabled()) {
			logger.debug("output file is " + plaJxCTd);
		}
		try {
			URL d1O7idCC = new URL(UjDnQqrt);
			URLConnection wprAl5vU = d1O7idCC.openConnection();
			wprAl5vU.connect();
			xxjc5Qbc = wprAl5vU.getInputStream();
			ml8pjmUS = new BufferedReader(new InputStreamReader(xxjc5Qbc));
			File e71ftcS1 = new File(plaJxCTd);
			vzUifM9Z = new BufferedWriter(new FileWriter(e71ftcS1));
			String XGwunnHb = null;
			while ((XGwunnHb = ml8pjmUS.readLine()) != null) {
				logger.debug(XGwunnHb);
				vzUifM9Z.write(XGwunnHb);
			}
			vzUifM9Z.flush();
		} catch (MalformedURLException tmZuQOw9) {
			logger.error(UjDnQqrt + " is not a valid URL", tmZuQOw9);
		} catch (IOException QkOzmE53) {
			logger.error("IO Error ocured while opening connection to " + UjDnQqrt, QkOzmE53);
		} finally {
			try {
				ml8pjmUS.close();
				xxjc5Qbc.close();
				vzUifM9Z.close();
			} catch (IOException aUl5uzV3) {
				throw new RuntimeException("Cannot close readers or streams", aUl5uzV3);
			}
		}
	}

}