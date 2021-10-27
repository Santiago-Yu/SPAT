class n4898682 {
	public void run() {
		try {
			URL url = new URL("http://snoop.minecraft.net/");
			String s = (new StringBuilder()).append("fName=").append(URLEncoder.encode("???", "UTF-8"))
					.append("&lName=").append(URLEncoder.encode("???", "UTF-8")).toString();
			HttpURLConnection httpurlconnection = (HttpURLConnection) url.openConnection();
			httpurlconnection.setRequestMethod("POST");
			httpurlconnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			httpurlconnection.setRequestProperty("Content-Length",
					(new StringBuilder()).append("").append(Integer.toString(s.getBytes().length)).toString());
			httpurlconnection.setRequestProperty("Content-Language", "en-US");
			httpurlconnection.setUseCaches(false);
			httpurlconnection.setDoInput(true);
			httpurlconnection.setDoOutput(true);
			DataOutputStream dataoutputstream = new DataOutputStream(httpurlconnection.getOutputStream());
			dataoutputstream.writeBytes(s);
			dataoutputstream.flush();
			dataoutputstream.close();
			java.io.InputStream inputstream = httpurlconnection.getInputStream();
			StringBuffer stringbuffer = new StringBuffer();
			BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(inputstream));
			String s1;
			while ((s1 = bufferedreader.readLine()) != null) {
				stringbuffer.append(s1);
				stringbuffer.append('\r');
			}
			bufferedreader.close();
		} catch (Exception exception) {
		}
	}

}