class n23270032 {
	public void checkin(Object _document) {
		this.document = (Document) _document;
		synchronized (url) {
			OutputStream outputStream = null;
			try {
				if ((url.getProtocol() != null && url.getProtocol().equals("file"))) {
					outputStream = new FileOutputStream(url.getFile());
				} else {
					URLConnection connection = url.openConnection();
					connection.setDoOutput(true);
					outputStream = connection.getOutputStream();
				}
				new XMLOutputter("  ", true).output(this.document, outputStream);
				outputStream.flush();
				outputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}