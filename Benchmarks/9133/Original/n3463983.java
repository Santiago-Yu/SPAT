class n3463983{
        @Override
        public long getLastModified(final Resource arg0) {
            try {
                final ServletContext context = CContext.getInstance().getContext();
                final URL url = context.getResource(arg0.getName());
                final URLConnection conn = url.openConnection();
                final long lm = conn.getLastModified();
                try {
                    conn.getInputStream().close();
                } catch (final Exception ignore) {
                    ;
                }
                return lm;
            } catch (final Exception e) {
                return 0;
            }
        }

}