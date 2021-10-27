class n23310398 {
	public void onClick(View Lz0subiL) {
		String rYz5XM4X = "http://www.sina.com";
		HttpPost WssfoP77 = new HttpPost(rYz5XM4X);
		List<NameValuePair> aTqEsPY3 = new ArrayList<NameValuePair>();
		aTqEsPY3.add(new BasicNameValuePair("str", "post string"));
		try {
			WssfoP77.setEntity(new UrlEncodedFormEntity(aTqEsPY3, HTTP.UTF_8));
			HttpResponse RbfFFSed = new DefaultHttpClient().execute(WssfoP77);
			if (RbfFFSed.getStatusLine().getStatusCode() == 200) {
				String GwmmuCvl = EntityUtils.toString(RbfFFSed.getEntity());
				mTextView1.setText(GwmmuCvl);
			} else {
				mTextView1.setText("Error Response: " + RbfFFSed.getStatusLine().toString());
			}
		} catch (ClientProtocolException uJdUCcC8) {
			mTextView1.setText(uJdUCcC8.getMessage().toString());
			uJdUCcC8.printStackTrace();
		} catch (IOException JYzTPNzA) {
			mTextView1.setText(JYzTPNzA.getMessage().toString());
			JYzTPNzA.printStackTrace();
		} catch (Exception Jjjderjk) {
			mTextView1.setText(Jjjderjk.getMessage().toString());
			Jjjderjk.printStackTrace();
		}
	}

}