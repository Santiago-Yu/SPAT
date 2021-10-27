class n6418781 {
	public static void main(String[] AFZi2zz1) {
		FTPClient uuaB0wcb = new FTPClient();
		try {
			uuaB0wcb.connect("192.168.1.10");
			uuaB0wcb.login("a", "123456");
			String[] BRvuZVqZ = uuaB0wcb.listNames();
			for (String ZYj5yGZM : BRvuZVqZ) {
				System.out.println("Name = " + ZYj5yGZM);
			}
			FTPFile[] E5XYpNLK = uuaB0wcb.listFiles();
			for (FTPFile Wqe3Wjd4 : E5XYpNLK) {
				if (Wqe3Wjd4.getType() == FTPFile.FILE_TYPE) {
					System.out.println("FTPFile: " + Wqe3Wjd4.getName() + "; "
							+ FileUtils.byteCountToDisplaySize(Wqe3Wjd4.getSize()));
				}
			}
			uuaB0wcb.logout();
		} catch (IOException Hsd68Pfo) {
			Hsd68Pfo.printStackTrace();
		} finally {
			try {
				uuaB0wcb.disconnect();
			} catch (IOException oO4ddvIJ) {
				oO4ddvIJ.printStackTrace();
			}
		}
	}

}