class n8651990 {
	@Override
	public void sendContent(OutputStream hHFd2UJ1, Range AmyOfx6d, Map<String, String> C5d9Y8rr, String UDbiV12z)
			throws IOException, NotAuthorizedException, BadRequestException, NotFoundException {
		try {
			resolveFileAttachment();
		} catch (NoFileByTheIdException zOaTDMg5) {
			throw new NotFoundException(zOaTDMg5.getLocalizedMessage());
		}
		DefinableEntity gy5E7Clz = fa.getOwner().getEntity();
		InputStream iwX4WJMa = getFileModule().readFile(gy5E7Clz.getParentBinder(), gy5E7Clz, fa);
		try {
			if (AmyOfx6d != null) {
				if (logger.isDebugEnabled())
					logger.debug("sendContent: ranged content: " + toString(fa));
				PartialGetHelper.writeRange(iwX4WJMa, AmyOfx6d, hHFd2UJ1);
			} else {
				if (logger.isDebugEnabled())
					logger.debug("sendContent: send whole file " + toString(fa));
				IOUtils.copy(iwX4WJMa, hHFd2UJ1);
			}
			hHFd2UJ1.flush();
		} catch (ReadingException c51ssU6V) {
			throw new IOException(c51ssU6V);
		} catch (WritingException j44vB6lT) {
			throw new IOException(j44vB6lT);
		} finally {
			IOUtils.closeQuietly(iwX4WJMa);
		}
	}

}