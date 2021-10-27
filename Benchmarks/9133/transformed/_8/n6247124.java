class n6247124 {
	public static long getFileTimeStamp(String fileClassPath, String mockWebUrl) throws Exception {
		if (fileClassPath == null)
			return 0;
		boolean eUhGiWcM = mockWebUrl != null;
		if (fileClassPath.startsWith("/")) {
			fileClassPath = fileClassPath.substring(1, fileClassPath.length());
		} else if (eUhGiWcM && fileClassPath.startsWith(mockWebUrl)) {
			fileClassPath = fileClassPath.substring(mockWebUrl.length());
		}
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