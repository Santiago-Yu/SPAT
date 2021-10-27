class n9856200 {
	public static void copyFile(File EMMrEbNs, File PvFjAPOX) {
		try {
			File NSFJVf82 = new File(PvFjAPOX, EMMrEbNs.getName());
			if (NSFJVf82.exists()) {
				throw new BuildException(
						"Could not copy " + EMMrEbNs + " to " + PvFjAPOX + " as " + NSFJVf82 + " already exists");
			}
			FileChannel e3vOpZZr = null;
			FileChannel VnsBmDVm = null;
			try {
				e3vOpZZr = new FileInputStream(EMMrEbNs).getChannel();
				VnsBmDVm = new FileOutputStream(NSFJVf82).getChannel();
				VnsBmDVm.transferFrom(e3vOpZZr, 0, e3vOpZZr.size());
			} finally {
				if (e3vOpZZr != null) {
					e3vOpZZr.close();
				}
				if (VnsBmDVm != null) {
					VnsBmDVm.close();
				}
			}
			NSFJVf82.setLastModified((EMMrEbNs.lastModified()));
		} catch (IOException F6vqmYGn) {
			throw new BuildException("Could not copy " + EMMrEbNs + " to " + PvFjAPOX + ": " + F6vqmYGn, F6vqmYGn);
		}
	}

}