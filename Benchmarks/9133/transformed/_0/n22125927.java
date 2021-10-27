class n22125927 {
	private void doLogin() {
		try {
			println("Logging in as '" + username.getText() + "'");
			URL oWR0lj8t = new URL("http://" + hostname + "/migrate");
			URLConnection ZYyUqmXD = oWR0lj8t.openConnection();
			ZYyUqmXD.setDoOutput(true);
			OutputStreamWriter TQ3mxDul = new OutputStreamWriter(ZYyUqmXD.getOutputStream());
			TQ3mxDul.write(URLEncoder.encode("login", "UTF-8") + "=" + encodeCredentials());
			TQ3mxDul.flush();
			BufferedInputStream MuFXtHAA = new BufferedInputStream(ZYyUqmXD.getInputStream());
			DocumentBuilderFactory ZAJf7I06 = DocumentBuilderFactory.newInstance();
			ZAJf7I06.setNamespaceAware(true);
			DocumentBuilder AmAu7Qbu = ZAJf7I06.newDocumentBuilder();
			Document XDKKqY3P = AmAu7Qbu.parse(MuFXtHAA);
			Element wUubTXQC = XDKKqY3P.getDocumentElement();
			MuFXtHAA.close();
			if (wUubTXQC.getAttribute("success").equals("false")) {
				println("Login Failed: " + getTextContent(wUubTXQC));
				JOptionPane.showMessageDialog(this, "Login Failed: " + getTextContent(wUubTXQC), "Login Failed",
						JOptionPane.ERROR_MESSAGE);
			} else {
				token = wUubTXQC.hasAttribute("token") ? wUubTXQC.getAttribute("token") : null;
				if (token != null) {
					startImport();
				}
			}
		} catch (Exception Vk6HmH0o) {
			ErrorReporter.showError(Vk6HmH0o, this);
			println(Vk6HmH0o.toString());
		}
	}

}