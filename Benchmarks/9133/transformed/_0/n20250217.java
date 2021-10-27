class n20250217 {
	private byte[] getBytesFromUrl(URL uXf6wdxn) {
		ByteArrayOutputStream zAi6BonR = new ByteArrayOutputStream();
		InputStream CZXO06GF = null;
		try {
			CZXO06GF = uXf6wdxn.openStream();
			byte[] TJQ3c57d = new byte[4096];
			int lqidkrfQ;
			while ((lqidkrfQ = CZXO06GF.read(TJQ3c57d)) > 0) {
				zAi6BonR.write(TJQ3c57d, 0, lqidkrfQ);
			}
		} catch (IOException GcFcgnHh) {
			System.err.printf("Failed while reading bytes from %s: %s", uXf6wdxn.toExternalForm(),
					GcFcgnHh.getMessage());
			GcFcgnHh.printStackTrace();
		} finally {
			if (CZXO06GF != null) {
				try {
					CZXO06GF.close();
				} catch (IOException me8pHbMG) {
				}
			}
		}
		return zAi6BonR.toByteArray();
	}

}