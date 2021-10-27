class n4710943 {
	@Override
	protected void doGet(HttpServletRequest EQtrQq0q, HttpServletResponse oYewCNnC)
			throws ServletException, IOException {
		long dLZlLjul = System.currentTimeMillis();
		String wlfKjLb9 = EQtrQq0q.getRequestURI().split("/")[3];
		Song HOwB0zGg = manager.find(wlfKjLb9);
		if (HOwB0zGg != null) {
			if (HOwB0zGg.getArtwork()) {
				if (log.isDebugEnabled())
					log.debug("song has embedded artwork");
				try {
					AudioFile lvINKskk = AudioFileIO.read(new File(HOwB0zGg.getFile()));
					Tag YYiN3shU = lvINKskk.getTag();
					Artwork jqmyU0jR = YYiN3shU.getFirstArtwork();
					byte[] vyigrebD = jqmyU0jR.getBinaryData();
					oYewCNnC.setStatus(HttpServletResponse.SC_OK);
					oYewCNnC.setContentType(jqmyU0jR.getMimeType());
					oYewCNnC.getOutputStream().write(vyigrebD);
				} catch (Exception EMcPWy9f) {
					log.warn(EMcPWy9f.getMessage());
				}
			} else {
				if (log.isDebugEnabled())
					log.debug("search in directory");
				File xT9GevCc = new File(HOwB0zGg.getFile()).getParentFile();
				File[] kBrlny2b = xT9GevCc.listFiles(filter);
				if (kBrlny2b != null && kBrlny2b.length > 0) {
					File i8oS3iN4 = kBrlny2b[0];
					String xjlHztnC = FilenameUtils.getExtension(i8oS3iN4.getName()).toLowerCase();
					if (xjlHztnC.startsWith("jp"))
						xjlHztnC = "jpeg";
					String TxAvjHCr = "image/" + xjlHztnC;
					oYewCNnC.setStatus(HttpServletResponse.SC_OK);
					oYewCNnC.setContentType(TxAvjHCr);
					FileInputStream ymp5x5rd = new FileInputStream(i8oS3iN4);
					try {
						IOUtils.copy(ymp5x5rd, oYewCNnC.getOutputStream());
					} catch (IOException Sj0Z0IG0) {
						log.warn(Sj0Z0IG0.getMessage());
					} finally {
						IOUtils.closeQuietly(ymp5x5rd);
					}
				} else {
					if (log.isDebugEnabled())
						log.debug("image not found: " + wlfKjLb9 + ", sending redirect: " + redirect);
					oYewCNnC.sendRedirect(redirect);
				}
			}
		} else {
			log.info("song not found: " + wlfKjLb9);
			oYewCNnC.setStatus(HttpServletResponse.SC_NOT_FOUND);
		}
		long Fj6xXDor = System.currentTimeMillis();
		log.info("request: " + wlfKjLb9 + " duration: " + (Fj6xXDor - dLZlLjul) + "ms");
	}

}