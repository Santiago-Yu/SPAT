class n7474020 {
	protected void copyClassFiles(File PxFhxGUN, File O7IeMC35) {
		if (PxFhxGUN != null && O7IeMC35 != null) {
			File[] lFiaD9Z3 = PxFhxGUN.listFiles();
			File WJIldRbW = null, vRSa2b0t = null;
			FileInputStream zLCN4jhM = null;
			FileOutputStream v5CuN5lU = null;
			FileChannel caQvIdAN = null, om7l4lk3 = null;
			for (File Glh2mt4W : lFiaD9Z3) {
				if (Glh2mt4W != null) {
					if (Glh2mt4W.isDirectory()) {
						WJIldRbW = fileExistAsChild(O7IeMC35, Glh2mt4W.getName());
						if (WJIldRbW == null) {
							try {
								WJIldRbW = new File(O7IeMC35, Glh2mt4W.getName());
								WJIldRbW.mkdir();
							} catch (Exception rAKsPDAf) {
								rAKsPDAf.printStackTrace();
							}
						}
						copyClassFiles(Glh2mt4W, WJIldRbW);
					} else {
						try {
							vRSa2b0t = new File(O7IeMC35, Glh2mt4W.getName());
							zLCN4jhM = new FileInputStream(Glh2mt4W);
							v5CuN5lU = new FileOutputStream(vRSa2b0t);
							caQvIdAN = zLCN4jhM.getChannel();
							om7l4lk3 = v5CuN5lU.getChannel();
							ByteBuffer Cz6YxnJ0 = ByteBuffer.allocate(1000);
							int UzhRZlwo = 0;
							while (caQvIdAN.position() < caQvIdAN.size()) {
								UzhRZlwo = caQvIdAN.read(Cz6YxnJ0);
								if (UzhRZlwo > 0) {
									om7l4lk3.write(Cz6YxnJ0);
								}
							}
							caQvIdAN.close();
							om7l4lk3.close();
						} catch (Exception CfUM7nqw) {
							CfUM7nqw.printStackTrace();
						}
					}
				}
			}
		}
	}

}