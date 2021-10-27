class n10993811 {
	Bitmap downloadImage(String R3AKDYwP) {
		try {
			mGetMethod.setURI(new URI(R3AKDYwP));
			HttpResponse b7CCyBdv = mClient.execute(mGetMethod);
			if (b7CCyBdv.getStatusLine().getStatusCode() < 400) {
				InputStream LLtDFMGo = b7CCyBdv.getEntity().getContent();
				String TOJhvbCw = convertStreamToString(LLtDFMGo);
				Log.d(TAG, "hoge" + TOJhvbCw);
				LLtDFMGo.close();
				return null;
			}
		} catch (Exception yyEFp9VC) {
			yyEFp9VC.printStackTrace();
		}
		return null;
	}

}