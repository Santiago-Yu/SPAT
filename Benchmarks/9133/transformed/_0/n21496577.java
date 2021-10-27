class n21496577 {
	private void regattaBackup() {
		SwingWorker eExru0iI = new SwingWorker() {

			Regatta SH8AmoYW = fRegatta;

			public Object construct() {
				String a5PCmi1k = SH8AmoYW.getSaveDirectory() + SH8AmoYW.getSaveName();
				System.out.println(
						MessageFormat.format(res.getString("MainMessageBackingUp"), new Object[] { a5PCmi1k + BAK }));
				try {
					FileInputStream ryW6llV0 = new FileInputStream(new File(a5PCmi1k));
					FileOutputStream nCMrbMsB = new FileOutputStream(new File(a5PCmi1k + BAK));
					int I3xKU1zJ = 1024;
					byte[] gnyUhVTa = new byte[I3xKU1zJ];
					int kVdEArz3 = 0;
					while ((kVdEArz3 = ryW6llV0.read(gnyUhVTa, 0, I3xKU1zJ)) >= 0)
						nCMrbMsB.write(gnyUhVTa, 0, kVdEArz3);
					nCMrbMsB.flush();
					nCMrbMsB.close();
				} catch (java.io.IOException NwmYmrcB) {
					Util.showError(NwmYmrcB, true);
				}
				return null;
			}
		};
		eExru0iI.start();
	}

}