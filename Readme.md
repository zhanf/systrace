
1、clone Robust
2、修改 gradle 版本，修改 publish 到 mavenLocal()
3、两 Plugin 中 修改compile project(':autopatchbase') 为 compileOnly project(':autopatchbase')
4、替换 auto-patch-plugin 下 resources/libs/dx.jar 为本项目编译的 dx.jar (如 /Users/zhan/Library/Android/sdk/build-tools/29.0.3/lib)
5、分别上传 autopatchbase、auto-patch-plugin、gradle-plugin 到本地仓库（如 /Users/zhan/.m2/repository）
6、集成 参考 [美团 Robust 集成文档](https://github.com/Meituan-Dianping/Robust/blob/master/README-zh.md)