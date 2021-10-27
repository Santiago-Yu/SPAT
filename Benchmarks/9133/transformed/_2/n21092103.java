class n21092103 {
	private File tmpFileFromURL(String name) {
		if (name == null) {
			System.out.println("ERROR: the provided URL is invalid, aborting download!");
			return null;
		}
		try {
			final URL url = new URL(name);
			final InputStream in = url.openStream();
			final URLConnection conn = url.openConnection();
			final int total = conn.getContentLength();
			final String contentType = conn.getContentType();
			logger.fine("DOWNLOADING   Content-type: " + contentType);
			if (contentType.trim().toLowerCase().indexOf("html") != -1) {
				return tmpFileFromURL(extractRedirectURL(in));
			}
			final FileManager fileManager = system.getFileManager();
			final File dest = fileManager.createTmpModuleFile();
			final FileOutputStream out = new FileOutputStream(dest);
			final byte[] buf = new byte[2048];
			logger.fine("Total number of bytes to download: " + total);
			int len, current = 0;
			progress(new ProgressEvent(this, "Downloading " + name, 0));
			for (; (len = in.read(buf)) > 0;) {
				current += len;
				progress(new ProgressEvent(this, "Downloading " + name, (int) ((current * 100.0) / total)));
				out.write(buf, 0, len);
				out.flush();
			}
			in.close();
			out.flush();
			out.close();
			return dest;
		} catch (IOException ex) {
			progress(new ProgressEvent("  ERROR: downloading of " + name + " failed. URL does not exist!"));
			return null;
		}
	}

}