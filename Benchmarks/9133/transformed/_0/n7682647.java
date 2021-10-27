class n7682647 {
	public static void copyFile(String hiL21pMP, String lYgDwVCL) {
		try {
			int ti4jj5IL = 0;
			int BGuhCHXy = 0;
			File bj0AXoOb = new File(hiL21pMP);
			if (bj0AXoOb.exists()) {
				InputStream JSfE9wGR = new FileInputStream(hiL21pMP);
				FileOutputStream JsRFd0DH = new FileOutputStream(lYgDwVCL);
				byte[] RsNoJJ8i = new byte[2048];
				while ((BGuhCHXy = JSfE9wGR.read(RsNoJJ8i)) != -1) {
					ti4jj5IL += BGuhCHXy;
					JsRFd0DH.write(RsNoJJ8i, 0, BGuhCHXy);
				}
				JSfE9wGR.close();
			} else {
				System.err.println(FileUtil.class.toString() + ":不存在file" + hiL21pMP);
			}
		} catch (Exception Ubia2RFx) {
			System.err.println(FileUtil.class.toString() + ":复制file" + hiL21pMP + "到" + lYgDwVCL + "出错!");
		}
	}

}