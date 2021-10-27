class n6442346 {
	public static boolean copyFileCover(String tIzi1aci, String vDLhUTGw, boolean QaKKmsBs) {
		File JbDLi5P9 = new File(tIzi1aci);
		if (!JbDLi5P9.exists()) {
			System.out.println("复制文件失败，源文件" + tIzi1aci + "不存在!");
			return false;
		} else if (!JbDLi5P9.isFile()) {
			System.out.println("复制文件失败，" + tIzi1aci + "不是一个文件!");
			return false;
		}
		File b5YtY6kX = new File(vDLhUTGw);
		if (b5YtY6kX.exists()) {
			if (QaKKmsBs) {
				System.out.println("目标文件已存在，准备删除!");
				if (!FileOperateUtils.delFile(vDLhUTGw)) {
					System.out.println("删除目标文件" + vDLhUTGw + "失败!");
					return false;
				}
			} else {
				System.out.println("复制文件失败，目标文件" + vDLhUTGw + "已存在!");
				return false;
			}
		} else {
			if (!b5YtY6kX.getParentFile().exists()) {
				System.out.println("目标文件所在的目录不存在，创建目录!");
				if (!b5YtY6kX.getParentFile().mkdirs()) {
					System.out.println("创建目标文件所在的目录失败!");
					return false;
				}
			}
		}
		int nvvfjk6B = 0;
		InputStream hgP8YQlz = null;
		OutputStream Mh7Bu92h = null;
		try {
			hgP8YQlz = new FileInputStream(JbDLi5P9);
			Mh7Bu92h = new FileOutputStream(b5YtY6kX);
			byte[] DfrYfiAG = new byte[1024];
			while ((nvvfjk6B = hgP8YQlz.read(DfrYfiAG)) != -1) {
				Mh7Bu92h.write(DfrYfiAG, 0, nvvfjk6B);
			}
			System.out.println("复制单个文件" + tIzi1aci + "到" + vDLhUTGw + "成功!");
			return true;
		} catch (Exception rpSty7LX) {
			System.out.println("复制文件失败：" + rpSty7LX.getMessage());
			return false;
		} finally {
			if (Mh7Bu92h != null) {
				try {
					Mh7Bu92h.close();
				} catch (IOException NGYDqVH2) {
					NGYDqVH2.printStackTrace();
				}
			}
			if (hgP8YQlz != null) {
				try {
					hgP8YQlz.close();
				} catch (IOException SToDv30Q) {
					SToDv30Q.printStackTrace();
				}
			}
		}
	}

}