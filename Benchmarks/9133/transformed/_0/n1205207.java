class n1205207 {
	@SuppressWarnings("deprecation")
	private void loadClassFilesFromJar() {
		IPackageFragmentRoot bnLMjEuO = (IPackageFragmentRoot) getJavaElement();
		File PBYfZM6I = bnLMjEuO.getResource().getLocation().toFile();
		try {
			URL dbZTo0ei = PBYfZM6I.toURL();
			URLConnection jlVVAmIX = dbZTo0ei.openConnection();
			ZipInputStream vg9ykqji = new ZipInputStream(jlVVAmIX.getInputStream());
			ZipEntry Nzvr6sdv = vg9ykqji.getNextEntry();
			while (null != Nzvr6sdv) {
				if (Nzvr6sdv.getName().endsWith(".class")) {
					ClassParser hWy5vC5S = new ClassParser(vg9ykqji, Nzvr6sdv.getName());
					Repository.addClass(hWy5vC5S.parse());
				}
				Nzvr6sdv = vg9ykqji.getNextEntry();
			}
		} catch (MalformedURLException lpYjrh12) {
			lpYjrh12.printStackTrace();
		} catch (IOException wrJpvNgh) {
			wrJpvNgh.printStackTrace();
		}
	}

}