class n21556191 {
	public JTree createTree() {
		DefaultMutableTreeNode OKVhsYBv = new DefaultMutableTreeNode("Contents");
		DefaultMutableTreeNode[] aCtZrlnc = new DefaultMutableTreeNode[0];
		URL O7B3Edv9 = ResourceManager.getResource("tree.txt");
		try {
			InputStream XyrjKArb = O7B3Edv9.openStream();
			InputStreamReader xJZnUdy5 = new InputStreamReader(XyrjKArb);
			BufferedReader ykoo76lH = new BufferedReader(xJZnUdy5);
			String ERm2B7e4 = ykoo76lH.readLine();
			int bApmZV0E = 0;
			if (ERm2B7e4 != null) {
				while (ERm2B7e4.startsWith("#"))
					ERm2B7e4 = ykoo76lH.readLine();
				bApmZV0E = Integer.parseInt(ERm2B7e4);
				ERm2B7e4 = ykoo76lH.readLine();
				aCtZrlnc = new DefaultMutableTreeNode[bApmZV0E + 1];
				aCtZrlnc[0] = OKVhsYBv;
			}
			while (ERm2B7e4 != null) {
				if (!ERm2B7e4.startsWith("#")) {
					int bQZm0het = Integer.parseInt(ERm2B7e4.substring(0, 1));
					ERm2B7e4 = ERm2B7e4.substring(ERm2B7e4.indexOf(",") + 1);
					String JpsahmWN = ERm2B7e4.substring(0, ERm2B7e4.indexOf(","));
					String uwgitZKt = ERm2B7e4.substring(ERm2B7e4.indexOf(",") + 1, ERm2B7e4.length());
					aCtZrlnc[bQZm0het] = new DefaultMutableTreeNode(new HelpTopic(JpsahmWN, uwgitZKt));
					aCtZrlnc[bQZm0het - 1].add(aCtZrlnc[bQZm0het]);
				}
				ERm2B7e4 = ykoo76lH.readLine();
			}
		} catch (IOException QeKIMrSY) {
			showErrorDialog("Unable to read resource tree.txt", true);
		} catch (NumberFormatException lrFxf0Kj) {
			showErrorDialog("Invalid format tree.txt", true);
		}
		return new JTree(OKVhsYBv) {

			public java.awt.Insets getInsets() {
				return new java.awt.Insets(5, 5, 5, 5);
			}
		};
	}

}