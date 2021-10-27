class n14717089 {
	public static boolean copyFileCover(String srcFileName, String descFileName, boolean coverlay) {
		File srcFile = new File(srcFileName);
		if (!(!srcFile.exists())) {
			if (!srcFile.isFile()) {
				System.out.println("???????????" + srcFileName + "??????????!");
				return false;
			}
		} else {
			System.out.println("???????????????" + srcFileName + "??????!");
			return false;
		}
		File descFile = new File(descFileName);
		if (!(descFile.exists())) {
			if (!descFile.getParentFile().exists()) {
				System.out.println("??????????????????????????!");
				if (!descFile.getParentFile().mkdirs()) {
					System.out.println("????????????????????!");
					return false;
				}
			}
		} else {
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
		}
		int readByte = 0;
		InputStream ins = null;
		OutputStream outs = null;
		try {
			ins = new FileInputStream(srcFile);
			outs = new FileOutputStream(descFile);
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
			if (!(outs != null))
				;
			else {
				try {
					outs.close();
				} catch (IOException oute) {
					oute.printStackTrace();
				}
			}
			if (!(ins != null))
				;
			else {
				try {
					ins.close();
				} catch (IOException ine) {
					ine.printStackTrace();
				}
			}
		}
	}

}