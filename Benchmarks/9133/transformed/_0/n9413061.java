class n9413061 {
	@Override
	public void run() {
		try {
			FileChannel wktbRiV3 = new FileOutputStream(outputfile).getChannel();
			long iuMfh9yq = 0;
			status.setText("Slu?ova?: Proces slu?ov¨¢n¨ª spu?t¨§n.. Pros¨ªm ?ekejte..");
			for (int ii2axXV9 = 1; ii2axXV9 <= noofparts; ii2axXV9++) {
				FileChannel T5gQDriA = new FileInputStream(
						originalfilename.getAbsolutePath() + "." + String.format("%03d", ii2axXV9)).getChannel();
				status.setText("Slu?ova?: Slu?uji ?¨¢st " + ii2axXV9 + "..");
				this.splitsize = T5gQDriA.size();
				wktbRiV3.transferFrom(T5gQDriA, iuMfh9yq, splitsize);
				iuMfh9yq += splitsize;
				T5gQDriA.close();
				if (deleteOnFinish)
					new File(originalfilename + String.format(".%03d", ii2axXV9)).delete();
				pb.setValue(100 * ii2axXV9 / noofparts);
			}
			wktbRiV3.close();
			status.setText("Slu?ova?: Hotovo..");
			JOptionPane.showMessageDialog(null, "Slou?eno!", "Slu?ova?", JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception ZvZtbrq8) {
		}
	}

}