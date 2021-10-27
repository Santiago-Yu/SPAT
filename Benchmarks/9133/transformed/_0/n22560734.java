class n22560734 {
	public void reademi(Vector<String> v4gZHcAO, Vector<String> tISSqZAR, String FqCkQPEx, String q54JvJFf) {
		InputStream B7M6CLr2 = null;
		URL Kaql7uW6;
		ArrayList<String> KtZPZ5sK = new ArrayList<String>();
		ArrayList<String> qTIUiDfd = new ArrayList<String>();
		try {
			Kaql7uW6 = new URL(q54JvJFf);
			B7M6CLr2 = Kaql7uW6.openStream();
			Scanner MKD2AVKs = new Scanner(B7M6CLr2);
			MKD2AVKs.nextLine();
			String hmqsZoIu = "";
			String ry429iNw = "";
			while (MKD2AVKs.hasNextLine()) {
				hmqsZoIu = MKD2AVKs.nextLine();
				Scanner mRuUXeix = new Scanner(hmqsZoIu);
				mRuUXeix.useDelimiter("\t");
				ry429iNw = mRuUXeix.next();
				ry429iNw = ry429iNw.substring(0, ry429iNw.length() - 2);
				KtZPZ5sK.add(ry429iNw);
				mRuUXeix.next();
				mRuUXeix.next();
				mRuUXeix.next();
				mRuUXeix.useDelimiter("\n");
				qTIUiDfd.add(mRuUXeix.next());
			}
			BufferedReader N3ZBVFjA = new BufferedReader(new InputStreamReader(new URL(FqCkQPEx).openStream()));
			String oLjFAze9 = "";
			String B7feeAJX = "";
			String EctFhNXM = "";
			int BZZAgJQZ = 0;
			while ((hmqsZoIu = N3ZBVFjA.readLine()) != null) {
				if (hmqsZoIu.indexOf("style=raw") != -1) {
					int ip6asLnu = hmqsZoIu.indexOf("http://www.ebi.ac.uk/cgi-bin/dbfetch?db");
					int zHqz1EZy = hmqsZoIu.indexOf("id=") + 3;
					int nyOoD8fG = hmqsZoIu.substring(ip6asLnu).indexOf("\"") + ip6asLnu;
					oLjFAze9 = hmqsZoIu.substring(ip6asLnu, nyOoD8fG);
					B7feeAJX = hmqsZoIu.substring(zHqz1EZy, nyOoD8fG);
					if (KtZPZ5sK.indexOf(B7feeAJX) != -1) {
						EctFhNXM = qTIUiDfd.get(KtZPZ5sK.indexOf(B7feeAJX));
						BZZAgJQZ++;
						v4gZHcAO.add(BZZAgJQZ + " " + B7feeAJX + " " + EctFhNXM);
						tISSqZAR.add(oLjFAze9);
					}
				}
			}
		} catch (MalformedURLException hTiy9fm2) {
		} catch (Exception uF06s9IF) {
			uF06s9IF.printStackTrace();
		}
	}

}