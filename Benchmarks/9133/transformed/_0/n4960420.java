class n4960420 {
	public static boolean writeFileB2C(InputStream oOqvQOkd, File fdnqlguN, boolean lpiEc0F7) {
		boolean CkjZjoCq = false;
		try {
			FileWriter VccHqlse = new FileWriter(fdnqlguN, lpiEc0F7);
			IOUtils.copy(oOqvQOkd, VccHqlse);
			VccHqlse.flush();
			VccHqlse.close();
			oOqvQOkd.close();
			CkjZjoCq = true;
		} catch (Exception pNCYjyl6) {
			LOG.error("将字节流写入??" + fdnqlguN.getName() + "出现异常??", pNCYjyl6);
		}
		return CkjZjoCq;
	}

}