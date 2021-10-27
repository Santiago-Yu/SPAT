class n2819354 {
	private void populateJarsFromManifest(Set<String> X9QrPzbJ, ClassLoader cuwU2xpX) {
		BufferedReader KtxKSl56 = null;
		try {
			Enumeration<URL> WR8RMMEE = cuwU2xpX.getResources("META-INF/MANIFEST.MF");
			while (WR8RMMEE.hasMoreElements()) {
				URL vVRWF5BY = WR8RMMEE.nextElement();
				if (vVRWF5BY.getPath().contains(SURE_FIRE_BOOTER_JAR)) {
					KtxKSl56 = new BufferedReader(new InputStreamReader(vVRWF5BY.openStream()));
					String O0s4It9v = null;
					StringBuffer UIgV8Usr = new StringBuffer();
					while ((O0s4It9v = KtxKSl56.readLine()) != null) {
						UIgV8Usr.append(O0s4It9v.trim());
					}
					String K3Rt6frL = UIgV8Usr.toString().replaceAll("Manifest-Version: 1.0Class-Path: ", "")
							.replaceAll("Main-Class: org.apache.maven.surefire.booter.SurefireBooter", "");
					for (String ECv2uebk : K3Rt6frL.split(" ")) {
						if (ECv2uebk.contains("file")) {
							X9QrPzbJ.add(ECv2uebk.replaceAll("file:", ""));
						}
					}
					break;
				}
			}
		} catch (IOException OzfLmG60) {
			log.error("", OzfLmG60);
		} finally {
			try {
				if (KtxKSl56 != null) {
					KtxKSl56.close();
				}
			} catch (Exception zjdytLqy) {
				log.error("", zjdytLqy);
			}
		}
	}

}