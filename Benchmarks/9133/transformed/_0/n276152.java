class n276152 {
	public static void main(String[] NU8q2t7J) throws Exception {
		String IdfDb869 = System.getProperty("line.separator");
		FileOutputStream mDH9BqxZ = new FileOutputStream(new File("lib-licenses.txt"));
		mDH9BqxZ.write(
				new String("JCP contains the following libraries. Please read this for comments on copyright etc."
						+ IdfDb869 + IdfDb869).getBytes());
		mDH9BqxZ.write(new String("Chemistry Development Kit, master version as of " + new Date().toString()
				+ " (http://cdk.sf.net)" + IdfDb869).getBytes());
		mDH9BqxZ.write(new String("Copyright 1997-2009 The CDK Development Team" + IdfDb869).getBytes());
		mDH9BqxZ.write(new String("License: LGPL v2 (http://www.gnu.org/licenses/old-licenses/gpl-2.0.html)" + IdfDb869)
				.getBytes());
		mDH9BqxZ.write(new String("Download: https://sourceforge.net/projects/cdk/files/" + IdfDb869).getBytes());
		mDH9BqxZ.write(new String(
				"Source available at: http://sourceforge.net/scm/?type=git&group_id=20024" + IdfDb869 + IdfDb869)
						.getBytes());
		File[] Z78MG76a = new File(NU8q2t7J[0]).listFiles(new JarFileFilter());
		for (int MIpJA7Xh = 0; MIpJA7Xh < Z78MG76a.length; MIpJA7Xh++) {
			if (new File(Z78MG76a[MIpJA7Xh].getPath() + ".meta").exists()) {
				Map<String, Map<String, String>> ySMmOJrV = readProperties(
						new File(Z78MG76a[MIpJA7Xh].getPath() + ".meta"));
				Iterator<String> XUXZcZHH = ySMmOJrV.keySet().iterator();
				while (XUXZcZHH.hasNext()) {
					String PpdmkgPY = XUXZcZHH.next();
					mDH9BqxZ.write(new String(
							ySMmOJrV.get(PpdmkgPY).get("Library") + " " + ySMmOJrV.get(PpdmkgPY).get("Version") + " ("
									+ ySMmOJrV.get(PpdmkgPY).get("Homepage") + ")" + IdfDb869).getBytes());
					mDH9BqxZ.write(
							new String("Copyright " + ySMmOJrV.get(PpdmkgPY).get("Copyright") + IdfDb869).getBytes());
					mDH9BqxZ.write(new String("License: " + ySMmOJrV.get(PpdmkgPY).get("License") + " ("
							+ ySMmOJrV.get(PpdmkgPY).get("LicenseURL") + ")" + IdfDb869).getBytes());
					mDH9BqxZ.write(
							new String("Download: " + ySMmOJrV.get(PpdmkgPY).get("Download") + IdfDb869).getBytes());
					mDH9BqxZ.write(new String(
							"Source available at: " + ySMmOJrV.get(PpdmkgPY).get("SourceCode") + IdfDb869 + IdfDb869)
									.getBytes());
				}
			}
			if (new File(Z78MG76a[MIpJA7Xh].getPath() + ".extra").exists()) {
				mDH9BqxZ.write(new String("The author says:" + IdfDb869).getBytes());
				FileInputStream lkeNEcc2 = new FileInputStream(new File(Z78MG76a[MIpJA7Xh].getPath() + ".extra"));
				int EYhDM3xW;
				byte[] t9OqzlXk = new byte[1024];
				while ((EYhDM3xW = lkeNEcc2.read(t9OqzlXk)) > 0) {
					mDH9BqxZ.write(t9OqzlXk, 0, EYhDM3xW);
				}
			}
			mDH9BqxZ.write(IdfDb869.getBytes());
		}
		mDH9BqxZ.close();
	}

}