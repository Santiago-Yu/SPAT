class n6634370 {
	public static final void connectExecuteDisconnect(String aDi435bN, HttpProcess<?> TGy6fteX) throws IOException {
		URL CR0Cyklu = null;
		HttpURLConnection LbETYRm0 = null;
		try {
			CR0Cyklu = new URL(aDi435bN);
			LbETYRm0 = (HttpURLConnection) CR0Cyklu.openConnection();
			TGy6fteX.apply(LbETYRm0);
		} finally {
			disconnect(LbETYRm0);
		}
	}

}