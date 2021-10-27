class n6680023{
                public ResourceMigrator getCompletedResourceMigrator() {
                    return new ResourceMigrator() {

                        public void migrate(InputMetadata meta, InputStream inputStream, OutputCreator outputCreator) throws IOException, ResourceMigrationException {
                            OutputStream outputStream = outputCreator.createOutputStream();
                            IOUtils.copy(inputStream, outputStream);
                        }
                    };
                }

}