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
import apijson.framework.javax.APIJSONCreator;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.alibaba.fastjson2.JSONWriter;

import java.util.List;
import java.util.Map;

/**启动入口 Application
 * 调用 APIJSONApplication.init
 * @author Lemon
 */
public class APIJSONApplication extends apijson.framework.javax.APIJSONApplication {

    //static {
    //    apijson.JSON.DEFAULT_JSON_PARSER = JSON.DEFAULT_JSON_PARSER; // 解决 DEFAULT_JSON_PARSER 初始化前就自测导致抛异常
    //}

    static {
        JSON.DEFAULT_JSON_PARSER = new JSONParser() {
            @Override
            public JSONObject createJSONObject() {
                return JSONParser.super.createJSONObject();
            }

            @Override
            public JSONArray createJSONArray() {
                return JSONParser.super.createJSONArray();
            }

            @Override
            public String toJSONString(Object obj, boolean format) {
                if (obj instanceof String) {
                    if (! format) {
                        return (String) obj;
                    }

                    obj = com.alibaba.fastjson2.JSON.parseObject((String) obj);
                }

                if (format) {
                    return com.alibaba.fastjson2.JSON.toJSONString(obj, JSONWriter.Feature.PrettyFormat);
                }

                return com.alibaba.fastjson2.JSON.toJSONString(obj);
            }

            @Override
            public Object parse(Object json) {
                return com.alibaba.fastjson2.JSON.parse(toJSONString(json));
            }

            @Override
            public JSONObject parseObject(Object json) {
                return com.alibaba.fastjson2.JSON.parseObject(toJSONString(json));
            }

            @Override
            public <T> T parseObject(Object json, Class<T> clazz) {
                return com.alibaba.fastjson2.JSON.parseObject(toJSONString(json), clazz);
            }

            @Override
            public JSONArray parseArray(Object json) {
                return com.alibaba.fastjson2.JSON.parseArray(toJSONString(json));
            }

            @Override
            public <T> List<T> parseArray(Object json, Class<T> clazz) {
                return com.alibaba.fastjson2.JSON.parseArray(toJSONString(json), clazz);
            }
        };
    }


    //public static <T> APIJSONParser<T> createParser() {
    //    return (APIJSONParser<T>) DEFAULT_APIJSON_CREATOR.createParser();
    //}

    /**初始化，加载所有配置并校验
     * @return
     * @throws Exception
     */
    public static void init() throws Exception {
        init(true, DEFAULT_APIJSON_CREATOR);
    }
    /**初始化，加载所有配置并校验
     * @param shutdownWhenServerError
     * @return
     * @throws Exception
     */
    public static void init(boolean shutdownWhenServerError) throws Exception {
        init(shutdownWhenServerError, DEFAULT_APIJSON_CREATOR);
    }
    /**初始化，加载所有配置并校验
     * @param creator
     * @return
     * @throws Exception
     */
    public static <T, M extends Map<String, Object>, L extends List<Object>> void init(
            @NotNull APIJSONCreator<T, M, L> creator) throws Exception {
        init(true, creator);
    }
    /**初始化，加载所有配置并校验
     * @param shutdownWhenServerError
     * @param creator
     * @return
     * @throws Exception
     */
    public static <T, M extends Map<String, Object>, L extends List<Object>> void init(
            boolean shutdownWhenServerError, @NotNull APIJSONCreator<T, M, L> creator) throws Exception {
        apijson.framework.javax.APIJSONApplication.init(shutdownWhenServerError, creator);
    }

}
