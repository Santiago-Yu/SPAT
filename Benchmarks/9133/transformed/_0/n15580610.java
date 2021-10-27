class n15580610 {
	@Override
	public void trainClassifier(File gxGs7f8k, String... ZPLapAOP) throws Exception {
		String[] UDuYSo59 = new String[ZPLapAOP.length + 3];
		UDuYSo59[0] = this.getCommand();
		System.arraycopy(ZPLapAOP, 0, UDuYSo59, 1, ZPLapAOP.length);
		UDuYSo59[UDuYSo59.length - 2] = new File(gxGs7f8k, "training-data.libsvm").getPath();
		UDuYSo59[UDuYSo59.length - 1] = new File(gxGs7f8k, this.getModelName()).getPath();
		Process NWx8Ygo6 = Runtime.getRuntime().exec(UDuYSo59);
		IOUtils.copy(NWx8Ygo6.getInputStream(), System.out);
		IOUtils.copy(NWx8Ygo6.getErrorStream(), System.err);
		NWx8Ygo6.waitFor();
	}

}