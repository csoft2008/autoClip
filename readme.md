# 自动裁剪工具 Clipper

实现将当前目录下的所有图片文件自动批量裁剪指定像素大小。

适合需要批量将图片例如边框裁剪掉等类似需求。

将直接在原文件上裁剪。原文件如果需要保留，请先备份。

## 使用方法
1. 样例1：java com.wangjingya.tool.Clipper 10，上下左右都各裁剪10像素
2. 样例2：java com.wangjingya.tool.Clipper 20 10，左右各裁剪20像素，上下各裁剪10像素

## 示例
### 命令
> D:\photo\> java com.wangjingya.tool.Clipper 10

### 效果
```text
第5页-2.PNG
old width:1080
old height:1376
new width:1060
new height:1356
--------------
第7页-3.PNG
old width:1080
old height:1369
new width:1060
new height:1349
--------------
第9页-4.PNG
old width:1080
old height:683
new width:1060
new height:663
--------------
total files: 3
```