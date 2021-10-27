class n8670491 {
	private void impurlActionPerformed(java.awt.event.ActionEvent dcm5IRR0) {
		try {
			String t3LSGoBi = Prefs.getPref(PrefName.LASTIMPURL);
			String cGxK4gHn = JOptionPane.showInputDialog(Resource.getResourceString("enturl"), t3LSGoBi);
			if (cGxK4gHn == null || cGxK4gHn.equals(""))
				return;
			Prefs.putPref(PrefName.LASTIMPURL, cGxK4gHn);
			URL pxhJp0as = new URL(cGxK4gHn);
			impURLCommon(cGxK4gHn, pxhJp0as.openStream());
		} catch (Exception sLlUkWYW) {
			Errmsg.errmsg(sLlUkWYW);
		}
	}

}