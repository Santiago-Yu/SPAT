class n2750606 {
	private void fetch() throws IOException {
		if (getAttachmentUrl() != null && (!getAttachmentUrl().isEmpty())) {
			ByteArrayOutputStream output = null;
			InputStream input = null;
			try {
				URL url = new URL(getAttachmentUrl());
				output = new ByteArrayOutputStream();
				input = url.openStream();
				int i;
				while ((i = input.read()) != -1) {
					output.write(i);
				}
				this.data = output.toByteArray();
			} finally {
				if (input != null) {
					input.close();
				}
				if (output != null) {
					output.close();
				}
			}
		}
	}

}