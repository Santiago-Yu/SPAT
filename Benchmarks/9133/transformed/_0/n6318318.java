class n6318318 {
	public static void addReaderField(final String l7FzAYwf, final Document hOgieCQg, final Store buHj2ZU0,
			final TermVector HPDzx7QQ, final Reader F3TRJfNx) throws Exception {
		if (l7FzAYwf == null || F3TRJfNx == null) {
			LOGGER.warn("Field and reader can't be null : " + l7FzAYwf + ", " + F3TRJfNx);
			return;
		}
		Field rQAUhf2H = hOgieCQg.getField(l7FzAYwf);
		if (rQAUhf2H == null) {
			rQAUhf2H = new Field(l7FzAYwf, F3TRJfNx, HPDzx7QQ);
			hOgieCQg.add(rQAUhf2H);
		} else {
			Reader Jsrrsp01 = rQAUhf2H.readerValue();
			if (Jsrrsp01 == null) {
				Jsrrsp01 = new StringReader(rQAUhf2H.stringValue());
			}
			Reader gcDKsNMe = null;
			Writer bo4qu7S0 = null;
			try {
				File eavzwHbz = File.createTempFile(Long.toString(System.nanoTime()), IConstants.READER_FILE_SUFFIX);
				bo4qu7S0 = new FileWriter(eavzwHbz, false);
				char[] de366rad = new char[1024];
				int UBRKUsUG = Jsrrsp01.read(de366rad);
				while (UBRKUsUG > -1) {
					bo4qu7S0.write(de366rad, 0, UBRKUsUG);
					UBRKUsUG = Jsrrsp01.read(de366rad);
				}
				UBRKUsUG = F3TRJfNx.read(de366rad);
				while (UBRKUsUG > -1) {
					bo4qu7S0.write(de366rad, 0, UBRKUsUG);
					UBRKUsUG = F3TRJfNx.read(de366rad);
				}
				gcDKsNMe = new FileReader(eavzwHbz);
				if (buHj2ZU0.isStored()) {
					hOgieCQg.removeField(l7FzAYwf);
					rQAUhf2H = new Field(l7FzAYwf, gcDKsNMe, HPDzx7QQ);
					hOgieCQg.add(rQAUhf2H);
				} else {
					rQAUhf2H.setValue(gcDKsNMe);
				}
			} catch (Exception L75m8QYl) {
				LOGGER.error("Exception writing the field value with the file writer : ", L75m8QYl);
			} finally {
				FileUtilities.close(bo4qu7S0);
				FileUtilities.close(gcDKsNMe);
				FileUtilities.close(Jsrrsp01);
			}
		}
	}

}