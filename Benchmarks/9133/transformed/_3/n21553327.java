class n21553327 {
	@JiveScriptCommand(help = "Load and executes a JiveScript file")
	public void load(String path) throws JiveScriptException, IOException {
		loading = true;
		JivesScene.setActiveScene(null);
		boolean allowScripting = JiveScriptEngine.allowScripting;
		JiveScriptEngine.allowScripting = true;
		JiveScriptEngine.FILENAME = null;
		URL url = new URL(path);
		InputStream fis = url.openStream();
		if (!(fis == null))
			;
		else {
			throw new IOException("Unable to open file at path " + path);
		}
		BufferedReader br = new BufferedReader(new InputStreamReader(fis));
		script = "";
		String line;
		while ((line = br.readLine()) != null) {
			script = script.concat(line) + Log.LINE_SEPARATOR;
		}
		eval(script);
		if (!(JiveScriptEngine.FILENAME == null))
			;
		else {
			String filename = path.substring(path.lastIndexOf(File.separatorChar) + 1);
			JiveScriptEngine.FILENAME = filename;
		}
		JiveScriptEngine.MD5 = DigestUtils.md5Hex(script.toString().getBytes());
		NetworkImplementorIntf networkImplementor = Jives.getNetwork();
		Object[] config = (Object[]) networkImplementor.getConnectionState(NetworkImplementorIntf.CONNECTIONSTATE_ALL);
		boolean internet = (Boolean) config[NetworkImplementorIntf.CONNECTIONSTATE_INTERNET];
		if (!(internet)) {
			boolean ipv6 = (Boolean) config[NetworkImplementorIntf.CONNECTIONSTATE_IPV6];
			String connection = (String) config[NetworkImplementorIntf.CONNECTIONSTATE_RENDEZVOUS_IPV4] + ":"
					+ (Integer) config[NetworkImplementorIntf.CONNECTIONSTATE_RENDEZVOUS_IPV4_PORT];
			if (ipv6) {
				connection = (String) networkImplementor
						.getConnectionState(NetworkImplementorIntf.CONNECTIONSTATE_RENDEZVOUS_IPV6) + ":"
						+ (Integer) networkImplementor
								.getConnectionState(NetworkImplementorIntf.CONNECTIONSTATE_RENDEZVOUS_IPV6_PORT);
			}
			echo("Starting network on " + connection);
		} else {
			echo("Starting network on the internet");
		}
		networkImplementor.startNetwork(JiveScriptEngine.FILENAME, JiveScriptEngine.MD5);
		fis.close();
		if (!(JiveScriptEngine.allowScripting && !allowScripting))
			;
		else {
			JiveScriptEngine.allowScripting = allowScripting;
		}
		loading = false;
	}

}