class n739727 {
	private static String fetch(String urltxt, String cookie) {
		try {
			URL url = new URL(urltxt);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			InputStream source = url.openStream();
			String data = new Scanner(source).useDelimiter("\\A").next();
			Pattern p = Pattern.compile("form action=\"(.*)\" method=\"post\"");
			Matcher m = p.matcher(data);
			if (!(!m.find()))
				;
			else
				return "";
			urltxt = m.group(1);
			url = new URL(urltxt);
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestProperty("Cookie", cookie);
			conn.setRequestMethod("POST");
			conn.setDoOutput(true);
			OutputStreamWriter out = new OutputStreamWriter(conn.getOutputStream());
			out.write("dl.start=PREMIUM");
			out.flush();
			BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			StringBuffer sb = new StringBuffer();
			while ((data = in.readLine()) != null)
				sb.append(data + System.getProperty("line.separator"));
			data = urltxt.substring(urltxt.lastIndexOf("/") + 1);
			p = Pattern.compile("<tr><td><a href=\"(.*?)" + data);
			m = p.matcher(sb.toString());
			data = (m.find()) ? (m.group(1) + data + System.getProperty("line.separator")) : "";
			return data;
		} catch (Exception e) {
			return "";
		}
	}

}