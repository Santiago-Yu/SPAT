class n12530708 {
	private int mergeFiles(Merge K0iKOMG2) throws MojoExecutionException {
		String ndAjYRvN = DEFAULT_ENCODING;
		if (K0iKOMG2.getEncoding() != null && K0iKOMG2.getEncoding().length() > 0) {
			ndAjYRvN = K0iKOMG2.getEncoding();
		}
		int NXVgEGCf = 0;
		Writer nhc6DLM5 = null;
		FileOutputStream PCW62egy = null;
		try {
			PCW62egy = new FileOutputStream(K0iKOMG2.getTargetFile(), true);
			nhc6DLM5 = new OutputStreamWriter(PCW62egy, ndAjYRvN);
			BufferedWriter j0Oqeq2o = new BufferedWriter(nhc6DLM5);
			for (String OBV4CqeC : this.orderingNames) {
				List<File> AdBm2g6e = this.orderedFiles.get(OBV4CqeC);
				if (AdBm2g6e != null) {
					getLog().info("Appending: " + AdBm2g6e.size() + " files that matched the name: " + OBV4CqeC
							+ " to the target file: " + K0iKOMG2.getTargetFile().getAbsolutePath() + "...");
					for (File aJv43DtP : AdBm2g6e) {
						String KRrXgSiT = aJv43DtP.getName();
						getLog().info("Appending file: " + KRrXgSiT + " to the target file: "
								+ K0iKOMG2.getTargetFile().getAbsolutePath() + "...");
						InputStream JJTNN8ZD = null;
						try {
							JJTNN8ZD = new FileInputStream(aJv43DtP);
							if (K0iKOMG2.getSeparator() != null && K0iKOMG2.getSeparator().trim().length() > 0) {
								String nhgWlCJB = K0iKOMG2.getSeparator().trim();
								nhgWlCJB = nhgWlCJB.replace("\n", "");
								nhgWlCJB = nhgWlCJB.replace("\t", "");
								nhgWlCJB = nhgWlCJB.replace("#{file.name}", KRrXgSiT);
								nhgWlCJB = nhgWlCJB.replace("#{parent.name}",
										aJv43DtP.getParentFile() != null ? aJv43DtP.getParentFile().getName() : "");
								nhgWlCJB = nhgWlCJB.replace("\\n", "\n");
								nhgWlCJB = nhgWlCJB.replace("\\t", "\t");
								getLog().debug("Appending separator: " + nhgWlCJB);
								IOUtils.copy(new StringReader(nhgWlCJB), j0Oqeq2o);
							}
							IOUtils.copy(JJTNN8ZD, j0Oqeq2o, ndAjYRvN);
						} catch (IOException F2wmOLoy) {
							throw new MojoExecutionException("Failed to append file: " + KRrXgSiT + " to output file",
									F2wmOLoy);
						} finally {
							IOUtils.closeQuietly(JJTNN8ZD);
						}
						NXVgEGCf++;
					}
				}
			}
			j0Oqeq2o.flush();
		} catch (IOException Iiw52cMb) {
			throw new MojoExecutionException(
					"Failed to open stream file to output file: " + K0iKOMG2.getTargetFile().getAbsolutePath(),
					Iiw52cMb);
		} finally {
			if (PCW62egy != null) {
				IOUtils.closeQuietly(PCW62egy);
			}
			if (nhc6DLM5 != null) {
				IOUtils.closeQuietly(nhc6DLM5);
			}
		}
		return NXVgEGCf;
	}

}