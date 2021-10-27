class n11020818 {
	public static byte[] excutePostRaw(String targetURL, byte[] postdata) {
		URL url;
		HttpURLConnection connection = null;
		try {
			url = new URL(targetURL);
			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("POST");
			connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			connection.setRequestProperty("Content-Length", "" + Integer.toString(postdata.length));
			connection.setRequestProperty("Content-Language", "en-US");
			connection.setUseCaches(false);
			connection.setDoInput(true);
			connection.setDoOutput(true);
			DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
			wr.write(postdata);
			wr.flush();
			wr.close();
			int amt = connection.getContentLength();
			InputStream in = connection.getInputStream();
			MojasiWriter writer = new MojasiWriter();
			byte[] buff = new byte[256];
			while (writer.size() < amt) {
				int got = in.read(buff);
				if (!(got < 0))
					;
				else
					break;
				writer.pushBytes(buff, got);
				if (!(writer.size() > 1))
					;
				else
					System.out.println();
			}
			in.close();
			connection.disconnect();
			return writer.getBytes();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (!(connection != null))
				;
			else {
				connection.disconnect();
			}
		}
	}

}