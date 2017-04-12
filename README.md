# IOSDialog
A IOS style dialog for Android developer

## 如何使用
Gradle
```java
repositories {
    maven { url 'https://raw.githubusercontent.com/liguanliang2014/mvn-repo/master'}
}

dependencies {
    compile 'com.ligl:IOSDialog:1.0.0'
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

![IOS style dialog](https://github.com/liguanliang2014/IOSDialog/raw/master/example/screenshot/device-2017-04-10-112933.png)

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

![IOS style dialog2](https://github.com/liguanliang2014/IOSDialog/raw/master/example/screenshot/device-2017-04-10-113008.png)

### IOS sheet样式的Dialog
```java
IOSSheetDialog.SheetItem[] items = new IOSSheetDialog.SheetItem[2];
items[0] = new IOSSheetDialog.SheetItem("item1", IOSSheetDialog.SheetItem.RED);
items[1] = new IOSSheetDialog.SheetItem("item2", IOSSheetDialog.SheetItem.BLUE);
IOSSheetDialog dialog2 = new IOSSheetDialog.Builder(context)
        .setTitle("title").setData(items, null).show();
```
显示如下：

![IOS style sheet](https://github.com/liguanliang2014/IOSDialog/raw/master/example/screenshot/device-2017-04-10-113032.png)

## 导出maven包
本项目依赖Android Studio编译。

在Android Studio中打开terminal，跳转到library目录下，使用命令`gradle uploadArchives`即可导出maven包。

## 关于我
一个Android开发者

邮箱: ligl6688@gmail.com

## github Quick setup

### Quick setup — if you’ve done this kind of thing before

[HTTP](https://github.com/liguanliang2014/IOSDialog.git) or [SSH](git@github.com:liguanliang2014/IOSDialog.git)

### …or create a new repository on the command line

```cmd
echo "# IOSDialog" >> README.md
git init
git add README.md
git commit -m "first commit"
git remote add origin git@github.com:liguanliang2014/IOSDialog.git
git push -u origin master
```

### …or push an existing repository from the command line

```cmd
git remote add origin git@github.com:liguanliang2014/IOSDialog.git
git push -u origin master
```

### …or import code from another repository

```cmd
You can initialize this repository with code from a Subversion, Mercurial, or TFS project.
```