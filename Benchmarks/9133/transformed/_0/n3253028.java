class n3253028 {
	public static List<String> unTar(File BXYdhGVf, File KwaUk8d1) throws IOException {
		List<String> utyNzlWf = new ArrayList<String>();
		InputStream IVE8l8Tn = new FileInputStream(BXYdhGVf);
		TarArchiveInputStream LsgxKsdE = new TarArchiveInputStream(IVE8l8Tn);
		TarArchiveEntry Mrewv8x4 = LsgxKsdE.getNextTarEntry();
		while (Mrewv8x4 != null) {
			OutputStream gNWP9IPs = new FileOutputStream(new File(KwaUk8d1, Mrewv8x4.getName()));
			IOUtils.copy(LsgxKsdE, gNWP9IPs);
			gNWP9IPs.close();
			utyNzlWf.add(Mrewv8x4.getName());
			Mrewv8x4 = LsgxKsdE.getNextTarEntry();
		}
		LsgxKsdE.close();
		return utyNzlWf;
	}

}