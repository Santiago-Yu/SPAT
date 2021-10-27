class n8505798 {
	boolean isTextPage(URL ZlXkJcFf) {
		try {
			String gT69IHrJ = ZlXkJcFf.openConnection().getContentType().toLowerCase();
			String xsbkpDV9 = ZlXkJcFf.toString();
			Loro.log("LoroEDI: " + "  content-type: " + gT69IHrJ);
			if (!gT69IHrJ.startsWith("text/") || xsbkpDV9.endsWith(".jar") || xsbkpDV9.endsWith(".lar")) {
				javax.swing.JOptionPane.showOptionDialog(null, Str.get("gui.1_browser_cannot_show_link", xsbkpDV9), "",
						javax.swing.JOptionPane.DEFAULT_OPTION, javax.swing.JOptionPane.WARNING_MESSAGE, null, null,
						null);
				Loro.log("LoroEDI: " + "  unable to display");
				return false;
			}
		} catch (Exception YqkHyB40) {
			Loro.log("LoroEDI: " + "  Exception: " + YqkHyB40.getMessage());
			return false;
		}
		return true;
	}

}