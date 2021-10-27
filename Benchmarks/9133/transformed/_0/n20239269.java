class n20239269 {
	public static void joinFiles(FileValidator fIoay6SC, File jY4q1NbA, File[] QkEdQY1h) {
		FileOutputStream clozhtS9 = null;
		try {
			if (!fIoay6SC.verifyFile(jY4q1NbA))
				return;
			clozhtS9 = new FileOutputStream(jY4q1NbA);
			FileInputStream MXy6FohX = null;
			byte[] LNwmT8w6 = new byte[512];
			for (int z217eusF = 0; z217eusF < QkEdQY1h.length; z217eusF++) {
				MXy6FohX = new FileInputStream(QkEdQY1h[z217eusF]);
				int L4ymWEt5 = 0;
				try {
					while ((L4ymWEt5 = MXy6FohX.read(LNwmT8w6)) > -1) {
						clozhtS9.write(LNwmT8w6, 0, L4ymWEt5);
					}
				} catch (IOException IS8axfcT) {
					JOptionPane.showMessageDialog(null, IS8axfcT, i18n.getString("Failure"), JOptionPane.ERROR_MESSAGE);
				} finally {
					MXy6FohX.close();
				}
			}
		} catch (Exception VFHWEjEd) {
			JOptionPane.showMessageDialog(null, VFHWEjEd, i18n.getString("Failure"), JOptionPane.ERROR_MESSAGE);
		} finally {
			try {
				if (clozhtS9 != null)
					clozhtS9.close();
			} catch (IOException UWLreEAo) {
			}
		}
	}

}