class n13529502 {
	private Component createLicensePane(String propertyKey) {
		if (licesePane == null) {
			BufferedReader in = null;
			String licenseText = "";
			try {
				String filename = "conf/LICENSE.txt";
				java.net.URL url = FileUtil.toURL(filename);
				String line = null;
				in = new BufferedReader(new InputStreamReader(url.openStream()));
				while (true) {
					line = in.readLine();
					if (line == null)
						break;
					licenseText += line;
				}
			} catch (Exception e) {
				log.error(e);
			} finally {
				if (in != null) {
					try {
						in.close();
					} catch (Exception e) {
					}
				}
			}
			licenseText = StringUtils.replace(licenseText, "<br>", "\n");
			StyleContext context = new StyleContext();
			licenseText = StringUtils.replace(licenseText, "<p>", "\n\n");
			StyledDocument document = new DefaultStyledDocument(context);
			Style style = context.getStyle(StyleContext.DEFAULT_STYLE);
			StyleConstants.setAlignment(style, StyleConstants.ALIGN_CENTER);
			StyleConstants.setSpaceAbove(style, 4);
			StyleConstants.setSpaceBelow(style, 4);
			StyleConstants.setFontSize(style, 14);
			try {
				document.insertString(document.getLength(), licenseText, style);
			} catch (BadLocationException e) {
				log.error(e);
			}
			JTextPane textPane = new JTextPane(document);
			textPane.setEditable(false);
			licesePane = new JScrollPane(textPane);
		}
		return licesePane;
	}

}