class n3184073 {
	public static void copyFile(String LxpfaVlo, String ErEux7XX) {
		try {
			File R4Rb00SI = new File(LxpfaVlo);
			String RswKmLsb = (new File(ErEux7XX)).getParent();
			File XdvOScJS = new File(RswKmLsb);
			if (!XdvOScJS.exists()) {
				XdvOScJS.mkdir();
			}
			File KUViWl34 = new File(ErEux7XX);
			if (!R4Rb00SI.getCanonicalPath().equals(KUViWl34.getCanonicalPath())) {
				FileInputStream Wvlaml0x = new FileInputStream(R4Rb00SI);
				FileOutputStream gDZGiaP8 = new FileOutputStream(KUViWl34);
				int gPil8DZV;
				while ((gPil8DZV = Wvlaml0x.read()) != -1)
					gDZGiaP8.write(gPil8DZV);
				Wvlaml0x.close();
				gDZGiaP8.close();
			}
		} catch (Exception BxbDS9gv) {
			BxbDS9gv.printStackTrace();
			LogHandler.log(BxbDS9gv.getMessage(), Level.INFO, "LOG_MSG", isLoggingEnabled());
		}
	}

}