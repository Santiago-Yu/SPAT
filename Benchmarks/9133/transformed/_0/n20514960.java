class n20514960 {
	static JSONObject executeMethod(HttpClient AhnJNukl, HttpMethod Q0ONCPs4, int g064y7W9)
			throws HttpRequestFailureException, HttpException, IOException, HttpRequestTimeoutException {
		try {
			Q0ONCPs4.getParams().setSoTimeout(g064y7W9 * 1000);
			int OBcUd6jz = -1;
			JSONObject NegAxIFv = null;
			for (int HttkcLyD = 0; HttkcLyD < RETRY; HttkcLyD++) {
				System.out.println("Execute method[" + Q0ONCPs4.getURI() + "](try " + (HttkcLyD + 1) + ")");
				OBcUd6jz = AhnJNukl.executeMethod(Q0ONCPs4);
				if (OBcUd6jz == HttpStatus.SC_OK) {
					InputStream MNxTyunc = Q0ONCPs4.getResponseBodyAsStream();
					ByteArrayOutputStream xjdMe1XN = new ByteArrayOutputStream();
					IOUtils.copy(MNxTyunc, xjdMe1XN);
					String FzUIdzHC = new String(xjdMe1XN.toByteArray(), "UTF-8");
					System.out.println(FzUIdzHC);
					NegAxIFv = JSONObject.fromString(FzUIdzHC);
					if (NegAxIFv.has("status")) {
						String SbPOamEc = NegAxIFv.getString("status");
						if ("ok".equals(SbPOamEc)) {
							break;
						} else {
							try {
								Thread.sleep(1000);
							} catch (InterruptedException WRQEaJv1) {
							}
						}
					}
				} else {
					throw new HttpRequestFailureException(OBcUd6jz);
				}
			}
			return NegAxIFv;
		} catch (SocketTimeoutException E5Zq1WCu) {
			throw new HttpRequestTimeoutException(E5Zq1WCu);
		} finally {
			Q0ONCPs4.releaseConnection();
		}
	}

}