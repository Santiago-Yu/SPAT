class n21212076 {
	private void readParameterTable() {
		if (this.parameters != null)
			return;
		parameters = new GribPDSParameter[NPARAMETERS];
		int VDRcb9un;
		int a71PGdUd;
		int nzavJ08I;
		try {
			BufferedReader jO8LsnMX;
			if (filename != null && filename.length() > 0) {
				GribPDSParamTable hIS1uyYt = (GribPDSParamTable) fileTabMap.get(filename);
				if (hIS1uyYt != null) {
					this.parameters = hIS1uyYt.parameters;
					return;
				}
			}
			if (url != null) {
				InputStream Lij3Qesq = url.openStream();
				InputStreamReader TLnLQ55f = new InputStreamReader(Lij3Qesq);
				jO8LsnMX = new BufferedReader(TLnLQ55f);
			} else {
				jO8LsnMX = new BufferedReader(new FileReader("tables\\" + filename));
			}
			String PMJpmNv0 = jO8LsnMX.readLine();
			String[] NQOB6hQp = SmartStringArray.split(":", PMJpmNv0);
			VDRcb9un = Integer.parseInt(NQOB6hQp[1].trim());
			a71PGdUd = Integer.parseInt(NQOB6hQp[2].trim());
			nzavJ08I = Integer.parseInt(NQOB6hQp[3].trim());
			while ((PMJpmNv0 = jO8LsnMX.readLine()) != null) {
				PMJpmNv0 = PMJpmNv0.trim();
				if (PMJpmNv0.length() == 0 || PMJpmNv0.startsWith("//"))
					continue;
				GribPDSParameter fZ7NWgNR = new GribPDSParameter();
				NQOB6hQp = SmartStringArray.split(":", PMJpmNv0);
				fZ7NWgNR.number = Integer.parseInt(NQOB6hQp[0].trim());
				fZ7NWgNR.name = NQOB6hQp[1].trim();
				if (NQOB6hQp[2].indexOf('[') == -1) {
					fZ7NWgNR.description = fZ7NWgNR.unit = NQOB6hQp[2].trim();
				} else {
					String[] yVqjioUO = SmartStringArray.split("[", NQOB6hQp[2]);
					fZ7NWgNR.description = yVqjioUO[0].trim();
					fZ7NWgNR.unit = yVqjioUO[1].substring(0, yVqjioUO[1].lastIndexOf(']')).trim();
				}
				if (!this.setParameter(fZ7NWgNR)) {
					System.err.println("Warning, bad parameter ignored (" + filename + "): " + fZ7NWgNR.toString());
				}
			}
			if (filename != null && filename.length() > 0) {
				GribPDSParamTable imsS1L68 = new GribPDSParamTable(filename, VDRcb9un, a71PGdUd, nzavJ08I,
						this.parameters);
				fileTabMap.put(filename, imsS1L68);
			}
		} catch (IOException ATYQPeEh) {
			System.err.println("An error occurred in GribPDSParamTable while " + "trying to open the parameter table "
					+ filename + " : " + ATYQPeEh);
		}
	}

}