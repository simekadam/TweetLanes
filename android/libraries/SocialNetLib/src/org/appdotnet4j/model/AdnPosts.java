/*
 * Copyright (C) 2013 Chris Lacy
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.appdotnet4j.model;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;

public class AdnPosts {

	public ArrayList<AdnPost> mPosts;
	
	public AdnPosts(String jsonAsString) {
		
		mPosts = new ArrayList<AdnPost>();
		
		try {
			JSONArray jsonArray = new JSONArray(jsonAsString);
			for (int i = 0; i < jsonArray.length(); i++) {
				//JSONObject postObject = jsonArray.getJSONObject(i);
				String listString = jsonArray.getString(i);
				AdnPost post = new AdnPost(listString);
				if (post.mIsDeleted == false) {
					mPosts.add(post);
				}
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (mPosts.size() == 0) {
			mPosts = null;
		}
	}
	
}
