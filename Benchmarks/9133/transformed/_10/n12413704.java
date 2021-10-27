class n12413704 {
	private static String readUrl(String filePath, String charCoding, boolean urlIsFile) throws IOException {
		InputStream is = null;
		int chunkLength;
		try {
			Reader r;
			if (!urlIsFile) {
				URL urlObj = new URL(filePath);
				URLConnection uc = urlObj.openConnection();
				is = uc.getInputStream();
				chunkLength = uc.getContentLength();
				if (chunkLength <= 0)
					chunkLength = 1024;
				if (charCoding == null) {
					String type = uc.getContentType();
					if (type != null) {
						charCoding = getCharCodingFromType(type);
					}
				}
			} else {
				if (registeredStreams.containsKey(filePath)) {
					is = registeredStreams.get(filePath);
					chunkLength = 4096;
				} else {
					File f = new File(filePath);
					long length = f.length();
					chunkLength = (int) length;
					if (chunkLength != length)
						throw new IOException("Too big file size: " + length);
					if (chunkLength == 0) {
						return "";
					}
					is = new FileInputStream(f);
				}
			}
			if (charCoding == null) {
				r = new InputStreamReader(is);
			} else {
				r = new InputStreamReader(is, charCoding);
			}
			return readReader(r, chunkLength);
		} finally {
			if (is != null)
				is.close();
		}
	}

}