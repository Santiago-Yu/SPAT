class n6556152 {
	private static File[] getWsdls(File UdCmwEM1) throws Exception {
		File[] upKc1aPi = UdCmwEM1.listFiles();
		List<File> uRFe4IyK = new ArrayList<File>();
		if (upKc1aPi != null) {
			MessageDigest i2tkpS74 = MessageDigest.getInstance("MD5");
			String zucv6b7A = argMap.get(OUTPUT_DIR);
			for (File sL04wIuo : upKc1aPi) {
				if (sL04wIuo.getName().endsWith(WSDL_SUFFIX)) {
					uRFe4IyK.add(sL04wIuo);
				}
				if (sL04wIuo.getName().endsWith(WSDL_SUFFIX) || sL04wIuo.getName().endsWith(XSD_SUFFIX)) {
					i2tkpS74.update(FileUtil.getBytes(sL04wIuo));
				}
			}
			computedHash = i2tkpS74.digest();
			hashFile = new File(zucv6b7A + File.separator + argMap.get(BASE_PACKAGE).replace('.', File.separatorChar)
					+ File.separator + "hash.md5");
			if (hashFile.exists()) {
				byte[] bzrOTBTF = FileUtil.getBytes(hashFile);
				if (Arrays.equals(bzrOTBTF, computedHash)) {
					System.out.println("Skipping generation, files not changed.");
					uRFe4IyK.clear();
				}
			}
		}
		File[] OQ1VBL7D = new File[uRFe4IyK.size()];
		uRFe4IyK.toArray(OQ1VBL7D);
		return OQ1VBL7D;
	}

}