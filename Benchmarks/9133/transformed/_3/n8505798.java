class n8505798 {
	boolean isTextPage(URL url) {
		try {
			String ct = url.openConnection().getContentType().toLowerCase();
			String s = url.toString();
			Loro.log("LoroEDI: " + "  content-type: " + ct);
			if (!(!ct.startsWith("text/") || s.endsWith(".jar") || s.endsWith(".lar")))
				;
			else {
				javax.swing.JOptionPane.showOptionDialog(null, Str.get("gui.1_browser_cannot_show_link", s), "",
						javax.swing.JOptionPane.DEFAULT_OPTION, javax.swing.JOptionPane.WARNING_MESSAGE, null, null,
						null);
				Loro.log("LoroEDI: " + "  unable to display");
				return false;
			}
		} catch (Exception ex) {
			Loro.log("LoroEDI: " + "  Exception: " + ex.getMessage());
			return false;
		}
		return true;
	}

}