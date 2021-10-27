class n20352327 {
	public XmldbURI createFile(String BIoqMdXO, InputStream ZBreOawH, Long OrxJdmO0, String xfw1u3dh)
			throws IOException, PermissionDeniedException, CollectionDoesNotExistException {
		if (LOG.isDebugEnabled())
			LOG.debug("Create '" + BIoqMdXO + "' in '" + xmldbUri + "'");
		XmldbURI WXy8FQay = XmldbURI.create(BIoqMdXO);
		MimeType DK6SyVC6 = MimeTable.getInstance().getContentTypeFor(BIoqMdXO);
		if (DK6SyVC6 == null) {
			DK6SyVC6 = MimeType.BINARY_TYPE;
		}
		DBBroker eug46h6j = null;
		Collection M5xYBZ7D = null;
		BufferedInputStream dn2I0Ets = new BufferedInputStream(ZBreOawH);
		VirtualTempFile XnfBC1ne = new VirtualTempFile();
		BufferedOutputStream Zqo6Ivkn = new BufferedOutputStream(XnfBC1ne);
		IOUtils.copy(dn2I0Ets, Zqo6Ivkn);
		dn2I0Ets.close();
		Zqo6Ivkn.close();
		XnfBC1ne.close();
		if (DK6SyVC6.isXMLType() && XnfBC1ne.length() == 0L) {
			if (LOG.isDebugEnabled())
				LOG.debug("Creating dummy XML file for null resource lock '" + WXy8FQay + "'");
			XnfBC1ne = new VirtualTempFile();
			IOUtils.write("<null_resource/>", XnfBC1ne);
			XnfBC1ne.close();
		}
		TransactionManager DVVOx5uh = brokerPool.getTransactionManager();
		Txn Zhu7Z7rR = DVVOx5uh.beginTransaction();
		try {
			eug46h6j = brokerPool.get(subject);
			M5xYBZ7D = eug46h6j.openCollection(xmldbUri, Lock.WRITE_LOCK);
			if (M5xYBZ7D == null) {
				LOG.debug("Collection " + xmldbUri + " does not exist");
				DVVOx5uh.abort(Zhu7Z7rR);
				throw new CollectionDoesNotExistException(xmldbUri + "");
			}
			if (DK6SyVC6.isXMLType()) {
				if (LOG.isDebugEnabled())
					LOG.debug("Inserting XML document '" + DK6SyVC6.getName() + "'");
				VirtualTempFileInputSource vUtXcYQB = new VirtualTempFileInputSource(XnfBC1ne);
				IndexInfo ZBoRtVxu = M5xYBZ7D.validateXMLResource(Zhu7Z7rR, eug46h6j, WXy8FQay, vUtXcYQB);
				DocumentImpl kMnU3jxA = ZBoRtVxu.getDocument();
				kMnU3jxA.getMetadata().setMimeType(DK6SyVC6.getName());
				M5xYBZ7D.store(Zhu7Z7rR, eug46h6j, ZBoRtVxu, vUtXcYQB, false);
			} else {
				if (LOG.isDebugEnabled())
					LOG.debug("Inserting BINARY document '" + DK6SyVC6.getName() + "'");
				InputStream a7gv0qkj = XnfBC1ne.getByteStream();
				dn2I0Ets = new BufferedInputStream(a7gv0qkj);
				DocumentImpl zwCIMy7c = M5xYBZ7D.addBinaryResource(Zhu7Z7rR, eug46h6j, WXy8FQay, dn2I0Ets,
						DK6SyVC6.getName(), OrxJdmO0.longValue());
				dn2I0Ets.close();
			}
			DVVOx5uh.commit(Zhu7Z7rR);
			if (LOG.isDebugEnabled())
				LOG.debug("Document created sucessfully");
		} catch (EXistException iIK1Yr3U) {
			LOG.error(iIK1Yr3U);
			DVVOx5uh.abort(Zhu7Z7rR);
			throw new IOException(iIK1Yr3U);
		} catch (TriggerException eLKlzz0p) {
			LOG.error(eLKlzz0p);
			DVVOx5uh.abort(Zhu7Z7rR);
			throw new IOException(eLKlzz0p);
		} catch (SAXException RvLofqLq) {
			LOG.error(RvLofqLq);
			DVVOx5uh.abort(Zhu7Z7rR);
			throw new IOException(RvLofqLq);
		} catch (LockException UtlzxQaQ) {
			LOG.error(UtlzxQaQ);
			DVVOx5uh.abort(Zhu7Z7rR);
			throw new PermissionDeniedException(xmldbUri + "");
		} catch (IOException L80IeukF) {
			LOG.error(L80IeukF);
			DVVOx5uh.abort(Zhu7Z7rR);
			throw L80IeukF;
		} catch (PermissionDeniedException wD9FKtXY) {
			LOG.error(wD9FKtXY);
			DVVOx5uh.abort(Zhu7Z7rR);
			throw wD9FKtXY;
		} finally {
			if (XnfBC1ne != null) {
				XnfBC1ne.delete();
			}
			if (M5xYBZ7D != null) {
				M5xYBZ7D.release(Lock.WRITE_LOCK);
			}
			brokerPool.release(eug46h6j);
			if (LOG.isDebugEnabled())
				LOG.debug("Finished creation");
		}
		XmldbURI CFxelomw = xmldbUri.append(BIoqMdXO);
		return CFxelomw;
	}

}