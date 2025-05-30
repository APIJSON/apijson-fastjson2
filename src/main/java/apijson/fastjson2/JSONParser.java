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


/**JSON 相关解析器
 * @author Lemon
 */
public interface JSONParser extends apijson.JSONParser<JSONObject, JSONArray> {
    default JSONObject createJSONObject() {
        return new JSONObject();
    }

    default JSONArray createJSONArray() {
        return new JSONArray();
    }
}
