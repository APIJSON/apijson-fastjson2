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

import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;


/**APIJSON相关创建器
 * @author Lemon
 */
public class APIJSONCreator<T> extends apijson.framework.javax.APIJSONCreator<T, JSONObject, JSONArray>{

	@Override
	public APIJSONParser<T> createParser() {
		return new APIJSONParser<>();
	}

	@Override
	public APIJSONFunctionParser<T> createFunctionParser() {
		return new APIJSONFunctionParser<>();
	}

	@Override
	public APIJSONVerifier<T> createVerifier() {
		return new APIJSONVerifier<>();
	}
	
	@Override
	public APIJSONSQLConfig<T> createSQLConfig() {
		return new APIJSONSQLConfig<>();
	}

	@Override
	public APIJSONSQLExecutor<T> createSQLExecutor() {
		return new APIJSONSQLExecutor<>();
	}

}
