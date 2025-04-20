# apijson-fastjson2  [![](https://jitpack.io/v/APIJSON/apijson-fastjson2.svg)](https://jitpack.io/#APIJSON/apijson-fastjson2)
腾讯 [APIJSON](https://github.com/Tencent/APIJSON) 8.0.0+ 的 fastjson2 插件，简化使用。<br />
A fastjson2 plugin for Tencent [APIJSON](https://github.com/Tencent/APIJSON) 8.0.0+.<br />


## 添加依赖
## Add Dependency

### Maven
#### 1. 在 pom.xml 中添加 JitPack 仓库
#### 1. Add the JitPack repository to pom.xml
```xml
	<repositories>
		<repository>
		    <id>jitpack.io</id>
		    <url>https://jitpack.io</url>
		</repository>
	</repositories>
```

![image](https://user-images.githubusercontent.com/5738175/167263399-339dad4f-2884-461e-9781-f2de6d100340.png)

<br />

#### 2. 在 pom.xml 中添加 apijson-fastjson2 依赖
#### 2. Add the apijson-fastjson2 dependency to pom.xml
```xml
	<dependency>
	    <groupId>com.github.APIJSON</groupId>
	    <artifactId>apijson-fastjson2</artifactId>
	    <version>LATEST</version>
	</dependency>
```


<br />
<br />

### Gradle
#### 1. 在项目根目录 build.gradle 中最后添加 JitPack 仓库
#### 1. Add the JitPack repository in your root build.gradle at the end of repositories
```gradle
	allprojects {
		repositories {
			maven { url 'https://jitpack.io' }
		}
	}
```
<br />

#### 2. 在项目某个 module 目录(例如 `app`) build.gradle 中添加 apijson-fastjson2 依赖
#### 2. Add the apijson-fastjson2 dependency in one of your modules(such as `app`)
```gradle
	dependencies {
	        implementation 'com.github.APIJSON:apijson-fastjson2:latest'
	}
```

<br />
<br />

## 初始化
## Initialization

#### 1.把所有 apijson.framework 中的解析类都替换成 apijson.fastjson2 的
#### 1.Replace all apijson.framework classes to that of apijson.fastjson2 what have same names

```java
import apijson.fastjson2.APIJSONApplication; // apijson.framework.APIJSONApplication;
        
public class DemoApplication {
    public static void main(String[] args) {
        // ...
        APIJSONApplication.init();
        // ...
    }
}
```

```java
import apijson.fastjson2.APIJSONController; // apijson.framework.APIJSONController;

public class DemoController extends APIJSONController<Long> { // apijson.framework.APIJSONController<Long, JSONObject, JSONArray>
}
```

```java
import apijson.fastjson2.APIJSONParser; // apijson.framework.APIJSONParser;

public class DemoParser extends APIJSONParser<Long> { // apijson.framework.APIJSONParser<Long, JSONObject, JSONArray>
}
```

```java
import apijson.fastjson2.APIJSONObjectParser; // apijson.framework.APIJSONObjectParser;

public class DemoParser extends APIJSONObjectParser<Long> { // apijson.framework.APIJSONObjectParser<Long, JSONObject, JSONArray>
}
```


```java
import apijson.fastjson2.APIJSONFunctionParser; // apijson.framework.APIJSONFunctionParser;

public class DemoParser extends APIJSONFunctionParser<Long> { // apijson.framework.APIJSONFunctionParser<Long, JSONObject, JSONArray>
}
```


```java
import apijson.fastjson2.APIJSONVerifier; // apijson.framework.APIJSONVerifier;

public class DemoParser extends APIJSONVerifier<Long> { // apijson.framework.APIJSONVerifier<Long, JSONObject, JSONArray>
}
```


```java
import apijson.fastjson2.APIJSONSQLConfig; // apijson.framework.APIJSONSQLConfig;

public class DemoSQLConfig extends APIJSONSQLConfig<Long> { // apijson.framework.APIJSONSQLConfig<Long, JSONObject, JSONArray>
}
```

```java
import apijson.fastjson2.APIJSONSQLExecutor; // apijson.framework.APIJSONSQLExecutor;

public class DemoSQLExecutor extends APIJSONSQLExecutor<Long> { // apijson.framework.APIJSONSQLExecutor<Long, JSONObject, JSONArray>
}
```

...

<br />


参考 [APIJSONController](/src/main/java/apijson/fastjson2/APIJSONController.java) 的注释及 [APIJSONBoot](https://github.com/APIJSON/APIJSON-Demo/blob/master/APIJSON-Java-Server/APIJSONBoot) 的 [DemoController](https://github.com/APIJSON/APIJSON-Demo/blob/master/APIJSON-Java-Server/APIJSONBoot/src/main/java/apijson/boot/DemoController.java) 和 [DemoApplication](https://github.com/APIJSON/APIJSON-Demo/blob/master/APIJSON-Java-Server/APIJSONBoot/src/main/java/apijson/boot/DemoApplication.java) <br />

See document in [APIJSONController](/src/main/java/apijson/fastjson2/APIJSONController.java) and [DemoController](https://github.com/APIJSON/APIJSON-Demo/blob/master/APIJSON-Java-Server/APIJSONBoot/src/main/java/apijson/boot/DemoController.java), [DemoApplication](https://github.com/APIJSON/APIJSON-Demo/blob/master/APIJSON-Java-Server/APIJSONBoot/src/main/java/apijson/boot/DemoApplication.java)  in [APIJSONBoot](https://github.com/APIJSON/APIJSON-Demo/blob/master/APIJSON-Java-Server/APIJSONBoot)

<br />

<br />
有问题可以去 Tencent/APIJSON 提 issue <br />
https://github.com/Tencent/APIJSON/issues/36

<br /><br />

#### 点右上角 ⭐Star 支持一下，谢谢 ^_^
#### Please ⭐Star this project ^_^
https://github.com/APIJSON/apijson-fastjson2
