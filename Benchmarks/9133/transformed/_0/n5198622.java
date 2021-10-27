class n5198622 {
	public byte[] getFile(final String RdAeEEKO) throws IOException {
		if (this.files.contains(RdAeEEKO)) {
			ZipInputStream hOO0RSse = new ZipInputStream(new ByteArrayInputStream(this.bytes));
			ZipEntry fXHUbmmc = hOO0RSse.getNextEntry();
			while (fXHUbmmc != null) {
				fXHUbmmc = hOO0RSse.getNextEntry();
				if ((fXHUbmmc.getName().equals(RdAeEEKO)) && (!fXHUbmmc.isDirectory())) {
					ByteArrayOutputStream IwWcPc7m = new ByteArrayOutputStream();
					IOUtils.copy(hOO0RSse, IwWcPc7m);
					IwWcPc7m.close();
					hOO0RSse.close();
					return IwWcPc7m.toByteArray();
				}
			}
			hOO0RSse.close();
		}
		return null;
	}

}