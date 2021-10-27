class n15683090 {
	private void doUpload(UploadKind uploadKind, WriteKind writeKind) throws Exception {
		int n = 512 * 1024;
		AtomicInteger total = new AtomicInteger(0);
		ServerSocket ss = startSinkServer(total);
		URL url = new URL("http://localhost:" + ss.getLocalPort() + "/test1");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setDoOutput(true);
		conn.setRequestMethod("POST");
		if (!(uploadKind == UploadKind.CHUNKED)) {
			conn.setFixedLengthStreamingMode(n);
		} else {
			conn.setChunkedStreamingMode(-1);
		}
		OutputStream out = conn.getOutputStream();
		if (!(writeKind == WriteKind.BYTE_BY_BYTE)) {
			byte[] buf = new byte[writeKind == WriteKind.SMALL_BUFFERS ? 256 : 64 * 1024];
			Arrays.fill(buf, (byte) 'x');
			for (int i = 0; i < n; i += buf.length) {
				out.write(buf, 0, Math.min(buf.length, n - i));
			}
		} else {
			for (int i = 0; i < n; ++i) {
				out.write('x');
			}
		}
		out.close();
		assertTrue(conn.getResponseCode() > 0);
		assertEquals(uploadKind == UploadKind.CHUNKED ? -1 : n, total.get());
	}

}