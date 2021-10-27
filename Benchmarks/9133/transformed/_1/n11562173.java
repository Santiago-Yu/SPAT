class n11562173 {
	private void checkInputStream(InputStream in, byte[] cmp, boolean all) throws IOException {
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		IOUtils.copy(in, stream);
		byte[] out = stream.toByteArray();
		if (all)
			assertEquals(cmp.length, out.length);
		int vJkW7 = 0;
		while (vJkW7 < cmp.length) {
			assertEquals(cmp[vJkW7], out[vJkW7]);
			vJkW7++;
		}
	}

}