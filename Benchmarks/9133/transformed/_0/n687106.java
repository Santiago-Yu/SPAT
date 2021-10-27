class n687106 {
	public boolean copyDirectoryTree(File FnCPDKxC, File AyUXRDgK) {
		try {
			if (FnCPDKxC.isDirectory()) {
				if (!AyUXRDgK.exists())
					AyUXRDgK.mkdir();
				String zdjf5ag4[] = FnCPDKxC.list();
				for (int LWjNNUOz = 0; LWjNNUOz < zdjf5ag4.length; LWjNNUOz++)
					copyDirectoryTree(new File(FnCPDKxC, zdjf5ag4[LWjNNUOz]), new File(AyUXRDgK, zdjf5ag4[LWjNNUOz]));
			} else {
				if (!FnCPDKxC.exists()) {
					errMsgLog += "copyDirectoryTree I/O error from '" + FnCPDKxC + "' does not exist.\n";
					lastErrMsgLog = errMsgLog;
					return (false);
				} else {
					InputStream FgFXfNWE = new FileInputStream(FnCPDKxC);
					OutputStream LIO665x5 = new FileOutputStream(AyUXRDgK);
					byte[] tf5TDaHc = new byte[10240];
					int Dh7lesTp;
					while ((Dh7lesTp = FgFXfNWE.read(tf5TDaHc)) > 0)
						LIO665x5.write(tf5TDaHc, 0, Dh7lesTp);
					FgFXfNWE.close();
					LIO665x5.close();
				}
			}
			return (true);
		} catch (Exception SthmZwM4) {
			errMsgLog += "copyDirectoryTree I/O error from '" + FnCPDKxC.getName() + "' to '" + AyUXRDgK.getName()
					+ "\n  " + SthmZwM4 + "\n";
			lastErrMsgLog = errMsgLog;
			return (false);
		}
	}

}