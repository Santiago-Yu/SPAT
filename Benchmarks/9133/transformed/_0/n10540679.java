class n10540679 {
	private static void downloadFile(String qPFYWBHn) throws Exception {
		URL mNGV8fDW = new URL("http://www.tegsoft.com/Tobe/getFile" + "?tegsoftFileName=" + qPFYWBHn);
		URLConnection S9cZ3CUn = mNGV8fDW.openConnection();
		InputStream O1zVT5LC = S9cZ3CUn.getInputStream();
		String X8Vcfnay = UiUtil.getParameter("RealPath.Context");
		OutputStream ZDJGHTqs = new FileOutputStream(X8Vcfnay + "/setup/" + qPFYWBHn);
		IOUtils.copy(O1zVT5LC, ZDJGHTqs);
		O1zVT5LC.close();
		ZDJGHTqs.close();
	}

}