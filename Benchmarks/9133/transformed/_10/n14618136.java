class n14618136 {
	public void process(Group group, List resourcesName, List excludeResources, ServletContext servletContext,
			Writer out, String location) throws IOException {
		LOG.debug("Merging content of group : " + group.getName());
		for (Iterator iterator = group.getSubgroups().iterator(); iterator.hasNext();) {
			Group subGroup = (Group) iterator.next();
			ResourcesProcessor subGroupProcessor = null;
			String subLocation = subGroup.getBestLocation(location);
			if (subGroup.isMinimize() == null)
				subGroupProcessor = this;
			else
				subGroupProcessor = subGroup.getJSProcessor();
			subGroupProcessor.process(subGroup, subGroup.getJsNames(), excludeResources, servletContext, out,
					subLocation);
		}
		for (Iterator it = resourcesName.iterator(); it.hasNext();) {
			String path = (String) it.next();
			URL url = null;
			if (!excludeResources.contains(path)) {
				url = URLUtils.getLocalURL(path, servletContext);
				if (url == null) {
					String webPath = URLUtils.concatUrlWithSlaches(group.getBestLocation(location), path);
					url = URLUtils.getWebUrlResource(webPath);
				}
				InputStream in = null;
				if (url == null) {
					throw new IOException("The resources '" + path
							+ "' could not be found neither in the webapp folder nor in a jar");
				}
				try {
					in = url.openStream();
					IOUtils.copy(in, out, URLUtils.DEFAULT_ENCODING);
					out.write("\n\n");
				} catch (Exception e) {
					LOG.error("Merge failed for file " + path, e);
				} finally {
					if (in != null)
						in.close();
				}
				excludeResources.add(path);
			}
		}
	}

}