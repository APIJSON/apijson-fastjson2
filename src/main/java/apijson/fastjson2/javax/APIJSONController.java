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

import apijson.RequestMethod;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import javax.servlet.http.HttpSession;

/**APIJSON base controller，建议在子项目被 @RestController 注解的类继承它或通过它的实例调用相关方法
 * <br > 全通过 HTTP POST 来请求:
 * <br > 1.减少代码 - 客户端无需写 HTTP GET, HTTP PUT 等各种方式的请求代码
 * <br > 2.提高性能 - 无需 URL encode 和 decode
 * <br > 3.调试方便 - 建议使用 APIAuto-机器学习自动化接口管理工具(https://github.com/TommyLemon/APIAuto)
 * @author Lemon
 */
public class APIJSONController<T> extends apijson.framework.javax.APIJSONController<T, JSONObject, JSONArray> {
	public static final String TAG = "APIJSONController";

	@Override
	public APIJSONParser<T> newParser(HttpSession session, RequestMethod method) {
		return (APIJSONParser<T>) super.newParser(session, method);
	}

	//	public JSONMap listMethod(String request) {
//		if (Log.DEBUG == false) {
//			return APIJSONParser.newErrorResult(new IllegalAccessException("非 DEBUG 模式下不允许使用 UnitAuto 单元测试！"));
//		}
//		return MethodUtil.listMethod(request);
//	}
//
//	public void invokeMethod(String request, HttpServletRequest servletRequest) {
//		AsyncContext asyncContext = servletRequest.startAsync();
//
//		final boolean[] called = new boolean[] { false };
//		MethodUtil.Listener<JSONMap> listener = new MethodUtil.Listener<JSONMap>() {
//
//			@Override
//			public void complete(JSONMap data, Method method, InterfaceProxy proxy, Object... extras) throws Exception {
//
//				ServletResponse servletResponse = called[0] ? null : asyncContext.getResponse();
//				if (servletResponse == null) {  //  || servletResponse.isCommitted()) {  // isCommitted 在高并发时可能不准，导致写入多次
//                    			Log.w(TAG, "invokeMethod  listener.complete  servletResponse == null || servletResponse.isCommitted() >> return;");
//                    			return;
//				}
//				called[0] = true;
//
//				servletResponse.setCharacterEncoding(servletRequest.getCharacterEncoding());
//				servletResponse.setContentType(servletRequest.getContentType());
//				servletResponse.getWriter().println(data);
//				asyncContext.complete();
//			}
//		};
//
//		if (Log.DEBUG == false) {
//			try {
//				listener.complete(MethodUtil.JSON_CALLBACK.newErrorResult(new IllegalAccessException("非 DEBUG 模式下不允许使用 UnitAuto 单元测试！")));
//			}
//			catch (Exception e1) {
//				e1.printStackTrace();
//				asyncContext.complete();
//			}
//
//			return;
//		}
//
//
//		try {
//			MethodUtil.invokeMethod(request, null, listener);
//		}
//		catch (Exception e) {
//			Log.e(TAG, "invokeMethod  try { JSONMap req = JSON.parseObject(request); ... } catch (Exception e) { \n" + e.getMessage());
//			try {
//				listener.complete(MethodUtil.JSON_CALLBACK.newErrorResult(e));
//			}
//			catch (Exception e1) {
//				e1.printStackTrace();
//				asyncContext.complete();
//			}
//		}
//	}

}
