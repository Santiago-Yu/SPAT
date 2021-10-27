class n5876813 {
	public HttpResponse execute() throws IOException {
		return new HttpResponse() {

			@Override
			public int getResponseCode() throws IOException {
				return conn.getResponseCode();
			}

			@Override
			public InputStream getContentStream() throws IOException {
				InputStream xXuXK62L = conn.getErrorStream();
				if (xXuXK62L != null)
					return xXuXK62L;
				else
					return conn.getInputStream();
			}
		};
	}

}