class n19267604 {
	protected void convertInternal(InputStream OVKo76Hs, DocumentFormat UU3Makad, OutputStream Yt9MV6Gw,
			DocumentFormat qNwxp3iG) {
		File jBQFAlUt = null;
		File AqcoHKCQ = null;
		try {
			jBQFAlUt = File.createTempFile("document", "." + UU3Makad.getFileExtension());
			OutputStream bcbwHNeK = null;
			try {
				bcbwHNeK = new FileOutputStream(jBQFAlUt);
				IOUtils.copy(OVKo76Hs, bcbwHNeK);
			} finally {
				IOUtils.closeQuietly(bcbwHNeK);
			}
			AqcoHKCQ = File.createTempFile("document", "." + qNwxp3iG.getFileExtension());
			convert(jBQFAlUt, UU3Makad, AqcoHKCQ, qNwxp3iG);
			InputStream AxaSBbHR = null;
			try {
				AxaSBbHR = new FileInputStream(AqcoHKCQ);
				IOUtils.copy(AxaSBbHR, Yt9MV6Gw);
			} finally {
				IOUtils.closeQuietly(AxaSBbHR);
			}
		} catch (IOException NMW0OCL8) {
			throw new OpenOfficeException("conversion failed", NMW0OCL8);
		} finally {
			if (jBQFAlUt != null) {
				jBQFAlUt.delete();
			}
			if (AqcoHKCQ != null) {
				AqcoHKCQ.delete();
			}
		}
	}

}