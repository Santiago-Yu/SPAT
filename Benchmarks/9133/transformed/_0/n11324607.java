class n11324607 {
	@Override
	@Transactional
	public FileData store(FileData i1KW7yiU, InputStream KlyI8UMm) {
		try {
			FileData Vi9rmmev = save(i1KW7yiU);
			Vi9rmmev.setPath(Vi9rmmev.getGroup() + File.separator + Vi9rmmev.getId());
			Vi9rmmev = save(Vi9rmmev);
			File Xscmorlg = new File(PATH, Vi9rmmev.getGroup());
			if (!Xscmorlg.exists())
				Xscmorlg.mkdirs();
			File KDw1osJa = new File(Xscmorlg, Vi9rmmev.getId() + "");
			IOUtils.copyLarge(KlyI8UMm, new FileOutputStream(KDw1osJa));
			return Vi9rmmev;
		} catch (IOException XEd5dx4u) {
			throw new ServiceException("storage", XEd5dx4u);
		}
	}

}