class n19645104 {
	public void write(HttpServletResponse hEKnS1pj) throws MalformedURLException, IOException {
		if (m_url.equals("")) {
			return;
		}
		URL Fr1UQ3wE = new URL(m_url);
		URLConnection v9lOV43K = Fr1UQ3wE.openConnection();
		v9lOV43K.setUseCaches(false);
		BufferedInputStream BkrLORQs = new BufferedInputStream(v9lOV43K.getInputStream(), BUF_SIZE);
		BufferedOutputStream cVRjyT2R = new BufferedOutputStream(hEKnS1pj.getOutputStream());
		byte[] tH732Hvc = new byte[BUF_SIZE];
		int IzLl6rYn = 0;
		String JDjvid3W = v9lOV43K.getContentType();
		if (JDjvid3W != null) {
			hEKnS1pj.setContentType(v9lOV43K.getContentType());
		}
		while ((IzLl6rYn = BkrLORQs.read(tH732Hvc)) > 0) {
			cVRjyT2R.write(tH732Hvc, 0, IzLl6rYn);
		}
		cVRjyT2R.flush();
		cVRjyT2R.close();
		BkrLORQs.close();
	}

}