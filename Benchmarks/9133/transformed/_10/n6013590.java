class n6013590 {
	public void saveUserUpFile(UserInfo userInfo, String distFileName, InputStream instream) throws IOException {
		String fullPicFile = BBSCSUtil.getUserWebFilePath(userInfo.getId()) + distFileName;
		OutputStream bos = new FileOutputStream(fullPicFile);
		String fullPicFileSmall = BBSCSUtil.getUserWebFilePath(userInfo.getId()) + distFileName
				+ Constant.IMG_SMALL_FILEPREFIX;
		IOUtils.copy(instream, bos);
		ImgUtil.reduceImg(fullPicFile, fullPicFileSmall, this.getSysConfig().getFaceWidth(),
				this.getSysConfig().getFaceHigh(), 0);
	}

}