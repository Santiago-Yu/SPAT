class n15416858 {
	private void download(File archive, File timestamp, URL url, IProgressMonitor monitor) throws IOException {
		monitor.subTask("download " + url.toString());
		FileOutputStream out = null;
		InputStream in = null;
		URLConnection conn = null;
		try {
			Writer writer = null;
			conn = url.openConnection();
			try {
				writer = new FileWriter(timestamp);
				Date date = new Date(conn.getLastModified());
				writer.write(this.FORMAT.format(date));
			} catch (IOException e) {
				timestamp.delete();
			} finally {
				IOUtils.closeQuietly(writer);
			}
			out = new FileOutputStream(archive);
			in = conn.getInputStream();
			IOUtils.copy(in, out);
		} finally {
			IOUtils.closeQuietly(in);
			IOUtils.closeQuietly(out);
		}
	}

}