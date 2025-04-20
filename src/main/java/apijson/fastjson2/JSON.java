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

import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**JSON工具类 防止解析时异常
 * @author Lemon
 */
public class JSON extends apijson.JSON {
	//static {
	//	DEFAULT_JSON_PARSER = new JSONParser() {
	//		@Override
	//		public JSONObject createJSONObject() {
	//			return JSONParser.super.createJSONObject();
	//		}
	//
	//		@Override
	//		public JSONArray createJSONArray() {
	//			return JSONParser.super.createJSONArray();
	//		}
	//
	//		@Override
	//		public String toJSONString(Object obj, boolean format) {
	//			if (format) {
	//				return com.alibaba.fastjson2.JSON.toJSONString(obj, JSONWriter.Feature.PrettyFormat);
	//			}
	//			return com.alibaba.fastjson2.JSON.toJSONString(obj);
	//		}
	//
	//		@Override
	//		public Object parse(Object json) {
	//			return com.alibaba.fastjson2.JSON.parse(toJSONString(json));
	//		}
	//
	//		@Override
	//		public JSONObject parseObject(Object json) {
	//			return com.alibaba.fastjson2.JSON.parseObject(toJSONString(json));
	//		}
	//
	//		@Override
	//		public <T> T parseObject(Object json, Class<T> clazz) {
	//			return com.alibaba.fastjson2.JSON.parseObject(toJSONString(json), clazz);
	//		}
	//
	//		@Override
	//		public JSONArray parseArray(Object json) {
	//			return com.alibaba.fastjson2.JSON.parseArray(toJSONString(json));
	//		}
	//
	//		@Override
	//		public <T> List<T> parseArray(Object json, Class<T> clazz) {
	//			return com.alibaba.fastjson2.JSON.parseArray(toJSONString(json), clazz);
	//		}
	//	};
	//}

	public static JSONObject newJSONObject() {
		return apijson.JSON.createJSONObject();
	}
	public static JSONObject newJSONObject(String key, Object value) {
		return apijson.JSON.createJSONObject(key, value);
	}
	public static JSONObject newJSONObject(Map<? extends String, ?> map) {
		return apijson.JSON.createJSONObject(map);
	}

	public static JSONArray newJSONArray() {
		return apijson.JSON.createJSONArray();
	}
	public static JSONArray newJSONArray(Object obj) {
		return apijson.JSON.createJSONArray(obj);
	}
	public static JSONArray newJSONArray(Collection<?> list) {
		return apijson.JSON.createJSONArray(list);
	}


	/**
	 * @param json
	 * @return
	 */
	public static JSONObject parseObject(Object json) {
		return apijson.JSON.parseObject(json);
	}
	public static <T> T parseObject(Object json, Class<T> clazz) {
		return apijson.JSON.parseObject(json, clazz);
	}


	/**
	 * @param json
	 * @return
	 */
	public static JSONArray parseArray(Object json) {
		return apijson.JSON.parseArray(json);
	}
	public static <T> List<T> parseArray(Object json, Class<T> clazz) {
		return apijson.JSON.parseArray(json, clazz);
	}

	/**
	 * Get a value from a Map and convert to the specified type
	 * @param map Source map
	 * @param key The key
	 * @return The converted value
	 */
	@SuppressWarnings("unchecked")
	public static JSONObject gainJSONObject(Map<String, Object> map, String key) {
		return apijson.JSON.getJSONObject(map, key);
	}

	/**
	 * Get a value from a Map and convert to the specified type
	 * @param map Source map
	 * @param key The key
	 * @return The converted value
	 */
	@SuppressWarnings("unchecked")
	public static JSONArray gainJSONArray(Map<String, Object> map, String key) {
		Object obj = get(map, key);
		return apijson.JSON.getJSONArray(map, key);
	}

	@SuppressWarnings("unchecked")
	public static JSONObject gainJSONObject(List<Object> list, int index) {
		Object obj = get(list, index);
		return (JSONObject) obj;
	}

	@SuppressWarnings("unchecked")
	public static JSONArray gainJSONArray(List<Object> list, int index) {
		Object obj = get(list, index);
		return (JSONArray) obj;
	}

}
