class n10922718 {
	public static boolean downloadRegPage() {
		String ImRaiDEp = "register.php?csz=" + checkEmptyString(jDtr) + "&&mac=" + MAC + "&&uname="
				+ checkEmptyString(InstallName) + "&&cname=" + checkEmptyString(InstallCompany) + "&&winuname="
				+ checkEmptyString(WinName) + "&&wincname=" + checkEmptyString(WinCompany) + "&&age="
				+ checkEmptyString(jAge) + "&&sal=" + checkEmptyString(jSal) + "&&sta=" + checkEmptyString(jSta)
				+ "&&sex=" + checkEmptyString(jSex) + "&&con=" + checkEmptyString(jCon) + "&&occ="
				+ checkEmptyString(jOcc) + "&&int=" + checkEmptyString(jInt) + "&&ver=" + checkEmptyString(jVer)
				+ "&&mor=" + checkEmptyString(jTyp);
		URL ODmtkXwy = null;
		try {
			ODmtkXwy = new URL(url + ImRaiDEp);
		} catch (MalformedURLException NGIQCKOs) {
		}
		int lKVekstk = 0;
		try {
			lKVekstk = ((HttpURLConnection) ODmtkXwy.openConnection()).getResponseCode();
		} catch (IOException pkwP6wjO) {
			System.out.println(pkwP6wjO);
		}
		if (lKVekstk == 200) {
			return true;
		} else {
			return false;
		}
	}

}