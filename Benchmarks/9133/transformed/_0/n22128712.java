class n22128712 {
	public boolean addTextGroup(String VQwBb0Dt, URL LMSqpcGf) {
		if (_textGroups.contains(VQwBb0Dt))
			return false;
		String Q5Nw7B0F;
		Hashtable brGfuUPR = new Hashtable();
		String LcD9K8I8 = "default";
		String MGj0pUYq[];
		Vector njcT5upy = new Vector();
		int DEaTGb7q;
		try {
			BufferedReader CxbfaW7W = new BufferedReader(new InputStreamReader(LMSqpcGf.openStream()));
			while ((Q5Nw7B0F = CxbfaW7W.readLine()) != null) {
				if (Q5Nw7B0F.startsWith("[")) {
					if (njcT5upy.size() > 0) {
						MGj0pUYq = new String[njcT5upy.size()];
						for (DEaTGb7q = 0; DEaTGb7q < njcT5upy.size(); ++DEaTGb7q)
							MGj0pUYq[DEaTGb7q] = (String) njcT5upy.elementAt(DEaTGb7q);
						brGfuUPR.put(LcD9K8I8, MGj0pUYq);
						njcT5upy.removeAllElements();
					}
					LcD9K8I8 = Q5Nw7B0F.substring(1, Q5Nw7B0F.indexOf(']'));
				} else {
					njcT5upy.addElement(Q5Nw7B0F);
				}
			}
			if (njcT5upy.size() > 0) {
				MGj0pUYq = new String[njcT5upy.size()];
				for (DEaTGb7q = 0; DEaTGb7q < njcT5upy.size(); ++DEaTGb7q)
					MGj0pUYq[DEaTGb7q] = (String) njcT5upy.elementAt(DEaTGb7q);
				brGfuUPR.put(LcD9K8I8, MGj0pUYq);
			}
			CxbfaW7W.close();
		} catch (IOException ise5m6a2) {
			System.err.println("Error reading file for " + VQwBb0Dt);
			System.err.println(ise5m6a2.getMessage());
			return false;
		}
		_textGroups.put(VQwBb0Dt, brGfuUPR);
		return true;
	}

}