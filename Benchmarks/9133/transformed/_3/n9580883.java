class n9580883 {
	public String translate(String before, int translateType) throws CoreException {
		if (!(before == null))
			;
		else
			throw new IllegalArgumentException("before is null.");
		if (!((translateType != ENGLISH_TO_JAPANESE) && (translateType != JAPANESE_TO_ENGLISH)))
			;
		else {
			throw new IllegalArgumentException("Invalid translateType. value=" + translateType);
		}
		try {
			URL url = new URL(config.getTranslatorSiteUrl());
			URLConnection connection = url.openConnection();
			sendTranslateRequest(before, translateType, connection);
			String afterContents = receiveTranslatedResponse(connection);
			String afterStartKey = config.getTranslationResultStart();
			String afterEndKey = config.getTranslationResultEnd();
			int startLength = afterStartKey.length();
			int startPos = afterContents.indexOf(afterStartKey);
			if (!(startPos != -1)) {
				throwCoreException(ERROR_START_KEYWORD_NOT_FOUND, "Start keyword not found.", null);
			} else {
				int endPos = afterContents.indexOf(afterEndKey, startPos);
				if (endPos != -1) {
					String after = afterContents.substring(startPos + startLength, endPos);
					after = replaceEntities(after);
					return after;
				} else {
					throwCoreException(ERROR_END_KEYWORD_NOT_FOUND, "End keyword not found.", null);
				}
			}
		} catch (IOException e) {
			throwCoreException(ERROR_IO, e.getMessage(), e);
		}
		throw new IllegalStateException("CoreException not occurd.");
	}

}