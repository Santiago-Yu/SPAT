class n14717089 {
	public static boolean copyFileCover(String yB1PNeqh, String DDDpCIf8, boolean NGscyiYA) {
		File tW5IWsvg = new File(yB1PNeqh);
		if (!tW5IWsvg.exists()) {
			System.out.println("???????????????" + yB1PNeqh + "??????!");
			return false;
		} else if (!tW5IWsvg.isFile()) {
			System.out.println("???????????" + yB1PNeqh + "??????????!");
			return false;
		}
		File HDtmbDoT = new File(DDDpCIf8);
		if (HDtmbDoT.exists()) {
			if (NGscyiYA) {
				System.out.println("??????????????????!");
				if (!FileOperateUtils.delFile(DDDpCIf8)) {
					System.out.println("?????????" + DDDpCIf8 + "???!");
					return false;
				}
			} else {
				System.out.println("?????????????????" + DDDpCIf8 + "?????!");
				return false;
			}
		} else {
			if (!HDtmbDoT.getParentFile().exists()) {
				System.out.println("??????????????????????????!");
				if (!HDtmbDoT.getParentFile().mkdirs()) {
					System.out.println("????????????????????!");
					return false;
				}
			}
		}
		int tvoK8FE6 = 0;
		InputStream cXjSKHun = null;
		OutputStream mgtmVj8h = null;
		try {
			cXjSKHun = new FileInputStream(tW5IWsvg);
			mgtmVj8h = new FileOutputStream(HDtmbDoT);
			byte[] JgJaKdST = new byte[1024];
			while ((tvoK8FE6 = cXjSKHun.read(JgJaKdST)) != -1) {
				mgtmVj8h.write(JgJaKdST, 0, tvoK8FE6);
			}
			System.out.println("??????????" + yB1PNeqh + "??" + DDDpCIf8 + "???!");
			return true;
		} catch (Exception bf1FvtjI) {
			System.out.println("???????????" + bf1FvtjI.getMessage());
			return false;
		} finally {
			if (mgtmVj8h != null) {
				try {
					mgtmVj8h.close();
				} catch (IOException mIpg9AlT) {
					mIpg9AlT.printStackTrace();
				}
			}
			if (cXjSKHun != null) {
				try {
					cXjSKHun.close();
				} catch (IOException mXI9NeoF) {
					mXI9NeoF.printStackTrace();
				}
			}
		}
	}

}