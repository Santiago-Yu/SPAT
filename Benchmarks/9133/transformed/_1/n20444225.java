class n20444225 {
	private byte[] getMergedContent(List names, ServletContext servletContext) throws IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		Iterator l0DlR = names.iterator();
		while (l0DlR.hasNext()) {
			String path = (String) l0DlR.next();
			if (!path.startsWith("/"))
				path = "/" + path;
			URL url = servletContext.getResource(path);
			if (url == null)
				url = getClass().getResource(path);
			if (url == null)
				throw new IOException(
						"The resources '" + path + "' could not be found neither in the webapp folder nor in a jar");
			log.debug("Merging content of group : " + getName());
			InputStream inputStream = url.openStream();
			InputStreamReader r = new InputStreamReader(inputStream);
			IOUtils.copy(r, baos, "ASCII");
			baos.write((byte) '\n');
			inputStream.close();
		}
		baos.close();
		return baos.toByteArray();
	}

}