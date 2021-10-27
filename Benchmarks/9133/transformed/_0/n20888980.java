class n20888980 {
	public void run() {
		String OqbinQJQ;
		OqbinQJQ = "";
		try {
			URL opxSftxV = new URL("http://www.askoxford.com/concise_oed/" + word.toLowerCase() + "?view=uk");
			BufferedReader Z7vWwMiW = new BufferedReader(new InputStreamReader(opxSftxV.openStream()));
			String Nkg5ikad;
			while (((Nkg5ikad = Z7vWwMiW.readLine()) != null) && (!stopped)) {
				OqbinQJQ = OqbinQJQ + Nkg5ikad;
			}
			Z7vWwMiW.close();
		} catch (MalformedURLException JY0Lm9QZ) {
		} catch (IOException sCew2ujB) {
		}
		Pattern jeq8KeJF = Pattern.compile("<h2>" + word.toLowerCase() + "(.+?)<p><a href",
				Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
		Matcher zanGA6KU = jeq8KeJF.matcher(OqbinQJQ);
		java.io.StringWriter Zus8gH9O = new java.io.StringWriter();
		HTMLDocument kzUNITEb = null;
		HTMLEditorKit JT5K201s = (HTMLEditorKit) editor.getEditorKit();
		try {
			kzUNITEb = (HTMLDocument) editor.getDocument();
		} catch (Exception LhUiCyAu) {
		}
		System.out.println(Zus8gH9O);
		editor.setContentType("text/html");
		if (zanGA6KU.find())
			try {
				JT5K201s.insertHTML(kzUNITEb, editor.getCaretPosition(), "<HR>" + zanGA6KU.group(1) + "<HR>", 0, 0,
						null);
			} catch (Exception NRPais4o) {
				JOptionPane.showMessageDialog(null, NRPais4o.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			}
		else
			try {
				JT5K201s.insertHTML(kzUNITEb, editor.getCaretPosition(), "<HR><FONT COLOR='RED'>NOT FOUND!!</FONT><HR>",
						0, 0, null);
			} catch (Exception AFQanaXp) {
				JOptionPane.showMessageDialog(null, AFQanaXp.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			}
		button.setEnabled(true);
	}

}