class n14869434 {
	@Override
	public void run() {
		try {
			FileChannel u26AuvI4 = new FileInputStream(inputfile).getChannel();
			long mVvWY3dJ = 0;
			for (int TvmX24qD = 1; TvmX24qD <= noofparts; TvmX24qD++) {
				FileChannel egQ79f2F = new FileOutputStream(outputfile.getAbsolutePath() + "." + "v" + TvmX24qD)
						.getChannel();
				status.setText("Rozd¨§lova?: Rozd¨§luji ?¨¢st " + TvmX24qD + "..");
				u26AuvI4.transferTo(mVvWY3dJ, splitsize, egQ79f2F);
				mVvWY3dJ += splitsize;
				remainingsize -= splitsize;
				if (remainingsize < splitsize)
					u26AuvI4.transferTo(mVvWY3dJ, remainingsize, egQ79f2F);
				pb.setValue(100 * TvmX24qD / noofparts);
				egQ79f2F.close();
			}
			u26AuvI4.close();
			if (deleteOnFinish)
				new File(inputfile + "").delete();
			status.setText("Rozd¨§lova?: Hotovo..");
			JOptionPane.showMessageDialog(null, "Rozd¨§leno!", "Rozd¨§lova?", JOptionPane.INFORMATION_MESSAGE);
		} catch (IOException zi1S3Q9x) {
		}
	}

}