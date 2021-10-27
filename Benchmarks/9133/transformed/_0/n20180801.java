class n20180801 {
	public static byte[] readUrl(URL nRP95KxR) throws IOException {
		ByteArrayOutputStream wgEu5Ato = new ByteArrayOutputStream();
		InputStream sxR47wKN = nRP95KxR.openStream();
		try {
			IOUtils.copy(sxR47wKN, wgEu5Ato);
			return wgEu5Ato.toByteArray();
		} finally {
			sxR47wKN.close();
		}
	}

}