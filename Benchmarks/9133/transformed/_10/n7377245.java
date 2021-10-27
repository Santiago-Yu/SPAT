class n7377245 {
	public void write(HttpServletRequest req, HttpServletResponse res, Object bean) throws IntrospectionException,
			IllegalAccessException, NoSuchMethodException, InvocationTargetException, IOException {
		res.setContentType(contentType);
		final Object r;
		if (HttpRpcServer.HttpRpcOutput.class.isAssignableFrom(bean.getClass())) {
			HttpRpcServer.HttpRpcOutput output = (HttpRpcServer.HttpRpcOutput) bean;
			r = output.getResult();
		} else
			r = bean;
		if (r != null) {
			if (File.class.isAssignableFrom(r.getClass())) {
				InputStream in = null;
				File file = (File) r;
				try {
					in = new FileInputStream(file);
					IOUtils.copy(in, res.getOutputStream());
				} finally {
					if (in != null)
						in.close();
				}
			} else if (InputStream.class.isAssignableFrom(r.getClass())) {
				InputStream in = null;
				try {
					in = (InputStream) r;
					IOUtils.copy(in, res.getOutputStream());
				} finally {
					if (in != null)
						in.close();
				}
			} else if (XFile.class.isAssignableFrom(r.getClass())) {
				InputStream in = null;
				XFile file = (XFile) r;
				try {
					in = new XFileInputStream(file);
					IOUtils.copy(in, res.getOutputStream());
				} finally {
					if (in != null)
						in.close();
				}
			}
			res.getOutputStream().flush();
		}
	}

}