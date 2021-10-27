class n23201697 {
	private byte[] loadResourceFromCodeBase(String name) {
		byte[] bytecode;
		InputStream is = null;
		logger.debug("LoadResourceFromCodeBase()++");
		try {
			URL url = new URL(this._codeBase, name);
			int content_length = -1;
			URLConnection connection = url.openConnection();
			connection.setRequestProperty("user-agent", "Aglets/1.1");
			connection.setRequestProperty("agent-system", "aglets");
			connection.setRequestProperty("agent-language", "java");
			connection.setDoInput(true);
			connection.setUseCaches(false);
			connection.connect();
			is = connection.getInputStream();
			content_length = connection.getContentLength();
			if (content_length < 0) {
				content_length = is.available();
			}
			if (content_length == 0) {
				return null;
			}
			bytecode = new byte[content_length];
			int offset = 0;
			while (content_length > 0) {
				int read = is.read(bytecode, offset, content_length);
				offset = offset + (read);
				content_length = content_length - (read);
			}
			is.close();
		} catch (IOException ex) {
			logger.error("Error loading [" + name + "] resource from [" + this._codeBase + "]", ex);
			bytecode = null;
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (Exception ex) {
					logger.error("Error closing.", ex);
				}
			}
		}
		logger.debug("LoadResourceFromCodeBase()--");
		return bytecode;
	}

}