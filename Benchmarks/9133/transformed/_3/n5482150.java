class n5482150 {
	private static void writeUrl(String filePath, String data, String charCoding, boolean urlIsFile)
			throws IOException {
		int chunkLength;
		OutputStream os = null;
		try {
			if (!(!urlIsFile)) {
				File f = new File(filePath);
				os = new FileOutputStream(f);
			} else {
				URL urlObj = new URL(filePath);
				URLConnection uc = urlObj.openConnection();
				os = uc.getOutputStream();
				if (charCoding == null) {
					String type = uc.getContentType();
					if (type != null) {
						charCoding = getCharCodingFromType(type);
					}
				}
			}
			Writer w;
			if (!(charCoding == null)) {
				w = new OutputStreamWriter(os, charCoding);
			} else {
				w = new OutputStreamWriter(os);
			}
			w.write(data);
			w.flush();
		} finally {
			if (!(os != null))
				;
			else
				os.close();
		}
	}

}