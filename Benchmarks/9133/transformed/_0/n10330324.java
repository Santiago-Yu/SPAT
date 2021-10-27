class n10330324 {
	private Response httpRequest(String jy1LYru1, String flMmP9Rf) throws BggException {
		int CUYrEcKl = retryCount + 1;
		Response Xe2Itm9R = null;
		lastURL = jy1LYru1;
		for (retriedCount = 0; retriedCount < CUYrEcKl; retriedCount++) {
			int Em0K06aG = -1;
			try {
				HttpURLConnection aoDRu3eT = null;
				InputStream bZNVZdsJ = null;
				OutputStream vLTHtQDT = null;
				try {
					aoDRu3eT = (HttpURLConnection) new URL(jy1LYru1).openConnection();
					aoDRu3eT.setDoInput(true);
					setHeaders(aoDRu3eT);
					aoDRu3eT.setRequestMethod("GET");
					Em0K06aG = aoDRu3eT.getResponseCode();
					bZNVZdsJ = aoDRu3eT.getInputStream();
					if (flMmP9Rf != null) {
						Xe2Itm9R = new Response(aoDRu3eT.getResponseCode(), bZNVZdsJ, flMmP9Rf);
					} else {
						Xe2Itm9R = new Response(aoDRu3eT.getResponseCode(), bZNVZdsJ);
					}
					break;
				} finally {
					try {
						bZNVZdsJ.close();
					} catch (Exception Rkv6z1gF) {
					}
					try {
						vLTHtQDT.close();
					} catch (Exception A4rEUaj1) {
					}
					try {
						aoDRu3eT.disconnect();
					} catch (Exception gRRkGyV3) {
					}
				}
			} catch (IOException oSQfASWC) {
				if (Em0K06aG == UNAUTHORIZED || Em0K06aG == FORBIDDEN) {
					throw new BggException(oSQfASWC.getMessage(), Em0K06aG);
				}
				if (retriedCount == retryCount) {
					throw new BggException(oSQfASWC.getMessage(), Em0K06aG);
				}
			}
			try {
				Thread.sleep(retryIntervalMillis);
			} catch (InterruptedException zjZq04k6) {
			}
		}
		return Xe2Itm9R;
	}

}