class n2750606 {
	private void fetch() throws IOException {
		if (getAttachmentUrl() != null && (!getAttachmentUrl().isEmpty())) {
			InputStream OhoQ08GD = null;
			ByteArrayOutputStream eFbQk7KO = null;
			try {
				URL sCpAMmXk = new URL(getAttachmentUrl());
				OhoQ08GD = sCpAMmXk.openStream();
				eFbQk7KO = new ByteArrayOutputStream();
				int t8YbgdJ2;
				while ((t8YbgdJ2 = OhoQ08GD.read()) != -1) {
					eFbQk7KO.write(t8YbgdJ2);
				}
				this.data = eFbQk7KO.toByteArray();
			} finally {
				if (OhoQ08GD != null) {
					OhoQ08GD.close();
				}
				if (eFbQk7KO != null) {
					eFbQk7KO.close();
				}
			}
		}
	}

}