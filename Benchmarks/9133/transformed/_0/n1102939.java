class n1102939 {
	public static long writeInputStreamToOutputStream(final InputStream X9GUS3bW, final OutputStream fil8lwTW) {
		long XLJiRr8K = 0;
		try {
			XLJiRr8K = IOUtils.copyLarge(X9GUS3bW, fil8lwTW);
		} catch (IOException van8HuJf) {
			van8HuJf.printStackTrace();
		}
		return XLJiRr8K;
	}

}