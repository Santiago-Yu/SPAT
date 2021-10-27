class n5753321 {
	public String selectFROM() throws Exception {
		BufferedReader VYgt3TCr = null;
		String e3c6ycgw = null;
		try {
			HttpClient X5k3STdp = new DefaultHttpClient();
			URI svTq0Njq = new URI("http://**.**.**.**/OctopusManager/index2.php");
			HttpGet hT3gVTCo = new HttpGet();
			hT3gVTCo.setURI(svTq0Njq);
			HttpResponse pRuR2LuY = X5k3STdp.execute(hT3gVTCo);
			HttpEntity mw1i2OeN = pRuR2LuY.getEntity();
			VYgt3TCr = new BufferedReader(new InputStreamReader(mw1i2OeN.getContent()));
			StringBuffer QZlLAYBW = new StringBuffer("");
			String qpV5123v = "";
			while ((qpV5123v = VYgt3TCr.readLine()) != null) {
				QZlLAYBW.append(qpV5123v);
			}
			VYgt3TCr.close();
			e3c6ycgw = QZlLAYBW.toString();
			return e3c6ycgw;
		} finally {
			if (VYgt3TCr != null) {
				try {
					VYgt3TCr.close();
					return e3c6ycgw;
				} catch (Exception ayqzPSKB) {
					ayqzPSKB.printStackTrace();
				}
			}
		}
	}

}