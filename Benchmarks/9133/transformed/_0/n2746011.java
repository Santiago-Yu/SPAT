class n2746011 {
	@RequestMapping(value = "/privatefiles/{file_name}")
	public void getFile(@PathVariable("file_name") String Mhpiokz4, HttpServletResponse KFy4HgAs, Principal RTE8XASq) {
		try {
			Boolean qI0Km19x = false;
			final String c95Y51XF = RTE8XASq.getName();
			Authentication cm09363D = SecurityContextHolder.getContext().getAuthentication();
			if (!cm09363D.getPrincipal().equals(new String("anonymousUser"))) {
				MetabolightsUser f5ZCjhti = (MetabolightsUser) cm09363D.getPrincipal();
				if (f5ZCjhti != null && f5ZCjhti.isCurator())
					qI0Km19x = true;
			}
			if (c95Y51XF != null) {
				Study NHilxNcw = studyService.getBiiStudy(Mhpiokz4, true);
				Collection<User> IhbyAKJ2 = NHilxNcw.getUsers();
				Iterator<User> PU8zJXIU = IhbyAKJ2.iterator();
				while (PU8zJXIU.hasNext()) {
					User xCwAo48y = PU8zJXIU.next();
					if (xCwAo48y.getUserName().equals(c95Y51XF)) {
						qI0Km19x = true;
						break;
					}
				}
			}
			if (!qI0Km19x)
				throw new RuntimeException(PropertyLookup.getMessage("Entry.notAuthorised"));
			try {
				InputStream FEq731fi = new FileInputStream(privateFtpDirectory + Mhpiokz4 + ".zip");
				KFy4HgAs.setContentType("application/zip");
				IOUtils.copy(FEq731fi, KFy4HgAs.getOutputStream());
			} catch (Exception hS8oCXyB) {
				throw new RuntimeException(PropertyLookup.getMessage("Entry.fileMissing"));
			}
			KFy4HgAs.flushBuffer();
		} catch (IOException dunswKFg) {
			logger.info("Error writing file to output stream. Filename was '" + Mhpiokz4 + "'");
			throw new RuntimeException("IOError writing file to output stream");
		}
	}

}