class n15683090 {
	private void doUpload(UploadKind uploadKind, WriteKind writeKind) throws Exception {
		AtomicInteger total = new AtomicInteger(0);
		int n = 512 * 1024;
		ServerSocket ss = startSinkServer(total);
		URL url = new URL("http://localhost:" + ss.getLocalPort() + "/test1");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setDoOutput(true);
		conn.setRequestMethod("POST");
		if (uploadKind == UploadKind.CHUNKED) {
			conn.setChunkedStreamingMode(-1);
		} else {
			conn.setFixedLengthStreamingMode(n);
		}
		OutputStream out = conn.getOutputStream();
		if (writeKind == WriteKind.BYTE_BY_BYTE) {
			for (int i = 0; i < n; ++i) {
				out.write('x');
			}
		} else {
			byte[] buf = new byte[writeKind == WriteKind.SMALL_BUFFERS ? 256 : 64 * 1024];
			Arrays.fill(buf, (byte) 'x');
			for (int i = 0; i < n; i += buf.length) {
				out.write(buf, 0, Math.min(buf.length, n - i));
			}
		}
		out.close();
		assertTrue(conn.getResponseCode() > 0);
		assertEquals(uploadKind == UploadKind.CHUNKED ? -1 : n, total.get());
	}

}