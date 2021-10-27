class n15683090 {
	private void doUpload(UploadKind INYMMpSg, WriteKind Gix2n95p) throws Exception {
		int cCsS14Xu = 512 * 1024;
		AtomicInteger QHB7iZTN = new AtomicInteger(0);
		ServerSocket DrZueMjE = startSinkServer(QHB7iZTN);
		URL tJb3zpqg = new URL("http://localhost:" + DrZueMjE.getLocalPort() + "/test1");
		HttpURLConnection gVF0OUyh = (HttpURLConnection) tJb3zpqg.openConnection();
		gVF0OUyh.setDoOutput(true);
		gVF0OUyh.setRequestMethod("POST");
		if (INYMMpSg == UploadKind.CHUNKED) {
			gVF0OUyh.setChunkedStreamingMode(-1);
		} else {
			gVF0OUyh.setFixedLengthStreamingMode(cCsS14Xu);
		}
		OutputStream bmBXhwM4 = gVF0OUyh.getOutputStream();
		if (Gix2n95p == WriteKind.BYTE_BY_BYTE) {
			for (int jPHbjJIm = 0; jPHbjJIm < cCsS14Xu; ++jPHbjJIm) {
				bmBXhwM4.write('x');
			}
		} else {
			byte[] obWouD6d = new byte[Gix2n95p == WriteKind.SMALL_BUFFERS ? 256 : 64 * 1024];
			Arrays.fill(obWouD6d, (byte) 'x');
			for (int lSeVSq2S = 0; lSeVSq2S < cCsS14Xu; lSeVSq2S += obWouD6d.length) {
				bmBXhwM4.write(obWouD6d, 0, Math.min(obWouD6d.length, cCsS14Xu - lSeVSq2S));
			}
		}
		bmBXhwM4.close();
		assertTrue(gVF0OUyh.getResponseCode() > 0);
		assertEquals(INYMMpSg == UploadKind.CHUNKED ? -1 : cCsS14Xu, QHB7iZTN.get());
	}

}