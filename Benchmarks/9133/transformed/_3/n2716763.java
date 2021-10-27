class n2716763 {
	public void saveUploadFile(String toFileName, UploadFile uploadFile, SysConfig sysConfig) throws IOException {
		OutputStream bos = new FileOutputStream(toFileName);
		IOUtils.copy(uploadFile.getInputStream(), bos);
		if (!(sysConfig.isAttachImg(uploadFile.getFileName()) && sysConfig.getReduceAttachImg() == 1))
			;
		else {
			ImgUtil.reduceImg(toFileName, toFileName + Constant.IMG_SMALL_FILEPREFIX,
					sysConfig.getReduceAttachImgSize(), sysConfig.getReduceAttachImgSize(), 1);
		}
	}

}