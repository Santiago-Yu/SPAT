class n16830463{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (log.isTraceEnabled()) {
            log.trace("doGet(requestURI=" + request.getRequestURI() + ")");
        }
        ServletConfig sc = getServletConfig();
        String uriPrefix = request.getContextPath() + "/" + request.getServletPath();
        String resUri = request.getRequestURI().substring(uriPrefix.length());
        if (log.isTraceEnabled()) {
            log.trace("Request for resource '" + resUri + "'");
        }
        boolean allowAccess = true;
        String prefixesSpec = sc.getInitParameter(PARAM_ALLOWED_PREFIXES);
        if (null != prefixesSpec && prefixesSpec.length() > 0) {
            String[] prefixes = prefixesSpec.split(";");
            allowAccess = false;
            if (log.isTraceEnabled()) {
                log.trace("allowedPrefixes specified; checking access");
            }
            for (String prefix : prefixes) {
                if (log.isTraceEnabled()) {
                    log.trace("Checking resource URI '" + resUri + "' against allowed prefix '" + prefix + "'");
                }
                if (resUri.startsWith(prefix)) {
                    if (log.isTraceEnabled()) {
                        log.trace("Found matching prefix for resource URI '" + resUri + "': '" + prefix + "'");
                    }
                    allowAccess = true;
                    break;
                }
            }
        }
        if (!allowAccess) {
            if (log.isWarnEnabled()) {
                log.warn("Requested for resource that does not match with" + " allowed prefixes: " + resUri);
            }
            response.sendError(HttpServletResponse.SC_FORBIDDEN);
            return;
        }
        String resPrefix = sc.getInitParameter(PARAM_RESOURCE_PREFIX);
        if (null != resPrefix && resPrefix.length() > 0) {
            if (log.isTraceEnabled()) {
                log.trace("resourcePrefix specified: " + resPrefix);
            }
            if (resPrefix.endsWith("/")) {
                resUri = resPrefix + resUri;
            } else {
                resUri = resPrefix + "/" + resUri;
            }
        }
        resUri = resUri.replaceAll("\\/\\/+", "/");
        if (log.isTraceEnabled()) {
            log.trace("Qualified (prefixed) resource URI: " + resUri);
        }
        String baseClassName = sc.getInitParameter(PARAM_BASE_CLASS);
        if (null == baseClassName || 0 == baseClassName.length()) {
            if (log.isTraceEnabled()) {
                log.trace("No baseClass initialization parameter specified; using default: " + ResourceLoaderServlet.class.getName());
            }
            baseClassName = ResourceLoaderServlet.class.getName();
        } else {
            if (log.isTraceEnabled()) {
                log.trace("Using baseClass: " + baseClassName);
            }
        }
        Class baseClass;
        try {
            baseClass = Class.forName(baseClassName);
        } catch (ClassNotFoundException ex) {
            throw new ServletException("Base class '" + baseClassName + "' not found", ex);
        }
        URL resUrl = baseClass.getResource(resUri);
        if (null != resUrl) {
            if (log.isTraceEnabled()) {
                log.trace("Sending resource: " + resUrl);
            }
            URLConnection urlc = resUrl.openConnection();
            response.setContentType(urlc.getContentType());
            response.setContentLength(urlc.getContentLength());
            response.setStatus(HttpServletResponse.SC_OK);
            final byte[] buf = new byte[255];
            int r = 0;
            InputStream in = new BufferedInputStream(urlc.getInputStream());
            OutputStream out = new BufferedOutputStream(response.getOutputStream());
            do {
                r = in.read(buf, 0, 255);
                if (r > 0) {
                    out.write(buf, 0, r);
                }
            } while (r > 0);
            in.close();
            out.flush();
            out.close();
        } else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Resource not found");
        }
    }

}