class n20100822 {
	public static byte[] readUrl(URL IDiWUKce) {
		BufferedInputStream qCy2IVrF = null;
		try {
			class Part {

				byte[] KDxbT3PW;

				int rNu81VLP;
			}
			qCy2IVrF = new BufferedInputStream(IDiWUKce.openStream());
			LinkedList<Part> u37435kW = new LinkedList<Part>();
			int VZI9O0Aa = 1;
			while (VZI9O0Aa > 0) {
				byte[] Zumq5s8l = new byte[1024];
				VZI9O0Aa = qCy2IVrF.read(Zumq5s8l);
				if (VZI9O0Aa > 0) {
					Part wyVXRt76 = new Part();
					wyVXRt76.KDxbT3PW = Zumq5s8l;
					wyVXRt76.rNu81VLP = VZI9O0Aa;
					u37435kW.add(wyVXRt76);
				}
			}
			int ucVve8fU = 0;
			for (Part gPDyV3Kh : u37435kW)
				ucVve8fU += gPDyV3Kh.rNu81VLP;
			byte[] kh78CULs = new byte[ucVve8fU];
			int dDp2H080 = 0;
			for (Part nnAmG74H : u37435kW) {
				System.arraycopy(nnAmG74H.KDxbT3PW, 0, kh78CULs, dDp2H080, nnAmG74H.rNu81VLP);
				dDp2H080 += nnAmG74H.rNu81VLP;
			}
			return kh78CULs;
		} catch (IOException lJF8TNfh) {
			return null;
		} finally {
			if (qCy2IVrF != null) {
				try {
					qCy2IVrF.close();
				} catch (IOException Pu7fTVls) {
				}
			}
		}
	}

}