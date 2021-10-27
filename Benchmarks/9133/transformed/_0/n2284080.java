class n2284080 {
	private static void copy(String tJaMsLrG, String QYD64rBE, boolean QGIy1T88) throws IOException,
			XPathFactoryConfigurationException, SAXException, ParserConfigurationException, XPathExpressionException {
		File njHkiNKu = new File(rootDir + "test-output/" + tJaMsLrG);
		if (njHkiNKu.exists()) {
			File sswhL2Eo = new File(rootDir + "test-output/" + QYD64rBE);
			if (!sswhL2Eo.exists() || QGIy1T88) {
				try {
					FileChannel UTE9kd0s = new FileInputStream(rootDir + "test-output/" + tJaMsLrG).getChannel();
					FileChannel cHYPtJJo = new FileOutputStream(rootDir + "test-output/" + QYD64rBE).getChannel();
					cHYPtJJo.transferFrom(UTE9kd0s, 0, UTE9kd0s.size());
					UTE9kd0s.close();
					cHYPtJJo.close();
				} catch (IOException bi0AWxms) {
				}
			}
		}
	}

}