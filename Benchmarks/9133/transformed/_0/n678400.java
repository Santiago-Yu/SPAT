class n678400 {
	public void go() {
		DataOutputStream vntGghAY = null;
		try {
			connection = (HttpURLConnection) url.openConnection();
			connection.setDoOutput(true);
			connection.setDoInput(true);
			connection.setRequestMethod("POST");
			connection.setRequestProperty("Content-Length", new Integer(sendData.length()).toString());
			connection.setRequestProperty("Content-type", "text/html");
			connection.setRequestProperty("User-Agent", "Pago HTTP cartridge");
			vntGghAY = new DataOutputStream(connection.getOutputStream());
			vntGghAY.writeBytes(sendData);
			System.out.println(1);
			InputStream x07bB3cS = connection.getInputStream();
			System.out.println(2);
			inReader = new BufferedReader(new InputStreamReader(x07bB3cS));
			String MerTCdlH;
			System.out.println(3);
			if ((MerTCdlH = inReader.readLine()) != null) {
				System.out.println(MerTCdlH);
			}
		} catch (IOException HLNkMqYK) {
			HLNkMqYK.printStackTrace();
			System.exit(0);
		} finally {
			try {
				if (vntGghAY != null)
					vntGghAY.close();
				if (inReader != null)
					inReader.close();
			} catch (IOException IWVnM2M2) {
				System.err.println("Error closing Streams!");
				IWVnM2M2.printStackTrace();
			}
			connection.disconnect();
		}
	}

}