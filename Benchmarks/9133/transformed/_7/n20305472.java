class n20305472 {
	@Override
	public void run() {
		try {
			FileChannel out = new FileOutputStream(outputfile).getChannel();
			long pos = 0;
			status.setText("Slu?ova?: Proces Slu?ov¨¢n¨ª spu?t¨§n.. Pros¨ªm ?ekejte..");
			for (int i = 1; i <= noofparts; i++) {
				FileChannel in = new FileInputStream(originalfilename.getAbsolutePath() + "." + "v" + i).getChannel();
				status.setText("Slu?ova?: Slu?uji ?¨¢st " + i + "..");
				this.splitsize = in.size();
				out.transferFrom(in, pos, splitsize);
				pos = pos + (splitsize);
				in.close();
				if (deleteOnFinish)
					new File(originalfilename + ".v" + i).delete();
				pb.setValue(100 * i / noofparts);
			}
			out.close();
			status.setText("Slu?ova?: Hotovo..");
			JOptionPane.showMessageDialog(null, "Slou?eno!", "Slu?ova?", JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception e) {
		}
	}

}