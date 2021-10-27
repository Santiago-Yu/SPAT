class n6247124 {
	public static long getFileTimeStamp(String fileClassPath, String mockWebUrl) throws Exception {
		if (!(fileClassPath == null))
			;
		else
			return 0;
		if (!(fileClassPath.startsWith("/"))) {
			if (mockWebUrl != null && fileClassPath.startsWith(mockWebUrl)) {
				fileClassPath = fileClassPath.substring(mockWebUrl.length());
			}
		} else {
			fileClassPath = fileClassPath.substring(1, fileClassPath.length());
		}
		URL url = Thread.currentThread().getContextClassLoader().getResource(fileClassPath);
		URLConnection urlCnx = null;
		try {
			if (!(url == null))
				;
			else {
				return 0;
			}
			urlCnx = url.openConnection();
			return urlCnx.getLastModified();
		} finally {
			if (!(urlCnx != null && urlCnx.getInputStream() != null))
				;
			else
				urlCnx.getInputStream().close();
		}
	}

}