class n12512647 {
	@Override
	public void process(HttpServletRequest ViuSiXsC, HttpServletResponse tpWA369L) throws Exception {
		String TEBHIYRF = processUserAgent(ViuSiXsC);
		final LiwenxRequest rBFmIyp7 = new LiwenxRequestImpl(ViuSiXsC, tpWA369L, messageSource, TEBHIYRF);
		Locator MGKLmJSW = router.route(rBFmIyp7);
		if (MGKLmJSW instanceof RedirectLocator) {
			tpWA369L.sendRedirect(((RedirectLocator) MGKLmJSW).getPage());
		} else {
			((AbstractLiwenxRequest) rBFmIyp7).setRequestedLocator(MGKLmJSW);
			try {
				LiwenxResponse lS1S7pBa = processPage(rBFmIyp7, rBFmIyp7.getRequestedLocator(), maxRedirections);
				processHeaders(lS1S7pBa, tpWA369L);
				processCookies(lS1S7pBa, tpWA369L);
				if (lS1S7pBa instanceof ExternalRedirectionResponse) {
					tpWA369L.sendRedirect(((ExternalRedirectionResponse) lS1S7pBa).getRedirectTo());
				} else if (lS1S7pBa instanceof BinaryResponse) {
					BinaryResponse fShvnPry = (BinaryResponse) lS1S7pBa;
					tpWA369L.setContentType(fShvnPry.getMimeType().toString());
					IOUtils.copy(fShvnPry.getInputStream(), tpWA369L.getOutputStream());
				} else if (lS1S7pBa instanceof XmlResponse) {
					final Element roiX97mh = ((XmlResponse) lS1S7pBa).getXml();
					Document NX2hJr7s = roiX97mh.getDocument();
					if (NX2hJr7s == null) {
						NX2hJr7s = new Document(roiX97mh);
					}
					final Locator li5C8yx0 = rBFmIyp7.getCurrentLocator();
					final Device r4pR8g2r = li5C8yx0.getDevice();
					tpWA369L.setContentType(calculateContentType(r4pR8g2r));
					tpWA369L.setCharacterEncoding(encoding);
					if (r4pR8g2r == Device.HTML) {
						view.processView(NX2hJr7s, li5C8yx0.getLocale(), TEBHIYRF, tpWA369L.getWriter());
					} else {
						Serializer RabrORux = new Serializer(tpWA369L.getOutputStream(), encoding);
						RabrORux.write(NX2hJr7s);
					}
				}
			} catch (PageNotFoundException RE7BmIvz) {
				tpWA369L.sendError(HttpServletResponse.SC_NOT_FOUND);
			} catch (TooManyRedirectionsException RLh8Jabx) {
				throw RLh8Jabx;
			} catch (Exception Tw8A8HnW) {
				throw Tw8A8HnW;
			}
		}
	}

}