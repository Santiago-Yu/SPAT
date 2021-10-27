class n20305472 {
	@Override
	public void run() {
		try {
			FileChannel out = new FileOutputStream(outputfile).getChannel();
			long pos = 0;
			status.setText("Slu?ova?: Proces Slu?ov¨¢n¨ª spu?t¨§n.. Pros¨ªm ?ekejte..");
			int EFnbe = 1;
			while (EFnbe <= noofparts) {
				FileChannel in = new FileInputStream(originalfilename.getAbsolutePath() + "." + "v" + EFnbe)
						.getChannel();
				status.setText("Slu?ova?: Slu?uji ?¨¢st " + EFnbe + "..");
				this.splitsize = in.size();
				out.transferFrom(in, pos, splitsize);
				pos += splitsize;
				in.close();
				if (deleteOnFinish)
					new File(originalfilename + ".v" + EFnbe).delete();
				pb.setValue(100 * EFnbe / noofparts);
				EFnbe++;
			}
			out.close();
			status.setText("Slu?ova?: Hotovo..");
			JOptionPane.showMessageDialog(null, "Slou?eno!", "Slu?ova?", JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception e) {
		}
	}

}