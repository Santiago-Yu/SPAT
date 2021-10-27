class n6189963 {
	public String jsFunction_send(String postData) {
		URL url = null;
		try {
			if (_uri.startsWith("http")) {
				url = new URL(_uri);
			} else {
				url = new URL("file://./" + _uri);
			}
		} catch (MalformedURLException e) {
			IdeLog.logError(ScriptingPlugin.getDefault(), Messages.WebRequest_Error, e);
			return StringUtils.EMPTY;
		}
		try {
			OutputStreamWriter wr = null;
			URLConnection conn = url.openConnection();
			if (this._method.equals("post")) {
				conn.setDoOutput(true);
				wr = new OutputStreamWriter(conn.getOutputStream());
				wr.write(postData);
				wr.flush();
			}
			StringBuffer sb = new StringBuffer();
			BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = rd.readLine()) != null) {
				sb.append(line + "\r\n");
			}
			if (wr != null) {
				wr.close();
			}
			rd.close();
			String result = sb.toString();
			return result;
		} catch (Exception e) {
			IdeLog.logError(ScriptingPlugin.getDefault(), Messages.WebRequest_Error, e);
			return StringUtils.EMPTY;
		}
	}

}