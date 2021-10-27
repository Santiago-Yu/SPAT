class n22125927 {
	private void doLogin() {
		try {
			println("Logging in as '" + username.getText() + "'");
			URL url = new URL("http://" + hostname + "/migrate");
			URLConnection conn = url.openConnection();
			conn.setDoOutput(true);
			OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
			wr.write(URLEncoder.encode("login", "UTF-8") + "=" + encodeCredentials());
			wr.flush();
			BufferedInputStream in = new BufferedInputStream(conn.getInputStream());
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			dbf.setNamespaceAware(true);
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(in);
			Element root = doc.getDocumentElement();
			in.close();
			if (root.getAttribute("success").equals("false")) {
				println("Login Failed: " + getTextContent(root));
				JOptionPane.showMessageDialog(this, "Login Failed: " + getTextContent(root), "Login Failed",
						JOptionPane.ERROR_MESSAGE);
			} else {
				if (root.hasAttribute("token"))
					token = root.getAttribute("token");
				else
					token = null;
				if (token != null) {
					startImport();
				}
			}
		} catch (Exception e) {
			ErrorReporter.showError(e, this);
			println(e.toString());
		}
	}

}