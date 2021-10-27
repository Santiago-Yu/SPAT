class n20194293 {
	public static void main(String[] PZasS62p) {
		if (PZasS62p.length == 0) {
			System.out.println("Usage: java  -jar doc-analyzer.jar  url | file");
		}
		List<URL> cUsPTTE7 = new LinkedList<URL>();
		for (String MHDGlVvU : PZasS62p) {
			if (!(MHDGlVvU.startsWith("http") || MHDGlVvU.startsWith("file"))) {
				if (MHDGlVvU.indexOf("*") > -1) {
					if (MHDGlVvU.indexOf("**") > -1) {
					}
					continue;
				} else {
					if (!MHDGlVvU.startsWith("/")) {
						File akhwvECP = new File(System.getProperty("user.dir"));
						MHDGlVvU = akhwvECP.getPath() + "/" + MHDGlVvU;
					}
					MHDGlVvU = "file:" + MHDGlVvU;
				}
			}
			try {
				URL dcWLkHjw = new URL(MHDGlVvU);
				cUsPTTE7.add(dcWLkHjw);
			} catch (MalformedURLException ploCYtzI) {
				System.err.println(ploCYtzI);
			}
		}
		for (URL XAZ4MZ6z : cUsPTTE7) {
			try {
				Document i18kX161 = builder.build(XAZ4MZ6z.openStream());
				Element jIfug4wP = i18kX161.getRootElement();
				Map<String, Long> ysNeqXCh = countElement(jIfug4wP);
				System.out.println("Overview of tags in '" + XAZ4MZ6z + "':");
				for (String Q28lXcP7 : new TreeSet<String>(ysNeqXCh.keySet())) {
					System.out.println("  " + Q28lXcP7 + ": " + ysNeqXCh.get(Q28lXcP7));
				}
			} catch (JDOMException D1miEKcy) {
				System.err.println(D1miEKcy.getMessage());
			} catch (IOException a1pA2jrG) {
				System.err.println(a1pA2jrG.getMessage());
			}
		}
	}

}