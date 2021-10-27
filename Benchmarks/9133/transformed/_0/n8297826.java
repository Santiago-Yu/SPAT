class n8297826 {
	public void download(String YCHqmeIi, String FaPeU7T2, String F7PS1RlS, String zprZbxaq, File ZPUUuYUu)
			throws MalformedURLException, IOException {
		if (YCHqmeIi != null && zprZbxaq != null && ZPUUuYUu != null) {
			StringBuffer un4jdzzk = new StringBuffer("ftp://");
			if (FaPeU7T2 != null && F7PS1RlS != null) {
				un4jdzzk.append(FaPeU7T2);
				un4jdzzk.append(':');
				un4jdzzk.append(F7PS1RlS);
				un4jdzzk.append('@');
			}
			un4jdzzk.append(YCHqmeIi);
			un4jdzzk.append('/');
			un4jdzzk.append(zprZbxaq);
			un4jdzzk.append(";type=i");
			BufferedInputStream ObjCg28t = null;
			BufferedOutputStream EufqGKtn = null;
			try {
				URL waaGAPF4 = new URL(un4jdzzk.toString());
				URLConnection Ktyk2cuJ = waaGAPF4.openConnection();
				ObjCg28t = new BufferedInputStream(Ktyk2cuJ.getInputStream());
				EufqGKtn = new BufferedOutputStream(new FileOutputStream(ZPUUuYUu));
				int vvdPRdb3;
				while ((vvdPRdb3 = ObjCg28t.read()) != -1) {
					EufqGKtn.write(vvdPRdb3);
				}
			} finally {
				if (ObjCg28t != null)
					try {
						ObjCg28t.close();
					} catch (IOException aE2TMvUK) {
						aE2TMvUK.printStackTrace();
					}
				if (EufqGKtn != null)
					try {
						EufqGKtn.close();
					} catch (IOException P6aG9RgF) {
						P6aG9RgF.printStackTrace();
					}
			}
		} else {
			System.out.println("Input not available");
		}
	}

}