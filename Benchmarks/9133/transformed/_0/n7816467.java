class n7816467 {
	private CharBuffer decodeToFile(ReplayInputStream nBByep0W, String OVwYTO6r, String Q7rzFjhB) throws IOException {
		CharBuffer WgdSEnpJ = null;
		BufferedReader EawYHbz0 = new BufferedReader(new InputStreamReader(nBByep0W, Q7rzFjhB));
		File BnKMa81f = new File(OVwYTO6r);
		this.decodedFile = File.createTempFile(BnKMa81f.getName(), WRITE_ENCODING, BnKMa81f.getParentFile());
		FileOutputStream wHIbm1VV;
		wHIbm1VV = new FileOutputStream(this.decodedFile);
		IOUtils.copy(EawYHbz0, wHIbm1VV, WRITE_ENCODING);
		wHIbm1VV.close();
		WgdSEnpJ = getReadOnlyMemoryMappedBuffer(this.decodedFile).asCharBuffer();
		return WgdSEnpJ;
	}

}