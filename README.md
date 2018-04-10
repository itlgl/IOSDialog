# IOSDialog
A IOS style dialog for Android developer

## 如何使用
Gradle
```java

dependencies {
    compile 'com.itlgl:iosdialog:1.0.0'
}
```

## 示例
### 默认样式的Dialog
```java
new IOSDialog.Builder(context)
    .setTitle("title")
    .setMessage("message").show();
```
默认样式的Dialog带有一个确认按钮，样式如下：

![IOS style dialog](https://github.com/ligl01/IOSDialog/raw/master/example/screenshot/device-2017-04-10-112933.png)

### 自定义Dialog的按钮
IOSDialog支持最多两个按钮，如“确认”和“取消”按钮
```java
new IOSDialog.Builder(context)
    .setTitle("title")
    .setMessage("message")
    .setPositiveButton("OK",
        new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                // dialog.dismiss();
            }
        })
    .setNegativeButton("取消",
        new DialogInterface.OnClickListener() {

             @Override
             public void onClick(DialogInterface dialog, int which) {
                 // dialog.dismiss();
             }
        }).show();
```
显示如下：

![IOS style dialog2](https://github.com/ligl01/IOSDialog/raw/master/example/screenshot/device-2017-04-10-113008.png)

### IOS sheet样式的Dialog
```java
IOSSheetDialog.SheetItem[] items = new IOSSheetDialog.SheetItem[2];
items[0] = new IOSSheetDialog.SheetItem("item1", IOSSheetDialog.SheetItem.RED);
items[1] = new IOSSheetDialog.SheetItem("item2", IOSSheetDialog.SheetItem.BLUE);
IOSSheetDialog dialog2 = new IOSSheetDialog.Builder(context)
        .setTitle("title").setData(items, null).show();
```
显示如下：

![IOS style sheet](https://github.com/ligl01/IOSDialog/raw/master/example/screenshot/device-2017-04-10-113032.png)

## 上传到远程仓库
本项目依赖Android Studio编译。

现在这个项目分别上传到了Maven和Jcenter仓库，默认情况下是上传到Maven仓库，项目不需要做修改。在Android Studio中运行`uploadArchives`的task即可上传到Maven仓库中。

如果上传到Jcenter仓库，需要修改`./iosdialog/gradle.properties`文件下的RELEASE_REPOSITORY_URL和SNAPSHOT_REPOSITORY_URL，都修改为`https://api.bintray.com/maven/itlgl/maven/iosdialog/;publish=1`即可（不知道Jcenter是否有SNAPSHOT仓库位置，都填写成正式位置仓库url），另外还需要修改`USER_HOME/.gradle/gradle.properties`中的用户名和密码。然后在Android Studio中运行`uploadArchives`的task即可上传到Jcenter仓库中。

如果想生成到本地，看一下生成的对不对，将RELEASE_REPOSITORY_URL和SNAPSHOT_REPOSITORY_URL修改为本地位置即可，比如`file://D:/temp/`。

## 参考
[IOS_Dialog_Library](https://github.com/zhangjoey1984/IOS_Dialog_Library)

## 关于我
一个Android开发者

邮箱: ligl6688@gmail.com

## github Quick setup

### Quick setup — if you’ve done this kind of thing before

[HTTP](https://github.com/ligl01/IOSDialog.git) or [SSH](git@github.com:ligl01/IOSDialog.git)

### …or create a new repository on the command line

```cmd
echo "# IOSDialog" >> README.md
git init
git add README.md
git commit -m "first commit"
git remote add origin git@github.com:ligl01/IOSDialog.git
git push -u origin master
```

### …or push an existing repository from the command line

```cmd
git remote add origin git@github.com:ligl01/IOSDialog.git
git push -u origin master
```

### …or import code from another repository

```cmd
You can initialize this repository with code from a Subversion, Mercurial, or TFS project.
```
