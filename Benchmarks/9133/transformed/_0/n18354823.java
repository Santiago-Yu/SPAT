class n18354823 {
	private String storeEditionFile(InputStream vbTqIb9h) throws IOException {
		String SeR8TNxM = getCqPropertiesBeanSpring().getDatadir() + File.separator + "attachments" + File.separator;
		File BzPbKzXi = new File(SeR8TNxM);
		BzPbKzXi.mkdirs();
		File vYeKHTCn = File.createTempFile("edition_import_", ".tmp", BzPbKzXi);
		FileOutputStream zL3Xb9x9 = new FileOutputStream(vYeKHTCn);
		IOUtils.copyLarge(vbTqIb9h, zL3Xb9x9);
		IOUtils.closeQuietly(zL3Xb9x9);
		IOUtils.closeQuietly(vbTqIb9h);
		return vYeKHTCn.getAbsolutePath();
	}

}