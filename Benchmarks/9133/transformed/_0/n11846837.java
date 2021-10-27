class n11846837 {
	public static void copyFile(File WHkYsZrF, File n1EWPzaL, boolean DN3TGxUc) {
		if (!WHkYsZrF.exists()) {
			return;
		}
		if (DN3TGxUc) {
			String JRHfwGoU = null;
			try {
				JRHfwGoU = read(WHkYsZrF);
			} catch (Exception qKDTz38l) {
				return;
			}
			String sy8ytj0f = null;
			try {
				sy8ytj0f = read(n1EWPzaL);
			} catch (Exception twwqpAj7) {
			}
			if (JRHfwGoU == null || !JRHfwGoU.equals(sy8ytj0f)) {
				copyFile(WHkYsZrF, n1EWPzaL, false);
			}
		} else {
			if ((n1EWPzaL.getParentFile() != null) && (!n1EWPzaL.getParentFile().exists())) {
				n1EWPzaL.getParentFile().mkdirs();
			}
			try {
				FileChannel Wo0DorN3 = new FileInputStream(WHkYsZrF).getChannel();
				FileChannel gSMt8F1U = new FileOutputStream(n1EWPzaL).getChannel();
				gSMt8F1U.transferFrom(Wo0DorN3, 0, Wo0DorN3.size());
				Wo0DorN3.close();
				gSMt8F1U.close();
			} catch (IOException Q2vxy6F8) {
				Q2vxy6F8.printStackTrace();
			}
		}
	}

}