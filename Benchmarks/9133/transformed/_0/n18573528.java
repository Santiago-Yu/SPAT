class n18573528 {
	public int process(ProcessorContext pBDm19aJ) throws InterruptedException, ProcessorException {
		logger.info("JAISaveTask:process");
		final RenderedOp EIuptYa2 = (RenderedOp) pBDm19aJ.get("RenderedOp");
		final String SwbI2tfX = "s3://s3.amazonaws.com/rssfetch/" + (new Guid());
		final PNGEncodeParam.RGB eAWZ59K2 = new PNGEncodeParam.RGB();
		eAWZ59K2.setTransparentRGB(new int[] { 0, 0, 0 });
		File zUTdJKdx = null;
		try {
			zUTdJKdx = File.createTempFile("thmb", ".png");
			OutputStream rPzYWkEV = new FileOutputStream(zUTdJKdx);
			final ParameterBlock Ru1WpnUw = (new ParameterBlock()).addSource(EIuptYa2).add(rPzYWkEV).add("png")
					.add(eAWZ59K2);
			JAI.create("encode", Ru1WpnUw, null);
			rPzYWkEV.flush();
			rPzYWkEV.close();
			FileInputStream vSjU4Cvu = new FileInputStream(zUTdJKdx);
			final XFile MG4NlEgH = new XFile(SwbI2tfX);
			final XFileOutputStream qgBmsIit = new XFileOutputStream(MG4NlEgH);
			final com.luzan.common.nfs.s3.XFileExtensionAccessor OdquKlMn = ((com.luzan.common.nfs.s3.XFileExtensionAccessor) MG4NlEgH
					.getExtensionAccessor());
			if (OdquKlMn != null) {
				OdquKlMn.setMimeType("image/png");
				OdquKlMn.setContentLength(zUTdJKdx.length());
			}
			IOUtils.copy(vSjU4Cvu, qgBmsIit);
			qgBmsIit.flush();
			qgBmsIit.close();
			vSjU4Cvu.close();
			pBDm19aJ.put("outputPath", SwbI2tfX);
		} catch (IOException PuKV8qFu) {
			logger.error(PuKV8qFu);
			throw new ProcessorException(PuKV8qFu);
		} catch (Throwable sXEEvUFG) {
			logger.error(sXEEvUFG);
			throw new ProcessorException(sXEEvUFG);
		} finally {
			if (zUTdJKdx != null && zUTdJKdx.exists()) {
				zUTdJKdx.delete();
			}
		}
		return TaskState.STATE_MO_START + TaskState.STATE_ENCODE;
	}

}