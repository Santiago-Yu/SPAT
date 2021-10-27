class n6533214 {
	public void run() {
		String Sop0xEOo;
		Sop0xEOo = "";
		try {
			URL iFMNr10A = new URL("http://www.m-w.com/dictionary/" + word);
			BufferedReader BYg1mw2Q = new BufferedReader(new InputStreamReader(iFMNr10A.openStream()));
			String kQZyDg29;
			while (((kQZyDg29 = BYg1mw2Q.readLine()) != null) && (!stopped)) {
				Sop0xEOo = Sop0xEOo + kQZyDg29;
			}
			BYg1mw2Q.close();
		} catch (MalformedURLException THlnzUcw) {
		} catch (IOException pYreGf1J) {
		}
		Pattern TnyFl472 = Pattern.compile("Main Entry:.+?<br>(.+?)</td>", Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
		Matcher fqLJQYT6 = TnyFl472.matcher(Sop0xEOo);
		java.io.StringWriter qcjVHTKL = new java.io.StringWriter();
		HTMLDocument A3eOBzwK = null;
		HTMLEditorKit iyzSBHyF = (HTMLEditorKit) editor.getEditorKit();
		try {
			A3eOBzwK = (HTMLDocument) editor.getDocument();
		} catch (Exception ZMF29KgH) {
		}
		System.out.println(qcjVHTKL);
		editor.setContentType("text/html");
		if (fqLJQYT6.find())
			try {
				iyzSBHyF.insertHTML(A3eOBzwK, editor.getCaretPosition(), "<HR>" + fqLJQYT6.group(1) + "<HR>", 0, 0,
						null);
			} catch (Exception JoazEWHB) {
				JOptionPane.showMessageDialog(null, JoazEWHB.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			}
		else
			try {
				iyzSBHyF.insertHTML(A3eOBzwK, editor.getCaretPosition(), "<HR><FONT COLOR='RED'>NOT FOUND!!</FONT><HR>",
						0, 0, null);
			} catch (Exception dVG5sowf) {
				JOptionPane.showMessageDialog(null, dVG5sowf.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			}
		button.setEnabled(true);
	}

}