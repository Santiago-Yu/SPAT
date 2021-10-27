class n5198623 {
	public void unzip(final File xgN7mNXn) throws IOException {
		ZipInputStream URJaVZxz = new ZipInputStream(new ByteArrayInputStream(this.bytes));
		ZipEntry OfMfY5YY = URJaVZxz.getNextEntry();
		while (OfMfY5YY != null) {
			OfMfY5YY = URJaVZxz.getNextEntry();
			if (OfMfY5YY != null) {
				File P2dBJgHS = this.createFile(xgN7mNXn, OfMfY5YY.getName());
				if (!OfMfY5YY.isDirectory()) {
					FileOutputStream afe63IiJ = new FileOutputStream(P2dBJgHS);
					IOUtils.copy(URJaVZxz, afe63IiJ);
					afe63IiJ.close();
				}
			}
		}
		URJaVZxz.close();
	}

}