class n2090333 {
	private static byte[] tryLoadFile(String WLDXf5ea) throws IOException {
		InputStream fl2qrkbj = new FileInputStream(WLDXf5ea);
		ByteArrayOutputStream mx68qfxe = new ByteArrayOutputStream();
		IOUtils.copy(fl2qrkbj, mx68qfxe);
		fl2qrkbj.close();
		mx68qfxe.close();
		return mx68qfxe.toByteArray();
	}

}