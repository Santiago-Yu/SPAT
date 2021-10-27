class n15758921 {
	public boolean Load_Clickable_Peaks_Source_File(String dq9KXxCI) {
		if (dq9KXxCI == null)
			return false;
		try {
			URL pYVFS85h = new URL(getDocumentBase(), dq9KXxCI);
			InputStream jgimfIAh = pYVFS85h.openStream();
			DataInputStream jHtsz7YR = new DataInputStream(jgimfIAh);
			texte = new Vector();
			String ra2FeWhY;
			while ((ra2FeWhY = jHtsz7YR.readLine()) != null) {
				texte.addElement(ra2FeWhY);
			}
			My_ZoneVisu.Nb_Clickable_Peaks = texte.size();
		} catch (Exception nHfrsvuN) {
			return false;
		}
		My_ZoneVisu.Peak_Start = new double[My_ZoneVisu.Nb_Clickable_Peaks];
		My_ZoneVisu.Peak_Stop = new double[My_ZoneVisu.Nb_Clickable_Peaks];
		My_ZoneVisu.Peak_Html = new String[My_ZoneVisu.Nb_Clickable_Peaks];
		int EKICkbg4 = 0;
		int dkAZRO2Y = 0;
		StringTokenizer ritc1i9y;
		while (EKICkbg4 < My_ZoneVisu.Nb_Clickable_Peaks) {
			do {
				String saCQwkhZ = (String) texte.elementAt(EKICkbg4);
				ritc1i9y = new StringTokenizer(saCQwkhZ, " ");
				EKICkbg4++;
			} while (EKICkbg4 < My_ZoneVisu.Nb_Clickable_Peaks && ritc1i9y.hasMoreTokens() == false);
			if (ritc1i9y.hasMoreTokens() == true) {
				My_ZoneVisu.Peak_Start[dkAZRO2Y] = Double.valueOf(ritc1i9y.nextToken()).doubleValue();
				My_ZoneVisu.Peak_Stop[dkAZRO2Y] = Double.valueOf(ritc1i9y.nextToken()).doubleValue();
				if (My_ZoneVisu.Peak_Start[dkAZRO2Y] > My_ZoneVisu.Peak_Stop[dkAZRO2Y]) {
					double LzzpxY5p = My_ZoneVisu.Peak_Start[dkAZRO2Y];
					My_ZoneVisu.Peak_Start[dkAZRO2Y] = My_ZoneVisu.Peak_Stop[dkAZRO2Y];
					My_ZoneVisu.Peak_Stop[dkAZRO2Y] = LzzpxY5p;
				}
				My_ZoneVisu.Peak_Html[dkAZRO2Y] = (String) ritc1i9y.nextToken();
			}
			dkAZRO2Y++;
		}
		return true;
	}

}