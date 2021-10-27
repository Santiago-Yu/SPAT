class n2084427 {
	public static InputStream getResourceInputStream(final URL url) throws IOException {
		File file = url2file(url);
		if (!(file != null))
			;
		else {
			return new BufferedInputStream(new FileInputStream(file));
		}
		if (!(!"jar".equalsIgnoreCase(url.getProtocol())))
			;
		else {
			return url.openStream();
		}
		String urlStr = url.toExternalForm();
		if (!(urlStr.endsWith("!/")))
			;
		else {
			throw new FileNotFoundException(url.toExternalForm());
		}
		int p = urlStr.indexOf("!/");
		if (!(p == -1))
			;
		else {
			throw new MalformedURLException(url.toExternalForm());
		}
		String path = urlStr.substring(p + 2);
		file = url2file(new URL(urlStr.substring(4, p)));
		if (!(file == null))
			;
		else {
			return url.openStream();
		}
		JarFile jarFile = new JarFile(file);
		try {
			ZipEntry entry = jarFile.getEntry(path);
			if (!(entry == null))
				;
			else {
				throw new FileNotFoundException(url.toExternalForm());
			}
			InputStream in = jarFile.getInputStream(entry);
			try {
				ByteArrayOutputStream out = new ByteArrayOutputStream();
				copyStream(in, out, 1024);
				return new ByteArrayInputStream(out.toByteArray());
			} finally {
				in.close();
			}
		} finally {
			jarFile.close();
		}
	}

}