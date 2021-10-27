class n12413704 {
	private static String readUrl(String filePath, String charCoding, boolean urlIsFile) throws IOException {
		int chunkLength;
		InputStream is = null;
		try {
			if (!urlIsFile) {
				URL urlObj = new URL(filePath);
				URLConnection uc = urlObj.openConnection();
				is = uc.getInputStream();
				chunkLength = uc.getContentLength();
				chunkLength = (chunkLength <= 0) ? 1024 : chunkLength;
				if (charCoding == null) {
					String type = uc.getContentType();
					charCoding = (type != null) ? getCharCodingFromType(type) : charCoding;
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
			Reader r;
			r = (charCoding == null) ? new InputStreamReader(is) : new InputStreamReader(is, charCoding);
			return readReader(r, chunkLength);
		} finally {
			if (is != null)
				is.close();
		}
	}

}