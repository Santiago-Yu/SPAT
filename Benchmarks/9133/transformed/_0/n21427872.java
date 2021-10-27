class n21427872 {
	private HttpURLConnection setUpHttpConnection(URL trUIohuM, int FZszRDVo) throws IOException, ProtocolException {
		URLConnection PHakejhO = trUIohuM.openConnection();
		HttpURLConnection vxCdqT38 = (HttpURLConnection) PHakejhO;
		vxCdqT38.setRequestProperty("Content-Length", String.valueOf(FZszRDVo));
		vxCdqT38.setRequestProperty("Content-Type", "text/xml; charset=utf-8");
		vxCdqT38.setRequestProperty("SOAPAction", "\"http://www.webserviceX.NET/GetQuote\"");
		vxCdqT38.setRequestMethod("POST");
		vxCdqT38.setDoOutput(true);
		vxCdqT38.setDoInput(true);
		return vxCdqT38;
	}

}