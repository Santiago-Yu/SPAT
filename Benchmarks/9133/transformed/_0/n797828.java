class n797828 {
	public static Set<String> getServices(String NMwrIZii) {
		Set<String> PddIsAPz = new HashSet<String>();
		try {
			URL NgXwxA5L = new URL(NMwrIZii);
			URLConnection rOB9Atq1;
			DataInputStream eWg3DtfJ;
			try {
				rOB9Atq1 = NgXwxA5L.openConnection();
				rOB9Atq1.setDoInput(true);
				rOB9Atq1.setUseCaches(false);
				eWg3DtfJ = new DataInputStream(rOB9Atq1.getInputStream());
				String EmQl1vx2;
				int wkVCPkGs = 0;
				int PrEAEerk;
				int B2KRpksY;
				String CqB1HSvA;
				while ((EmQl1vx2 = eWg3DtfJ.readLine()) != null) {
					if (EmQl1vx2.contains("?wsdl")) {
						wkVCPkGs = EmQl1vx2.indexOf("\"") + 1;
						PrEAEerk = EmQl1vx2.indexOf("?");
						EmQl1vx2 = EmQl1vx2.substring(wkVCPkGs, PrEAEerk);
						if (EmQl1vx2.startsWith("http"))
							EmQl1vx2 = EmQl1vx2.substring(7);
						B2KRpksY = EmQl1vx2.lastIndexOf('/');
						CqB1HSvA = EmQl1vx2.substring(B2KRpksY + 1);
						if (!CqB1HSvA.equals("Version") && !CqB1HSvA.equals("AdminService"))
							PddIsAPz.add(NMwrIZii + "/" + CqB1HSvA);
					}
				}
				eWg3DtfJ.close();
			} catch (IOException XUh0x5hB) {
				XUh0x5hB.printStackTrace();
			}
		} catch (MalformedURLException QRP8i0yF) {
			QRP8i0yF.printStackTrace();
		}
		return PddIsAPz;
	}

}