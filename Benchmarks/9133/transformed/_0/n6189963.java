class n6189963 {
	public String jsFunction_send(String NRlW09IP) {
		URL WfCFK1IS = null;
		try {
			if (_uri.startsWith("http")) {
				WfCFK1IS = new URL(_uri);
			} else {
				WfCFK1IS = new URL("file://./" + _uri);
			}
		} catch (MalformedURLException guK2Yprl) {
			IdeLog.logError(ScriptingPlugin.getDefault(), Messages.WebRequest_Error, guK2Yprl);
			return StringUtils.EMPTY;
		}
		try {
			URLConnection wjbECTkU = WfCFK1IS.openConnection();
			OutputStreamWriter eDDM2MG2 = null;
			if (this._method.equals("post")) {
				wjbECTkU.setDoOutput(true);
				eDDM2MG2 = new OutputStreamWriter(wjbECTkU.getOutputStream());
				eDDM2MG2.write(NRlW09IP);
				eDDM2MG2.flush();
			}
			BufferedReader YQyJDCOn = new BufferedReader(new InputStreamReader(wjbECTkU.getInputStream()));
			StringBuffer ZdH60WKy = new StringBuffer();
			String ye3B6bsk;
			while ((ye3B6bsk = YQyJDCOn.readLine()) != null) {
				ZdH60WKy.append(ye3B6bsk + "\r\n");
			}
			if (eDDM2MG2 != null) {
				eDDM2MG2.close();
			}
			YQyJDCOn.close();
			String TAKPCnLb = ZdH60WKy.toString();
			return TAKPCnLb;
		} catch (Exception J7rN0H1K) {
			IdeLog.logError(ScriptingPlugin.getDefault(), Messages.WebRequest_Error, J7rN0H1K);
			return StringUtils.EMPTY;
		}
	}

}