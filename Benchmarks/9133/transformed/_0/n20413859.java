class n20413859 {
	@Override
	public void doFilter(final ServletRequest QNB2slir, final ServletResponse SzXFEaZR, final FilterChain nbOo4PTo)
			throws IOException, ServletException {
		if (QNB2slir instanceof HttpServletRequest && SzXFEaZR instanceof HttpServletResponse) {
			final HttpServletRequest wqY78MQL = (HttpServletRequest) QNB2slir;
			final HttpServletResponse G6uCzr2z = (HttpServletResponse) SzXFEaZR;
			final String BW1dKtkf = wqY78MQL.getContextPath() + "/";
			final String uZv3Idhw = wqY78MQL.getRequestURI();
			if (uZv3Idhw.startsWith(BW1dKtkf)) {
				final String R0lc92hO = uZv3Idhw.substring(BW1dKtkf.length());
				final String kVtOeBXM = getFilterPath();
				if (R0lc92hO.startsWith(kVtOeBXM)) {
					final String q24AbY4f = R0lc92hO.substring(kVtOeBXM.length());
					for (final Entry<String, String> O8vyUvkp : mapping.entrySet()) {
						final String CdLtXaTp = O8vyUvkp.getKey();
						final String ACjrYxR5 = O8vyUvkp.getValue();
						if (q24AbY4f.startsWith(CdLtXaTp) && (q24AbY4f.length() > CdLtXaTp.length())) {
							final String SjEj9MOD = ACjrYxR5 + q24AbY4f.substring(CdLtXaTp.length());
							InputStream BUZk7Yh3 = null;
							try {
								BUZk7Yh3 = getClass().getResourceAsStream("/" + SjEj9MOD);
								if (BUZk7Yh3 != null) {
									IOUtils.copy(BUZk7Yh3, G6uCzr2z.getOutputStream());
									G6uCzr2z.flushBuffer();
									break;
								} else {
									G6uCzr2z.sendError(HttpServletResponse.SC_NOT_FOUND);
									break;
								}
							} catch (final IOException yIOTriJd) {
								throw new ServletException("Error serving resource [" + SjEj9MOD + "].", yIOTriJd);
							} finally {
								IOUtils.closeQuietly(BUZk7Yh3);
							}
						}
					}
				} else {
					nbOo4PTo.doFilter(QNB2slir, SzXFEaZR);
				}
			} else {
				nbOo4PTo.doFilter(QNB2slir, SzXFEaZR);
			}
		} else {
			nbOo4PTo.doFilter(QNB2slir, SzXFEaZR);
		}
	}

}