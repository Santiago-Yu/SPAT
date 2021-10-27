class n23310398 {
	public void onClick(View v) {
		String uriAPI = "http://www.sina.com";
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		HttpPost httpRequest = new HttpPost(uriAPI);
		params.add(new BasicNameValuePair("str", "post string"));
		try {
			httpRequest.setEntity(new UrlEncodedFormEntity(params, HTTP.UTF_8));
			HttpResponse httpResponse = new DefaultHttpClient().execute(httpRequest);
			if (httpResponse.getStatusLine().getStatusCode() == 200) {
				String strResult = EntityUtils.toString(httpResponse.getEntity());
				mTextView1.setText(strResult);
			} else {
				mTextView1.setText("Error Response: " + httpResponse.getStatusLine().toString());
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