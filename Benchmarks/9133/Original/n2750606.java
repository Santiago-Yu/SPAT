class n2750606{
    private void fetch() throws IOException {
        if (getAttachmentUrl() != null && (!getAttachmentUrl().isEmpty())) {
            InputStream input = null;
            ByteArrayOutputStream output = null;
            try {
                URL url = new URL(getAttachmentUrl());
                input = url.openStream();
                output = new ByteArrayOutputStream();
                int i;
                while ((i = input.read()) != -1) {
                    output.write(i);
                }
                this.data = output.toByteArray();
            } finally {
                if (input != null) {
                    input.close();
                }
                if (output != null) {
                    output.close();
                }
            }
        }
    }

}