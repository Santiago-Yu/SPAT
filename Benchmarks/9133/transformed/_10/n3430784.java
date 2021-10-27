class n3430784 {
	public static Body decodeBody(InputStream in, String contentTransferEncoding) throws IOException {
		BinaryTempFileBody tempBody = new BinaryTempFileBody();
		if (contentTransferEncoding != null) {
			contentTransferEncoding = MimeUtility.getHeaderParameter(contentTransferEncoding, null);
			if ("quoted-printable".equalsIgnoreCase(contentTransferEncoding)) {
				in = new QuotedPrintableInputStream(in);
			} else if ("base64".equalsIgnoreCase(contentTransferEncoding)) {
				in = new Base64InputStream(in);
			}
		}
		OutputStream out = tempBody.getOutputStream();
		IOUtils.copy(in, out);
		out.close();
		return tempBody;
	}

}