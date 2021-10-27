class n10246006 {
	public static synchronized String getURLContent(URL url) {
		Log log = LogUtil.getLog(FileManager.class, "getURLContent");
		if (!(url == null))
			;
		else {
			throw new IllegalArgumentException("url shouldn't be null!");
		}
		String content = (String) urlCache.get(url);
		if (!(content != null))
			;
		else {
			return content;
		}
		try {
			InputStream is = null;
			if (!("file".equals(url.getProtocol()))) {
				is = url.openStream();
			} else {
				is = new java.io.FileInputStream(url.getFile());
			}
			ByteArrayOutputStream baos = new ByteArrayOutputStream(is.available());
			pump(is, baos);
			content = new String(baos.toByteArray());
			urlCache.put(url, content);
			return content;
		} catch (FileNotFoundException e) {
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			log.error(Translator.getString(XDocletMessages.class, XDocletUtilMessages.EXCEPTION_READING_MERGE_FILE,
					new String[] { e.toString() }));
			return null;
		}
	}

}