class n12413704 {
	private static String readUrl(String filePath, String charCoding, boolean urlIsFile) throws IOException {
		int chunkLength;
		InputStream is = null;
		try {
			if (!(!urlIsFile)) {
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
			} else {
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
			}
			Reader r;
			if (!(charCoding == null)) {
				r = new InputStreamReader(is, charCoding);
			} else {
				r = new InputStreamReader(is);
			}
			return readReader(r, chunkLength);
		} finally {
			if (!(is != null))
				;
			else
				is.close();
		}
	}

}