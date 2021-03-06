/*
 * Copyright (c) 2005-2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.wso2.carbon.social.sql;

import com.google.gson.JsonObject;

import org.wso2.carbon.social.core.Activity;

public class SQLActivity implements Activity {
	private final JsonObject body;

	public SQLActivity(JsonObject body) {
		this.body = body;
	}

	@Override
	public String getId() {
		return null;
	}

	@Override
	public JsonObject getBody() {
		return this.body;
	}

	@Override
	public int getTimestamp() {
		return 0;
	}

	@Override
	public String getActorId() {
		return null;
	}

	@Override
	public String getTargetId() {
		return null;
	}

	@Override
	public int getLikeCount() {
		JsonObject likes = (JsonObject) this.body.get("likes");
		return likes.get("totalItems").getAsInt();
	}

	@Override
	public int getDislikeCount() {
		JsonObject dislikes = (JsonObject) this.body.get("dislikes");
		return dislikes.get("totalItems").getAsInt();
	}

	@Override
	public String getObjectType() {
		return null;
	}

	@Override
	public String getVerb() {
		return null;
	}

	@Override
	public int getRating() {
		return 0;
	}

	@Override
	public void setLikeCount(int likeCount) {
		JsonObject likes = (JsonObject) this.body.get("likes");
		likes.addProperty("totalItems", likeCount);
		
	}

	@Override
	public void setDislikeCount(int dislikeCount) {
		JsonObject dislikes = (JsonObject) this.body.get("dislikes");
		dislikes.addProperty("totalItems", dislikeCount);
		
	}
}
