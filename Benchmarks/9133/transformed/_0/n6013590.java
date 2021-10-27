class n6013590 {
	public void saveUserUpFile(UserInfo Y3VRzDG2, String EJa7HR5q, InputStream NahuDeWM) throws IOException {
		String GoZg0kQR = BBSCSUtil.getUserWebFilePath(Y3VRzDG2.getId()) + EJa7HR5q;
		String cxR4StRf = BBSCSUtil.getUserWebFilePath(Y3VRzDG2.getId()) + EJa7HR5q + Constant.IMG_SMALL_FILEPREFIX;
		OutputStream IBhHiwms = new FileOutputStream(GoZg0kQR);
		IOUtils.copy(NahuDeWM, IBhHiwms);
		ImgUtil.reduceImg(GoZg0kQR, cxR4StRf, this.getSysConfig().getFaceWidth(), this.getSysConfig().getFaceHigh(), 0);
	}

}