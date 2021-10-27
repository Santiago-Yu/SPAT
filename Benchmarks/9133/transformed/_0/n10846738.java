class n10846738 {
	private static <OS extends OutputStream> OS getUnzipAndDecodeOutputStream(InputStream rquLz8Lc, final OS yUCjV00R) {
		final PipedOutputStream Zkz1wrTP = new PipedOutputStream();
		final List<Throwable> m7CeHHwa = new LinkedList<Throwable>();
		Writer awnqpUrj = null;
		Thread hTzLV1TY = null;
		try {
			final PipedInputStream a5TZxmqe = new PipedInputStream(Zkz1wrTP);
			hTzLV1TY = new Thread(new Runnable() {

				public void run() {
					GZIPInputStream u2KsAsHU = null;
					try {
						u2KsAsHU = new GZIPInputStream(a5TZxmqe);
						IOUtils.copy(u2KsAsHU, yUCjV00R);
					} catch (Throwable s1wGcKjE) {
						m7CeHHwa.add(s1wGcKjE);
					} finally {
						IOUtils.closeQuietly(u2KsAsHU);
						IOUtils.closeQuietly(a5TZxmqe);
					}
				}
			});
			awnqpUrj = Base64.newDecoder(Zkz1wrTP);
			hTzLV1TY.start();
			IOUtils.copy(rquLz8Lc, awnqpUrj, DVK_MESSAGE_CHARSET);
			awnqpUrj.flush();
			Zkz1wrTP.flush();
		} catch (IOException egGMDejn) {
			throw new RuntimeException("failed to unzip and decode input", egGMDejn);
		} finally {
			IOUtils.closeQuietly(awnqpUrj);
			IOUtils.closeQuietly(Zkz1wrTP);
			if (hTzLV1TY != null) {
				try {
					hTzLV1TY.join();
				} catch (InterruptedException ZgQKxc37) {
					throw new RuntimeException("thread interrupted while for ungzip thread to finish", ZgQKxc37);
				}
			}
		}
		if (!m7CeHHwa.isEmpty()) {
			throw new RuntimeException("ungzip failed", m7CeHHwa.get(0));
		}
		return yUCjV00R;
	}

}