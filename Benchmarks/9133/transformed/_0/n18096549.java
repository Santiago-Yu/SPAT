class n18096549 {
	public static void copyFile(File zMdKDrFb, File gFUbXb3V, boolean fJbdkpDj) {
		if (zMdKDrFb.exists()) {
			try {
				BufferedOutputStream YHp1pESf = new BufferedOutputStream(new FileOutputStream(gFUbXb3V));
				BufferedInputStream XbKq4uc0 = new BufferedInputStream(new FileInputStream(zMdKDrFb));
				byte[] H4YSbb92 = new byte[128];
				int zXETOFjd = 128;
				while ((zXETOFjd = XbKq4uc0.read(H4YSbb92)) > 0)
					YHp1pESf.write(H4YSbb92, 0, zXETOFjd);
				YHp1pESf.flush();
				YHp1pESf.close();
				XbKq4uc0.close();
			} catch (IOException aNfFyvSQ) {
				String hW1paEPo = "Error while copying " + zMdKDrFb.getAbsolutePath() + " to "
						+ gFUbXb3V.getAbsolutePath() + " : " + aNfFyvSQ.getMessage();
				if (fJbdkpDj) {
					Log.getInstance(SystemUtils.class).warnWithUserNotification(hW1paEPo);
				} else {
					Log.getInstance(SystemUtils.class).warn(hW1paEPo);
				}
			}
		} else {
			String DeUEur3T = "Unable to copy file: source does not exists: " + zMdKDrFb.getAbsolutePath();
			if (fJbdkpDj) {
				Log.getInstance(SystemUtils.class).warnWithUserNotification(DeUEur3T);
			} else {
				Log.getInstance(SystemUtils.class).warn(DeUEur3T);
			}
		}
	}

}