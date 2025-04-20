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

import apijson.RequestMethod;
import apijson.framework.APIJSONApplication;
import apijson.orm.AbstractSQLConfig;
import apijson.orm.Join;
import apijson.orm.SQLConfig;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;

import java.util.List;


/**SQL配置
 * TiDB 用法和 MySQL 一致
 * @author Lemon
 */
public class APIJSONSQLConfig<T> extends apijson.framework.APIJSONSQLConfig<T, JSONObject, JSONArray> {
	public static final String TAG = "APIJSONSQLConfig";

	static {
		SIMPLE_CALLBACK = new SimpleCallback<Object>() {};
	}


	public APIJSONSQLConfig() {
		this(RequestMethod.GET);
	}

	public APIJSONSQLConfig(RequestMethod method) {
		super(method);
	}

	public APIJSONSQLConfig(RequestMethod method, String table) {
		super(method, table);
	}

	public APIJSONSQLConfig(RequestMethod method, int count, int page) {
		super(method, count, page);
	}


	/**
	 * 获取SQL配置
	 *
	 * @param table
	 * @param alias
	 * @param request
	 * @param isProcedure
	 * @return
	 * @throws Exception
	 */
	public static <T> SQLConfig<T, JSONObject, JSONArray> newSQLConfig(
			RequestMethod method, String table, String alias, JSONObject request, List<Join<T
			, JSONObject, JSONArray>> joinList, boolean isProcedure) throws Exception {
		return newSQLConfig(method, table, alias, request, joinList, isProcedure, new SimpleCallback<T>() {});
	}

	public static class SimpleCallback<T> extends AbstractSQLConfig.SimpleCallback<T, JSONObject, JSONArray> {

		@Override
		public SQLConfig<T, JSONObject, JSONArray> getSQLConfig(RequestMethod method, String database, String schema
				, String datasource, String table) {
			SQLConfig<T, JSONObject, JSONArray> config = APIJSONApplication.createSQLConfig();
			config.setMethod(method);
			config.setDatabase(database);
			config.setDatasource(datasource);
			config.setSchema(schema);
			config.setTable(table);
			return config;
		}
	}
}