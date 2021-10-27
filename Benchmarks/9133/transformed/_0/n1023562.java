class n1023562 {
	public static void downloadXrefTask(String ZyEIgtLZ, String K3Qc5SwF) {
		int ILldGMWU, Pi8bx8yh, EDFPuv1e;
		if (debug)
			System.err.println("Downloading " + ZyEIgtLZ + " into " + K3Qc5SwF);
		Progress DK4ZwOHW = Progress.crNew(null, "Downloading xref task");
		FileOutputStream MxWgoLoY = null;
		InputStream YenMYz9X = null;
		try {
			URLConnection ThgvSmuw = new URL(ZyEIgtLZ).openConnection();
			YenMYz9X = ThgvSmuw.getInputStream();
			File idIF0xBj = new File(K3Qc5SwF);
			if (!idIF0xBj.getParentFile().exists()) {
				idIF0xBj.getParentFile().mkdir();
			}
			MxWgoLoY = new FileOutputStream(idIF0xBj);
			byte dCyQgYhr[] = new byte[XREF_DOWNLOAD_BUFFER_SIZE];
			Pi8bx8yh = 0;
			EDFPuv1e = ThgvSmuw.getContentLength();
			ILldGMWU = 1;
			while (ILldGMWU >= 0) {
				ILldGMWU = YenMYz9X.read(dCyQgYhr, 0, XREF_DOWNLOAD_BUFFER_SIZE);
				if (ILldGMWU > 0) {
					MxWgoLoY.write(dCyQgYhr, 0, ILldGMWU);
					Pi8bx8yh += ILldGMWU;
				}
				if (!DK4ZwOHW.setProgress(Pi8bx8yh * 100 / EDFPuv1e)) {
					ILldGMWU = -2;
				}
			}
			YenMYz9X.close();
			MxWgoLoY.close();
			fileSetExecPermission(K3Qc5SwF);
			if (ILldGMWU == -2) {
				idIF0xBj.delete();
			}
		} catch (Exception Hqf48Cnz) {
			try {
				if (MxWgoLoY != null) {
					MxWgoLoY.close();
					new File(K3Qc5SwF).delete();
				}
				if (YenMYz9X != null)
					YenMYz9X.close();
			} catch (Exception vrqpHz5i) {
			}
			DK4ZwOHW.setVisible(false);
			JOptionPane.showMessageDialog(null,
					Hqf48Cnz.toString() + "\nWhile downloading " + ZyEIgtLZ + ".\nMaybe wrong proxy configuration?",
					"Xrefactory Error", JOptionPane.ERROR_MESSAGE);
		}
		DK4ZwOHW.setVisible(false);
	}

}