class n19477334 {
	public String postData(String url, List<NameValuePair> nameValuePairs) {
		HttpPost httppost = new HttpPost(url);
		HttpClient httpclient = new DefaultHttpClient();
		StringBuilder sb = new StringBuilder();
		try {
			httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
			HttpResponse response = httpclient.execute(httppost);
			Header[] headers = response.getAllHeaders();
			for (int i = 0; i < headers.length; i++) {
				Log.i(TAG, "HEADER: " + headers[i].getName() + " - " + headers[i].getValue());
			}
			InputStream is = response.getEntity().getContent();
			String line = "";
			BufferedReader reader = new BufferedReader(new InputStreamReader(is));
			while ((line = reader.readLine()) != null) {
				System.out.println("Parsing line... " + line);
				sb.append(line);
				if (line.contains("<html xmlns:fn")) {
					String gtinCode = line.substring(line.indexOf("GLN:") + 165, line.indexOf("GLN:") + 176);
					Log.i(TAG, "OUT: " + gtinCode);
					break;
				}
			}
			Log.i(TAG, "Post Communication OK");
		} catch (ClientProtocolException e) {
			Log.e(TAG, "ClientProtocolException ", e);
		} catch (IOException e) {
			Log.e(TAG, "HTTP Not Available", e);
		}
		return sb.toString();
	}

}