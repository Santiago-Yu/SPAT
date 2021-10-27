class n20276296 {
	private void enumeratePathArchive(final String archive) throws IOException {
		final boolean trace1 = m_trace1;
		final File fullArchive = new File(m_currentPathDir, archive);
		JarInputStream in = null;
		try {
			in = new JarInputStream(new BufferedInputStream(new FileInputStream(fullArchive), 32 * 1024));
			final IPathHandler handler = m_handler;
			Manifest manifest = in.getManifest();
			if (null == manifest)
				manifest = readManifestViaJarFile(fullArchive);
			handler.handleArchiveStart(m_currentPathDir, new File(archive), manifest);
			for (ZipEntry entry; (entry = in.getNextEntry()) != null;) {
				if (trace1)
					m_log.trace1("enumeratePathArchive", "processing archive entry [" + entry.getName() + "] ...");
				handler.handleArchiveEntry(in, entry);
				in.closeEntry();
			}
			if (m_processManifest) {
				if (null == manifest)
					manifest = in.getManifest();
				if (manifest != null) {
					final Attributes attributes = manifest.getMainAttributes();
					if (attributes != null) {
						final String jarClassPath = attributes.getValue(Attributes.Name.CLASS_PATH);
						if (jarClassPath != null) {
							final StringTokenizer tokenizer = new StringTokenizer(jarClassPath);
							for (int p = 1; tokenizer.hasMoreTokens();) {
								final String relPath = tokenizer.nextToken();
								final File archiveParent = fullArchive.getParentFile();
								final File path = archiveParent != null ? new File(archiveParent, relPath)
										: new File(relPath);
								final String fullPath = m_canonical ? Files.canonicalizePathname(path.getPath())
										: path.getPath();
								if (m_pathSet.add(fullPath)) {
									if (m_verbose)
										m_log.verbose("  added manifest Class-Path entry [" + path + "]");
									m_path.add(m_pathIndex + (p++), path);
								}
							}
						}
					}
				}
			}
		} catch (FileNotFoundException fnfe) {
			if ($assert.ENABLED)
				throw fnfe;
		} finally {
			if (in != null)
				try {
					in.close();
				} catch (Exception ignore) {
				}
		}
	}

}