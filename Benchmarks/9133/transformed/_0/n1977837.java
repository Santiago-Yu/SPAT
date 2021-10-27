class n1977837 {
	public void copyFile(File QiViNZt3, String rVidR5af, boolean APtgniSe, boolean hirEMVz8)
			throws FileNotFoundException, IOException {
		FileInputStream QhAGTHxb = null;
		FileOutputStream ddiJWmZ0 = null;
		byte[] IbsNe5ir;
		int VZwh7Lsj;
		File LRdm4Vt4 = new File(rVidR5af);
		if (APtgniSe && !LRdm4Vt4.exists())
			LRdm4Vt4.mkdirs();
		if (LRdm4Vt4.exists()) {
			File mgfL5ugV = new File(rVidR5af + "/" + QiViNZt3.getName());
			try {
				if (!mgfL5ugV.exists() || hirEMVz8) {
					QhAGTHxb = new FileInputStream(QiViNZt3);
					ddiJWmZ0 = new FileOutputStream(mgfL5ugV);
					IbsNe5ir = new byte[1024];
					while (true) {
						VZwh7Lsj = QhAGTHxb.read(IbsNe5ir);
						if (VZwh7Lsj == -1)
							break;
						ddiJWmZ0.write(IbsNe5ir, 0, VZwh7Lsj);
					}
				}
			} catch (Exception JMNn0RHb) {
				JMNn0RHb.printStackTrace();
			} finally {
				if (QhAGTHxb != null)
					try {
						QhAGTHxb.close();
					} catch (IOException X87H64Lv) {
					}
				if (ddiJWmZ0 != null)
					try {
						ddiJWmZ0.close();
					} catch (IOException b8rwGDYZ) {
					}
			}
		}
	}

}