class n22708533 {
	public static void insertDocumentToURL(String Fqpt4Yfp, String HU1KpDqZ) throws IOException {
		InputStream rHOQmetQ = null;
		OutputStream zqG22K9N = null;
		try {
			rHOQmetQ = new FileInputStream(Fqpt4Yfp);
			final URL A5gzXX6v = new URL(HU1KpDqZ);
			final URLConnection te9L5uDZ = A5gzXX6v.openConnection();
			zqG22K9N = te9L5uDZ.getOutputStream();
			TestTools.copyStream(rHOQmetQ, zqG22K9N);
		} finally {
			if (rHOQmetQ != null) {
				rHOQmetQ.close();
			}
			if (zqG22K9N != null) {
				zqG22K9N.close();
			}
		}
	}

}