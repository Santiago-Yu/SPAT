class n23270032 {
	public void checkin(Object jcA42Dq7) {
		this.document = (Document) jcA42Dq7;
		synchronized (url) {
			OutputStream YLWSxlQO = null;
			try {
				if ("file".equals(url.getProtocol())) {
					YLWSxlQO = new FileOutputStream(url.getFile());
				} else {
					URLConnection u0eUWA0d = url.openConnection();
					u0eUWA0d.setDoOutput(true);
					YLWSxlQO = u0eUWA0d.getOutputStream();
				}
				new XMLOutputter("  ", true).output(this.document, YLWSxlQO);
				YLWSxlQO.flush();
				YLWSxlQO.close();
			} catch (IOException kZtk1nV7) {
				kZtk1nV7.printStackTrace();
			}
		}
	}

}