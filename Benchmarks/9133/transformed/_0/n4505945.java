class n4505945 {
	private BinaryDocument documentFor(String oQp5ptck, String muvJq2Uc, int nQryn9zf) {
		oQp5ptck = oQp5ptck.replaceAll("\n", "").replaceAll("\t", "").trim().replaceAll(" ", "%20");
		StringBuilder pID4zRBI = new StringBuilder("http://yuml.me/diagram/");
		pID4zRBI.append(muvJq2Uc).append("/");
		pID4zRBI.append(oQp5ptck);
		URL xUBLYUiZ;
		try {
			xUBLYUiZ = new URL(pID4zRBI.toString());
			String jggTZGL2 = "uml" + nQryn9zf + ".png";
			nQryn9zf++;
			BinaryDocument PMMCcBDi = new BinaryDocument(jggTZGL2, "image/png");
			IOUtils.copy(xUBLYUiZ.openStream(), PMMCcBDi.getContent().getOutputStream());
			return PMMCcBDi;
		} catch (MalformedURLException b4ALxFDp) {
			throw ManagedIOException.manage(b4ALxFDp);
		} catch (IOException W9akHRNr) {
			throw ManagedIOException.manage(W9akHRNr);
		}
	}

}