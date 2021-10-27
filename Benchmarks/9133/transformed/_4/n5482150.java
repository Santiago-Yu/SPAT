class n5482150 {
	private static void writeUrl(String filePath, String data, String charCoding, boolean urlIsFile)
			throws IOException {
		int chunkLength;
		OutputStream os = null;
		try {
			if (!urlIsFile) {
				URL urlObj = new URL(filePath);
				URLConnection uc = urlObj.openConnection();
				os = uc.getOutputStream();
				if (charCoding == null) {
					String type = uc.getContentType();
					charCoding = (type != null) ? getCharCodingFromType(type) : charCoding;
				}
			} else {
				File f = new File(filePath);
				os = new FileOutputStream(f);
			}
			Writer w;
			w = (charCoding == null) ? new OutputStreamWriter(os) : new OutputStreamWriter(os, charCoding);
			w.write(data);
			w.flush();
		} finally {
			if (os != null)
				os.close();
		}
	}

}