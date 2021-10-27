class n15373370{
    @Override
    public VocabularyLocation next() {
        try {
            if (!urls.isEmpty()) {
                final URL url = urls.poll();
                return new VocabularyLocation(url.toExternalForm(), VocabularyFormat.RDFXML, 0, url.openStream());
            }
            if (!files.isEmpty()) {
                File file = files.poll();
                return new VocabularyLocation(file.getCanonicalPath(), file.getName().endsWith(".ntriples") ? VocabularyFormat.NTRIPLES : VocabularyFormat.RDFXML, file.lastModified(), new FileInputStream(file));
            }
            if (nextZipEntry != null) {
                String zipEntryAsString = IOUtils.toString(new CloseShieldInputStream(in), "UTF-8");
                VocabularyLocation location = new VocabularyLocation(nextZipEntry.getName(), nextZipEntry.getName().endsWith(".rdf") ? VocabularyFormat.RDFXML : null, nextZipEntry.getTime(), IOUtils.toInputStream(zipEntryAsString, "UTF-8"));
                findNextZipEntry();
                return location;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        throw new NoSuchElementException();
    }

}