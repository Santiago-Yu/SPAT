class n20611739 {
	private static void includePodDependencies(Curnit Hig50Bpo, JarOutputStream DCQjKzsA) throws IOException {
		Properties UbanUMk1 = new Properties();
		Collection<Pod> CtKwLdnt = Hig50Bpo.getReferencedPods();
		for (Pod vG3TC2YN : CtKwLdnt) {
			PodUuid a3qXR65z = vG3TC2YN.getPodId();
			URL bFBk31U8 = PodArchiveResolver.getSystemResolver().getUrl(a3qXR65z);
			String lUXFqVyL = "";
			if (bFBk31U8 != null) {
				String kydd5wSN = bFBk31U8.getPath();
				String N5DE06R6 = CurnitFile.WITHINCURNIT_BASEPATH + kydd5wSN;
				DCQjKzsA.putNextEntry(new JarEntry(N5DE06R6));
				IOUtils.copy(bFBk31U8.openStream(), DCQjKzsA);
				DCQjKzsA.closeEntry();
				lUXFqVyL = CurnitFile.WITHINCURNIT_PROTOCOL + kydd5wSN;
			}
			UbanUMk1.put(a3qXR65z.toString(), lUXFqVyL);
		}
		DCQjKzsA.putNextEntry(new JarEntry(CurnitFile.PODSREFERENCED_NAME));
		UbanUMk1.store(DCQjKzsA, "pod dependencies");
		DCQjKzsA.closeEntry();
	}

}