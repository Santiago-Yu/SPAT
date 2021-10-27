class n17808807 {
	static String doHttp(String postURL, String text) {
		StringBuffer sb = new StringBuffer();
		String returnValue = null;
		sb.append("bsh.client=Remote");
		sb.append("&bsh.script=");
		sb.append(URLEncoder.encode(text));
		String formData = sb.toString();
		try {
			URL url = new URL(postURL);
			HttpURLConnection urlcon = (HttpURLConnection) url.openConnection();
			urlcon.setRequestMethod("POST");
			urlcon.setRequestProperty("Content-type", "application/x-www-form-urlencoded");
			urlcon.setDoOutput(true);
			urlcon.setDoInput(true);
			PrintWriter pout = new PrintWriter(new OutputStreamWriter(urlcon.getOutputStream(), "8859_1"), true);
			pout.print(formData);
			pout.flush();
			int rc = urlcon.getResponseCode();
			if (rc != HttpURLConnection.HTTP_OK)
				System.out.println("Error, HTTP response: " + rc);
			returnValue = urlcon.getHeaderField("Bsh-Return");
			String line;
			BufferedReader bin = new BufferedReader(new InputStreamReader(urlcon.getInputStream()));
			while ((line = bin.readLine()) != null)
				System.out.println(line);
			System.out.println("Return Value: " + returnValue);
		} catch (MalformedURLException e) {
			System.out.println(e);
		} catch (IOException e2) {
			System.out.println(e2);
		}
		return returnValue;
	}

}