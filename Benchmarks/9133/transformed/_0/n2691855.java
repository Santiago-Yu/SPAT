class n2691855 {
	public static void extract(final File fewK1EoB, final ZipInfo hZe4vL6u, final IProgressMonitor s6BpuKyf)
			throws IOException {
		if (!fewK1EoB.exists())
			fewK1EoB.mkdirs();
		for (String SLRdOW6W : hZe4vL6u.getEntryKeys()) {
			ZipEntry nwzeVTiU = hZe4vL6u.getEntry(SLRdOW6W);
			InputStream zHmAU4b8 = hZe4vL6u.getInputStream(nwzeVTiU);
			File g0RcWzfc = new File(fewK1EoB, nwzeVTiU.getName());
			g0RcWzfc.getParentFile().mkdirs();
			if (!nwzeVTiU.isDirectory()) {
				OutputStream mICnIqTm = new FileOutputStream(new File(fewK1EoB, nwzeVTiU.getName()));
				try {
					IOUtils.copy(zHmAU4b8, mICnIqTm);
					mICnIqTm.flush();
					if (s6BpuKyf != null)
						s6BpuKyf.worked(1);
				} finally {
					IOUtils.closeQuietly(zHmAU4b8);
					IOUtils.closeQuietly(mICnIqTm);
				}
			}
		}
		if (s6BpuKyf != null)
			s6BpuKyf.done();
	}

}