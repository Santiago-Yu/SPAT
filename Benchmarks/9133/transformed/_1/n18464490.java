class n18464490 {
	@Override
	public void actionPerformed(ActionEvent e) {
		if (copiedFiles_ != null) {
			File[] tmpFiles = new File[copiedFiles_.length];
			File tmpDir = new File(Settings.getPropertyString(ConstantKeys.project_dir), "tmp/");
			tmpDir.mkdirs();
			int smpIv = copiedFiles_.length - 1;
			while (smpIv >= 0) {
				Frame f = FrameManager.getInstance().getFrameAtIndex(smpIv);
				try {
					File in = f.getFile();
					File out = new File(tmpDir, f.getFile().getName());
					FileChannel inChannel = new FileInputStream(in).getChannel();
					FileChannel outChannel = new FileOutputStream(out).getChannel();
					inChannel.transferTo(0, inChannel.size(), outChannel);
					if (inChannel != null)
						inChannel.close();
					if (outChannel != null)
						outChannel.close();
					tmpFiles[smpIv] = out;
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				smpIv--;
			}
			try {
				FrameManager.getInstance().insertFrames(getTable().getSelectedRow(), FrameManager.INSERT_TYPE.MOVE,
						tmpFiles);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

}