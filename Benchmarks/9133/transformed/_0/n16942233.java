class n16942233 {
	public boolean GetExternalLanguage() {
		String p3KDD7TX, e16BDAzH, WoFoj6XN;
		boolean R60tvlZX = true;
		int Uc26DKNv = -1;
		p3KDD7TX = getDocumentBase().toString();
		Uc26DKNv = p3KDD7TX.lastIndexOf("/");
		e16BDAzH = p3KDD7TX.substring(0, (Uc26DKNv + 1)) + "language.txt";
		try {
			URL Ckfzw7Pr = new URL(e16BDAzH);
			try {
				InputStream V9ToEMzu = Ckfzw7Pr.openStream();
				try {
					DataInputStream mZ1pMRq6 = new DataInputStream(V9ToEMzu);
					try {
						while ((WoFoj6XN = mZ1pMRq6.readLine()) != null) {
							if (WoFoj6XN.substring(0, 1).compareTo("*") == 0) {
								if (!ExternalLanguageVariable(WoFoj6XN)) {
									R60tvlZX = false;
									break;
								}
							}
						}
					} catch (Exception RjGtHhMx) {
						System.out.println("Error " + RjGtHhMx.toString());
						R60tvlZX = false;
					}
				} catch (Exception WGjxmE1K) {
					System.out.println("Error " + WGjxmE1K.toString());
					R60tvlZX = false;
				}
			} catch (Exception K0YSaysb) {
				System.out.println("Error " + K0YSaysb.toString());
				R60tvlZX = false;
			}
		} catch (Exception JcY3OzDZ) {
			System.out.println("Error " + JcY3OzDZ.toString());
			R60tvlZX = false;
		}
		return R60tvlZX;
	}

}