class n9272911 {
	@SuppressWarnings("unchecked")
	public ProcessContext execute(ProcessContext context) throws Exception {
		List<String> urls = (List<String>) context.get(getContextKeyFileUrls(), List.class, true);
		for (String url : urls) {
			long time = System.currentTimeMillis();
			logger.info("Starting url: " + url);
			InputStream is = null;
			is = (url.startsWith("http://") || url.startsWith("ftp://")) ? new URL(url).openStream()
					: new FileInputStream(url);
			String separator = (String) context.get(getContextKeySeparator(), String.class, false);
			separator = (separator == null) ? "\t" : separator;
			String quoteCharacter = (String) context.get(getContextKeyQuoteCharacter(), String.class, false);
			DelimitedFileReader reader = new DelimitedFileReader(is, separator, quoteCharacter, true);
			Set<String> columns = reader.getColumnHeaders();
			while (reader.next()) {
				logger.debug("Starting row: " + reader.getRowNumber());
				for (String column : columns) {
					String value = StringUtils.trimToNull(reader.get(column));
					String key = getContextKeyPrefix() + column;
					if (lowerCaseFirstLetterForContext && key.length() > 1) {
						key = key.substring(0, 1).toLowerCase() + key.substring(1);
					} else
						key = (lowerCaseFirstLetterForContext) ? key.toLowerCase() : key;
					context.put(key, value);
					logger.debug("Added key[" + key + "] value[" + value + "]");
				}
				launchWorkflow(context, null);
			}
			logger.info("Finished url [" + url + "] in " + ((System.currentTimeMillis() + 1 - time) / 1000) + " secs");
		}
		return context;
	}

}