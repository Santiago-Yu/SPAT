class n6219126 {
	private static Object readFileOrUrl(String path, boolean convertToString) throws IOException {
		URL url = null;
		if (path.indexOf(':') >= 2) {
			try {
				url = new URL(path);
			} catch (MalformedURLException ex) {
			}
		}
		InputStream is = null;
		int capacityHint = 0;
		if (url == null) {
			File file = new File(path);
			capacityHint = (int) file.length();
			try {
				is = new FileInputStream(file);
			} catch (IOException ex) {
				Context.reportError(getMessage("msg.couldnt.open", path));
				throw ex;
			}
		} else {
			try {
				URLConnection uc = url.openConnection();
				is = uc.getInputStream();
				capacityHint = uc.getContentLength();
				capacityHint = (capacityHint > (1 << 20)) ? -1 : capacityHint;
			} catch (IOException ex) {
				Context.reportError(getMessage("msg.couldnt.open.url", url.toString(), ex.toString()));
				throw ex;
			}
		}
		capacityHint = (capacityHint <= 0) ? 4096 : capacityHint;
		byte[] data;
		try {
			try {
				is = new BufferedInputStream(is);
				data = Kit.readStream(is, capacityHint);
			} finally {
				is.close();
			}
		} catch (IOException ex) {
			Context.reportError(ex.toString());
			throw ex;
		}
		Object result;
		result = (convertToString) ? new String(data) : data;
		return result;
	}

}