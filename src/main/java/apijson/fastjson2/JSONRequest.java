/*Copyright ©2025 APIJSON(https://github.com/APIJSON)

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.*/

package apijson.fastjson2;

import apijson.JSON;
import apijson.StringUtil;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;

import java.util.*;

/**JSONRequest for Server to replace apijson.JSONMap,
 * put JSON.parseObject(value) and not encode in public cases
 * @author Lemon
 * @see #put(String, Object)
 */
public class JSONRequest extends JSONObject implements apijson.JSONRequest<JSONObject, JSONArray> {

	public JSONRequest() {
		super();
	}
	/**
	 * encode = true
	 * {@link #JSONRequest(String, Object)}
	 * @param object
	 */
	public JSONRequest(Object object) {
		super();
		put(object);
	}
	/**
	 * @param name
	 * @param object
	 */
	public JSONRequest(String name, Object object) {
		super();
		put(name, object);
	}


	@Override
	public JSONRequest putsAll(Map<? extends String, ? extends Object> m) {
		putAll(m);
		return this;
	}

	/**
	 * @param value
	 * @return {@link #puts(String, Object)}
	 */
	@Override
	public JSONRequest puts(Object value) {
		put(value);
		return this;
	}
	/**
	 * @param key
	 * @param value
	 * @return this
	 * @see {@link #put(String, Object)}
	 */
	@Override
	public JSONRequest puts(String key, Object value) {
		put(key, value);
		return this;
	}


	/**自定义类型必须转为JSONObject或JSONArray，否则RequestParser解析不了
	 */
	@Override
	public Object put(String key, Object value) {
		if (value == null) {//  || key == null
			return null;
		}

        Object target = null;
        try {
            target = JSON.parse(value);
        } catch (Exception e) {
            // nothing
			e.printStackTrace();
        }
        //		if (target == null) { // "tag":"User" 报错
		//			return null;
		//		}
		return super.put(StringUtil.isNotEmpty(key, true) ? key : value.getClass().getSimpleName() //must handle key here
				, target == null ? value : target);
	}

	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}

	public static final String KEY_TAG = "tag";//只在最外层，最外层用JSONRequest
	public static final String KEY_VERSION = "version";//只在最外层，最外层用JSONRequest
	public static final String KEY_FORMAT = "format";//只在最外层，最外层用JSONRequest

	/**set "tag":tag in outermost layer
	 * for write operations
	 * @param tag
	 * @return
	 */
	public JSONRequest setTag(String tag) {
		return puts(KEY_TAG, tag);
	}

	/**set "version":version in outermost layer
	 * for target version of request
	 * @param version
	 * @return
	 */
	public JSONRequest setVersion(Integer version) {
		return puts(KEY_VERSION, version);
	}

	/**set "format":format in outermost layer
	 * for format APIJSON special keys to normal keys of response
	 * @param format
	 * @return
	 */
	public JSONRequest setFormat(Boolean format) {
		return puts(KEY_FORMAT, format);
	}


	//array object <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

	public static final int QUERY_TABLE = 0;
	public static final int QUERY_TOTAL = 1;
	public static final int QUERY_ALL = 2;

	public static final String QUERY_TABLE_STRING = "TABLE";
	public static final String QUERY_TOTAL_STRING = "TOTAL";
	public static final String QUERY_ALL_STRING = "ALL";

	public static final String SUBQUERY_RANGE_ALL = "ALL";
	public static final String SUBQUERY_RANGE_ANY = "ANY";

	public static final String KEY_QUERY = "query";
	public static final String KEY_COMPAT = "compat";
	public static final String KEY_COUNT = "count";
	public static final String KEY_PAGE = "page";
	public static final String KEY_JOIN = "join";
	public static final String KEY_SUBQUERY_RANGE = "range";
	public static final String KEY_SUBQUERY_FROM = "from";

	public static final List<String> ARRAY_KEY_LIST = new ArrayList<>(Arrays.asList(
			KEY_QUERY, KEY_COMPAT ,KEY_COUNT, KEY_PAGE, KEY_JOIN, KEY_SUBQUERY_RANGE, KEY_SUBQUERY_FROM
	));

	/**set what to query in Array layer
	 * @param query what need to query, Table,total,ALL?
	 * @return
	 * @see {@link #QUERY_TABLE}
	 * @see {@link #QUERY_TOTAL}
	 * @see {@link #QUERY_ALL}
	 */
	public JSONRequest setQuery(int query) {
		return puts(KEY_QUERY, query);
	}

	/**set maximum count of Tables to query in Array layer
	 * @param count <= 0 || >= max ? max : count
	 * @return
	 */
	public JSONRequest setCount(int count) {
		return puts(KEY_COUNT, count);
	}

	/**set page of Tables to query in Array layer
	 * @param page <= 0 ? 0 : page
	 * @return
	 */
	public JSONRequest setPage(int page) {
		return puts(KEY_PAGE, page);
	}

	/**set joins of Main Table and it's Vice Tables in Array layer
	 * @param joins "@/User/id@", "&/User/id@,>/Comment/momentId@" ...
	 * @return
	 */
	public JSONRequest setJoin(String... joins) {
		return setJson(this, StringUtil.get(joins));
	}

	public static <M extends Map<String, Object>> M setJson(M m, String... joins) {
		m.put(KEY_JSON, StringUtil.get(joins));
		return m;
	}

	/**set range for Subquery
	 * @param range
	 * @return
	 * @see {@link #SUBQUERY_RANGE_ALL}
	 * @see {@link #SUBQUERY_RANGE_ANY}
	 */
	public JSONRequest setSubqueryRange(String range) {
		return puts(KEY_SUBQUERY_RANGE, range);
	}

	/**set from for Subquery
	 * @param from
	 * @return
	 */
	public JSONRequest setSubqueryFrom(String from) {
		return puts(KEY_SUBQUERY_FROM, from);
	}

	//array object >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>


	/**create a parent JSONMap named KEY_ARRAY
	 * @param count
	 * @param page
	 * @return {@link #toArray(int, int)}
	 */
	public JSONRequest toArray(int count, int page) {
		return toArray(count, page, null);
	}

	/**create a parent JSONMap named name+KEY_ARRAY.
	 * @param count
	 * @param page
	 * @param name
	 * @return {name+KEY_ARRAY : this}. if needs to be put, use {@link #putsAll(Map<? extends String, ? extends Object>)} instead
	 */
	public JSONRequest toArray(int count, int page, String name) {
		return new JSONRequest(StringUtil.get(name) + KEY_ARRAY, this.setCount(count).setPage(page));
	}

}
