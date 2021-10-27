class n20305472 {
	@Override
	public void run() {
		try {
			FileChannel lEjBJwzN = new FileOutputStream(outputfile).getChannel();
			long Ued9mkaG = 0;
			status.setText("Slu?ova?: Proces Slu?ov¨¢n¨ª spu?t¨§n.. Pros¨ªm ?ekejte..");
			for (int UXpSoUkh = 1; UXpSoUkh <= noofparts; UXpSoUkh++) {
				FileChannel xrB0Wz6u = new FileInputStream(originalfilename.getAbsolutePath() + "." + "v" + UXpSoUkh)
						.getChannel();
				status.setText("Slu?ova?: Slu?uji ?¨¢st " + UXpSoUkh + "..");
				this.splitsize = xrB0Wz6u.size();
				lEjBJwzN.transferFrom(xrB0Wz6u, Ued9mkaG, splitsize);
				Ued9mkaG += splitsize;
				xrB0Wz6u.close();
				if (deleteOnFinish)
					new File(originalfilename + ".v" + UXpSoUkh).delete();
				pb.setValue(100 * UXpSoUkh / noofparts);
			}
			lEjBJwzN.close();
			status.setText("Slu?ova?: Hotovo..");
			JOptionPane.showMessageDialog(null, "Slou?eno!", "Slu?ova?", JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception QtDJuTl0) {
		}
	}

}