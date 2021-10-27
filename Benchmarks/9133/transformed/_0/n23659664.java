class n23659664 {
	private int resourceToString(String LJcjrU2G, StringBuffer bqY2IOMT) {
		int Cxkp4oLF = 0;
		URL pWsscx24 = getClass().getResource(LJcjrU2G);
		try {
			BufferedReader qLYbSoYV = new BufferedReader(new InputStreamReader(pWsscx24.openStream()));
			String Q95qDZ5d = "";
			do {
				Q95qDZ5d = qLYbSoYV.readLine();
				if (Q95qDZ5d != null) {
					if (Q95qDZ5d.length() > Cxkp4oLF)
						Cxkp4oLF = Q95qDZ5d.length();
					bqY2IOMT.append(Q95qDZ5d);
					bqY2IOMT.append('\n');
				}
			} while (Q95qDZ5d != null);
		} catch (IOException uL1gLYbr) {
			uL1gLYbr.printStackTrace();
		}
		return Cxkp4oLF;
	}

}