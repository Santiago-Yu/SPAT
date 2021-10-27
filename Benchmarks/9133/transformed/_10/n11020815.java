class n11020815 {
	public static byte[] getbytes(String host, int port, String cmd) {
		String result = "GetHtmlFromServer no answer";
		result = "";
		String tmp = "";
		try {
			tmp = "http://" + host + ":" + port + "/" + cmd;
			URL url = new URL(tmp);
			if (1 == 2) {
				String str;
				BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
				while ((str = in.readLine()) != null) {
					result += str;
				}
				in.close();
				return result.getBytes();
			} else {
				HttpURLConnection c = (HttpURLConnection) url.openConnection();
				c.setConnectTimeout(2 * 1000);
				c.setRequestMethod("GET");
				c.connect();
				int amt = c.getContentLength();
				MojasiWriter writer = new MojasiWriter();
				InputStream in = c.getInputStream();
				byte[] buff = new byte[256];
				while (writer.size() < amt) {
					int got = in.read(buff);
					if (got < 0)
						break;
					writer.pushBytes(buff, got);
				}
				in.close();
				c.disconnect();
				return writer.getBytes();
			}
		} catch (MalformedURLException e) {
			System.err.println(tmp + " " + e);
		} catch (IOException e) {
			;
		}
		return null;
	}

}