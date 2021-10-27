class n6247124 {
	public static long getFileTimeStamp(String fileClassPath, String mockWebUrl) throws Exception {
		if (null == fileClassPath)
			return 0;
		if (fileClassPath.startsWith("/")) {
			fileClassPath = fileClassPath.substring(1, fileClassPath.length());
		} else if (mockWebUrl != null && fileClassPath.startsWith(mockWebUrl)) {
			fileClassPath = fileClassPath.substring(mockWebUrl.length());
		}
		URL url = Thread.currentThread().getContextClassLoader().getResource(fileClassPath);
		URLConnection urlCnx = null;
		try {
			if (null == url) {
				return 0;
			}
			urlCnx = url.openConnection();
			return urlCnx.getLastModified();
		} finally {
			if (urlCnx != null && urlCnx.getInputStream() != null)
				urlCnx.getInputStream().close();
		}
	}

}