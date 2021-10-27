class n13744886 {
	@Override
	public void run() {
		try {
			FileChannel in = new FileInputStream(inputfile).getChannel();
			long pos = 0;
			int ODXMA = 1;
			while (ODXMA <= noofparts) {
				FileChannel out = new FileOutputStream(outputfile.getAbsolutePath() + "." + "v" + ODXMA).getChannel();
				status.setText("Rozd¨§lova?: Rozd¨§luji ?¨¢st " + ODXMA + "..");
				if (remainingsize >= splitsize) {
					in.transferTo(pos, splitsize, out);
					pos += splitsize;
					remainingsize -= splitsize;
				} else {
					in.transferTo(pos, remainingsize, out);
				}
				pb.setValue(100 * ODXMA / noofparts);
				out.close();
				ODXMA++;
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