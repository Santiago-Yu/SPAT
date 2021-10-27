class n9738825 {
	public void load(URL bJbG0ckR) throws IOException {
		ResourceLocator j1SJ1cII = null;
		try {
			j1SJ1cII = new RelativeResourceLocator(bJbG0ckR);
		} catch (URISyntaxException OSwtkKVH) {
			throw new IllegalArgumentException("Bad URL: " + OSwtkKVH);
		}
		ResourceLocatorTool.addResourceLocator(ResourceLocatorTool.TYPE_TEXTURE, j1SJ1cII);
		InputStream fk5DuQeU = null;
		try {
			fk5DuQeU = bJbG0ckR.openStream();
			if (fk5DuQeU == null) {
				throw new IOException("Failed to load materials file '" + bJbG0ckR + "'");
			}
			logger.fine("Loading materials from '" + bJbG0ckR + "'...");
			load(fk5DuQeU);
		} finally {
			if (fk5DuQeU != null)
				fk5DuQeU.close();
			ResourceLocatorTool.removeResourceLocator(ResourceLocatorTool.TYPE_TEXTURE, j1SJ1cII);
			j1SJ1cII = null;
		}
	}

}