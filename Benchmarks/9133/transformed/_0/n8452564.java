class n8452564 {
	public void run() {
		try {
			HttpPost JL7Rg9RA = new HttpPost(Feesh.device_URL);
			List<NameValuePair> AjZaUbUK = new ArrayList<NameValuePair>();
			AjZaUbUK.add(new BasicNameValuePair("c", "feed"));
			AjZaUbUK.add(new BasicNameValuePair("amount", String.valueOf(foodAmount)));
			AjZaUbUK.add(new BasicNameValuePair("type", String.valueOf(foodType)));
			JL7Rg9RA.setEntity(new UrlEncodedFormEntity(AjZaUbUK));
			HttpResponse sLz9eFPw = (HttpResponse) new DefaultHttpClient().execute(JL7Rg9RA);
			HttpEntity FrH3Nfsn = sLz9eFPw.getEntity();
			String L8avraT6 = "";
			if (FrH3Nfsn != null) {
				InputStream RKtpp58x = FrH3Nfsn.getContent();
				L8avraT6 = convertStreamToString(RKtpp58x);
				RKtpp58x.close();
			}
			Message kmEcWTHb = new Message();
			kmEcWTHb.obj = L8avraT6;
			toast_handler.sendMessage(kmEcWTHb);
		} catch (UnsupportedEncodingException aWX1QDzj) {
			aWX1QDzj.printStackTrace();
		} catch (ClientProtocolException v8H7CkPm) {
			v8H7CkPm.printStackTrace();
		} catch (IOException FGjgOXQj) {
			FGjgOXQj.printStackTrace();
		}
	}

}