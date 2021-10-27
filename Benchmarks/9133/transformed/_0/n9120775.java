class n9120775 {
	public void addFile(File D96vqjxP, boolean cNPur0Wq) {
		String YBnC8DRU = D96vqjxP.getPath();
		String mPqJ6ep2 = setUpFile(D96vqjxP);
		if (mPqJ6ep2 != null) {
			File qJ18WnYp = new File(mPqJ6ep2);
			int W5O2AjEn = JOptionPane.CANCEL_OPTION;
			if (YBnC8DRU.equals(mPqJ6ep2)) {
				mPqJ6ep2 = mPqJ6ep2.substring(openProject.getPath().length());
				openProject.addFile(mPqJ6ep2);
				if (qJ18WnYp.getName().toLowerCase().endsWith(".exp"))
					addExpFile(qJ18WnYp.getPath());
			} else if (!qJ18WnYp.exists() || JOptionPane.OK_OPTION == (W5O2AjEn = JOptionPane.showConfirmDialog(this,
					"File" + qJ18WnYp.getName() + " Already Exists! Do You Wish To Overwrite That File?"
							+ (qJ18WnYp.getName().toLowerCase().endsWith(".exp")
									? "\nOverwriting An Expression File Will Delete All Files Which Previously Required The Orginal File"
									: "")))) {
				try {
					if (W5O2AjEn == JOptionPane.OK_OPTION && qJ18WnYp.getName().toLowerCase().endsWith(".exp")) {
						File fwYIfJNs[] = qJ18WnYp.getParentFile().listFiles();
						for (int Te9fiNCf = 0; Te9fiNCf < fwYIfJNs.length; Te9fiNCf++) {
							while (fwYIfJNs[Te9fiNCf].exists()) {
								fwYIfJNs[Te9fiNCf].delete();
							}
						}
						qJ18WnYp.getParentFile().delete();
					}
					qJ18WnYp.getParentFile().mkdirs();
					qJ18WnYp.createNewFile();
					FileInputStream L0QiITSD = new FileInputStream(D96vqjxP);
					FileOutputStream pkVGJ0j3 = new FileOutputStream(qJ18WnYp);
					byte[] LU2ySE64 = new byte[8 * 1024];
					int SChgYqm7 = 0;
					do {
						pkVGJ0j3.write(LU2ySE64, 0, SChgYqm7);
						SChgYqm7 = L0QiITSD.read(LU2ySE64, 0, LU2ySE64.length);
					} while (SChgYqm7 != -1);
					L0QiITSD.close();
					pkVGJ0j3.close();
					if (cNPur0Wq)
						D96vqjxP.delete();
				} catch (Exception ACK0qcPq) {
					JOptionPane.showMessageDialog(this, "Error! Could Not Add " + D96vqjxP.getName() + " To Project");
				}
				mPqJ6ep2 = mPqJ6ep2
						.substring(mPqJ6ep2.lastIndexOf(openProject.getName()) + openProject.getName().length() + 1);
				openProject.addFile(mPqJ6ep2);
				if (qJ18WnYp.getName().toLowerCase().endsWith(".exp"))
					addExpFile(qJ18WnYp.getPath());
			}
		} else {
			String LiWw2XJI = "Error! Could Not Add " + D96vqjxP.getName() + " To Project\n";
			if (D96vqjxP.getName().endsWith(".gprj")) {
				LiWw2XJI += "You May Not Add A Project File To An Existing Project";
			} else if (D96vqjxP.getName().toLowerCase().endsWith(".ds_store")) {
				LiWw2XJI = "";
			} else if (D96vqjxP.getName().toLowerCase().endsWith(".txt")) {
				LiWw2XJI = "";
			} else if (D96vqjxP.getName().toLowerCase().endsWith(".gif")) {
				LiWw2XJI = "";
			} else if (D96vqjxP.getName().toLowerCase().endsWith(".jpeg")) {
				LiWw2XJI = "";
			} else if (D96vqjxP.getName().toLowerCase().endsWith(".jpg")) {
				LiWw2XJI = "";
			} else if (D96vqjxP.getName().toLowerCase().endsWith(".info")) {
				LiWw2XJI = "";
			} else if (D96vqjxP.getName().toLowerCase().endsWith(".html")) {
				LiWw2XJI = "";
			} else if (D96vqjxP.getName().toLowerCase().endsWith(".db")) {
				LiWw2XJI = "";
			} else if (D96vqjxP.getName().toLowerCase().endsWith(".raw")) {
				LiWw2XJI = "";
			} else if (D96vqjxP.getName().toLowerCase().endsWith(".cdt")) {
				LiWw2XJI = "";
			} else if (D96vqjxP.getName().toLowerCase().endsWith(".gtr")) {
				LiWw2XJI = "";
			} else if (D96vqjxP.getName().toLowerCase().endsWith(".jtv")) {
				LiWw2XJI = "";
			} else
				LiWw2XJI += "File Extension Unknown. Please Check The File To Ensure It Has The Correct Extension";
			if (!LiWw2XJI.equals(""))
				JOptionPane.showMessageDialog(this, LiWw2XJI);
		}
	}

}