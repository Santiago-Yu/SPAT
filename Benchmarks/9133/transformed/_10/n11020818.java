class n11020818 {
	public static byte[] excutePostRaw(String targetURL, byte[] postdata) {
		HttpURLConnection connection = null;
		URL url;
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
			MojasiWriter writer = new MojasiWriter();
			InputStream in = connection.getInputStream();
			byte[] buff = new byte[256];
			while (writer.size() < amt) {
				int got = in.read(buff);
				if (got < 0)
					break;
				writer.pushBytes(buff, got);
				if (writer.size() > 1)
					System.out.println();
			}
			in.close();
			connection.disconnect();
			return writer.getBytes();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (connection != null) {
				connection.disconnect();
			}
		}
	}

}