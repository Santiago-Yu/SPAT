class n14768963 {
	public static boolean exec_applet(String fname, VarContainer vc, ActionContainer ac, ThingTypeContainer ttc,
			Output OUT, InputStream IN, boolean AT, Statement state, String[] arggies) {
		urlpath = (!urlpath.endsWith("/")) ? urlpath + '/' : urlpath;
		urlpath = (!urlpath.startsWith("http://")) ? "http://" + urlpath : urlpath;
		String url = urlpath;
		url = (fname.startsWith("dusty_")) ? url + "libraries/" + fname : url + "users/" + fname;
		StringBuffer src = new StringBuffer(2400);
		try {
			String s;
			BufferedReader br = new BufferedReader(new InputStreamReader(new URL(url).openStream()));
			while ((s = br.readLine()) != null) {
				src.append(s).append('\n');
			}
			br.close();
		} catch (Exception e) {
			OUT.println(new DSOut(DSOut.ERR_OUT, -1,
					"Dustyscript failed at reading the file'" + fname + "'\n\t...for 'use' statement"), vc, AT);
			return false;
		}
		fork(src, vc, ac, ttc, OUT, IN, AT, state, arggies);
		return true;
	}

}