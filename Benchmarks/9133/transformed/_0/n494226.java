class n494226 {
	public static void main(String[] xpcP7XXA) throws Exception {
		String ZuS7nsdS = System.getProperty("line.separator");
		FileOutputStream RQrRGUb7 = new FileOutputStream(new File("lib-licenses.txt"));
		RQrRGUb7.write(
				new String("JCP contains the following libraries. Please read this for comments on copyright etc."
						+ ZuS7nsdS + ZuS7nsdS).getBytes());
		RQrRGUb7.write(new String("Chemistry Development Kit, master version as of " + new Date().toString()
				+ " (http://cdk.sf.net)" + ZuS7nsdS).getBytes());
		RQrRGUb7.write(new String("Copyright 1997-2009 The CDK Development Team" + ZuS7nsdS).getBytes());
		RQrRGUb7.write(new String("License: LGPL v2 (http://www.gnu.org/licenses/old-licenses/gpl-2.0.html)" + ZuS7nsdS)
				.getBytes());
		RQrRGUb7.write(new String("Download: https://sourceforge.net/projects/cdk/files/" + ZuS7nsdS).getBytes());
		RQrRGUb7.write(new String(
				"Source available at: http://sourceforge.net/scm/?type=git&group_id=20024" + ZuS7nsdS + ZuS7nsdS)
						.getBytes());
		File[] MDHJ57PG = new File(xpcP7XXA[0]).listFiles(new JarFileFilter());
		for (int iMbptMQr = 0; iMbptMQr < MDHJ57PG.length; iMbptMQr++) {
			if (new File(MDHJ57PG[iMbptMQr].getPath() + ".meta").exists()) {
				Map<String, Map<String, String>> w3qt2hmz = readProperties(
						new File(MDHJ57PG[iMbptMQr].getPath() + ".meta"));
				Iterator<String> exZPrgIg = w3qt2hmz.keySet().iterator();
				while (exZPrgIg.hasNext()) {
					String jOgByC0Y = exZPrgIg.next();
					RQrRGUb7.write(new String(
							w3qt2hmz.get(jOgByC0Y).get("Library") + " " + w3qt2hmz.get(jOgByC0Y).get("Version") + " ("
									+ w3qt2hmz.get(jOgByC0Y).get("Homepage") + ")" + ZuS7nsdS).getBytes());
					RQrRGUb7.write(
							new String("Copyright " + w3qt2hmz.get(jOgByC0Y).get("Copyright") + ZuS7nsdS).getBytes());
					RQrRGUb7.write(new String("License: " + w3qt2hmz.get(jOgByC0Y).get("License") + " ("
							+ w3qt2hmz.get(jOgByC0Y).get("LicenseURL") + ")" + ZuS7nsdS).getBytes());
					RQrRGUb7.write(
							new String("Download: " + w3qt2hmz.get(jOgByC0Y).get("Download") + ZuS7nsdS).getBytes());
					RQrRGUb7.write(new String(
							"Source available at: " + w3qt2hmz.get(jOgByC0Y).get("SourceCode") + ZuS7nsdS + ZuS7nsdS)
									.getBytes());
				}
			}
			if (new File(MDHJ57PG[iMbptMQr].getPath() + ".extra").exists()) {
				RQrRGUb7.write(new String("The author says:" + ZuS7nsdS).getBytes());
				FileInputStream Cu5B7ce8 = new FileInputStream(new File(MDHJ57PG[iMbptMQr].getPath() + ".extra"));
				int Zf5F328S;
				byte[] HMn6SsMn = new byte[1024];
				while ((Zf5F328S = Cu5B7ce8.read(HMn6SsMn)) > 0) {
					RQrRGUb7.write(HMn6SsMn, 0, Zf5F328S);
				}
			}
			RQrRGUb7.write(ZuS7nsdS.getBytes());
		}
		RQrRGUb7.close();
	}

}