class n23125251 {
	public static HttpData postRequest(HttpPost DnRVEXqo, String ppZC1Ata)
			throws ClientProtocolException, SocketException, IOException, SocketTimeoutException {
		HttpData aE3oIFJR = new HttpData();
		try {
			DnRVEXqo.addHeader("Content-Type", "text/xml; charset=utf-8");
			DnRVEXqo.addHeader("Connection", "Keep-Alive");
			DnRVEXqo.addHeader("User-Agent", "Openwave");
			StringEntity QgTDhZt1 = new StringEntity(ppZC1Ata, HTTP.UTF_8);
			DnRVEXqo.setEntity(QgTDhZt1);
			printPostRequestHeader(DnRVEXqo);
			HttpParams O3vmXIqJ = new BasicHttpParams();
			HttpConnectionParams.setConnectionTimeout(O3vmXIqJ, HTTP_TIMEOUT);
			HttpClient VFyDbdoA = new DefaultHttpClient(O3vmXIqJ);
			VFyDbdoA.getParams().setIntParameter(HttpConnectionParams.CONNECTION_TIMEOUT, DEFAULT_POST_REQUEST_TIMEOUT);
			VFyDbdoA.getParams().setIntParameter(HttpConnectionParams.SO_TIMEOUT, DEFAULT_POST_REQUEST_TIMEOUT);
			HttpResponse YiVT4b1o = VFyDbdoA.execute(DnRVEXqo);
			if (YiVT4b1o == null)
				throw new SocketTimeoutException();
			if (YiVT4b1o.getStatusLine().getStatusCode() == 200) {
				byte XlqdM7S4[] = ImageInputStream(YiVT4b1o.getEntity());
				aE3oIFJR.setByteArray(XlqdM7S4);
			} else {
				aE3oIFJR.setStatusCode(YiVT4b1o.getStatusLine().getStatusCode() + "");
			}
		} catch (SocketException hpdrxHMf) {
			throw new SocketException();
		} catch (SocketTimeoutException UGYT9zot) {
			throw new SocketTimeoutException();
		} catch (ClientProtocolException aJxJ7hvM) {
			throw new ClientProtocolException();
		} catch (IOException OqrxDxvy) {
			throw new IOException();
		} finally {
			DnRVEXqo.abort();
		}
		return aE3oIFJR;
	}

}