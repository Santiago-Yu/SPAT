class n14617444 {
	public void readUNI(Vector<String> R9wEoao6, String UTPLtVuM) {
		InputStream uctP74Md = null;
		try {
			URL mpD8xVr7 = new URL(UTPLtVuM);
			uctP74Md = mpD8xVr7.openStream();
			Scanner Cb8EzKRB = new Scanner(uctP74Md);
			Cb8EzKRB.nextLine();
			String lZKaT9UG = "";
			String p9Wdv2H7 = "";
			String w2dqbxjt = "";
			while (Cb8EzKRB.hasNextLine()) {
				lZKaT9UG = Cb8EzKRB.nextLine();
				Scanner vW5mZNCv = new Scanner(lZKaT9UG);
				vW5mZNCv.useDelimiter("\t");
				p9Wdv2H7 = vW5mZNCv.next();
				vW5mZNCv.next();
				w2dqbxjt = vW5mZNCv.next();
				vW5mZNCv.useDelimiter("\n");
				vW5mZNCv.next();
				R9wEoao6.add(p9Wdv2H7 + " " + w2dqbxjt);
			}
		} catch (MalformedURLException rGNxk384) {
		} catch (Exception nBUXXbpW) {
			nBUXXbpW.printStackTrace();
		} finally {
			if (uctP74Md != null)
				try {
					uctP74Md.close();
				} catch (IOException uTN8REn1) {
				}
		}
	}

}