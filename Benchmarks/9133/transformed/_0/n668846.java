class n668846 {
	public static String getURL(String tncUojPp, String Rc6VyrnJ, String L90FWQsA) {
		try {
			if (Rc6VyrnJ != null)
				if (!Rc6VyrnJ.equals(""))
					tncUojPp += "?" + Rc6VyrnJ;
			URL x4ULwW3z = new URL(tncUojPp);
			URLConnection sUMvmzUp = x4ULwW3z.openConnection();
			if (!L90FWQsA.equals("")) {
				sUMvmzUp.setDoOutput(true);
				PrintWriter AMmmrxMp = new PrintWriter(sUMvmzUp.getOutputStream());
				AMmmrxMp.print(L90FWQsA);
				AMmmrxMp.close();
			}
			BufferedReader Pdine1rX = new BufferedReader(new InputStreamReader(sUMvmzUp.getInputStream()));
			int Cf2pC94e;
			String Oov3rjhM = "";
			while ((Cf2pC94e = Pdine1rX.read()) != -1)
				Oov3rjhM += (char) Cf2pC94e;
			Pdine1rX.close();
			return Oov3rjhM;
		} catch (Exception U2IKaRy3) {
			return null;
		}
	}

}