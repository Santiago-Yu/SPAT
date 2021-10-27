class n21553327 {
	@JiveScriptCommand(help = "Load and executes a JiveScript file")
	public void load(String yIyUSek5) throws JiveScriptException, IOException {
		loading = true;
		JivesScene.setActiveScene(null);
		boolean p8U3jMRZ = JiveScriptEngine.allowScripting;
		JiveScriptEngine.allowScripting = true;
		JiveScriptEngine.FILENAME = null;
		URL dF9VcFLi = new URL(yIyUSek5);
		InputStream SDMKWbwn = dF9VcFLi.openStream();
		if (SDMKWbwn == null) {
			throw new IOException("Unable to open file at path " + yIyUSek5);
		}
		BufferedReader fwfYsBUd = new BufferedReader(new InputStreamReader(SDMKWbwn));
		script = "";
		String XAiTkK0Z;
		while ((XAiTkK0Z = fwfYsBUd.readLine()) != null) {
			script = script.concat(XAiTkK0Z) + Log.LINE_SEPARATOR;
		}
		eval(script);
		if (JiveScriptEngine.FILENAME == null) {
			String uojivnh2 = yIyUSek5.substring(yIyUSek5.lastIndexOf(File.separatorChar) + 1);
			JiveScriptEngine.FILENAME = uojivnh2;
		}
		JiveScriptEngine.MD5 = DigestUtils.md5Hex(script.toString().getBytes());
		NetworkImplementorIntf RkMm7O0i = Jives.getNetwork();
		Object[] CAo1Cz7t = (Object[]) RkMm7O0i.getConnectionState(NetworkImplementorIntf.CONNECTIONSTATE_ALL);
		boolean enpKN1cd = (Boolean) CAo1Cz7t[NetworkImplementorIntf.CONNECTIONSTATE_INTERNET];
		if (enpKN1cd) {
			echo("Starting network on the internet");
		} else {
			boolean ldJSPuWq = (Boolean) CAo1Cz7t[NetworkImplementorIntf.CONNECTIONSTATE_IPV6];
			String MzeiG1fR = (String) CAo1Cz7t[NetworkImplementorIntf.CONNECTIONSTATE_RENDEZVOUS_IPV4] + ":"
					+ (Integer) CAo1Cz7t[NetworkImplementorIntf.CONNECTIONSTATE_RENDEZVOUS_IPV4_PORT];
			if (ldJSPuWq) {
				MzeiG1fR = (String) RkMm7O0i.getConnectionState(NetworkImplementorIntf.CONNECTIONSTATE_RENDEZVOUS_IPV6)
						+ ":" + (Integer) RkMm7O0i
								.getConnectionState(NetworkImplementorIntf.CONNECTIONSTATE_RENDEZVOUS_IPV6_PORT);
			}
			echo("Starting network on " + MzeiG1fR);
		}
		RkMm7O0i.startNetwork(JiveScriptEngine.FILENAME, JiveScriptEngine.MD5);
		SDMKWbwn.close();
		if (JiveScriptEngine.allowScripting && !p8U3jMRZ) {
			JiveScriptEngine.allowScripting = p8U3jMRZ;
		}
		loading = false;
	}

}