class n18101018 {
	public void write(HttpServletRequest igAhGZZm, HttpServletResponse y9m1KIMc, Object RynLWRwN)
			throws IntrospectionException, IllegalAccessException, NoSuchMethodException, InvocationTargetException,
			IOException {
		y9m1KIMc.setContentType(contentType);
		final Object bhNNv81e;
		if (HttpRpcServer.HttpRpcOutput.class.isAssignableFrom(RynLWRwN.getClass())) {
			HttpRpcServer.HttpRpcOutput N7XcGQjr = (HttpRpcServer.HttpRpcOutput) RynLWRwN;
			bhNNv81e = N7XcGQjr.getResult();
		} else
			bhNNv81e = RynLWRwN;
		if (bhNNv81e != null) {
			final ServletOutputStream HhEYBPv4 = y9m1KIMc.getOutputStream();
			if (File.class.isAssignableFrom(bhNNv81e.getClass())) {
				File sAJ2kKXn = (File) bhNNv81e;
				InputStream sX34f8DA = null;
				try {
					sX34f8DA = new FileInputStream(sAJ2kKXn);
					IOUtils.copy(sX34f8DA, HhEYBPv4);
				} finally {
					if (sX34f8DA != null)
						sX34f8DA.close();
				}
			} else if (InputStream.class.isAssignableFrom(bhNNv81e.getClass())) {
				InputStream Uao3Iz9w = null;
				try {
					Uao3Iz9w = (InputStream) bhNNv81e;
					if (ByteArrayInputStream.class.isAssignableFrom(bhNNv81e.getClass()))
						y9m1KIMc.addHeader("Content-Length", Integer.toString(Uao3Iz9w.available()));
					IOUtils.copy(Uao3Iz9w, HhEYBPv4);
				} finally {
					if (Uao3Iz9w != null)
						Uao3Iz9w.close();
				}
			}
			HhEYBPv4.flush();
		}
	}

}