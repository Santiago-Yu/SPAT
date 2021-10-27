class n19910630 {
	public String postData(String kHSOikr0, DefaultHttpClient cXQYpqU8) {
		try {
			HttpPost Bu6uIRiB = new HttpPost("http://3dforandroid.appspot.com/api/v1/note/create");
			StringEntity cfzXwzrd = new StringEntity(kHSOikr0);
			cfzXwzrd.setContentEncoding(HTTP.UTF_8);
			cfzXwzrd.setContentType("application/json");
			Bu6uIRiB.setEntity(cfzXwzrd);
			Bu6uIRiB.setHeader("Content-Type", "application/json");
			Bu6uIRiB.setHeader("Accept", "*/*");
			HttpResponse iXnAZ5XW = cXQYpqU8.execute(Bu6uIRiB);
			HttpEntity MwxDaKpk = iXnAZ5XW.getEntity();
			InputStream Aek0kjTY;
			Aek0kjTY = MwxDaKpk.getContent();
			responseMessage = read(Aek0kjTY);
		} catch (IllegalStateException aTdb7go4) {
			aTdb7go4.printStackTrace();
		} catch (IOException o4DL6Sdf) {
			o4DL6Sdf.printStackTrace();
		}
		return responseMessage;
	}

}