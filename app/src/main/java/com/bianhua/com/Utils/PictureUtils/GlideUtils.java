package com.bianhua.com.Utils.PictureUtils;

import android.content.Context;
import android.widget.ImageView;

import com.bianhua.com.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;

/**
 * @author: lilingfei
 * @description:
 * @date: 2019/3/29
 */
public class GlideUtils {
    private GlideUtils() {
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    /**
     * 正常加载图片
     *
     * @param mContext
     * @param url
     * @param imageView
     */
    public static void loadImageCenterCrop(Context mContext, String url, ImageView imageView) {
        Glide.with(mContext)
                .load(url)
                .error(R.mipmap.no_img)
                .centerCrop()
                .into(imageView);
    }

    /**
     * 正常加载图片
     *
     * @param mContext
     * @param url
     * @param imageView
     */
    public static void loadImage(Context mContext, String url, ImageView imageView) {
        Glide.with(mContext)
                .load(url)
                .error(R.mipmap.no_img)
                .into(imageView);
    }

    /**
     * 加载头像
     *
     * @param mContext      上下文
     * @param url       获取到的头像
     * @param avatar        赋值的控件Id
     */
    public static void loadAvatar(Context mContext, String url, ImageView avatar) {
        if (mContext != null) {
            Glide.with(mContext)
                    .load(StringUtil.isEmpty(url) ? R.mipmap.no_img : url)
                    .error(R.mipmap.no_img)
                    .diskCacheStrategy(DiskCacheStrategy.NONE)//new CenterCrop(mContext)
                    .transform(new GlideCircleTransform(), new CenterCrop())
                    .into(avatar);
        }
    }


    public static void loadThumnailLocalImage(Context mContext, Integer drawable, ImageView img) {
        if (mContext != null) {
            Glide.with(mContext)
                    .load(drawable)
                    .thumbnail(0.5f)
                    .into(img);
        }
    }

    public static void loadTLocalAvatar(Context mContext, Integer drawable, ImageView img) {
        if (mContext != null) {
            Glide.with(mContext)
                    .load(drawable)
                    .thumbnail(0.5f)
                    .transform(new GlideCircleTransform(), new CenterCrop())
                    .into(img);
        }
    }

    /**
     * 加载无缓存图片
     *
     * @param context
     * @param url
     * @param imageView
     */
    public static void loadNoChacheImage(Context context, String url, ImageView imageView) {
        Glide.with(context)
                .load(url)
                .error(R.mipmap.no_img)
                .skipMemoryCache(true)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .into(imageView);
    }

    /**
     * 加载缩略图图片
     *
     * @param mContext
     * @param url
     * @param imageView
     */
    public static void loadThumbnailImageCenterCrop(Context mContext, String url, ImageView imageView) {
        Glide.with(mContext)
                .load(url)
                .thumbnail(0.5f)
                .error(R.mipmap.no_img)
                .centerCrop()
                .into(imageView);
    }

    /**
     * 加载缩略图图片
     *
     * @param mContext
     * @param url
     * @param imageView
     */
    public static void loadThumbnailImage(Context mContext, String url, ImageView imageView) {
        Glide.with(mContext)
                .load(StringUtil.isEmpty(url) ? R.mipmap.no_img : url)
                .thumbnail(0.5f)
                .error(R.mipmap.no_img)
                .into(imageView);
    }

    /**
     * 加载缩略图图片
     *
     * @param mContext
     * @param url
     * @param imageView
     */
    public static void loadThumbnailCircleImage(Context mContext, String url, ImageView imageView) {
        Glide.with(mContext)
                .load(url)
                .thumbnail(0.5f)
                .error(R.mipmap.no_img)
                .transform(new GlideCircleTransform(), new CenterCrop())
                .into(imageView);
    }


    /**
     * 加载圆形图片
     *
     * @param mContext
     * @param url
     * @param imageView
     */
    public static void loadCircleImage(Context mContext, String url, ImageView imageView) {
        Glide.with(mContext).load(url)
                .placeholder(R.mipmap.place_holder)
                .error(R.mipmap.place_holder)
                .transform(new CenterCrop(), new GlideCircleTransform())
                .into(imageView);
    }

    /**
     * 加载原型带边框图片
     *
     * @param mContext
     * @param url
     * @param borderWidth
     * @param borderColor
     * @param imageView
     */
    public static void loadCircleBorderImage(Context mContext, String url, int borderWidth, int borderColor, ImageView imageView) {
        Glide.with(mContext).load(url)
                .placeholder(R.mipmap.place_holder)
                .error(R.mipmap.place_holder)
                .transform(new CenterCrop(), new GlideCircleTransforms(mContext, borderWidth, borderColor))
                .into(imageView);
    }
}
