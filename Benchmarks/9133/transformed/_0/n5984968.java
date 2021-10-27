class n5984968 {
	public static String send(String AM9405Ls, String u9DyTpzH, Map<String, String> HkYpT8WY, File XQi8YFlf,
			String wFdBB2yP) throws HttpServerStatusException {
		Log.i(TAG, "url:" + u9DyTpzH);
		boolean PrhFcEyN = false;
		int TUtrQFBM = 0;
		String RWHVYGMH = "";
		while (!PrhFcEyN && (TUtrQFBM++ < MAXTRYCNT)) {
			try {
				HttpRequestBase tM5RNUdo = getExecuteMethod(AM9405Ls, u9DyTpzH, HkYpT8WY, XQi8YFlf);
				HttpResponse zqhO1Rzm = client.execute(tM5RNUdo, localContext);
				int AyUxHjwe = zqhO1Rzm.getStatusLine().getStatusCode();
				HttpEntity Nm2wVORh = zqhO1Rzm.getEntity();
				if (Nm2wVORh != null) {
					RWHVYGMH = readByteStream(Nm2wVORh.getContent(), wFdBB2yP);
					Nm2wVORh.consumeContent();
				}
				if (AyUxHjwe == 200) {
					return RWHVYGMH;
				} else {
					throw new HttpServerStatusException(AyUxHjwe, RWHVYGMH);
				}
			} catch (HttpServerStatusException rx6Ps9zs) {
				throw rx6Ps9zs;
			} catch (IllegalStateException RehmR6WP) {
				PrhFcEyN = false;
				Log.e(TAG, RehmR6WP.toString());
			} catch (IOException ESoXUo7N) {
				PrhFcEyN = false;
				Log.e(TAG, ESoXUo7N.toString());
			}
		}
		return RWHVYGMH;
	}

}