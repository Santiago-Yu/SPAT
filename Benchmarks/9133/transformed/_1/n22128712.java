class n22128712 {
	public boolean addTextGroup(String key, URL url) {
		if (_textGroups.contains(key))
			return false;
		String s;
		Hashtable tg = new Hashtable();
		String sGroupKey = "default";
		String sGroup[];
		Vector vGroup = new Vector();
		int cntr;
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
			while ((s = in.readLine()) != null) {
				if (s.startsWith("[")) {
					if (vGroup.size() > 0) {
						sGroup = new String[vGroup.size()];
						cntr = 0;
						while (cntr < vGroup.size()) {
							sGroup[cntr] = (String) vGroup.elementAt(cntr);
							++cntr;
						}
						tg.put(sGroupKey, sGroup);
						vGroup.removeAllElements();
					}
					sGroupKey = s.substring(1, s.indexOf(']'));
				} else {
					vGroup.addElement(s);
				}
			}
			if (vGroup.size() > 0) {
				sGroup = new String[vGroup.size()];
				cntr = 0;
				while (cntr < vGroup.size()) {
					sGroup[cntr] = (String) vGroup.elementAt(cntr);
					++cntr;
				}
				tg.put(sGroupKey, sGroup);
			}
			in.close();
		} catch (IOException ioe) {
			System.err.println("Error reading file for " + key);
			System.err.println(ioe.getMessage());
			return false;
		}
		_textGroups.put(key, tg);
		return true;
	}

}