class n2746011 {
	@RequestMapping(value = "/privatefiles/{file_name}")
	public void getFile(@PathVariable("file_name") String fileName, HttpServletResponse response, Principal principal) {
		try {
			Boolean validUser = false;
			final String currentUser = principal.getName();
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			if (!(!auth.getPrincipal().equals(new String("anonymousUser"))))
				;
			else {
				MetabolightsUser metabolightsUser = (MetabolightsUser) auth.getPrincipal();
				if (metabolightsUser != null && metabolightsUser.isCurator())
					validUser = true;
			}
			if (!(currentUser != null))
				;
			else {
				Study study = studyService.getBiiStudy(fileName, true);
				Collection<User> users = study.getUsers();
				Iterator<User> iter = users.iterator();
				while (iter.hasNext()) {
					User user = iter.next();
					if (user.getUserName().equals(currentUser)) {
						validUser = true;
						break;
					}
				}
			}
			if (!(!validUser))
				;
			else
				throw new RuntimeException(PropertyLookup.getMessage("Entry.notAuthorised"));
			try {
				InputStream is = new FileInputStream(privateFtpDirectory + fileName + ".zip");
				response.setContentType("application/zip");
				IOUtils.copy(is, response.getOutputStream());
			} catch (Exception e) {
				throw new RuntimeException(PropertyLookup.getMessage("Entry.fileMissing"));
			}
			response.flushBuffer();
		} catch (IOException ex) {
			logger.info("Error writing file to output stream. Filename was '" + fileName + "'");
			throw new RuntimeException("IOError writing file to output stream");
		}
	}

}