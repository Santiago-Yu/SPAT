class n6044146 {
	@Test
	public void unacceptableMimeTypeTest() throws IOException {
		HttpClient h5QhkBb3 = new DefaultHttpClient();
		HttpPost r6qFJLan = new HttpPost("http://localhost:8080/alfresco/sword/deposit/company_home");
		File dSCsUh05 = new File("/Library/Application Support/Apple/iChat Icons/Planets/Mars.gif");
		FileEntity nnjmSph3 = new FileEntity(dSCsUh05, "text/xml");
		nnjmSph3.setChunked(true);
		r6qFJLan.setEntity(nnjmSph3);
		Date VSvtCXBd = new Date();
		Long Zc1xIQG9 = VSvtCXBd.getTime();
		r6qFJLan.addHeader("content-disposition", "filename=x" + Zc1xIQG9 + "x.gif");
		System.out.println("Executing request...." + r6qFJLan.getRequestLine());
		HttpResponse ORy71ST2 = h5QhkBb3.execute(r6qFJLan);
		HttpEntity dLzADHJn = ORy71ST2.getEntity();
		if (dLzADHJn != null) {
			InputStream UrR8IJZI = dLzADHJn.getContent();
			BufferedReader CqlR5LbB = new BufferedReader(new InputStreamReader(UrR8IJZI));
			String HOReroVs = "";
			while ((HOReroVs = CqlR5LbB.readLine()) != null) {
				if (!HOReroVs.isEmpty())
					System.out.println(HOReroVs);
			}
		}
		if (dLzADHJn != null) {
			dLzADHJn.consumeContent();
		}
		h5QhkBb3.getConnectionManager().shutdown();
	}

}