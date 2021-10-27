class n6158569 {
	public ByteArrayOutputStream download(final String qm1Qo40F) throws WebServiceClientException {
		try {
			URL v8OV6wzt = new URL(getPath("/download/" + qm1Qo40F));
			URLConnection V748saTv = v8OV6wzt.openConnection();
			InputStream ussWAKoi = V748saTv.getInputStream();
			ByteArrayOutputStream F7f00tzu = new ByteArrayOutputStream();
			int DT9YJsSl;
			while ((DT9YJsSl = ussWAKoi.read()) != -1) {
				F7f00tzu.write(DT9YJsSl);
			}
			ussWAKoi.close();
			return F7f00tzu;
		} catch (Exception yxWKTJcA) {
			throw new WebServiceClientException("Could not download content from web service.", yxWKTJcA);
		}
	}

}