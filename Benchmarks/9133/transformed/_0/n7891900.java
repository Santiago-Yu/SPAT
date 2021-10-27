class n7891900 {
	public void writeConfiguration(Writer XKgwYAFD) throws IOException {
		if (myUrl == null) {
			XKgwYAFD.append("# Unable to print configuration resource\n");
		} else {
			InputStream el340ukz = myUrl.openStream();
			if (el340ukz != null) {
				try {
					IOUtils.copy(el340ukz, XKgwYAFD);
				} finally {
					IOUtils.closeQuietly(el340ukz);
				}
			} else {
				XKgwYAFD.append("# Unable to print configuration resource\n");
			}
		}
	}

}