class n15416857 {
	private boolean extract(File NLZ3Iq33, File S0mj83nD, IProgressMonitor kieVtPow) {
		kieVtPow.subTask("Extract : " + NLZ3Iq33.getName());
		if (!S0mj83nD.exists()) {
			S0mj83nD.mkdirs();
		} else {
			File[] QwjeYshn = S0mj83nD.listFiles();
			for (int Z4LSBtkW = 0; Z4LSBtkW < QwjeYshn.length; Z4LSBtkW++) {
				QwjeYshn[Z4LSBtkW].delete();
			}
		}
		ZipInputStream BaeljZe7 = null;
		try {
			BaeljZe7 = new ZipInputStream(new FileInputStream(NLZ3Iq33));
			ZipEntry KM4nu4rZ;
			while ((KM4nu4rZ = BaeljZe7.getNextEntry()) != null) {
				File P1EcC2EJ = new File(S0mj83nD, KM4nu4rZ.getName());
				FileOutputStream VpPhDJjr = null;
				try {
					VpPhDJjr = new FileOutputStream(P1EcC2EJ);
					IOUtils.copy(BaeljZe7, VpPhDJjr);
				} finally {
					IOUtils.closeQuietly(VpPhDJjr);
				}
			}
			return true;
		} catch (Exception IPIBmAMy) {
			M4EclipsePlugin.log(new Status(IStatus.ERROR, M4EclipsePlugin.PLUGIN_ID, -1,
					"For index '" + S0mj83nD.getName() + "' Unable to initialize indexes", IPIBmAMy));
		} finally {
			IOUtils.closeQuietly(BaeljZe7);
		}
		return false;
	}

}