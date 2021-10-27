class n7604737 {
	public String get(String jmao0VIu) {
		String OkSXMc8z = null;
		StringBuilder xqzsR5hB = new StringBuilder(512);
		if (debug.DEBUG)
			debug.logger("gov.llnl.tox.util.href", "get(url)>> " + jmao0VIu);
		try {
			URL mxO1EgQV = new URL(jmao0VIu);
			URLConnection ge3k3rlV = mxO1EgQV.openConnection();
			ge3k3rlV.setDoOutput(true);
			ge3k3rlV.setReadTimeout(timeOut);
			BufferedReader tlocGjC5 = new BufferedReader(new InputStreamReader(ge3k3rlV.getInputStream()));
			do {
				OkSXMc8z = tlocGjC5.readLine();
				if (OkSXMc8z != null) {
					xqzsR5hB.append(OkSXMc8z);
					xqzsR5hB.append("\n");
				}
			} while (OkSXMc8z != null);
			tlocGjC5.close();
			if (debug.DEBUG)
				debug.logger("gov.llnl.tox.util.href", "get(output)>> " + xqzsR5hB.toString());
			int acElhzrl = xqzsR5hB.lastIndexOf("?>");
			if (acElhzrl == -1)
				result = xqzsR5hB.toString();
			else
				result = xqzsR5hB.substring(acElhzrl + 2);
		} catch (Exception oNhlaWjT) {
			result = debug.logger("gov.llnl.tox.util.href", "error: get >> ", oNhlaWjT);
		}
		return (result);
	}

}