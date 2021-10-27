class n5685389 {
	private void extractSpecifications(String jNLEcImy, File sH06NqQi) {
		Object UAQxuHfs = getClass().getResource(jNLEcImy + ".xml");
		if (UAQxuHfs instanceof URL) {
			URL uzsS0mVA = (URL) UAQxuHfs;
			try {
				InputStream D6FrcIkI = uzsS0mVA.openStream();
				try {
					OutputStream NxeVTL2S = new FileOutputStream(sH06NqQi);
					try {
						byte[] pECa22fD = new byte[1024];
						int MylJsIEE;
						while ((MylJsIEE = D6FrcIkI.read(pECa22fD)) > 0) {
							NxeVTL2S.write(pECa22fD, 0, MylJsIEE);
						}
					} finally {
						NxeVTL2S.close();
					}
				} finally {
					D6FrcIkI.close();
				}
			} catch (IOException ItapUsMf) {
				throw new RuntimeException("Failed to open " + uzsS0mVA, ItapUsMf);
			}
		}
	}

}