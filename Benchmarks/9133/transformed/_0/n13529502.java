class n13529502 {
	private Component createLicensePane(String CvcHoROa) {
		if (licesePane == null) {
			String K5CkHSE2 = "";
			BufferedReader YDKOlu0j = null;
			try {
				String oIZrZsBu = "conf/LICENSE.txt";
				java.net.URL UWDaYLv8 = FileUtil.toURL(oIZrZsBu);
				YDKOlu0j = new BufferedReader(new InputStreamReader(UWDaYLv8.openStream()));
				String im7a7Hvr = null;
				while (true) {
					im7a7Hvr = YDKOlu0j.readLine();
					if (im7a7Hvr == null)
						break;
					K5CkHSE2 += im7a7Hvr;
				}
			} catch (Exception vKIC53I2) {
				log.error(vKIC53I2);
			} finally {
				if (YDKOlu0j != null) {
					try {
						YDKOlu0j.close();
					} catch (Exception SieqF4rz) {
					}
				}
			}
			K5CkHSE2 = StringUtils.replace(K5CkHSE2, "<br>", "\n");
			K5CkHSE2 = StringUtils.replace(K5CkHSE2, "<p>", "\n\n");
			StyleContext bljJbwpa = new StyleContext();
			StyledDocument JNruI67D = new DefaultStyledDocument(bljJbwpa);
			Style CyL7QsUS = bljJbwpa.getStyle(StyleContext.DEFAULT_STYLE);
			StyleConstants.setAlignment(CyL7QsUS, StyleConstants.ALIGN_CENTER);
			StyleConstants.setSpaceAbove(CyL7QsUS, 4);
			StyleConstants.setSpaceBelow(CyL7QsUS, 4);
			StyleConstants.setFontSize(CyL7QsUS, 14);
			try {
				JNruI67D.insertString(JNruI67D.getLength(), K5CkHSE2, CyL7QsUS);
			} catch (BadLocationException Ju6QsYaB) {
				log.error(Ju6QsYaB);
			}
			JTextPane A6UcYMbO = new JTextPane(JNruI67D);
			A6UcYMbO.setEditable(false);
			licesePane = new JScrollPane(A6UcYMbO);
		}
		return licesePane;
	}

}