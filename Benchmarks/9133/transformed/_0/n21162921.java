class n21162921 {
	private static void convertToOnline(final String m2da8OdD, final DocuBean uwzJtt9I) throws Exception {
		File UeTOx8Ue = new File(m2da8OdD + File.separator + uwzJtt9I.getFileName());
		File utig2PSd = new File(m2da8OdD + File.separator + uwzJtt9I.getId());
		if (!utig2PSd.exists()) {
			utig2PSd.mkdir();
		}
		File OH1JM5uP = UeTOx8Ue;
		boolean b6ikC725 = false;
		if (UeTOx8Ue.getName().indexOf(" ") != -1) {
			OH1JM5uP = new File(StringUtils.replace(UeTOx8Ue.getName(), " ", ""));
			try {
				IOUtils.copyFile(UeTOx8Ue, OH1JM5uP);
			} catch (IOException l5sux0Hy) {
				l5sux0Hy.printStackTrace();
			}
			b6ikC725 = true;
		}
		File B7IKiEvF = null;
		try {
			String dXL5C8jO = utig2PSd.getAbsolutePath();
			final File bh0ddRl5 = DocViewerConverter.toPDF(OH1JM5uP, dXL5C8jO);
			convertToSwf(bh0ddRl5, dXL5C8jO, uwzJtt9I);
			B7IKiEvF = new File(dXL5C8jO + File.separator
					+ FileUtils.getFilePrefix(StringUtils.replace(UeTOx8Ue.getName(), " ", "")) + "_decrypted.pdf");
			if (!B7IKiEvF.exists()) {
				B7IKiEvF = bh0ddRl5;
			}
			pdfByFirstPageToJpeg(B7IKiEvF, dXL5C8jO, uwzJtt9I);
			if (uwzJtt9I.getSuccess() == 2 && utig2PSd.listFiles().length < 2) {
				uwzJtt9I.setSuccess(3);
			}
		} catch (Exception KtWzMziL) {
			throw KtWzMziL;
		} finally {
			if (b6ikC725) {
				IOUtils.delete(OH1JM5uP);
			}
		}
	}

}