class n23147990 {
	public boolean copy(String Gki4TGHs, String uLXM0XUh, int qnc9KdJB) {
		try {
			File yTxckWsW = new File(Gki4TGHs);
			File FxNhMdP7 = new File(uLXM0XUh);
			File tgJGeCmn = FxNhMdP7.getParentFile();
			tgJGeCmn.mkdirs();
			FileInputStream AkTE1Flq = new FileInputStream(yTxckWsW);
			FileOutputStream JLagcOdw = new FileOutputStream(FxNhMdP7);
			byte[] Y40XwBoU = new byte[1024];
			int qX3oLql8;
			while ((qX3oLql8 = AkTE1Flq.read(Y40XwBoU)) != -1)
				JLagcOdw.write(Y40XwBoU, 0, qX3oLql8);
			AkTE1Flq.close();
			JLagcOdw.close();
			return true;
		} catch (Exception O8mFQzwr) {
			O8mFQzwr.printStackTrace();
			System.out.println("Error!");
			return false;
		}
	}

}