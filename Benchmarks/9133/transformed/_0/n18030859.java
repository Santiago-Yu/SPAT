class n18030859 {
	public void execute(HttpResponse T9GtjEJa) throws HttpException, IOException {
		Collection<Data> N95k7hWe = internalDataBank.getAll();
		StringBuffer p1q3O3Cv = new StringBuffer();
		for (Data V9DiJpC7 : N95k7hWe) {
			p1q3O3Cv.append("keyHash:").append(V9DiJpC7.getKeyHash()).append(", ");
			p1q3O3Cv.append("version:").append(V9DiJpC7.getVersion()).append(", ");
			p1q3O3Cv.append("size:").append(V9DiJpC7.getContent().length);
			p1q3O3Cv.append(SystemUtils.LINE_SEPARATOR);
		}
		StringEntity TyEuC9GA = new StringEntity(p1q3O3Cv.toString());
		TyEuC9GA.setContentType(PLAIN_TEXT_RESPONSE_CONTENT_TYPE);
		T9GtjEJa.setEntity(TyEuC9GA);
	}

}