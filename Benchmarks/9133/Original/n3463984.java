class n3463984{
        @Override
        public InputStream getResourceStream(final String arg0) throws ResourceNotFoundException {
            try {
                final ServletContext context = CContext.getInstance().getContext();
                final URL url = context.getResource(arg0);
                return url.openStream();
            } catch (final Exception e) {
                return null;
            }
        }

}