class n22930145{
    private long getLastModification() {
        try {
            if (connection == null) connection = url.openConnection();
            return connection.getLastModified();
        } catch (IOException e) {
            LOG.warn("URL could not be opened: " + e.getMessage(), e);
            return 0;
        }
    }

}