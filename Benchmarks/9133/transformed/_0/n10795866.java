class n10795866 {
	public String upload() {
		System.out.println(imgFile);
		String LxrMKb88 = "E:\\ganymede_workspace\\training01\\web\\user_imgs\\map_bg.jpg";
		FileOutputStream iv5XWVmI;
		try {
			iv5XWVmI = new FileOutputStream(new File(LxrMKb88));
			IOUtils.copy(new FileInputStream(imgFile), iv5XWVmI);
			IOUtils.closeQuietly(iv5XWVmI);
		} catch (FileNotFoundException NGVpi0gS) {
			NGVpi0gS.printStackTrace();
		} catch (IOException AI4l9GfP) {
			AI4l9GfP.printStackTrace();
		}
		return "show";
	}

}