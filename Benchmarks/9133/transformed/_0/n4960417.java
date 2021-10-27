class n4960417 {
	public static boolean writeFileByBinary(InputStream Y4oiNzUW, File rB04JKuy, boolean BoMc22F3) {
		boolean NqNruQrL = false;
		try {
			FileOutputStream oN6b6GWi = new FileOutputStream(rB04JKuy, BoMc22F3);
			IOUtils.copy(Y4oiNzUW, oN6b6GWi);
			oN6b6GWi.flush();
			oN6b6GWi.close();
			Y4oiNzUW.close();
			NqNruQrL = true;
		} catch (Exception S6BjqXd7) {
			LOG.error("将字节流写入??" + rB04JKuy.getName() + "出现异常??", S6BjqXd7);
		}
		return NqNruQrL;
	}

}