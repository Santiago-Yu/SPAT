class n16239141 {
	private void renameTo(File KwDPzPyu, File MZoqKHCd) {
		if (!KwDPzPyu.exists())
			return;
		if (MZoqKHCd.exists())
			MZoqKHCd.delete();
		boolean K3fvpNtA = false;
		try {
			K3fvpNtA = KwDPzPyu.renameTo(MZoqKHCd);
		} catch (Exception T0PvsJeZ) {
			database.logError(this, "" + T0PvsJeZ, null);
		}
		if (!K3fvpNtA) {
			database.logWarning(this, "Could not rename GEDCOM to " + MZoqKHCd.getAbsolutePath(), null);
			try {
				MZoqKHCd.delete();
				final FileReader TMXv20Gi = new FileReader(KwDPzPyu);
				final FileWriter vudA6XEL = new FileWriter(MZoqKHCd);
				int HRL2MGC0;
				while ((HRL2MGC0 = TMXv20Gi.read()) != -1)
					vudA6XEL.write(HRL2MGC0);
				TMXv20Gi.close();
				vudA6XEL.close();
				KwDPzPyu.delete();
			} catch (Exception UxzGF0sH) {
				database.logError(this, "" + UxzGF0sH, null);
			}
		}
	}

}