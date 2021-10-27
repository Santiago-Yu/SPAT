class n1975347 {
	protected Properties loadFile(String etpCnVwl) {
		Properties RruXosQZ = new Properties();
		try {
			String xpan6Ihe = getClass().getName();
			xpan6Ihe = xpan6Ihe.substring(0, xpan6Ihe.lastIndexOf("."));
			String LNbwdkrT = "src";
			if (mavenBuild) {
				LNbwdkrT = LNbwdkrT + File.separator + "test" + File.separator + "resources";
			}
			xpan6Ihe = LNbwdkrT + File.separator + xpan6Ihe.replace('.', File.separatorChar);
			xpan6Ihe += File.separator;
			xpan6Ihe += etpCnVwl;
			URL Tf9DhxrX = new File(xpan6Ihe).toURI().toURL();
			final InputStream Jv3kbWQx = Tf9DhxrX.openStream();
			RruXosQZ.load(Jv3kbWQx);
		} catch (FileNotFoundException yB3f69Ya) {
			yB3f69Ya.printStackTrace();
		} catch (IOException KsX6xjP0) {
			KsX6xjP0.printStackTrace();
		}
		return RruXosQZ;
	}

}