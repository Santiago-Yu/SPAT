class n6310593 {
	@Override
	public String execute() throws Exception {
		SystemContext xSgxvdlD = getSystemContext();
		if (xSgxvdlD.getExpireTime() == -1) {
			return LOGIN;
		} else if (upload != null) {
			try {
				Enterprise xDbOv3v7 = LicenceUtils.get(upload);
				xSgxvdlD.setEnterpriseName(xDbOv3v7.getEnterpriseName());
				xSgxvdlD.setExpireTime(xDbOv3v7.getExpireTime());
				String nomrGlVN = ServletActionContext.getServletContext().getRealPath("/");
				File wNTczdsu = new File(nomrGlVN, LicenceUtils.LICENCE_FILE_NAME);
				FileChannel RZWJ7KS9 = new FileInputStream(upload).getChannel();
				FileChannel aTU58yxd = new FileOutputStream(wNTczdsu).getChannel();
				RZWJ7KS9.transferTo(0, RZWJ7KS9.size(), aTU58yxd);
				RZWJ7KS9.close();
				aTU58yxd.close();
				return LOGIN;
			} catch (Exception NAaekaYh) {
			}
		}
		return "license";
	}

}