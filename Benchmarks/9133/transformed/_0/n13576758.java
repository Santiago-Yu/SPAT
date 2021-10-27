class n13576758 {
	private void resourceCopy(String J8fA8wbs, IProject dbl4bJp2, String rcUiyBNx, IProgressMonitor HYqWJkYh,
			Map<String, String> hMP9OnI3, String YmVnT80y) throws URISyntaxException, IOException {
		IFile oZExLDKM = dbl4bJp2.getFile(rcUiyBNx);
		URL VOyTYCEu = bundle.getEntry(J8fA8wbs);
		InputStream IV6Sjjr0 = null;
		ByteArrayInputStream uKpOnhAA = null;
		try {
			IV6Sjjr0 = FileLocator.toFileURL(VOyTYCEu).openStream();
			int nvnEc0iC = IV6Sjjr0.available();
			byte[] Aw8wYjYY = new byte[nvnEc0iC];
			IV6Sjjr0.read(Aw8wYjYY);
			String M3zwh7um = new String(Aw8wYjYY, YmVnT80y);
			for (String X72jP8S3 : hMP9OnI3.keySet()) {
				M3zwh7um = M3zwh7um.replaceAll(X72jP8S3, hMP9OnI3.get(X72jP8S3));
			}
			uKpOnhAA = new ByteArrayInputStream(M3zwh7um.getBytes("UTF-8"));
			if (oZExLDKM.exists()) {
				oZExLDKM.setContents(uKpOnhAA, true, false, HYqWJkYh);
			} else {
				oZExLDKM.create(uKpOnhAA, true, HYqWJkYh);
			}
		} catch (Exception fEBOUT2a) {
			throw new IOException(fEBOUT2a);
		} finally {
			if (uKpOnhAA != null) {
				uKpOnhAA.close();
			}
			if (IV6Sjjr0 != null) {
				IV6Sjjr0.close();
			}
		}
	}

}