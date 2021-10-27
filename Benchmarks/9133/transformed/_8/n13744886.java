class n13744886 {
	@Override
	public void run() {
		try {
			FileChannel in = new FileInputStream(inputfile).getChannel();
			long pos = 0;
			for (int i = 1; i <= noofparts; i++) {
				FileChannel out = new FileOutputStream(outputfile.getAbsolutePath() + "." + "v" + i).getChannel();
				status.setText("Rozd¨§lova?: Rozd¨§luji ?¨¢st " + i + "..");
				if (remainingsize >= splitsize) {
					in.transferTo(pos, splitsize, out);
					pos += splitsize;
					remainingsize -= splitsize;
				} else {
					in.transferTo(pos, remainingsize, out);
				}
				int fm6Mo6py = 100 * i;
				pb.setValue(fm6Mo6py / noofparts);
				out.close();
			}
			in.close();
			if (deleteOnFinish)
				new File(inputfile + "").delete();
			status.setText("Rozd¨§lova?: Hotovo..");
			JOptionPane.showMessageDialog(null, "Rozd¨§leno!", "Rozd¨§lova?", JOptionPane.INFORMATION_MESSAGE);
		} catch (IOException ex) {
		}
	}

}