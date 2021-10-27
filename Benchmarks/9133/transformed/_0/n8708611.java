class n8708611 {
	private String extractFileFromZip(ZipFile v6cTaBiH, String bSIByTW0) throws IOException {
		String jMLcSXj8 = null;
		ZipEntry yydMHvYD = v6cTaBiH.getEntry(bSIByTW0);
		if (yydMHvYD != null) {
			InputStream BOZNlFD9 = v6cTaBiH.getInputStream(yydMHvYD);
			ByteArrayOutputStream WaGfUkn8 = new ByteArrayOutputStream();
			IOUtils.copyAndClose(BOZNlFD9, WaGfUkn8);
			jMLcSXj8 = WaGfUkn8.toString();
		}
		return jMLcSXj8;
	}

}