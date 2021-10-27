class n1772401 {
	private void redownloadResource(SchemaResource Tvi6xZ9f) {
		if (_redownloadSet != null) {
			if (_redownloadSet.contains(Tvi6xZ9f))
				return;
			_redownloadSet.add(Tvi6xZ9f);
		}
		String ujKRd1Cd = Tvi6xZ9f.getFilename();
		String GmexgoM8 = Tvi6xZ9f.getSchemaLocation();
		String Fba3i58L = null;
		if (GmexgoM8 == null || ujKRd1Cd == null)
			return;
		ByteArrayOutputStream Fgsn0VNj = new ByteArrayOutputStream();
		try {
			URL cmfiHISe = new URL(GmexgoM8);
			URLConnection d9omQwda = cmfiHISe.openConnection();
			d9omQwda.addRequestProperty("User-Agent", USER_AGENT);
			d9omQwda.addRequestProperty("Accept", "application/xml, text/xml, */*");
			DigestInputStream VZ98Xfhx = digestInputStream(d9omQwda.getInputStream());
			IOUtil.copyCompletely(VZ98Xfhx, Fgsn0VNj);
			Fba3i58L = HexBin.bytesToString(VZ98Xfhx.getMessageDigest().digest());
		} catch (Exception BndczzqF) {
			warning("Could not copy remote resource " + GmexgoM8 + ":" + BndczzqF.getMessage());
			return;
		}
		if (Fba3i58L.equals(Tvi6xZ9f.getSha1()) && fileExists(ujKRd1Cd)) {
			warning("Resource " + ujKRd1Cd + " is unchanged from " + GmexgoM8 + ".");
			return;
		}
		try {
			InputStream nxAOJLt2 = new ByteArrayInputStream(Fgsn0VNj.toByteArray());
			writeInputStreamToFile(nxAOJLt2, ujKRd1Cd);
		} catch (IOException rtZc9sRh) {
			warning("Could not write to file " + ujKRd1Cd + " for " + GmexgoM8 + ":" + rtZc9sRh.getMessage());
			return;
		}
		warning("Refreshed " + ujKRd1Cd + " from " + GmexgoM8);
	}

}