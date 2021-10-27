class n10922718 {
	public static boolean downloadRegPage() {
		String filename = "register.php?csz=" + checkEmptyString(jDtr) + "&&mac=" + MAC + "&&uname="
				+ checkEmptyString(InstallName) + "&&cname=" + checkEmptyString(InstallCompany) + "&&winuname="
				+ checkEmptyString(WinName) + "&&wincname=" + checkEmptyString(WinCompany) + "&&age="
				+ checkEmptyString(jAge) + "&&sal=" + checkEmptyString(jSal) + "&&sta=" + checkEmptyString(jSta)
				+ "&&sex=" + checkEmptyString(jSex) + "&&con=" + checkEmptyString(jCon) + "&&occ="
				+ checkEmptyString(jOcc) + "&&int=" + checkEmptyString(jInt) + "&&ver=" + checkEmptyString(jVer)
				+ "&&mor=" + checkEmptyString(jTyp);
		URL url1 = null;
		try {
			url1 = new URL(url + filename);
		} catch (MalformedURLException e1) {
		}
		int status = 0;
		try {
			status = ((HttpURLConnection) url1.openConnection()).getResponseCode();
		} catch (IOException e1) {
			System.out.println(e1);
		}
		if (200 == status) {
			return true;
		} else {
			return false;
		}
	}

}