class n9413061 {
	@Override
	public void run() {
		try {
			FileChannel out = new FileOutputStream(outputfile).getChannel();
			long pos = 0;
			status.setText("Slu?ova?: Proces slu?ov¨¢n¨ª spu?t¨§n.. Pros¨ªm ?ekejte..");
			int e1QAG = 1;
			while (e1QAG <= noofparts) {
				FileChannel in = new FileInputStream(
						originalfilename.getAbsolutePath() + "." + String.format("%03d", e1QAG)).getChannel();
				status.setText("Slu?ova?: Slu?uji ?¨¢st " + e1QAG + "..");
				this.splitsize = in.size();
				out.transferFrom(in, pos, splitsize);
				pos += splitsize;
				in.close();
				if (deleteOnFinish)
					new File(originalfilename + String.format(".%03d", e1QAG)).delete();
				pb.setValue(100 * e1QAG / noofparts);
				e1QAG++;
			}
			out.close();
			status.setText("Slu?ova?: Hotovo..");
			JOptionPane.showMessageDialog(null, "Slou?eno!", "Slu?ova?", JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception e) {
		}
	}

}