class n2105429 {
	private byte[] pullMapBytes(String H1h76hvW) {
		ByteArrayOutputStream jhj3uR6K = new ByteArrayOutputStream();
		try {
			URL mepg0o09 = new URL(H1h76hvW);
			HttpURLConnection JL8BS0iu = (HttpURLConnection) mepg0o09.openConnection();
			InputStream pQJwRdHM = JL8BS0iu.getInputStream();
			int oasAMcku;
			byte[] zy9FwCzm = new byte[1024];
			while ((oasAMcku = pQJwRdHM.read(zy9FwCzm, 0, zy9FwCzm.length)) != -1) {
				jhj3uR6K.write(zy9FwCzm, 0, oasAMcku);
			}
			jhj3uR6K.flush();
		} catch (MalformedURLException JaBkYMSM) {
			JaBkYMSM.printStackTrace();
		} catch (IOException CSXEZyNk) {
			CSXEZyNk.printStackTrace();
		}
		return jhj3uR6K.toByteArray();
	}

}