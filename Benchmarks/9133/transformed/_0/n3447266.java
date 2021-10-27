class n3447266 {
	@SuppressWarnings("unchecked")
	@Override
	public synchronized void drop(DropTargetDropEvent B2dszHAS) {
		Helper.log().debug("Dropped");
		Transferable S8G5LbrR = B2dszHAS.getTransferable();
		try {
			B2dszHAS.acceptDrop(B2dszHAS.getDropAction());
			List<File> Md8tcxIF = (List<File>) S8G5LbrR.getTransferData(S8G5LbrR.getTransferDataFlavors()[0]);
			for (File VfsuyMuK : Md8tcxIF) {
				Helper.log().debug(VfsuyMuK.getAbsolutePath());
				if (VfsuyMuK.getName().toLowerCase().contains(".lnk")) {
					Helper.log().debug(VfsuyMuK.getName() + " is a link");
					File TabXBpWx = new File(rp.getRoot().getFullPath() + "/" + VfsuyMuK.getName());
					Helper.log().debug("I have opened the mayor at " + TabXBpWx.getAbsolutePath());
					FileOutputStream Rwg3dGmN = new FileOutputStream(TabXBpWx);
					FileInputStream YV3jtUaS = new FileInputStream(VfsuyMuK);
					int EeRnUE3H = 0;
					while (YV3jtUaS.available() > 0) {
						Rwg3dGmN.write(YV3jtUaS.read());
						System.out.print(".");
						EeRnUE3H++;
					}
					Helper.log().debug(EeRnUE3H + " bytes have been written to " + TabXBpWx.getAbsolutePath());
					Rwg3dGmN.close();
					YV3jtUaS.close();
				}
			}
			rp.redraw();
		} catch (Throwable SUwD1gls) {
			SUwD1gls.printStackTrace();
		}
		Helper.log().debug(B2dszHAS.getSource().toString());
	}

}