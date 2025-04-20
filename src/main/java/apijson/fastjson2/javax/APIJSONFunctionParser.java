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

package apijson.fastjson2.javax;

import apijson.NotNull;
import apijson.RequestMethod;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import javax.servlet.http.HttpSession;

/**可远程调用的函数类
 * @author Lemon
 */
public class APIJSONFunctionParser<T> extends apijson.framework.javax.APIJSONFunctionParser<T, JSONObject, JSONArray> {
	public static final String TAG = "APIJSONFunctionParser";

	public APIJSONFunctionParser() {
		this(null);
	}

	public APIJSONFunctionParser(HttpSession session) {
		this(null, null, 0, null, session);
	}

	public APIJSONFunctionParser(RequestMethod method, String tag, int version, JSONObject curObj, HttpSession session) {
		super(method, tag, version, curObj, session);
	}

	public APIJSONFunctionParser<T> setSession(HttpSession session) {
		super.setSession(session);
		return this;
	}

	public APIJSONFunctionParser<T> setMethod(RequestMethod method) {
		super.setMethod(method);
		return this;
	}

	public APIJSONFunctionParser<T> setTag(String tag) {
		super.setTag(tag);
		return this;
	}

	public APIJSONFunctionParser<T> setVersion(int version) {
		super.setVersion(version);
		return this;
	}


	// 必须重写以下方法，否则启动自检报错方法不存在

	@Override
	public JSONObject getFunctionDemo(@NotNull JSONObject curObj) {
		return super.getFunctionDemo(curObj);
	}

	@Override
	public String getFunctionDetail(@NotNull JSONObject curObj) {
		return super.getFunctionDetail(curObj);
	}

	@Override
	public double plus(@NotNull JSONObject curObj, String i0, String i1) {
		return super.plus(curObj, i0, i1);
	}

	@Override
	public double minus(@NotNull JSONObject curObj, String i0, String i1) {
		return super.minus(curObj, i0, i1);
	}

	@Override
	public double multiply(@NotNull JSONObject curObj, String i0, String i1) {
		return super.multiply(curObj, i0, i1);
	}

	@Override
	public double divide(@NotNull JSONObject curObj, String i0, String i1) {
		return super.divide(curObj, i0, i1);
	}

	@Override
	public double plus(@NotNull JSONObject curObj, Number n0, Number n1) {
		return super.plus(curObj, n0, n1);
	}

	@Override
	public double minus(@NotNull JSONObject curObj, Number n0, Number n1) {
		return super.minus(curObj, n0, n1);
	}

	@Override
	public double multiply(@NotNull JSONObject curObj, Number n0, Number n1) {
		return super.multiply(curObj, n0, n1);
	}

	@Override
	public double divide(@NotNull JSONObject curObj, Number n0, Number n1) {
		return super.divide(curObj, n0, n1);
	}

	@Override
	public boolean isArrayEmpty(@NotNull JSONObject curObj, String array) {
		return super.isArrayEmpty(curObj, array);
	}

	public boolean isObjectEmpty(@NotNull JSONObject curObj, String object) {
		return super.isObjectEmpty(curObj, object);
	}

	@Override
	public int countArray(@NotNull JSONObject curObj, String array) {
		return super.countArray(curObj, array);
	}

	@Override
	public int countObject(@NotNull JSONObject curObj, String object) {
		return super.countObject(curObj, object);
	}

	@Override
	public boolean isContain(JSONObject curObj, String array, String value) {
		return super.isContain(curObj, array, value);
	}

	@Override
	public boolean isContainKey(@NotNull JSONObject curObj, String object, String key) {
		return super.isContainKey(curObj, object, key);
	}

	@Override
	public boolean isContainValue(@NotNull JSONObject curObj, String object, String value) {
		return super.isContainValue(curObj, object, value);
	}

	@Override
	public Object getFromArray(@NotNull JSONObject curObj, String array, String position) {
		return super.getFromArray(curObj, array, position);
	}

	@Override
	public Object getFromObject(@NotNull JSONObject curObj, String object, String key) {
		return super.getFromObject(curObj, object, key);
	}

	//根据键移除值 <<<<<<<<<<<<<<<<<<<<<<<<<<<<<
	/**移除
	 ** @param curObj
	 * @param index 支持直接传数字，例如 getFromArray(array,0) ；或者引用当前对象的值，例如 "@position": 0, "result()": "getFromArray(array,@position)"
	 * @return
	 */
	@Override
	public Object removeIndex(@NotNull JSONObject curObj, String index) {
		return super.removeKey(curObj, index);
	}
	/**移除
	 * @param curObj
	 * @param key
	 * @return
	 */
	@Override
	public Object removeKey(@NotNull JSONObject curObj, String key) {
		return super.removeKey(curObj, key);
	}
	//根据键获取值 >>>>>>>>>>>>>>>>>>>>>>>>>>>>>



	//获取非基本类型对应基本类型的非空值 <<<<<<<<<<<<<<<<<<<<<<<<<<<<<
	/**获取非空值
	 * @param curObj
	 * @param value
	 * @return
	 */
	@Override
	public boolean booleanValue(@NotNull JSONObject curObj, String value) {
		return super.booleanValue(curObj, value);
	}
	/**获取非空值
	 * @param curObj
	 * @param value
	 * @return
	 */
	@Override
	public int intValue(@NotNull JSONObject curObj, String value) {
		return super.intValue(curObj, value);
	}
	/**获取非空值
	 * @param curObj
	 * @param value
	 * @return
	 */
	@Override
	public long longValue(@NotNull JSONObject curObj, String value) {
		return super.longValue(curObj, value);
	}
	/**获取非空值
	 * @param curObj
	 * @param value
	 * @return
	 */
	@Override
	public float floatValue(@NotNull JSONObject curObj, String value) {
		return super.floatValue(curObj, value);
	}
	/**获取非空值
	 * @param curObj
	 * @param value
	 * @return
	 */
	@Override
	public double doubleValue(@NotNull JSONObject curObj, String value) {
		return super.doubleValue(curObj, value);
	}
	//获取非基本类型对应基本类型的非空值 >>>>>>>>>>>>>>>>>>>>>>>>>>>>>

	@Override
	public Object getWithDefault(@NotNull JSONObject curObj, String value, String defaultValue) {
		return super.getWithDefault(curObj, value, defaultValue);
	}

}