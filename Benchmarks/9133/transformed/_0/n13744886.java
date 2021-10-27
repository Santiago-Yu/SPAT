class n13744886 {
	@Override
	public void run() {
		try {
			FileChannel cUPh8WJn = new FileInputStream(inputfile).getChannel();
			long ZR7MvVeO = 0;
			for (int JGZCqlck = 1; JGZCqlck <= noofparts; JGZCqlck++) {
				FileChannel cxTulIMR = new FileOutputStream(outputfile.getAbsolutePath() + "." + "v" + JGZCqlck)
						.getChannel();
				status.setText("Rozd¨§lova?: Rozd¨§luji ?¨¢st " + JGZCqlck + "..");
				if (remainingsize >= splitsize) {
					cUPh8WJn.transferTo(ZR7MvVeO, splitsize, cxTulIMR);
					ZR7MvVeO += splitsize;
					remainingsize -= splitsize;
				} else {
					cUPh8WJn.transferTo(ZR7MvVeO, remainingsize, cxTulIMR);
				}
				pb.setValue(100 * JGZCqlck / noofparts);
				cxTulIMR.close();
			}
			cUPh8WJn.close();
			if (deleteOnFinish)
				new File(inputfile + "").delete();
			status.setText("Rozd¨§lova?: Hotovo..");
			JOptionPane.showMessageDialog(null, "Rozd¨§leno!", "Rozd¨§lova?", JOptionPane.INFORMATION_MESSAGE);
		} catch (IOException cVOiefPv) {
		}
	}

}