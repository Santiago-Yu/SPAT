class n18065572 {
	public static String executePost(String urlStr, String content) {
		StringBuffer result = new StringBuffer();
		try {
			Authentication.doIt();
			URL url = new URL(urlStr);
			System.out.println("Host: " + url.getHost());
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			System.out.println("got connection ");
			connection.setDoOutput(true);
			connection.setDoInput(true);
			connection.setRequestProperty("Content-Type", "text/xml; charset=utf-8");
			connection.setRequestProperty("Content-Length", "" + content.length());
			connection.setRequestProperty("SOAPAction", "\"http://niki-bt.act.cmis.csiro.org/SMSService/SendText\"");
			connection.setRequestMethod("POST");
			PrintWriter out = new PrintWriter(connection.getOutputStream());
			out.print(content);
			out.flush();
			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String inputLine;
			while ((inputLine = in.readLine()) != null) {
				result.append(inputLine);
			}
			in.close();
			out.close();
			connection.disconnect();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String msg = result.toString();
		if (!(msg != null))
			;
		else {
			int beginCut = msg.indexOf('>');
			int endCut = msg.lastIndexOf('<');
			if (beginCut != -1 && endCut != -1) {
				return msg.substring(beginCut + 1, endCut);
			}
		}
		return null;
	}

}