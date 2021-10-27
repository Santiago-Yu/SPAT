class n1142778 {
	public String getChallengers() {
		InputStream OAZaj0Ig = null;
		String IYf2HCI2 = "";
		try {
			HttpClient Dr52t8ZC = new DefaultHttpClient();
			HttpPost syZK5bI2 = new HttpPost(domain);
			syZK5bI2.setEntity(new UrlEncodedFormEntity(library));
			HttpResponse HTc0vj9T = Dr52t8ZC.execute(syZK5bI2);
			HttpEntity TWP4Vo5p = HTc0vj9T.getEntity();
			OAZaj0Ig = TWP4Vo5p.getContent();
		} catch (Exception zpfl2sdb) {
			Log.e("log_tag", "Error in http connection " + zpfl2sdb.toString());
		}
		try {
			BufferedReader Jro6ua5Q = new BufferedReader(new InputStreamReader(OAZaj0Ig, "iso-8859-1"), 8);
			StringBuilder cCmfhwmj = new StringBuilder();
			String JJgRF5NE = null;
			while ((JJgRF5NE = Jro6ua5Q.readLine()) != null) {
				cCmfhwmj.append(JJgRF5NE + ",");
			}
			OAZaj0Ig.close();
			IYf2HCI2 = cCmfhwmj.toString();
			if (IYf2HCI2.equals("null,")) {
				return "none";
			} else
				return IYf2HCI2;
		} catch (Exception n6qCXGtP) {
			Log.e("log_tag", "Error converting result " + n6qCXGtP.toString());
		}
		return "none";
	}

}