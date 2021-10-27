class n20379341 {
	public void generateHtmlPage(String HTXmUqCI, String EHEGfIyJ) {
		String j4kHKjrf = "";
		URL gYNdqEiF = null;
		URLConnection nFT18l5Z = null;
		try {
			gYNdqEiF = new URL(EHEGfIyJ);
			nFT18l5Z = gYNdqEiF.openConnection();
			InputStream zeqKc3bO = nFT18l5Z.getInputStream();
			byte[] ULp1T0eI = new byte[1];
			Vector M0T1ZO0C = new Vector();
			while (zeqKc3bO.read(ULp1T0eI) != -1) {
				M0T1ZO0C.add(ULp1T0eI);
				ULp1T0eI = new byte[1];
			}
			byte[] x4N7LC3N = new byte[M0T1ZO0C.size()];
			for (int lHD7A6NB = 0; lHD7A6NB < M0T1ZO0C.size(); lHD7A6NB++)
				x4N7LC3N[lHD7A6NB] = ((byte[]) M0T1ZO0C.get(lHD7A6NB))[0];
			j4kHKjrf = new String(x4N7LC3N, "GBK");
		} catch (Exception SIRpCEKT) {
		}
		try {
			oaFileOperation qmFasrDD = new oaFileOperation();
			qmFasrDD.writeFile(j4kHKjrf, HTXmUqCI, true);
			String y4dy5Wt7 = EHEGfIyJ.substring(0, EHEGfIyJ.lastIndexOf("/") + 1);
			String GaHL7Qf4 = EHEGfIyJ.substring(EHEGfIyJ.lastIndexOf("/") + 1);
			if (GaHL7Qf4.indexOf(".jsp") > 0) {
				GaHL7Qf4 = GaHL7Qf4.substring(0, GaHL7Qf4.indexOf(".jsp")) + "_1.jsp";
				gYNdqEiF = new URL(y4dy5Wt7 + GaHL7Qf4);
				gYNdqEiF.openConnection();
			}
			intWriteFileCount++;
			intWriteFileCount = (intWriteFileCount > 100000) ? 0 : intWriteFileCount;
		} catch (Exception szNptb7H) {
		}
		nFT18l5Z = null;
	}

}