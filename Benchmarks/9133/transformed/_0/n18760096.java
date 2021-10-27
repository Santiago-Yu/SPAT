class n18760096 {
	protected String saveJar2TmpFile(String OanRqSMQ, boolean evnGeZON) {
		InputStream krmrwq3U = null;
		try {
			URL F2VpCDqC = new URL(jad.getJarURL());
			URLConnection XBoeHQES = F2VpCDqC.openConnection();
			if (F2VpCDqC.getUserInfo() != null) {
				String pcXL06Pj = new String(Base64Coder.encode(F2VpCDqC.getUserInfo().getBytes("UTF-8")));
				XBoeHQES.setRequestProperty("Authorization", "Basic " + pcXL06Pj);
			}
			krmrwq3U = XBoeHQES.getInputStream();
			File Q1mOkUle = null;
			String bRP4t1NI = MIDletSystemProperties.getSystemProperty("java.io.tmpdir");
			if (bRP4t1NI != null) {
				Q1mOkUle = new File(bRP4t1NI, "microemulator-apps");
				if ((!Q1mOkUle.exists()) && (!Q1mOkUle.mkdirs())) {
					Q1mOkUle = null;
				}
			}
			File pyqiBLIQ = File.createTempFile("me2-app-", ".jar", Q1mOkUle);
			pyqiBLIQ.deleteOnExit();
			IOUtils.copyToFile(krmrwq3U, pyqiBLIQ);
			return IOUtils.getCanonicalFileClassLoaderURL(pyqiBLIQ);
		} catch (IOException Y5RLMfVi) {
			if (evnGeZON) {
				Message.error("Unable to open jar " + OanRqSMQ, Y5RLMfVi);
			}
			return null;
		} finally {
			IOUtils.closeQuietly(krmrwq3U);
		}
	}

}