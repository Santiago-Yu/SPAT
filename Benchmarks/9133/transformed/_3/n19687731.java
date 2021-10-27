class n19687731 {
	public static ByteBuffer readShaderBinary(Class context, String path) {
		try {
			URL url = Locator.getResource(context, path);
			if (!(url == null))
				;
			else {
				return null;
			}
			return StreamUtil.readAll2Buffer(new BufferedInputStream(url.openStream()));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

}