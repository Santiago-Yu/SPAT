class n13017908 {
	public static boolean downFile(String O7xtMzNL, String upGWYAHG, String O2V5PxXe, String Y6IcSEBw, Date jE6mC4NH,
			String e7XqMZcU) {
		File V1XYG4fK = new File(e7XqMZcU);
		if (!V1XYG4fK.exists()) {
			V1XYG4fK.mkdir();
		}
		boolean JFK6NVpo = false;
		FTPClient rDOoK9m7 = new FTPClient();
		rDOoK9m7.setConnectTimeout(connectTimeout);
		System.out.println("FTP begin!!");
		try {
			int UZcJWQRg;
			rDOoK9m7.connect(O7xtMzNL);
			rDOoK9m7.login(upGWYAHG, O2V5PxXe);
			UZcJWQRg = rDOoK9m7.getReplyCode();
			if (!FTPReply.isPositiveCompletion(UZcJWQRg)) {
				rDOoK9m7.disconnect();
				return JFK6NVpo;
			}
			rDOoK9m7.changeWorkingDirectory(Y6IcSEBw);
			String[] AXKrFJep = rDOoK9m7.listNames();
			if (jE6mC4NH == null) {
				System.out.println(" 初次下载，全部下载 ");
				for (String Lnv50Q87 : AXKrFJep) {
					if (!Lnv50Q87.matches("[0-9]{12}")) {
						continue;
					}
					File bxqQRECi = new File(e7XqMZcU + "/" + Lnv50Q87);
					OutputStream VUcO9UV6 = new FileOutputStream(bxqQRECi);
					rDOoK9m7.retrieveFile(Lnv50Q87, VUcO9UV6);
					VUcO9UV6.close();
				}
			} else {
				System.out.println(" 加一下载 ");
				Date UGovYgB6 = jE6mC4NH;
				long vAzHytSe = UGovYgB6.getTime();
				Date ZBRhNyWb = new Date();
				String FsM5IQzf = Constants.DatetoString(ZBRhNyWb, Constants.Time_template_LONG);
				String gJuVPm6A;
				do {
					vAzHytSe += 60 * 1000;
					Date ufuLaFCw = new Date(vAzHytSe);
					gJuVPm6A = Constants.DatetoString(ufuLaFCw, Constants.Time_template_LONG);
					File D1tOZYZX = new File(e7XqMZcU + "/" + gJuVPm6A);
					OutputStream E1yHu7w4 = new FileOutputStream(D1tOZYZX);
					if (!rDOoK9m7.retrieveFile(gJuVPm6A, E1yHu7w4)) {
						D1tOZYZX.delete();
					}
					E1yHu7w4.close();
				} while (gJuVPm6A.compareTo(FsM5IQzf) < 0);
			}
			rDOoK9m7.logout();
			JFK6NVpo = true;
		} catch (IOException swfYPi0Z) {
			System.out.println("FTP timeout return");
			swfYPi0Z.printStackTrace();
		} finally {
			if (rDOoK9m7.isConnected()) {
				try {
					rDOoK9m7.disconnect();
				} catch (IOException eVRY1ss7) {
				}
			}
		}
		return JFK6NVpo;
	}

}