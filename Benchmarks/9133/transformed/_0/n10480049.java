class n10480049 {
	public static SearchItem register(String... bBAVcjEp) {
		SearchItem g7o2mIFF = new SearchItem();
		String U7C1A2EI = null;
		try {
			DefaultHttpClient jqNC227x = new DefaultHttpClient();
			HttpPost lwzAOIAq = new HttpPost(URL_REGISTER);
			List<NameValuePair> wFXN10vi = new ArrayList<NameValuePair>(6);
			wFXN10vi.add(new BasicNameValuePair("format", "xml"));
			wFXN10vi.add(new BasicNameValuePair("firtname", bBAVcjEp[0]));
			wFXN10vi.add(new BasicNameValuePair("lastname", bBAVcjEp[1]));
			wFXN10vi.add(new BasicNameValuePair("email", bBAVcjEp[2]));
			wFXN10vi.add(new BasicNameValuePair("phone", bBAVcjEp[3]));
			wFXN10vi.add(new BasicNameValuePair("password", bBAVcjEp[4]));
			wFXN10vi.add(new BasicNameValuePair("confirmpassword", bBAVcjEp[5]));
			lwzAOIAq.setEntity(new UrlEncodedFormEntity(wFXN10vi));
			lwzAOIAq.setEntity(new UrlEncodedFormEntity(wFXN10vi));
			HttpResponse OPNX6pcZ = jqNC227x.execute(lwzAOIAq);
			U7C1A2EI = EntityUtils.toString(OPNX6pcZ.getEntity());
			Document DMOf923c = XMLfunctions.XMLfromString(U7C1A2EI);
			NodeList t6HHUFQk = DMOf923c.getElementsByTagName("response");
			Element aUyGF2Rf = (Element) t6HHUFQk.item(0);
			g7o2mIFF.set(0, XMLfunctions.getValue(aUyGF2Rf, "success"));
			if ("false".endsWith(g7o2mIFF.get(0))) {
				g7o2mIFF.set(1, XMLfunctions.getValue(aUyGF2Rf, "error"));
			} else {
				g7o2mIFF.set(1, XMLfunctions.getValue(aUyGF2Rf, "message"));
			}
			return g7o2mIFF;
		} catch (Exception HAIAkbHZ) {
			U7C1A2EI = "<results status=\"error\"><msg>Can't connect to server</msg></results>";
			U7C1A2EI = null;
			g7o2mIFF.set(0, "false");
			g7o2mIFF.set(1, "");
		}
		return g7o2mIFF;
	}

}