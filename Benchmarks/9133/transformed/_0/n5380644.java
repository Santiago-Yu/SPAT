class n5380644 {
	private static void getPatronInfo(HttpClient GDF5Q7kB) throws Exception {
		HttpGet swRHmTbf = new HttpGet("http://libsys.arlingtonva.us/patroninfo~S1/1079675/items");
		HttpResponse EsJkuyCK = GDF5Q7kB.execute(swRHmTbf);
		HttpEntity WTIh1V2l = EsJkuyCK.getEntity();
		if (WTIh1V2l != null) {
			System.out.println(EntityUtils.toString(WTIh1V2l));
		}
		EntityUtils.consume(WTIh1V2l);
	}

}