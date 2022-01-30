package com.wangjingya.tool;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Locale;

/**
 * Hello world!
 *
 */
public class Clipper
{
    public static void main( String[] args )
    {
        if(args.length < 1){
            System.out.println("格式不对,正确格式为：");
            System.out.println("样例1：java com.wangjingya.tool.app 10");
            System.out.println("样例2：java com.wangjingya.tool.app 10 10");
            System.out.println("参数中数字分别为需要裁剪掉宽度和高度的像素值");
            return;
        }

        int clipPixWidth ;
        int clipPixHeight ;

        if(args.length == 1){
            clipPixWidth = Integer.parseInt(args[0]);
            clipPixHeight = Integer.parseInt(args[0]);
        }else{
            clipPixWidth = Integer.parseInt(args[0]);
            clipPixHeight = Integer.parseInt(args[1]);
        }

        File dir = new File(".");
        Clipper.clip(dir,clipPixWidth,clipPixHeight);

    }

    /**
     *
     * @param dir 需要扫描图片的目录
     * @param clipPixWidth 裁剪掉的宽度像素
     * @param clipPixHeight 裁剪掉的高度像素
     */
    public static void clip(File dir,int clipPixWidth,int clipPixHeight){
        File[] fileList = dir.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                name = name.toUpperCase(Locale.ROOT);
                return (name.contains("PNG"))||(name.contains("JPG"));
            }
        });
        int i = 0;
        if(fileList!=null){
            for (File file:fileList) {
                int oldHeight,oldWidth;
                int newHeight,newWidth;
                try {
                    BufferedImage bufImage = ImageIO.read(file);
                    oldHeight = bufImage.getHeight();
                    oldWidth = bufImage.getWidth();
                    System.out.println(file.getName());
                    System.out.println("old width:" + oldWidth);
                    System.out.println("old height:" + oldHeight);

                    newWidth = oldWidth - 2 * clipPixWidth;
                    newHeight = oldHeight - 2 * clipPixHeight;

                    BufferedImage newFile  = bufImage.getSubimage(clipPixWidth,clipPixHeight,newWidth,newHeight);
                    System.out.println("new width:" + newFile.getWidth());
                    System.out.println("new height:" + newFile.getHeight());

                    ImageIO.write(newFile,"PNG",file);
                    System.out.println("--------------");
                    i ++;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("total files: " + i);
        }else {
            System.out.println("no 'png' or 'jpg' files be found.");
        }

    }
}
