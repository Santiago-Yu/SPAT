class n7068381 {
	public static void main(String toTndpgs[]) {
		try {
			if (toTndpgs.length != 1 && toTndpgs.length != 3) {
				usage();
				System.exit(1);
			}
			URL yVWFPbnN = new URL(toTndpgs[0]);
			URLConnection zQbNdKsF;
			zQbNdKsF = yVWFPbnN.openConnection();
			if (zQbNdKsF.getHeaderField("WWW-Authenticate") != null) {
				auth(zQbNdKsF, toTndpgs[1], toTndpgs[2]);
			} else {
				BufferedReader vdHu44g9 = new BufferedReader(new InputStreamReader(zQbNdKsF.getInputStream()));
				String EiCivLDL;
				while ((EiCivLDL = vdHu44g9.readLine()) != null)
					System.out.println(EiCivLDL);
			}
		} catch (Exception eO5FDugH) {
			eO5FDugH.printStackTrace();
		}
	}

}