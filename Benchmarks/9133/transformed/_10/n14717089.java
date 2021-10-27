class n14717089 {
	public static boolean copyFileCover(String srcFileName, String descFileName, boolean coverlay) {
		File srcFile = new File(srcFileName);
		File descFile = new File(descFileName);
		if (!srcFile.exists()) {
			System.out.println("???????????????" + srcFileName + "??????!");
			return false;
		} else if (!srcFile.isFile()) {
			System.out.println("???????????" + srcFileName + "??????????!");
			return false;
		}
		int readByte = 0;
		if (descFile.exists()) {
			if (coverlay) {
				System.out.println("??????????????????!");
				if (!FileOperateUtils.delFile(descFileName)) {
					System.out.println("?????????" + descFileName + "???!");
					return false;
				}
			} else {
				System.out.println("?????????????????" + descFileName + "?????!");
				return false;
			}
		} else {
			if (!descFile.getParentFile().exists()) {
				System.out.println("??????????????????????????!");
				if (!descFile.getParentFile().mkdirs()) {
					System.out.println("????????????????????!");
					return false;
				}
			}
		}
		OutputStream outs = null;
		InputStream ins = null;
		try {
			outs = new FileOutputStream(descFile);
			ins = new FileInputStream(srcFile);
			byte[] buf = new byte[1024];
			while ((readByte = ins.read(buf)) != -1) {
				outs.write(buf, 0, readByte);
			}
			System.out.println("??????????" + srcFileName + "??" + descFileName + "???!");
			return true;
		} catch (Exception e) {
			System.out.println("???????????" + e.getMessage());
			return false;
		} finally {
			if (outs != null) {
				try {
					outs.close();
				} catch (IOException oute) {
					oute.printStackTrace();
				}
			}
			if (ins != null) {
				try {
					ins.close();
				} catch (IOException ine) {
					ine.printStackTrace();
				}
			}
		}
	}

}