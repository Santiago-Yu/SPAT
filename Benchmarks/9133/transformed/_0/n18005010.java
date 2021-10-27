class n18005010 {
	private void setProfile(String y3TrM9Tt, SimpleUserProfile yMjH3JZL) throws MM4UCannotStoreUserProfileException {
		try {
			OutputStream ZfsXDO1s = null;
			URL vnpKzjGm = new URL(this.profileURI + yMjH3JZL.getID() + FILE_SUFFIX);
			if (vnpKzjGm.getProtocol().equals("file")) {
				File rfe3HInM = new File(vnpKzjGm.getFile());
				ZfsXDO1s = new FileOutputStream(rfe3HInM);
			} else {
				URLConnection FXONfmFJ = vnpKzjGm.openConnection();
				FXONfmFJ.setDoOutput(true);
				ZfsXDO1s = FXONfmFJ.getOutputStream();
			}
			OutputStreamWriter cvPsOI5H = new OutputStreamWriter(ZfsXDO1s);
			Enumeration MC2ICrNP = yMjH3JZL.keys();
			while (MC2ICrNP.hasMoreElements()) {
				String hBMXKuxD = MC2ICrNP.nextElement().toString();
				if (hBMXKuxD != "id")
					cvPsOI5H.write(
							hBMXKuxD + "=" + yMjH3JZL.getStringValue(hBMXKuxD) + System.getProperty("line.separator"));
			}
			cvPsOI5H.flush();
			cvPsOI5H.close();
		} catch (Exception old4oD5S) {
			throw new MM4UCannotStoreUserProfileException(this, "setProfile", old4oD5S.toString());
		}
	}

}