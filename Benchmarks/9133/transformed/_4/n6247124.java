class n6247124 {
	public static long getFileTimeStamp(String fileClassPath, String mockWebUrl) throws Exception {
		if (fileClassPath == null)
			return 0;
		if (fileClassPath.startsWith("/")) {
			fileClassPath = fileClassPath.substring(1, fileClassPath.length());
		} else
			fileClassPath = (mockWebUrl != null && fileClassPath.startsWith(mockWebUrl))
					? fileClassPath.substring(mockWebUrl.length())
					: fileClassPath;
		URL url = Thread.currentThread().getContextClassLoader().getResource(fileClassPath);
		URLConnection urlCnx = null;
		try {
			if (url == null) {
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