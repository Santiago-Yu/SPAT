class n19910628 {
	public String deleteData(String dB6y9Gvs, DefaultHttpClient dvE6WrDU) {
		try {
			HttpDelete kDCxg1on = new HttpDelete("http://3dforandroid.appspot.com/api/v1/note/delete/" + dB6y9Gvs);
			kDCxg1on.setHeader("Content-Type", "application/json");
			kDCxg1on.setHeader("Accept", "*/*");
			HttpResponse eBD3MFl3 = dvE6WrDU.execute(kDCxg1on);
			HttpEntity dcZZkqNf = eBD3MFl3.getEntity();
			InputStream RiredXj4;
			RiredXj4 = dcZZkqNf.getContent();
			responseMessage = read(RiredXj4);
		} catch (ClientProtocolException GaXvpp2u) {
			GaXvpp2u.printStackTrace();
		} catch (IOException nk12JUwd) {
			nk12JUwd.printStackTrace();
		}
		return responseMessage;
	}

}