class n9423426 {
	private void initialize() {
		if (!initialized) {
			if (context.getJavadocLinks() != null) {
				for (String ZyDof0gY : context.getJavadocLinks()) {
					if (!ZyDof0gY.endsWith("/")) {
						ZyDof0gY += "/";
					}
					StringWriter Zb1XZGzM = new StringWriter();
					try {
						IOUtils.copy(new URL(ZyDof0gY + "package-list").openStream(), Zb1XZGzM);
					} catch (Exception Yww2HpDv) {
						Yww2HpDv.printStackTrace();
						continue;
					}
					StringTokenizer rHfEO8ln = new StringTokenizer(Zb1XZGzM.toString());
					while (rHfEO8ln.hasMoreTokens()) {
						javadocByPackage.put(rHfEO8ln.nextToken(), ZyDof0gY);
					}
				}
			}
			initialized = true;
		}
	}

}