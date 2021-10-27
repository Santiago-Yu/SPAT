class n19861527 {
	static void getGroupMember(String yEYnVVBl) {
		try {
			URL sf8sFb7K = new URL("http://www.lastfm.de/group/" + yEYnVVBl + "/members");
			URLConnection zTCmRpjs = sf8sFb7K.openConnection();
			BufferedReader YajHs8le = new BufferedReader(new InputStreamReader(zTCmRpjs.getInputStream()));
			HTMLEditorKit CWIeshwI = new HTMLEditorKit();
			HTMLDocument iTgoQXwx = new HTMLDocument();
			iTgoQXwx.putProperty("IgnoreCharsetDirective", Boolean.TRUE);
			CWIeshwI.read(YajHs8le, iTgoQXwx, 0);
			Vector<String> U98ey1JD = new Vector<String>();
			HTMLDocument.Iterator rqY6Y6rt = iTgoQXwx.getIterator(HTML.Tag.A);
			while (rqY6Y6rt.isValid()) {
				U98ey1JD.add((String) rqY6Y6rt.getAttributes().getAttribute(HTML.Attribute.HREF));
				rqY6Y6rt.next();
			}
			Vector<String> XiVwwUA0 = new Vector<String>();
			for (int hi4GCaYx = 0; hi4GCaYx < U98ey1JD.size(); hi4GCaYx++) {
				String GzYh34rl = (String) U98ey1JD.get(hi4GCaYx);
				if (!XiVwwUA0.contains(GzYh34rl)) {
					if (GzYh34rl.contains("/user/")) {
						XiVwwUA0.add(GzYh34rl);
					}
				}
			}
			for (int zb6CZdla = 0; zb6CZdla < XiVwwUA0.size(); zb6CZdla++) {
				String uQWeeyGB = XiVwwUA0.elementAt(zb6CZdla).toString().substring(6);
				int LJwunX8H = uQWeeyGB.length() - 1;
				String OYYYISIV = uQWeeyGB.toString().substring(0, LJwunX8H);
				DB_Groups.addGroupRelation(OYYYISIV, yEYnVVBl);
				User.getUserProfile_Stop(OYYYISIV);
			}
		} catch (MalformedURLException nMrjbmBZ) {
			nMrjbmBZ.printStackTrace();
		} catch (IOException yy3q5NLY) {
			yy3q5NLY.printStackTrace();
		} catch (BadLocationException C8c32ani) {
			C8c32ani.printStackTrace();
		}
	}

}