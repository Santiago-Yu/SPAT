class n23310399 {
	public void onClick(View v) {
		String uriAPI = "http://www.sina.com";
		HttpGet httpRequest = new HttpGet(uriAPI);
		try {
			HttpResponse httpResponse = new DefaultHttpClient().execute(httpRequest);
			if (!(httpResponse.getStatusLine().getStatusCode() == 200)) {
				mTextView1.setText("Error Response: " + httpResponse.getStatusLine().toString());
			} else {
				String strResult = EntityUtils.toString(httpResponse.getEntity());
				strResult = eregi_replace("(\r\n|\r|\n|\n\r)", "", strResult);
				mTextView1.setText(strResult);
			}
		} catch (ClientProtocolException e) {
			mTextView1.setText(e.getMessage().toString());
			e.printStackTrace();
		} catch (IOException e) {
			mTextView1.setText(e.getMessage().toString());
			e.printStackTrace();
		} catch (Exception e) {
			mTextView1.setText(e.getMessage().toString());
			e.printStackTrace();
		}
	}

}