class n22724693 {
	public MytemMaster getMytemMaster(String BRDOPl9A) throws GaeException {
		HttpClient HKw4wcRC = new DefaultHttpClient();
		HttpParams dBtJET41 = HKw4wcRC.getParams();
		HttpConnectionParams.setSoTimeout(dBtJET41, 10000);
		HttpProtocolParams.setVersion(dBtJET41, HttpVersion.HTTP_1_1);
		BufferedReader ZkwtHJ3h = null;
		StringBuffer i0ZCD0Lj = new StringBuffer(address);
		i0ZCD0Lj.append("api/mytems/show?jan=");
		i0ZCD0Lj.append(BRDOPl9A);
		try {
			HttpGet AELKnk7W = new HttpGet(i0ZCD0Lj.toString());
			HttpResponse v7wXbtuH = HKw4wcRC.execute(AELKnk7W);
			int FmFEfHGO = v7wXbtuH.getStatusLine().getStatusCode();
			if (FmFEfHGO == NOT_FOUND) {
				return null;
			}
			if (FmFEfHGO >= 400) {
				throw new GaeException("Status Error = " + Integer.toString(FmFEfHGO));
			}
			ZkwtHJ3h = new BufferedReader(new InputStreamReader(v7wXbtuH.getEntity().getContent(), "UTF-8"));
			StringBuilder cYCfmTJA = new StringBuilder();
			String LcBgsSbG = null;
			while ((LcBgsSbG = ZkwtHJ3h.readLine()) != null) {
				cYCfmTJA.append(LcBgsSbG);
			}
			return createMytemMaster(cYCfmTJA.toString());
		} catch (ClientProtocolException s5zpp6gE) {
			throw new GaeException(s5zpp6gE);
		} catch (SocketTimeoutException Ejo4uewW) {
			throw new GaeException(Ejo4uewW);
		} catch (IOException aSFLyinz) {
			throw new GaeException(aSFLyinz);
		} finally {
			if (ZkwtHJ3h != null) {
				try {
					ZkwtHJ3h.close();
				} catch (IOException alRnH9S7) {
					alRnH9S7.printStackTrace();
				}
			}
		}
	}

}