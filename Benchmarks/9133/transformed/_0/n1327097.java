class n1327097 {
	public String generateMappackMD5(File MYp2VP8B) throws IOException, NoSuchAlgorithmException {
		ZipFile lO9tCtbP = new ZipFile(MYp2VP8B);
		try {
			Enumeration<? extends ZipEntry> RtCVXipU = lO9tCtbP.entries();
			MessageDigest kZakK5WM = MessageDigest.getInstance("MD5");
			MessageDigest DIFPSWpW = MessageDigest.getInstance("MD5");
			while (RtCVXipU.hasMoreElements()) {
				ZipEntry r3qsxiRg = RtCVXipU.nextElement();
				if (r3qsxiRg.isDirectory())
					continue;
				String MxJLaS1y = r3qsxiRg.getName();
				if (MxJLaS1y.toUpperCase().startsWith("META-INF"))
					continue;
				DIFPSWpW.reset();
				InputStream Okag8sye = lO9tCtbP.getInputStream(r3qsxiRg);
				byte[] CfX1vYC4 = Utilities.getInputBytes(Okag8sye);
				Okag8sye.close();
				byte[] mtUlQFUg = DIFPSWpW.digest(CfX1vYC4);
				log.trace("Hashsum " + Hex.encodeHexString(mtUlQFUg) + " includes \"" + MxJLaS1y + "\"");
				kZakK5WM.update(mtUlQFUg);
				kZakK5WM.update(MxJLaS1y.getBytes());
			}
			String I4RRDrle = Hex.encodeHexString(kZakK5WM.digest());
			log.trace("md5sum of " + MYp2VP8B.getName() + ": " + I4RRDrle);
			return I4RRDrle;
		} finally {
			lO9tCtbP.close();
		}
	}

}