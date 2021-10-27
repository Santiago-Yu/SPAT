class n23201697 {
	private byte[] loadResourceFromCodeBase(String name) {
		InputStream is = null;
		byte[] bytecode;
		logger.debug("LoadResourceFromCodeBase()++");
		try {
			int content_length = -1;
			URL url = new URL(this._codeBase, name);
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
			int offset = 0;
			bytecode = new byte[content_length];
			while (content_length > 0) {
				int read = is.read(bytecode, offset, content_length);
				offset += read;
				content_length -= read;
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