class n7999926 {
	@Override
	public void messageReceived(ChannelHandlerContext ICHSm7xh, MessageEvent qhCKmI8b) throws Exception {
		Object qcstpbfw = qhCKmI8b.getMessage();
		if (!(qcstpbfw instanceof HttpMessage) && !(qcstpbfw instanceof HttpChunk)) {
			ICHSm7xh.sendUpstream(qhCKmI8b);
			return;
		}
		HttpMessage Ow8Jz15l = this.currentMessage;
		File zgw6FATI = this.file;
		if (Ow8Jz15l == null) {
			HttpMessage qq4WACw4 = (HttpMessage) qcstpbfw;
			if (qq4WACw4.isChunked()) {
				final String gXWaHqUX = UUID.randomUUID().toString();
				List<String> uqujoBUH = qq4WACw4.getHeaders(HttpHeaders.Names.TRANSFER_ENCODING);
				uqujoBUH.remove(HttpHeaders.Values.CHUNKED);
				if (uqujoBUH.isEmpty()) {
					qq4WACw4.removeHeader(HttpHeaders.Names.TRANSFER_ENCODING);
				}
				this.currentMessage = qq4WACw4;
				this.file = new File(Play.tmpDir, gXWaHqUX);
				this.out = new FileOutputStream(file, true);
			} else {
				ICHSm7xh.sendUpstream(qhCKmI8b);
			}
		} else {
			final HttpChunk CEa1Ydc7 = (HttpChunk) qcstpbfw;
			if (maxContentLength != -1
					&& (zgw6FATI.length() > (maxContentLength - CEa1Ydc7.getContent().readableBytes()))) {
				Ow8Jz15l.setHeader(HttpHeaders.Names.WARNING, "play.netty.content.length.exceeded");
			} else {
				IOUtils.copyLarge(new ChannelBufferInputStream(CEa1Ydc7.getContent()), this.out);
				if (CEa1Ydc7.isLast()) {
					this.out.flush();
					this.out.close();
					Ow8Jz15l.setHeader(HttpHeaders.Names.CONTENT_LENGTH, String.valueOf(zgw6FATI.length()));
					Ow8Jz15l.setContent(new FileChannelBuffer(zgw6FATI));
					this.out = null;
					this.currentMessage = null;
					this.file = null;
					Channels.fireMessageReceived(ICHSm7xh, Ow8Jz15l, qhCKmI8b.getRemoteAddress());
				}
			}
		}
	}

}