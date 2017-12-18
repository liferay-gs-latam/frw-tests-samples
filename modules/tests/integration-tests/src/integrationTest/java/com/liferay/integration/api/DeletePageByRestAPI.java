package com.liferay.integration.api;

import java.util.List;

import org.apache.http.NameValuePair;

import com.liferay.integration.utils.CommonMethods;

public class DeletePageByRestAPI {

	CommonMethods commonMethods = new CommonMethods();

	public String deletePage(IPageParametersByRestAPI pageParameters) throws Exception {

		List<NameValuePair> params = commonMethods.commonApiParams(pageParameters.getGroupID(),
				pageParameters.getIsPrivatePage(), pageParameters.getLayoutId());

		commonMethods.executePost("/api/jsonws/layout/delete-layout", params);
		
		return commonMethods.getMyObj().toString();
	}

}
