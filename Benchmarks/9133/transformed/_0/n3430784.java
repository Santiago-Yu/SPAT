class n3430784 {
	public static Body decodeBody(InputStream f7WYexVT, String bS2GL9UC) throws IOException {
		if (bS2GL9UC != null) {
			bS2GL9UC = MimeUtility.getHeaderParameter(bS2GL9UC, null);
			if ("quoted-printable".equalsIgnoreCase(bS2GL9UC)) {
				f7WYexVT = new QuotedPrintableInputStream(f7WYexVT);
			} else if ("base64".equalsIgnoreCase(bS2GL9UC)) {
				f7WYexVT = new Base64InputStream(f7WYexVT);
			}
		}
		BinaryTempFileBody tekLHbjv = new BinaryTempFileBody();
		OutputStream Bk2ScgWr = tekLHbjv.getOutputStream();
		IOUtils.copy(f7WYexVT, Bk2ScgWr);
		Bk2ScgWr.close();
		return tekLHbjv;
	}

}