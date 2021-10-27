class n5879230 {
	public void loadFromInternet(boolean Gkx269kr) {
		if (!Gkx269kr && this.internetScoreGroupModel != null) {
			return;
		}
		loadingFlag = true;
		ProgressBar IBVUQDeM = (ProgressBar) this.activity.findViewById(R.id.settingProgressBar);
		IBVUQDeM.setVisibility(View.VISIBLE);
		final Timer PN4RMBmR = new Timer();
		final Handler yciQkZzr = new Handler() {

			@Override
			public void handleMessage(Message yCrpoNiG) {
				if (loadingFlag == false) {
					ProgressBar jIdcMeEj = (ProgressBar) BestScoreExpandableListAdapter.this.activity
							.findViewById(R.id.settingProgressBar);
					jIdcMeEj.setVisibility(View.INVISIBLE);
					PN4RMBmR.cancel();
				}
				super.handleMessage(yCrpoNiG);
			}
		};
		final TimerTask XWn5uGZr = new TimerTask() {

			@Override
			public void run() {
				Message kiBjOFhH = new Message();
				yciQkZzr.sendMessage(kiBjOFhH);
			}
		};
		PN4RMBmR.schedule(XWn5uGZr, 1, 50);
		String blnPqUdV = Constants.SERVER_URL + "/rollingcard.php?op=viewbestscore";
		HttpGet FmCVnYaR = new HttpGet(blnPqUdV);
		HttpClient B88HrlSr = new DefaultHttpClient();
		try {
			HttpResponse G74Enfvv = B88HrlSr.execute(FmCVnYaR);
			if (G74Enfvv.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				String qheu1WXA = EntityUtils.toString(G74Enfvv.getEntity());
				String[] zl4Wu94g = qheu1WXA.split(";");
				this.internetScoreGroupModel = new ScoreGroupModel();
				for (int t3O5bVJO = 0; t3O5bVJO < zl4Wu94g.length; t3O5bVJO++) {
					String[] ZaCBfGae = zl4Wu94g[t3O5bVJO].split("\\|");
					if (ZaCBfGae.length != 3) {
						continue;
					}
					ScoreItemModel mzGo5pQl = new ScoreItemModel(ZaCBfGae[0], ZaCBfGae[1], ZaCBfGae[2]);
					this.internetScoreGroupModel.addItem(mzGo5pQl);
				}
			}
		} catch (ClientProtocolException g0Z8RGcl) {
			this.internetScoreGroupModel = null;
			g0Z8RGcl.printStackTrace();
		} catch (IOException Lc6uvVAv) {
			this.internetScoreGroupModel = null;
			Lc6uvVAv.printStackTrace();
		}
		loadingFlag = false;
	}

}