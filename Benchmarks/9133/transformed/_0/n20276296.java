class n20276296 {
	private void enumeratePathArchive(final String DgCVPNBA) throws IOException {
		final boolean KZM5Uah5 = m_trace1;
		final File VPBPpqmG = new File(m_currentPathDir, DgCVPNBA);
		JarInputStream i5E59yBU = null;
		try {
			i5E59yBU = new JarInputStream(new BufferedInputStream(new FileInputStream(VPBPpqmG), 32 * 1024));
			final IPathHandler KuWzNcbM = m_handler;
			Manifest ub5uxdv9 = i5E59yBU.getManifest();
			if (ub5uxdv9 == null)
				ub5uxdv9 = readManifestViaJarFile(VPBPpqmG);
			KuWzNcbM.handleArchiveStart(m_currentPathDir, new File(DgCVPNBA), ub5uxdv9);
			for (ZipEntry Nadx3Nhg; (Nadx3Nhg = i5E59yBU.getNextEntry()) != null;) {
				if (KZM5Uah5)
					m_log.trace1("enumeratePathArchive", "processing archive entry [" + Nadx3Nhg.getName() + "] ...");
				KuWzNcbM.handleArchiveEntry(i5E59yBU, Nadx3Nhg);
				i5E59yBU.closeEntry();
			}
			if (m_processManifest) {
				if (ub5uxdv9 == null)
					ub5uxdv9 = i5E59yBU.getManifest();
				if (ub5uxdv9 != null) {
					final Attributes Rd66CoUt = ub5uxdv9.getMainAttributes();
					if (Rd66CoUt != null) {
						final String vVCmy1nI = Rd66CoUt.getValue(Attributes.Name.CLASS_PATH);
						if (vVCmy1nI != null) {
							final StringTokenizer SrpCneC5 = new StringTokenizer(vVCmy1nI);
							for (int Ot4A2yE3 = 1; SrpCneC5.hasMoreTokens();) {
								final String omljRmF8 = SrpCneC5.nextToken();
								final File EU8vPjFi = VPBPpqmG.getParentFile();
								final File QCOvFhfv = EU8vPjFi != null ? new File(EU8vPjFi, omljRmF8)
										: new File(omljRmF8);
								final String MRvAt1Sr = m_canonical ? Files.canonicalizePathname(QCOvFhfv.getPath())
										: QCOvFhfv.getPath();
								if (m_pathSet.add(MRvAt1Sr)) {
									if (m_verbose)
										m_log.verbose("  added manifest Class-Path entry [" + QCOvFhfv + "]");
									m_path.add(m_pathIndex + (Ot4A2yE3++), QCOvFhfv);
								}
							}
						}
					}
				}
			}
		} catch (FileNotFoundException aR156NI6) {
			if ($assert.ENABLED)
				throw aR156NI6;
		} finally {
			if (i5E59yBU != null)
				try {
					i5E59yBU.close();
				} catch (Exception G4zjOy0Z) {
				}
		}
	}

}