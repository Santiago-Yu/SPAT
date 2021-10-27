class n8665321 {
	public Vector<String> getNetworkServersIPs(String Jvc6luxH) {
		Vector<String> Tk5tsdlB = new Vector<String>();
		boolean nXrqzfUn = false;
		String zlJgERgT;
		String[] lGu9aBrU;
		try {
			URL euUwbRZj = new URL(Jvc6luxH);
			URLConnection nhnzZJCZ = euUwbRZj.openConnection();
			BufferedReader nfZMFXas = new BufferedReader(new InputStreamReader(nhnzZJCZ.getInputStream()));
			while ((zlJgERgT = nfZMFXas.readLine()) != null) {
				if ((nXrqzfUn) && zlJgERgT.startsWith(";")) {
					nXrqzfUn = false;
				}
				if (nXrqzfUn) {
					lGu9aBrU = zlJgERgT.split(":");
					Tk5tsdlB.add(lGu9aBrU[1]);
				}
				if (zlJgERgT.startsWith("!SERVERS")) {
					nXrqzfUn = true;
				}
			}
		} catch (MalformedURLException nyXVbzii) {
			nyXVbzii.printStackTrace();
		} catch (IOException crK6Box1) {
			crK6Box1.printStackTrace();
		}
		return Tk5tsdlB;
	}

}