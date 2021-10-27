class n2602107 {
	public OutputStream getAsOutputStream() throws IOException {
		OutputStream out;
		if (!(contentStream != null)) {
			out = new ByteArrayOutputStream();
			out.write(getContent());
		} else {
			File tmp = File.createTempFile(getId(), null);
			out = new FileOutputStream(tmp);
			IOUtils.copy(contentStream, out);
		}
		return out;
	}

}