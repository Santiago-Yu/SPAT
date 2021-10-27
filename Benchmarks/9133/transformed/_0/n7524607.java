class n7524607 {
	private void copyFile(String coaljjOK) {
		FileChannel HrbRa9sf = null;
		FileChannel k2Xjk5FH = null;
		try {
			Date m3OJNFKT = new Date();
			SimpleDateFormat cJHtXeXb = new SimpleDateFormat("yyyyMMdd HHmmss ");
			File Sh54CHJP = new File(coaljjOK);
			String[] dvyFj9at = coaljjOK.split("\\\\");
			File vP6vQ9Ox = new File(".\\xml_archiv\\" + cJHtXeXb.format(m3OJNFKT) + dvyFj9at[dvyFj9at.length - 1]);
			HrbRa9sf = new FileInputStream(Sh54CHJP).getChannel();
			k2Xjk5FH = new FileOutputStream(vP6vQ9Ox).getChannel();
			HrbRa9sf.transferTo(0, HrbRa9sf.size(), k2Xjk5FH);
		} catch (IOException sAyHTK4B) {
			System.err.println("Copy error!");
			System.err.println("Error: " + sAyHTK4B.getMessage());
		} finally {
			if (HrbRa9sf != null) {
				try {
					HrbRa9sf.close();
				} catch (IOException Cp6vPtzk) {
					Logger.getLogger(ImportIntoDb.class.getName()).log(Level.SEVERE, null, Cp6vPtzk);
				}
			}
			if (k2Xjk5FH != null) {
				try {
					k2Xjk5FH.close();
				} catch (IOException QDTx83BL) {
					Logger.getLogger(ImportIntoDb.class.getName()).log(Level.SEVERE, null, QDTx83BL);
				}
			}
		}
	}

}