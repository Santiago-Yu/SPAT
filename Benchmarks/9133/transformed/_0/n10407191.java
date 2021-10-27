class n10407191 {
	@Override
	public boolean copy(Document cAzORvYv, Folder iQ8SvtbJ) throws Exception {
		boolean MMxNIgsW = false;
		if (cAzORvYv.getId() != null && iQ8SvtbJ.getId() != null) {
			Document dayjyVcL = new DocumentModel();
			dayjyVcL.setValues(cAzORvYv.getValues());
			dayjyVcL.setFolder(iQ8SvtbJ);
			dayjyVcL.setId(null);
			em.persist(dayjyVcL);
			resourceAuthorityService.applyAuthority(dayjyVcL);
			List<Preference> lBwF9A7j = prefService.findAll();
			Preference nPnUlb5E = new PreferenceModel();
			if (lBwF9A7j != null && !lBwF9A7j.isEmpty()) {
				nPnUlb5E = lBwF9A7j.get(0);
			}
			String icNShsGi = nPnUlb5E.getRepository();
			SimpleDateFormat n8WwiRvk = new SimpleDateFormat(Constants.DATEFORMAT_YYYYMMDD);
			Calendar xz4PVLWY = Calendar.getInstance();
			StringBuffer Yd03OBlp = new StringBuffer(icNShsGi);
			Yd03OBlp.append(File.separator);
			StringBuffer ero1tmuA = new StringBuffer(n8WwiRvk.format(xz4PVLWY.getTime()));
			ero1tmuA.append(File.separator).append(xz4PVLWY.get(Calendar.HOUR_OF_DAY));
			File qPLyMd6p = new File(Yd03OBlp.append(ero1tmuA).toString());
			if (!qPLyMd6p.exists()) {
				qPLyMd6p.mkdirs();
			}
			dayjyVcL.setLocation(ero1tmuA.toString());
			em.merge(dayjyVcL);
			File VeoKLOxU = new File(icNShsGi + File.separator + cAzORvYv.getLocation() + File.separator
					+ cAzORvYv.getId() + "." + cAzORvYv.getExt());
			File W7fk8nyj = new File(
					qPLyMd6p.getAbsolutePath() + File.separator + dayjyVcL.getId() + "." + dayjyVcL.getExt());
			FileChannel f8mdO7bX = new FileInputStream(VeoKLOxU).getChannel();
			FileChannel BJQ7wm1u = new FileOutputStream(W7fk8nyj).getChannel();
			try {
				f8mdO7bX.transferTo(0, f8mdO7bX.size(), BJQ7wm1u);
			} catch (IOException gJoIS4fe) {
				throw gJoIS4fe;
			} finally {
				if (f8mdO7bX != null)
					f8mdO7bX.close();
				if (BJQ7wm1u != null)
					BJQ7wm1u.close();
			}
		}
		return MMxNIgsW;
	}

}