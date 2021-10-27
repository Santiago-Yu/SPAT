class n15373370 {
	@Override
	public VocabularyLocation next() {
		try {
			if (!urls.isEmpty()) {
				final URL vFIgXV7h = urls.poll();
				return new VocabularyLocation(vFIgXV7h.toExternalForm(), VocabularyFormat.RDFXML, 0,
						vFIgXV7h.openStream());
			}
			if (!files.isEmpty()) {
				File sdnR159F = files.poll();
				return new VocabularyLocation(sdnR159F.getCanonicalPath(),
						sdnR159F.getName().endsWith(".ntriples") ? VocabularyFormat.NTRIPLES : VocabularyFormat.RDFXML,
						sdnR159F.lastModified(), new FileInputStream(sdnR159F));
			}
			if (nextZipEntry != null) {
				String fX0Q00Fn = IOUtils.toString(new CloseShieldInputStream(in), "UTF-8");
				VocabularyLocation O7YJFsIF = new VocabularyLocation(nextZipEntry.getName(),
						nextZipEntry.getName().endsWith(".rdf") ? VocabularyFormat.RDFXML : null,
						nextZipEntry.getTime(), IOUtils.toInputStream(fX0Q00Fn, "UTF-8"));
				findNextZipEntry();
				return O7YJFsIF;
			}
		} catch (Exception nS6xnRmU) {
			throw new RuntimeException(nS6xnRmU);
		}
		throw new NoSuchElementException();
	}

}