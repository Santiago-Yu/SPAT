class n14617443 {
	public void reademi(Vector<String> heBybt1W, Vector<String> uEL9X7bz, String VsZywtzn, String yYFTnauz) {
		InputStream RkT84ogd = null;
		URL OloZDK1m;
		ArrayList<String> L6xbo7fT = new ArrayList<String>();
		ArrayList<String> vtxjpXgn = new ArrayList<String>();
		try {
			OloZDK1m = new URL(yYFTnauz);
			RkT84ogd = OloZDK1m.openStream();
			Scanner GTdnT3pK = new Scanner(RkT84ogd);
			GTdnT3pK.nextLine();
			String BZWtJERf = "";
			String cFNyhweJ = "";
			while (GTdnT3pK.hasNextLine()) {
				BZWtJERf = GTdnT3pK.nextLine();
				Scanner yXRBd8fS = new Scanner(BZWtJERf);
				yXRBd8fS.useDelimiter("\t");
				cFNyhweJ = yXRBd8fS.next();
				cFNyhweJ = cFNyhweJ.substring(0, cFNyhweJ.length() - 2);
				L6xbo7fT.add(cFNyhweJ);
				yXRBd8fS.next();
				yXRBd8fS.next();
				yXRBd8fS.next();
				yXRBd8fS.useDelimiter("\n");
				vtxjpXgn.add(yXRBd8fS.next());
			}
			BufferedReader uH8x2TUs = new BufferedReader(new InputStreamReader(new URL(VsZywtzn).openStream()));
			String FNQHJHph = "";
			String OR8yGuXb = "";
			String PNVEFKHd = "";
			int MMeKhIvo = 0;
			while ((BZWtJERf = uH8x2TUs.readLine()) != null) {
				if (BZWtJERf.indexOf("style=raw") != -1) {
					int nD0rfLsS = BZWtJERf.indexOf("http://www.ebi.ac.uk/cgi-bin/dbfetch?db");
					int t34rQjyX = BZWtJERf.indexOf("id=") + 3;
					int ViJxQazA = BZWtJERf.substring(nD0rfLsS).indexOf("\"") + nD0rfLsS;
					FNQHJHph = BZWtJERf.substring(nD0rfLsS, ViJxQazA);
					OR8yGuXb = BZWtJERf.substring(t34rQjyX, ViJxQazA);
					if (L6xbo7fT.indexOf(OR8yGuXb) != -1) {
						PNVEFKHd = vtxjpXgn.get(L6xbo7fT.indexOf(OR8yGuXb));
						MMeKhIvo++;
						heBybt1W.add(MMeKhIvo + " " + OR8yGuXb + " " + PNVEFKHd);
						uEL9X7bz.add(FNQHJHph);
					}
				}
			}
		} catch (MalformedURLException GU24ZYd2) {
		} catch (Exception KvogR2IW) {
			KvogR2IW.printStackTrace();
		}
	}

}