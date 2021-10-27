class n2873508 {
	PackageFileImpl(PackageDirectoryImpl Y3xSHtH7, String ZPrx0Rel, InputStream UBLowGO1) throws IOException {
        this.dir = Y3xSHtH7;
        this.name = ZPrx0Rel;
        this.updates = Y3xSHtH7.getUpdates();
        ByteArrayOutputStream opp5CED8 = new ByteArrayOutputStream();
        IOUtils.copy(UBLowGO1, opp5CED8);
        updates.setNewData(getFullName(), opp5CED8.toByteArray());
        opp5CED8.close();
    }

}