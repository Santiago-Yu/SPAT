class n4602568 {
	public String storeImage(InputStream NqH2UOxc, String KL3vMVHM, boolean GKh2YcGR) throws Exception {
		Calendar wd0pz0qy = Calendar.getInstance();
		String HW2h19eQ = "" + wd0pz0qy.get(Calendar.YEAR)
				+ StringUtil.getPaddedIntWithZeros(2, wd0pz0qy.get(Calendar.MONTH) + 1)
				+ StringUtil.getPaddedIntWithZeros(2, wd0pz0qy.get(Calendar.DATE));
		String nX7MIWMo = props.getProperty("uploaded.files.root");
		File vfIbVB9s = new File(nX7MIWMo + System.getProperty("file.separator") + HW2h19eQ);
		if (!vfIbVB9s.exists())
			vfIbVB9s.mkdirs();
		String UFSZFMvg = FilenameUtils.getExtension(KL3vMVHM);
		String XRoi3PGp;
		if (Boolean.parseBoolean(props.getPropertiesInstance().getProperty(IFConsts.USEORIGINALFILENAME, "true"))) {
			XRoi3PGp = StringUtil.removeSpecChars(StringUtil.unaccent(FilenameUtils.getBaseName(KL3vMVHM)));
		} else {
			XRoi3PGp = StringUtil.hash(KL3vMVHM + Long.toString(System.currentTimeMillis()));
		}
		if (Boolean.parseBoolean(props.getPropertiesInstance().getProperty(IFConsts.USEEXTENSION, "true"))) {
			XRoi3PGp = XRoi3PGp + DOT + UFSZFMvg;
		}
		String FwfosPWc = nX7MIWMo + System.getProperty("file.separator") + HW2h19eQ
				+ System.getProperty("file.separator") + props.getProperty("uploaded.files.prefix") + XRoi3PGp;
		File JcunoxsN = new File(FwfosPWc);
		_logger.info("uploadedFile.getAbsolutePath() = {}", JcunoxsN.getAbsolutePath());
		JcunoxsN.createNewFile();
		OutputStream XPTfEQpv = new FileOutputStream(FwfosPWc);
		IOUtils.copyLarge(NqH2UOxc, XPTfEQpv);
		IOUtils.closeQuietly(NqH2UOxc);
		XPTfEQpv.close();
		if (GKh2YcGR) {
			writeResizedImage(FwfosPWc, UFSZFMvg, "imgSize_xs");
			writeResizedImage(FwfosPWc, UFSZFMvg, "imgSize_s");
			writeResizedImage(FwfosPWc, UFSZFMvg, "imgSize_m");
			writeResizedImage(FwfosPWc, UFSZFMvg, "imgSize_l");
			writeResizedImage(FwfosPWc, UFSZFMvg, "imgSize_xl");
		}
		String Q2LIaicY = HW2h19eQ + "/" + props.getProperty("uploaded.files.prefix") + XRoi3PGp;
		return Q2LIaicY;
	}

}