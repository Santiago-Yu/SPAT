class n20089257 {
	public void store(String HLiGWkvT, InputStream bAn4I1mN) throws IOException {
		toIgnore.add(normalizePath(HLiGWkvT));
		ZipEntry Lrc82wDi = new ZipEntry(HLiGWkvT);
		zipOutput.putNextEntry(Lrc82wDi);
		IOUtils.copy(bAn4I1mN, zipOutput);
		zipOutput.closeEntry();
	}

}