class n372172 {
	public static void main(String[] g9srkJ6o) throws Exception {
		String IGwIEcyB = System.getProperty("line.separator");
		FileOutputStream f2o4AMs4 = new FileOutputStream(new File("lib-licenses.txt"));
		f2o4AMs4.write(
				new String("JCP contains the following libraries. Please read this for comments on copyright etc."
						+ IGwIEcyB + IGwIEcyB).getBytes());
		f2o4AMs4.write(new String("Chemistry Development Kit, master version as of " + new Date().toString()
				+ " (http://cdk.sf.net)" + IGwIEcyB).getBytes());
		f2o4AMs4.write(new String("Copyright 1997-2009 The CDK Development Team" + IGwIEcyB).getBytes());
		f2o4AMs4.write(new String("License: LGPL v2 (http://www.gnu.org/licenses/old-licenses/gpl-2.0.html)" + IGwIEcyB)
				.getBytes());
		f2o4AMs4.write(new String("Download: https://sourceforge.net/projects/cdk/files/" + IGwIEcyB).getBytes());
		f2o4AMs4.write(new String(
				"Source available at: http://sourceforge.net/scm/?type=git&group_id=20024" + IGwIEcyB + IGwIEcyB)
						.getBytes());
		File[] vrERkf0N = new File(g9srkJ6o[0]).listFiles(new JarFileFilter());
		for (int jrw2glnQ = 0; jrw2glnQ < vrERkf0N.length; jrw2glnQ++) {
			if (new File(vrERkf0N[jrw2glnQ].getPath() + ".meta").exists()) {
				Map<String, Map<String, String>> XYvChAiG = readProperties(
						new File(vrERkf0N[jrw2glnQ].getPath() + ".meta"));
				Iterator<String> HC7aN24w = XYvChAiG.keySet().iterator();
				while (HC7aN24w.hasNext()) {
					String xT8GR8AM = HC7aN24w.next();
					f2o4AMs4.write(new String(
							XYvChAiG.get(xT8GR8AM).get("Library") + " " + XYvChAiG.get(xT8GR8AM).get("Version") + " ("
									+ XYvChAiG.get(xT8GR8AM).get("Homepage") + ")" + IGwIEcyB).getBytes());
					f2o4AMs4.write(
							new String("Copyright " + XYvChAiG.get(xT8GR8AM).get("Copyright") + IGwIEcyB).getBytes());
					f2o4AMs4.write(new String("License: " + XYvChAiG.get(xT8GR8AM).get("License") + " ("
							+ XYvChAiG.get(xT8GR8AM).get("LicenseURL") + ")" + IGwIEcyB).getBytes());
					f2o4AMs4.write(
							new String("Download: " + XYvChAiG.get(xT8GR8AM).get("Download") + IGwIEcyB).getBytes());
					f2o4AMs4.write(new String(
							"Source available at: " + XYvChAiG.get(xT8GR8AM).get("SourceCode") + IGwIEcyB + IGwIEcyB)
									.getBytes());
				}
			}
			if (new File(vrERkf0N[jrw2glnQ].getPath() + ".extra").exists()) {
				f2o4AMs4.write(new String("The author says:" + IGwIEcyB).getBytes());
				FileInputStream etsATK6S = new FileInputStream(new File(vrERkf0N[jrw2glnQ].getPath() + ".extra"));
				int EY3Y7EsG;
				byte[] KrLyGXTH = new byte[1024];
				while ((EY3Y7EsG = etsATK6S.read(KrLyGXTH)) > 0) {
					f2o4AMs4.write(KrLyGXTH, 0, EY3Y7EsG);
				}
			}
			f2o4AMs4.write(IGwIEcyB.getBytes());
		}
		f2o4AMs4.close();
	}

}