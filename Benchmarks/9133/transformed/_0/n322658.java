class n322658 {
	public static void main(String[] QVrIiC2Z) throws Exception {
		String G6CKwCDY = System.getProperty("line.separator");
		FileOutputStream CUS5QpQ4 = new FileOutputStream(new File("lib-licenses.txt"));
		CUS5QpQ4.write(
				new String("JCP contains the following libraries. Please read this for comments on copyright etc."
						+ G6CKwCDY + G6CKwCDY).getBytes());
		CUS5QpQ4.write(new String("Chemistry Development Kit, master version as of " + new Date().toString()
				+ " (http://cdk.sf.net)" + G6CKwCDY).getBytes());
		CUS5QpQ4.write(new String("Copyright 1997-2009 The CDK Development Team" + G6CKwCDY).getBytes());
		CUS5QpQ4.write(new String("License: LGPL v2 (http://www.gnu.org/licenses/old-licenses/gpl-2.0.html)" + G6CKwCDY)
				.getBytes());
		CUS5QpQ4.write(new String("Download: https://sourceforge.net/projects/cdk/files/" + G6CKwCDY).getBytes());
		CUS5QpQ4.write(new String(
				"Source available at: http://sourceforge.net/scm/?type=git&group_id=20024" + G6CKwCDY + G6CKwCDY)
						.getBytes());
		File[] YiF3UDb6 = new File(QVrIiC2Z[0]).listFiles(new JarFileFilter());
		for (int kMbMuLeB = 0; kMbMuLeB < YiF3UDb6.length; kMbMuLeB++) {
			if (new File(YiF3UDb6[kMbMuLeB].getPath() + ".meta").exists()) {
				Map<String, Map<String, String>> zullFDhO = readProperties(
						new File(YiF3UDb6[kMbMuLeB].getPath() + ".meta"));
				Iterator<String> jTH8rOfu = zullFDhO.keySet().iterator();
				while (jTH8rOfu.hasNext()) {
					String K3DqDbqp = jTH8rOfu.next();
					CUS5QpQ4.write(new String(
							zullFDhO.get(K3DqDbqp).get("Library") + " " + zullFDhO.get(K3DqDbqp).get("Version") + " ("
									+ zullFDhO.get(K3DqDbqp).get("Homepage") + ")" + G6CKwCDY).getBytes());
					CUS5QpQ4.write(
							new String("Copyright " + zullFDhO.get(K3DqDbqp).get("Copyright") + G6CKwCDY).getBytes());
					CUS5QpQ4.write(new String("License: " + zullFDhO.get(K3DqDbqp).get("License") + " ("
							+ zullFDhO.get(K3DqDbqp).get("LicenseURL") + ")" + G6CKwCDY).getBytes());
					CUS5QpQ4.write(
							new String("Download: " + zullFDhO.get(K3DqDbqp).get("Download") + G6CKwCDY).getBytes());
					CUS5QpQ4.write(new String(
							"Source available at: " + zullFDhO.get(K3DqDbqp).get("SourceCode") + G6CKwCDY + G6CKwCDY)
									.getBytes());
				}
			}
			if (new File(YiF3UDb6[kMbMuLeB].getPath() + ".extra").exists()) {
				CUS5QpQ4.write(new String("The author says:" + G6CKwCDY).getBytes());
				FileInputStream CqOeD00o = new FileInputStream(new File(YiF3UDb6[kMbMuLeB].getPath() + ".extra"));
				int NAZczroi;
				byte[] CV2mvYvm = new byte[1024];
				while ((NAZczroi = CqOeD00o.read(CV2mvYvm)) > 0) {
					CUS5QpQ4.write(CV2mvYvm, 0, NAZczroi);
				}
			}
			CUS5QpQ4.write(G6CKwCDY.getBytes());
		}
		CUS5QpQ4.close();
	}

}