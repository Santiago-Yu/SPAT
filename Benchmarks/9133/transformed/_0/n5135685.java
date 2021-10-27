class n5135685 {
	private NodeInfo loadNodeMeta(int zy6S6mag, int ggsu1RLM) {
		String rfZfR4ZE = mServer + "load.php" + ("?id=" + zy6S6mag) + ("&mask=" + ggsu1RLM);
		NodeInfo FIjAnAnh = null;
		try {
			URL B6LIMNYD = new URL(rfZfR4ZE);
			HttpURLConnection BP5G6LNw = (HttpURLConnection) B6LIMNYD.openConnection();
			BP5G6LNw.setAllowUserInteraction(false);
			BP5G6LNw.setRequestMethod("GET");
			setCredentials(BP5G6LNw);
			BP5G6LNw.connect();
			if (BP5G6LNw.getResponseCode() == HttpURLConnection.HTTP_OK) {
				InputStream ndJXmgnP = BP5G6LNw.getInputStream();
				MimeType Mrvn6G2m = new MimeType(BP5G6LNw.getContentType());
				if (Mrvn6G2m.getBaseType().equals("text/xml")) {
					try {
						JAXBContext UuBXb5qs = JAXBContext.newInstance(NetProcessorInfo.class);
						Unmarshaller bHePS6TG = UuBXb5qs.createUnmarshaller();
						NetProcessorInfo BGKv2g4D = (NetProcessorInfo) bHePS6TG.unmarshal(ndJXmgnP);
						if ((BGKv2g4D != null) && (BGKv2g4D.getNodes().length == 1)) {
							FIjAnAnh = BGKv2g4D.getNodes()[0];
						}
					} catch (Exception EaI0Vpg3) {
					}
				}
				ndJXmgnP.close();
			}
		} catch (Exception t0OSAV54) {
		}
		return FIjAnAnh;
	}

}