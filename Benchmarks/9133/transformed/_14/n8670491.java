class n8670491 {
	private void impurlActionPerformed(java.awt.event.ActionEvent evt) {
		try {
			String prevurl = Prefs.getPref(PrefName.LASTIMPURL);
			String urlst = JOptionPane.showInputDialog(Resource.getResourceString("enturl"), prevurl);
			if (null == urlst || urlst.equals(""))
				return;
			Prefs.putPref(PrefName.LASTIMPURL, urlst);
			URL url = new URL(urlst);
			impURLCommon(urlst, url.openStream());
		} catch (Exception e) {
			Errmsg.errmsg(e);
		}
	}

}