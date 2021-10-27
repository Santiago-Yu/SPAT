class n18464490 {
	@Override
	public void actionPerformed(ActionEvent HfV5F5DX) {
		if (copiedFiles_ != null) {
			File[] lvZy5sLY = new File[copiedFiles_.length];
			File vSM5BPxY = new File(Settings.getPropertyString(ConstantKeys.project_dir), "tmp/");
			vSM5BPxY.mkdirs();
			for (int F3vGrcdU = copiedFiles_.length - 1; F3vGrcdU >= 0; F3vGrcdU--) {
				Frame fwdjcTRn = FrameManager.getInstance().getFrameAtIndex(F3vGrcdU);
				try {
					File X0TgenwB = fwdjcTRn.getFile();
					File yu3Y8VsH = new File(vSM5BPxY, fwdjcTRn.getFile().getName());
					FileChannel eqltKhlQ = new FileInputStream(X0TgenwB).getChannel();
					FileChannel NJJQ2FSG = new FileOutputStream(yu3Y8VsH).getChannel();
					eqltKhlQ.transferTo(0, eqltKhlQ.size(), NJJQ2FSG);
					if (eqltKhlQ != null)
						eqltKhlQ.close();
					if (NJJQ2FSG != null)
						NJJQ2FSG.close();
					lvZy5sLY[F3vGrcdU] = yu3Y8VsH;
				} catch (IOException E6JvKnGf) {
					E6JvKnGf.printStackTrace();
				}
			}
			try {
				FrameManager.getInstance().insertFrames(getTable().getSelectedRow(), FrameManager.INSERT_TYPE.MOVE,
						lvZy5sLY);
			} catch (IOException NoxH7sGW) {
				NoxH7sGW.printStackTrace();
			}
		}
	}

}