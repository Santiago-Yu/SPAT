class n19861526 {
	static void getGroups(String sfG40GOT) {
		try {
			Gui.getBalken().setValue(85);
			Gui.getBalken().setString("crawling Groups");
			Gui.getBalken().paint(Gui.getBalken().getGraphics());
			URL gIaEo2Xs = new URL("http://www.lastfm.de/user/" + sfG40GOT + "/groups/");
			URLConnection QQ6xmNrd = gIaEo2Xs.openConnection();
			BufferedReader NPGBA1AJ = new BufferedReader(new InputStreamReader(QQ6xmNrd.getInputStream()));
			HTMLEditorKit ISjT88ez = new HTMLEditorKit();
			HTMLDocument MnCY2QP3 = new HTMLDocument();
			MnCY2QP3.putProperty("IgnoreCharsetDirective", Boolean.TRUE);
			ISjT88ez.read(NPGBA1AJ, MnCY2QP3, 0);
			Vector R3PXICQY = new Vector();
			HTMLDocument.Iterator zKPcKp9b = MnCY2QP3.getIterator(HTML.Tag.A);
			while (zKPcKp9b.isValid()) {
				R3PXICQY.add((String) zKPcKp9b.getAttributes().getAttribute(HTML.Attribute.HREF));
				zKPcKp9b.next();
			}
			Vector EPm3h4Zu = new Vector();
			for (int PcLfMBqO = 0; PcLfMBqO < R3PXICQY.size(); PcLfMBqO++) {
				String FMfi9jEB = (String) R3PXICQY.get(PcLfMBqO);
				if (!EPm3h4Zu.contains(FMfi9jEB)) {
					if (FMfi9jEB.contains("/group/"))
						EPm3h4Zu.add(FMfi9jEB);
				}
			}
			for (int EbOkvuTC = 0; EbOkvuTC < EPm3h4Zu.size(); EbOkvuTC++) {
				String DNMuHxDy = EPm3h4Zu.elementAt(EbOkvuTC).toString().substring(7);
				if (DNMuHxDy.contains("Last.fm+auf+Deutsch")) {
					System.out.println("Auschalten Last.fm.auf.Deutsch");
				} else {
					System.out.println(DNMuHxDy + " gruppe ");
					if (!DB_Groups.checkGroup(DNMuHxDy)) {
						System.out.println(DNMuHxDy);
						if (!DB_Groups.checkGroup(DNMuHxDy)) {
							DB_Groups.addGroup(DNMuHxDy);
							getGroupsImage(sfG40GOT);
							getGroupMember(DNMuHxDy);
						}
						DB_Groups.addGroupRelation(sfG40GOT, DNMuHxDy);
						getGroupsImage(sfG40GOT);
					}
				}
			}
		} catch (MalformedURLException CgRHrHIf) {
			CgRHrHIf.printStackTrace();
		} catch (IOException dbhXFm9t) {
			dbhXFm9t.printStackTrace();
		} catch (BadLocationException OsuIXuBf) {
			OsuIXuBf.printStackTrace();
		}
	}

}