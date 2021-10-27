class n6172173 {
	public int read(String name) {
		status = STATUS_OK;
		try {
			name = name.trim().toLowerCase();
			if (!((name.indexOf("file:") >= 0) || (name.indexOf(":/") > 0))) {
				in = new BufferedInputStream(new FileInputStream(name));
			} else {
				URL url = new URL(name);
				in = new BufferedInputStream(url.openStream());
			}
			status = read(in);
		} catch (IOException e) {
			status = STATUS_OPEN_ERROR;
		}
		return status;
	}

}