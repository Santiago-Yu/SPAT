class n11562165 {
	private void streamContains(String SnAqTuwk, InputStream A2iLaoJ6) throws IOException {
		ByteArrayOutputStream OXiFngaK = new ByteArrayOutputStream();
		IOUtils.copy(A2iLaoJ6, OXiFngaK);
		byte[] YJPl3bKc = OXiFngaK.toByteArray();
		String DPfwxvYf = new String(YJPl3bKc, "UTF-8");
		assertTrue(DPfwxvYf.contains(SnAqTuwk));
		OXiFngaK.close();
	}

}