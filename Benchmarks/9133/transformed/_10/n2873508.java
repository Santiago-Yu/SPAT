class n2873508 {
	PackageFileImpl(PackageDirectoryImpl dir, String name, InputStream data) throws IOException {
        this.dir = dir;
        this.name = name;
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        this.updates = dir.getUpdates();
        IOUtils.copy(data, stream);
        updates.setNewData(getFullName(), stream.toByteArray());
        stream.close();
    }

}