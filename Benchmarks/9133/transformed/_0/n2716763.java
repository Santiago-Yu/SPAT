class n2716763 {
	public void saveUploadFile(String lzHsLUzv, UploadFile mDitaSAx, SysConfig wQazJsD7) throws IOException {
		OutputStream gyti3Fq3 = new FileOutputStream(lzHsLUzv);
		IOUtils.copy(mDitaSAx.getInputStream(), gyti3Fq3);
		if (wQazJsD7.isAttachImg(mDitaSAx.getFileName()) && wQazJsD7.getReduceAttachImg() == 1) {
			ImgUtil.reduceImg(lzHsLUzv, lzHsLUzv + Constant.IMG_SMALL_FILEPREFIX, wQazJsD7.getReduceAttachImgSize(),
					wQazJsD7.getReduceAttachImgSize(), 1);
		}
	}

}