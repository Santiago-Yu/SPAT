class n15703302 {
	@HttpAction(name = "map.calibrate", method = { HttpAction.Method.post }, responseType = "text/plain", parameters = {
			@HttpParameter(name = "user"), @HttpParameter(name = "guid"), @HttpParameter(name = "uploadFile"),
			@HttpParameter(name = "mapUrl"), @HttpParameter(name = "mapSource"), @HttpParameter(name = "south"),
			@HttpParameter(name = "west"), @HttpParameter(name = "north"), @HttpParameter(name = "east") })
	@HttpAuthentication(method = { HttpAuthentication.Method.WSSE })
	public String calibrate(User flbjxBLy, String Bqvz9zMU, Collection<FileItem> As17MF2g, String mHzDNYHo,
			String YTAPF29j, String sU8YM6H9, String NaK82Lc5, String PpPCqTkN, String YMzeGupx)
			throws HttpRpcException {
		GenericDAO<UserMapOriginal> hLM50fuk = DAOFactory.createDAO(UserMapOriginal.class);
		try {
			TransactionManager.beginTransaction();
		} catch (Throwable fWyxhTro) {
			logger.error(fWyxhTro);
			return "FAIL";
		}
		try {
			final UserMapOriginal dMLjJPmu = hLM50fuk.findUniqueByCriteria(Expression.eq("guid", Bqvz9zMU));
			if (dMLjJPmu == null)
				throw new HttpRpcException(ErrorConstant.ERROR_NOT_FOUND, "map");
			if (UserMapOriginal.SubState.INPROC.equals(dMLjJPmu.getSubstate()))
				throw new HttpRpcException(ErrorConstant.ERROR_ILLEGAL_OBJECT_STATE, "map");
			if (UserMapOriginal.State.COMBINE.equals(dMLjJPmu.getState()))
				throw new HttpRpcException(ErrorConstant.ERROR_ILLEGAL_OBJECT_STATE, "map");
			if (!"download".equals(YTAPF29j) && !"upload".equals(YTAPF29j) && !"current".equals(YTAPF29j))
				throw new HttpRpcException(ErrorConstant.ERROR_INVALID_OBJECT, "mapSource");
			try {
				dMLjJPmu.setSWLat(Double.parseDouble(sU8YM6H9));
			} catch (Throwable NVBozjw8) {
				throw new HttpRpcException(ErrorConstant.ERROR_INVALID_OBJECT, "south");
			}
			try {
				dMLjJPmu.setSWLon(Double.parseDouble(NaK82Lc5));
			} catch (Throwable nWzzrYmn) {
				throw new HttpRpcException(ErrorConstant.ERROR_INVALID_OBJECT, "west");
			}
			try {
				dMLjJPmu.setNELat(Double.parseDouble(PpPCqTkN));
			} catch (Throwable uAKa3Y4p) {
				throw new HttpRpcException(ErrorConstant.ERROR_INVALID_OBJECT, "north");
			}
			try {
				dMLjJPmu.setNELon(Double.parseDouble(YMzeGupx));
			} catch (Throwable cHHtUYu0) {
				throw new HttpRpcException(ErrorConstant.ERROR_INVALID_OBJECT, "east");
			}
			dMLjJPmu.setState(UserMapOriginal.State.CALIBRATE);
			dMLjJPmu.setSubstate(UserMapOriginal.SubState.INPROC);
			final XFile cXFyhyFb = new XFile(new XFile(Configuration.getInstance().getPrivateMapStorage().toString()),
					dMLjJPmu.getGuid());
			cXFyhyFb.mkdir();
			if ("download".equals(YTAPF29j)) {
				final XFile h8L6Wkkj;
				final URI wsSgTO8t = new URI(mHzDNYHo);
				String lfVFHOVM = (StringUtils.isEmpty(wsSgTO8t.getQuery())) ? "?BBOX=" : "&BBOX=";
				lfVFHOVM += NaK82Lc5 + "," + sU8YM6H9 + "," + YMzeGupx + "," + PpPCqTkN;
				URLConnection F66Ac04A = (new URL(mHzDNYHo + lfVFHOVM)).openConnection();
				if (F66Ac04A == null || F66Ac04A.getContentLength() == 0)
					throw new HttpRpcException(ErrorConstant.ERROR_INVALID_RESOURCE, "mapUrl");
				if (!F66Ac04A.getContentType().startsWith("image/"))
					throw new HttpRpcException(ErrorConstant.ERROR_INVALID_OBJECT_TYPE, "mapUrl");
				h8L6Wkkj = new XFile(cXFyhyFb, dMLjJPmu.getGuid());
				XFileOutputStream IZ9GpZQ7 = new XFileOutputStream(h8L6Wkkj);
				IOUtils.copy(F66Ac04A.getInputStream(), IZ9GpZQ7);
				IZ9GpZQ7.flush();
				IZ9GpZQ7.close();
			} else if ("upload".equals(YTAPF29j)) {
				final XFile rSFrd4cM;
				final FileItem Ki7V9IRT = As17MF2g.iterator().next();
				if (Ki7V9IRT == null || Ki7V9IRT.getSize() == 0)
					throw new HttpRpcException(ErrorConstant.ERROR_INVALID_RESOURCE, "uploadFile");
				if (!Ki7V9IRT.getContentType().startsWith("image/"))
					throw new HttpRpcException(ErrorConstant.ERROR_INVALID_OBJECT_TYPE, "uploadFile");
				rSFrd4cM = new XFile(cXFyhyFb, dMLjJPmu.getGuid());
				XFileOutputStream h0P77lfs = new XFileOutputStream(rSFrd4cM);
				IOUtils.copy(Ki7V9IRT.getInputStream(), h0P77lfs);
				h0P77lfs.flush();
				h0P77lfs.close();
			} else if ("current".equals(YTAPF29j)) {
			}
			hLM50fuk.update(dMLjJPmu);
			TransactionManager.commitTransaction();
			try {
				PoolClientInterface ATNeMRwT = PoolFactory.getInstance().getClientPool();
				if (ATNeMRwT == null)
					throw ErrorConstant.EXCEPTION_INTERNAL;
				ATNeMRwT.put(dMLjJPmu, new StatesStack(new byte[] { 0x00, 0x18 }), GeneralCompleteStrategy.class);
			} catch (Throwable xTdhb4G8) {
				logger.error(xTdhb4G8);
			}
			return "SUCCESS";
		} catch (HttpRpcException TpUwCDT6) {
			TransactionManager.rollbackTransaction();
			logger.error(TpUwCDT6);
			return "FAIL";
		} catch (Throwable FQIQPK5f) {
			logger.error(FQIQPK5f);
			TransactionManager.rollbackTransaction();
			return "FAIL";
		}
	}

}